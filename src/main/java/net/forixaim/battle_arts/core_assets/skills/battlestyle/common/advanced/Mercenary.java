package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.MercenaryStyles;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.CommonEvents;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts.initialization.registry.BattleArtsDataKeys;
import net.forixaim.battle_arts.initialization.registry.BattleArtsSkills;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

import java.util.UUID;

public class Mercenary extends BattleStyle
{


    private static final UUID EVENT_UUID = UUID.fromString("7e975e33-5226-47eb-8b0d-51fe9946f2e4");
    public Mercenary(SkillBuilder<?> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener listener)
    {
        super.onInitiate(container, listener);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, BattleArtsSkills.POWER_GEYSER);
        listener.registerEvent(EpicFightClientEventHooks.Control.MAPPED_MOVEMENT_INPUT_UPDATE, CommonEvents::LOCK_MOVEMENT_GUARDING, this);

    }

    @Override
    public void updateContainer(SkillContainer container) {
        super.updateContainer(container);
        if (container.getDataManager().getDataValue(BattleArtsDataKeys.RANDOM_FLAUNT) == 0)
        {
            container.getDataManager().setDataSync(BattleArtsDataKeys.RANDOM_FLAUNT, container.getExecutor().getOriginal().getRandom().nextIntBetweenInclusive(200, 300));
        }
        if (container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == MercenaryStyles.MERCENARY_WEAPON_ART && container.getExecutor().getCurrentLivingMotion() == LivingMotions.IDLE)
        {
            container.getDataManager().setDataSyncF(BattleArtsDataKeys.IDLE_TIMER, data -> data + 1);
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.IDLE_TIMER) >= container.getDataManager().getDataValue(BattleArtsDataKeys.RANDOM_FLAUNT))
            {
                container.getDataManager().setDataSync(BattleArtsDataKeys.IDLE_TIMER, 0);
                playAnim(container);
            }
        }
        else
        {
            container.getDataManager().setDataSync(BattleArtsDataKeys.IDLE_TIMER, 0);
        }
    }

    private void playAnim(SkillContainer container)
    {
        container.getExecutor().playAnimationSynchronized(MercenaryGreatswordAnimations.FLAUNT, 0);
        container.getDataManager().setDataSync(BattleArtsDataKeys.RANDOM_FLAUNT, container.getExecutor().getOriginal().getRandom().nextIntBetweenInclusive(200, 300));
    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
    }
}
