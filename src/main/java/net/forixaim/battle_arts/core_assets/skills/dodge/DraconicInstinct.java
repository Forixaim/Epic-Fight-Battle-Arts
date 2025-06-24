package net.forixaim.battle_arts.core_assets.skills.dodge;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import net.forixaim.battle_arts.Config;
import net.forixaim.battle_arts.core_assets.animations.other.DraconicInstinctAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.world.tags.DamageTags;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageTypes;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.ActionAnimation;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.dodge.DodgeSkill;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.List;
import java.util.UUID;

public class DraconicInstinct extends DodgeSkill
{

    private static final List<AnimationManager.AnimationAccessor<? extends ActionAnimation>> DODGES = Lists.newArrayList(
            DraconicInstinctAnimations.DODGE_1,
            DraconicInstinctAnimations.DODGE_2,
            DraconicInstinctAnimations.DODGE_3,
            DraconicInstinctAnimations.DODGE_4
    );
    private static final UUID EVENT_UUID = UUID.fromString("c8ba19f5-e3b2-4d83-889d-f3c38e7bc193");
    public DraconicInstinct(Builder builder) {
        super(builder);
    }

    @Override
    public void drawOnGui(BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y) {
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        poseStack.translate(0, (float)gui.getSlidingProgression(), 0);
        guiGraphics.blit(getSkillTexture(), (int)x, (int)y, 24, 24, 0, 0, 1, 1, 1, 1);
        Integer Heat = container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_GAUGE.get());
        String HeatLevel = Heat.toString();
        guiGraphics.drawString(gui.getFont(), HeatLevel, x + 4, y + 16, 16777215, true);
        poseStack.popPose();
    }

    @Override
    public boolean shouldDraw(SkillContainer container) {
        return true;
    }



    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.HURT_EVENT_PRE, EVENT_UUID, event ->
        {
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_GAUGE.get()) > 80 && container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_WINDOW.get()) <= 0)
            {
                container.getDataManager().setDataSyncF(BattleArtsDataKeys.INSTINCT_GAUGE.get(), value ->
                {
                    if (Config.ULTRA_INSTINCT.get())
                        return value;
                    else
                        return value - 80;
                }, event.getPlayerPatch().getOriginal());
                container.getDataManager().setDataSync(BattleArtsDataKeys.INSTINCT_WINDOW.get(), 20, event.getPlayerPatch().getOriginal());
            }
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_WINDOW.get()) > 0 && !event.getDamageSource().is(DamageTypes.FELL_OUT_OF_WORLD))
            {
                if (!event.getDamageSource().is(DamageTags.DODGE_BYPASS_LEVEL_3))
                {
                    RandomSource rng = container.getExecutor().getOriginal().getRandom();
                    event.getPlayerPatch().playAnimationSynchronized(DODGES.get(rng.nextInt(0, 4)), 0);
                    event.setResult(AttackResult.ResultType.MISSED);
                    event.getPlayerPatch().onDodgeSuccess(event.getDamageSource());
                    event.setCanceled(true);
                }
            }
        });
    }

    @Override
    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.HURT_EVENT_PRE, EVENT_UUID);
        super.onRemoved(container);
    }

    @Override
    public void updateContainer(SkillContainer container) {
        super.updateContainer(container);
        if (!container.getExecutor().isLogicalClient() && container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_GAUGE.get()) < 640)
        {
            container.getDataManager().setDataSyncF(BattleArtsDataKeys.INSTINCT_GAUGE.get(), value -> value + 1, container.getServerExecutor().getOriginal());
        }
        if (!container.getExecutor().isLogicalClient() && container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_WINDOW.get()) > 0)
        {
            container.getDataManager().setDataSyncF(BattleArtsDataKeys.INSTINCT_WINDOW.get(), value -> value - 1, container.getServerExecutor().getOriginal());
        }
    }

    //This does nothing
    @Override
    public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf args) {
    }
}
