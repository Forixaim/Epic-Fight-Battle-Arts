package net.forixaim.battle_arts.core_assets.skills.combat_art;

import com.mojang.blaze3d.vertex.PoseStack;
import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninTachiAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.RoninStyles;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.capabilities.item.Style;

public class TranquilityUnleash extends CombatArt
{

    public TranquilityUnleash(SkillBuilder<?> builder)
    {
        super(builder);
    }

    @Override
    public boolean canExecute(SkillContainer container)
    {
        return container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).hasSkill(SkillRegistry.RONIN.get()) &&
                (container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == RoninStyles.RONIN_UCHIGATANA_SHEATHE ||
        container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == RoninStyles.RONIN_UCHIGATANA ||
                        container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == RoninStyles.RONIN_TACHI);
    }

    @Override
    public boolean shouldDraw(SkillContainer container)
    {
        return this.canExecute(container);
    }
    @Override
    public void drawOnGui(BattleModeGui gui, SkillContainer container, GuiGraphics guiGraphics, float x, float y, float pt)
    {
        PoseStack poseStack = guiGraphics.pose();
        poseStack.pushPose();
        guiGraphics.blit(getSkillTexture(), (int)x, (int)y, 24, 24, 0, 0, 1, 1, 1, 1);
        if (!container.isFull())
        {
            Float Heat = container.getNeededResource();
            String Heat_Level = String.format("%.0f", Heat);
            guiGraphics.drawString(gui.getFont(), Heat_Level, x + 4, y + 16, 16777215, true);
        }
        guiGraphics.drawString(gui.getFont(), Integer.toString(container.getStack()), x + 8, y+8, 16777215, true);
        poseStack.popPose();
    }

    @Override
    public void executeOnServer(SkillContainer container, CompoundTag args)
    {
        super.executeOnServer(container, args);

        Style weaponStyle = container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor());

        switch (weaponStyle) {
            case RoninStyles.RONIN_UCHIGATANA_SHEATHE ->
                    container.getExecutor().playAnimationSynchronized(RoninUchigatanaAnimations.FLYING_SHOCKWAVE, 0);
            case RoninStyles.RONIN_UCHIGATANA -> {
                container.getExecutor().playAnimationSynchronized(RoninUchigatanaAnimations.FLASH_CLEAVE, 0);
                container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().setDataSync(BattleArtsDataKeys.TRANQUILITY_SHEATH, true);
                container.getServerExecutor().modifyLivingMotionByCurrentItem();
            }
            case RoninStyles.RONIN_TACHI ->
                    container.getExecutor().playAnimationSynchronized(RoninTachiAnimations.FLYING_SHOCKWAVE, 0);
            default -> BattleArts.LOGGER.debug("nope");
        }
    }
}
