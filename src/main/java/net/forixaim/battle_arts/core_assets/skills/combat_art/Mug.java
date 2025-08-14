package net.forixaim.battle_arts.core_assets.skills.combat_art;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.ThiefStyles;
import net.forixaim.battle_arts.initialization.registry.TagRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import yesman.epicfight.client.gui.BattleModeGui;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

public class Mug extends CombatArt
{
    private static final UUID EVENT_UUID = UUID.fromString("0a84970f-7559-460b-a92f-0d9c874de77b");

    public Mug(SkillBuilder<? extends CombatArt> builder)
    {
        super(builder);
        this.allowedWeapons.add(CapabilityItem.WeaponCategories.DAGGER);
    }

    @Override
    public void onInitiate(SkillContainer container)
    {
        super.onInitiate(container);

        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_HURT, EVENT_UUID, event ->
        {
            if (event.getDamageSource().getAnimation() == ThiefDaggerAnimations.MUG)
                if (event.getTarget() instanceof Enemy && !event.getTarget().getTags().contains(TagRegistry.STOLEN.toString())) {
                    ItemEntity item = EntityType.ITEM.create(event.getTarget().level());
                    LogUtils.getLogger().debug("oof");
                    if (item != null)
                    {
                        int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.MOB_LOOTING, container.getExecutor().getOriginal());
                        item.setItem(new ItemStack(Items.EMERALD, 1 + i));
                        item.setPos(event.getTarget().position());
                        event.getTarget().level().addFreshEntity(item);
                    }
                    event.getTarget().addTag(TagRegistry.STOLEN.toString());
                }
        });
    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.DEAL_DAMAGE_EVENT_HURT, EVENT_UUID);
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
        poseStack.translate(0, (float)gui.getSlidingProgression(), 0);
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
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args)
    {
        super.executeOnServer(container, args);
        if (container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == ThiefStyles.THIEF_WEAPON)
            container.getServerExecutor().playAnimationSynchronized(ThiefDaggerAnimations.MUG, 0);
    }
}
