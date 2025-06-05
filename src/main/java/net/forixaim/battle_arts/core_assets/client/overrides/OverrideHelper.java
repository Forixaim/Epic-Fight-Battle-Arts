package net.forixaim.battle_arts.core_assets.client.overrides;

import com.google.common.collect.Lists;
import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.LongbowItem;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.bs_api.battle_arts_skills.BattleArtsSkillSlots;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.InteractionHand;
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
                living != null && living.isUsingItem() && living.getUseItem() == stack ? 1.0f : 0.0f);
        ItemProperties.register(longbow, PULL, (stack, world, shooter, value) ->

                shooter != null && shooter.getUseItem() == stack ? longbow.getNockProgress(stack, shooter) : 0.0f);
    }

    public static void registerUchigatanaOverrides()
    {

    }
}
