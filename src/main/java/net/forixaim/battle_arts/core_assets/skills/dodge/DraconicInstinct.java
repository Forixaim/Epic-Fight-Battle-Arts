package net.forixaim.battle_arts.core_assets.skills.dodge;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import net.forixaim.battle_arts.Config;
import net.forixaim.battle_arts.core_assets.animations.other.DraconicInstinctAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.ActionAnimation;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.dodge.DodgeSkill;
import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;
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

    private static final List<TagKey<DamageType>> BYPASSES = Lists.newArrayList(
            DamageTypeTags.BYPASSES_INVULNERABILITY,
            EpicFightDamageTypeTags.BYPASS_DODGE
    );

    private static final List<ResourceKey<DamageType>> V_BYPASSES = Lists.newArrayList(
            DamageTypes.IN_FIRE,
            DamageTypes.FELL_OUT_OF_WORLD,
            DamageTypes.CRAMMING,
            DamageTypes.ON_FIRE,
            DamageTypes.DROWN,
            DamageTypes.STARVE,
            DamageTypes.LAVA,
            DamageTypes.FLY_INTO_WALL,
            DamageTypes.FALL
    );

    private static final UUID EVENT_UUID = UUID.fromString("c8ba19f5-e3b2-4d83-889d-f3c38e7bc193");
    public DraconicInstinct(Builder builder) {
        super(builder);
    }

    @Override
    public void drawOnGui(BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y, float pt) {
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
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID, event ->
        {
            if (!contains(event.getDamageSource()) && !event.getPlayerPatch().getOriginal().isUsingItem() && !event.getPlayerPatch().isHoldingAny())
            {
                if (container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_GAUGE.get()) > 80 && container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_WINDOW.get()) <= 0)
                {
                    container.getDataManager().setDataSyncF(BattleArtsDataKeys.INSTINCT_GAUGE.get(), value ->
                    {
                        if (Config.ULTRA_INSTINCT.get())
                            return value;
                        else
                            return value - 80;
                    });
                    container.getDataManager().setDataSync(BattleArtsDataKeys.INSTINCT_WINDOW.get(), 20);
                }
                if (container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_WINDOW.get()) > 0 && !event.getDamageSource().is(DamageTypes.FELL_OUT_OF_WORLD))
                {
                    RandomSource rng = container.getExecutor().getOriginal().getRandom();
                    event.getPlayerPatch().playAnimationSynchronized(DODGES.get(rng.nextInt(0, 4)), 0);
                    event.getPlayerPatch().onDodgeSuccess(event.getDamageSource(), event.getPlayerPatch().getOriginal().position());
                    event.setCanceled(true);
                    event.setResult(AttackResult.ResultType.MISSED);
                }
            }

        });
    }

    private static boolean contains(DamageSource source)
    {
        for (TagKey<DamageType> tag : BYPASSES)
        {
            if (source.is(tag))
                return true;
        }
        for (ResourceKey<DamageType> tage : V_BYPASSES)
        {
            if (source.is(tage))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onRemoved(SkillContainer container) {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_ATTACK, EVENT_UUID);
        super.onRemoved(container);
    }

    @Override
    public void updateContainer(SkillContainer container) {
        super.updateContainer(container);
        if (!container.getExecutor().isLogicalClient() && container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_GAUGE.get()) < 640)
        {
            container.getDataManager().setDataSyncF(BattleArtsDataKeys.INSTINCT_GAUGE.get(), value -> value + 1);
        }
        if (!container.getExecutor().isLogicalClient() && container.getDataManager().getDataValue(BattleArtsDataKeys.INSTINCT_WINDOW.get()) > 0)
        {
            container.getDataManager().setDataSyncF(BattleArtsDataKeys.INSTINCT_WINDOW.get(), value -> value - 1);
        }
    }

    //This does nothing
    @Override
    public void executeOnServer(SkillContainer skillContainer, FriendlyByteBuf args) {
    }
}
