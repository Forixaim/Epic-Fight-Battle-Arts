package net.forixaim.battle_arts.core_assets.items.weapons.melee.special;

import net.forixaim.battle_arts.core_assets.items.weapons.melee.HalberdItem;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class TheSilverHalberdItem extends HalberdItem {
    public TheSilverHalberdItem() {
        super(Tiers.NETHERITE, new Properties().fireResistant());
    }

    @Override
    public boolean onLeftClickEntity(@NotNull ItemStack stack, Player player, @NotNull Entity entity) {
        if (player.getRandom().nextBoolean())
        {
            LightningBolt lightning = EntityType.LIGHTNING_BOLT.create(entity.level());
            if (lightning != null) {
                lightning.moveTo(Vec3.atBottomCenterOf(entity.blockPosition()));
                entity.level().addFreshEntity(lightning);
            }
        }

        return super.onLeftClickEntity(stack, player, entity);
    }
}
