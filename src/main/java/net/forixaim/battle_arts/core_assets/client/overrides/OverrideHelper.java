package net.forixaim.battle_arts.core_assets.client.overrides;

import com.google.common.collect.Lists;
import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.LongbowItem;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.bs_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.efm_ex.capabilities.ExCapCategories;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Items;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.Style;
import yesman.epicfight.world.item.EpicFightItems;

import java.util.List;

public class OverrideHelper
{
    public static final ResourceLocation PULLING = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "pulling");
    public static final ResourceLocation PULL = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "pull");
    public static final ResourceLocation BATTLE_STYLE_COMPATIBLE = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "battle_style_compatible");

    public static final List<Style> UchigatanaOverrides = Lists.newArrayList(
    RoninStyles.RONIN_UCHIGATANA, RoninStyles.RONIN_UCHIGATANA_SHEATHE);

    public static void registerLongbowPropertyOverrides(LongbowItem longbow)
    {
        ItemProperties.register(longbow, PULLING, (stack, world, living, value) ->
                {
                    LivingEntityPatch<?> livingEntityPatch = EpicFightCapabilities.getEntityPatch(living, LivingEntityPatch.class);

                    if (livingEntityPatch instanceof PlayerPatch<?> playerPatch && playerPatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == ExCapCategories.BOW && !living.isUsingItem())
                    {
                        if (playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING.get()) && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULLING.get()))
                        {
                            return playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULLING.get()) ? 1.0f : 0.0f;
                        }
                        return playerPatch.isChargingSkill() ? 1.0f : 0.0f;
                    }
                    return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0f : 0.0f;
                });

        ItemProperties.register(longbow, PULL, (stack, world, shooter, value) ->
                {
                    LivingEntityPatch<?> livingEntityPatch = EpicFightCapabilities.getEntityPatch(shooter, LivingEntityPatch.class);
                    if (livingEntityPatch instanceof PlayerPatch<?> playerPatch && playerPatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == ExCapCategories.BOW && playerPatch.isChargingSkill() && !shooter.isUsingItem())
                    {
                        if (playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING.get()) && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULLING.get()))
                        {
                            return playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULL_LEVEL.get());
                        }
                        int maxCharge = playerPatch.getChargingSkill().getMaxChargingTicks();
                        return  playerPatch.isChargingSkill() ? ((float)playerPatch.getSkillChargingTicks() /  maxCharge): 0;
                    }
                    return shooter != null && shooter.getUseItem() == stack ? longbow.getNockProgress(stack, shooter) : 0.0f;
                });

    }

    public static void registerUchigatanaOverrides()
    {
        ItemProperties.register(Items.BOW, ResourceLocation.fromNamespaceAndPath("minecraft", "pull"), ((pStack, pLevel, pEntity, pSeed) ->
        {
            LivingEntityPatch<?> livingEntityPatch = EpicFightCapabilities.getEntityPatch(pEntity, LivingEntityPatch.class);
            if (livingEntityPatch instanceof PlayerPatch<?> playerPatch && playerPatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == ExCapCategories.BOW && playerPatch.isChargingSkill() && !pEntity.isUsingItem())
            {
                if (playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING.get()) && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULLING.get()))
                {
                    return playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULL_LEVEL.get());
                }
                int maxCharge = playerPatch.getChargingSkill().getMaxChargingTicks();
                return  playerPatch.isChargingSkill() ? ((float)playerPatch.getSkillChargingTicks() /  maxCharge): 0;
            }
            if (pEntity == null)
            {
                return 0.0f;
            }
            return pEntity.getUseItem() != pStack ? 0.0F : (float)(pStack.getUseDuration() - pEntity.getUseItemRemainingTicks()) / 20.0F;
        }));

        ItemProperties.register(Items.BOW, ResourceLocation.fromNamespaceAndPath("minecraft", "pulling"), ((pStack, pLevel, pEntity, pSeed) ->
                pEntity != null && pEntity.isUsingItem() && pEntity.getUseItem() == pStack ? 1.0F : 0.0F));

    }
}
