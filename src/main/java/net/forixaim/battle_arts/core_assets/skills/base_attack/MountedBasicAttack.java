package net.forixaim.battle_arts.core_assets.skills.base_attack;

import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.skill.*;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.eventlistener.BasicAttackEvent;
import yesman.epicfight.world.entity.eventlistener.ComboCounterHandleEvent;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;
import yesman.epicfight.world.entity.eventlistener.SkillConsumeEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MountedBasicAttack extends BasicAttack
{
    private static final UUID EVENT_UUID = UUID.fromString("1c64051b-046e-4794-9437-aa40661eaa37");

    public MountedBasicAttack(SkillBuilder<? extends BasicAttack> builder)
    {
        super(builder);
    }

    public void onInitiate(SkillContainer container) {
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.ACTION_EVENT_SERVER, EVENT_UUID, (event) -> {
            if (event.getAnimation().get().getProperty(AnimationProperty.ActionAnimationProperty.RESET_PLAYER_COMBO_COUNTER).orElse(true)) {
                CapabilityItem itemCapability = event.getPlayerPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND);
                List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> comboAnimations = itemCapability.getAutoAttackMotion(container.getExecutor());
                if (comboAnimations == null) {
                    return;
                }
                Set<AnimationManager.AnimationAccessor<? extends AttackAnimation>> attackMotionSet = Set.copyOf(new HashSet<>(comboAnimations));
                if (!attackMotionSet.contains(event.getAnimation()) && itemCapability.shouldCancelCombo(event.getPlayerPatch())) {
                    setComboCounterWithEvent(ComboCounterHandleEvent.Causal.ANOTHER_ACTION_ANIMATION, event.getPlayerPatch(), container, event.getAnimation(), 0);
                }
            }
        });
    }

    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.ACTION_EVENT_SERVER, EVENT_UUID);
    }

    @Override
    public void updateContainer(SkillContainer container) {
        if (!container.getExecutor().isLogicalClient() && container.getExecutor().getTickSinceLastAction() > 16 && container.getDataManager().getDataValue(BattleArtsDataKeys.COMBO_COUNTER.get()) > 0) {
            setComboCounterWithEvent(ComboCounterHandleEvent.Causal.TIME_EXPIRED, container.getServerExecutor(), container, null, 0);
        }
    }

    public static void setComboCounterWithEvent(ComboCounterHandleEvent.Causal reason, ServerPlayerPatch playerpatch, SkillContainer container, AnimationManager.AnimationAccessor<? extends StaticAnimation> causalAnimation, int value) {
        int prevValue = container.getDataManager().getDataValue(BattleArtsDataKeys.COMBO_COUNTER.get());
        ComboCounterHandleEvent comboResetEvent = new ComboCounterHandleEvent(reason, playerpatch, causalAnimation, prevValue, value);
        container.getExecutor().getEventListener().triggerEvents(PlayerEventListener.EventType.COMBO_COUNTER_HANDLE_EVENT, comboResetEvent);
        container.getDataManager().setDataSync(BattleArtsDataKeys.COMBO_COUNTER.get(), comboResetEvent.getNextValue(), playerpatch.getOriginal());
    }

    @Override
    public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf args)
    {
        ServerPlayerPatch executor = skillContainer.getServerExecutor();
        SkillConsumeEvent event = new SkillConsumeEvent(executor, this, this.resource);
        executor.getEventListener().triggerEvents(PlayerEventListener.EventType.SKILL_CONSUME_EVENT, event);
        if (!event.isCanceled()) {
            event.getResourceType().consumer.consume(skillContainer, executor, event.getAmount());
        }

        if (!executor.getEventListener().triggerEvents(PlayerEventListener.EventType.BASIC_ATTACK_EVENT, new BasicAttackEvent(executor))) {
            CapabilityItem cap = executor.getHoldingItemCapability(InteractionHand.MAIN_HAND);
            AnimationManager.AnimationAccessor<? extends AttackAnimation> attackMotion;
            SkillDataManager dataManager = skillContainer.getDataManager();
            int comboCounter = dataManager.getDataValue(BattleArtsDataKeys.COMBO_COUNTER.get());

            List<AnimationManager.AnimationAccessor<? extends AttackAnimation>> combo = cap.getAutoAttackMotion(executor);
            if (combo == null) {
                return;
            }

            int comboSize = combo.size();

            comboCounter %= comboSize;

            attackMotion = combo.get(comboCounter);
            comboCounter += 1;
            setComboCounterWithEvent(ComboCounterHandleEvent.Causal.ANOTHER_ACTION_ANIMATION, executor, skillContainer, attackMotion, comboCounter);
            if (attackMotion != null) {
                executor.playAnimationSynchronized(attackMotion, 0.0F);
            }

            executor.updateEntityState();
        }
    }
}
