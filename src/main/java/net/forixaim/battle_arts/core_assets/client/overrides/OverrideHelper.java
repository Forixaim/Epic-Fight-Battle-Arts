package net.forixaim.battle_arts.core_assets.client.overrides;

import com.google.common.collect.Lists;
import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.AdaptiveGloveItem;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.LongbowItem;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.ex_cap.capabilities.ExCapCategories;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.InteractionHand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.skill.modules.ChargeableSkill;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.Style;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class OverrideHelper
{
    public static final ResourceLocation PULLING = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "pulling");
    public static final ResourceLocation PULL = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "pull");
    public static final ResourceLocation WIDE_SLIM = ResourceLocation.fromNamespaceAndPath(EpicFightBattleArts.MOD_ID, "wide_slim");

    public static final List<Style> UchigatanaOverrides = Lists.newArrayList(
    RoninStyles.RONIN_UCHIGATANA, RoninStyles.RONIN_UCHIGATANA_SHEATHE);

    public static void registerGloveOverrides(AdaptiveGloveItem gloveItem)
    {
        ItemProperties.register(gloveItem, WIDE_SLIM, ((itemStack, clientLevel, livingEntity, i) ->
                (livingEntity instanceof AbstractClientPlayer acp && acp.getModelName().equals("slim")) ? 1.0f : 0.0f));
    }

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
                        return playerPatch.isHoldingAny() ? 1.0f : 0.0f;
                    }
                    return living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0f : 0.0f;
                });

        ItemProperties.register(longbow, PULL, (stack, world, shooter, value) ->
                {
                    LivingEntityPatch<?> livingEntityPatch = EpicFightCapabilities.getEntityPatch(shooter, LivingEntityPatch.class);
                    if (livingEntityPatch instanceof PlayerPatch<?> playerPatch && playerPatch.getHoldingItemCapability(InteractionHand.MAIN_HAND).getWeaponCategory() == ExCapCategories.BOW && playerPatch.isHoldingAny() && !shooter.isUsingItem())
                    {
                        if (playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING.get()) && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULLING.get()))
                        {
                            return playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.PULL_LEVEL.get());
                        }
                        if (playerPatch.getHoldingSkill() instanceof ChargeableSkill cs)
                        {
                            int maxCharge = cs.getMaxChargingTicks();
                            return  playerPatch.isHoldingAny() ? ((float)playerPatch.getSkillChargingTicks() /  maxCharge): 0;
                        }
                    }
                    return shooter != null && shooter.getUseItem() == stack ? longbow.getNockProgress(stack, shooter) : 0.0f;
                });

    }

    public static void registerUchigatanaOverrides()
    {

    }
}
