package net.forixaim.battle_arts.core_assets.skills.combat_art;

import com.mojang.blaze3d.vertex.PoseStack;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.DuelistStyles;
import net.forixaim.battle_arts.initialization.registry.BattleArtsParticles;
import net.forixaim.battle_arts.initialization.registry.BattleArtsSkills;
import net.forixaim.battle_arts.initialization.registry.BattleArtsSounds;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class SkyStriker extends CombatArt {

    public SkyStriker(SkillBuilder<?> builder) {
        super(builder);
        allowedWeapons.add(CapabilityItem.WeaponCategories.LONGSWORD);
        allowedWeapons.add(CapabilityItem.WeaponCategories.SWORD);
        allowedWeapons.add(CapabilityItem.WeaponCategories.TACHI);

    }

    @Override
    public boolean canExecute(SkillContainer container)
    {
        return container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).hasSkill(BattleArtsSkills.DUELIST.get()) &&
                (container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == DuelistStyles.DUELIST_SWORD) && super.canExecute(container);
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
    public void executeOnServer(SkillContainer container, CompoundTag args) {
        container.getExecutor().playSound(BattleArtsSounds.SPECIAL_MOVE.get(),  1, 1);
        double yPos = OpenMatrix4f.transform(((HumanoidArmature)container.getExecutor().getArmature()).chest.getToOrigin(), container.getExecutor().getOriginal().position()).y() + 0.25;
        ((ServerLevel)container.getServerExecutor().getOriginal().level()).sendParticles(BattleArtsParticles.SPECIAL_RING.get(), container.getExecutor().getOriginal().getX(), yPos, container.getExecutor().getOriginal().getZ(), 1, 0, 0, 0, 0.0f);
        if (container.getExecutor().getOriginal().onGround())
        {
            container.getExecutor().playAnimationSynchronized(DuelistSwordAnimations.PIERCING_FALCON, 0);
        }
        else
        {
            container.getExecutor().playAnimationSynchronized(DuelistSwordAnimations.SHOOTING_STAR, 0);
        }
        super.executeOnServer(container, args);
    }
}
