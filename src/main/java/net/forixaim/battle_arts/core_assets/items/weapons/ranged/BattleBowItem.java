package net.forixaim.battle_arts.core_assets.items.weapons.ranged;

import net.forixaim.battle_arts.core_assets.items.types.RangedTieredItem;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.EventHooks;
import net.neoforged.neoforge.event.entity.player.ArrowLooseEvent;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public class BattleBowItem extends RangedTieredItem
{
    public BattleBowItem(Tier pTier, Properties pProperties)
    {
        super(pTier, pProperties);
    }


    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }


    public float getNockProgress(ItemStack stack, LivingEntity shooter)
    {
        return shooter.getTicksUsingItem() / (20.0F * 1);
    }

    public void releaseUsing(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull LivingEntity pEntityLiving, int pTimeLeft)
    {
        if (pEntityLiving instanceof Player player)
        {
            boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getEnchantmentLevel(pLevel.registryAccess().holderOrThrow(Enchantments.INFINITY), pEntityLiving) > 0;
            ItemStack itemstack = player.getProjectile(pStack);
            int i = this.getUseDuration(pStack) - pTimeLeft;
            ArrowLooseEvent event = new ArrowLooseEvent(player, pStack, pLevel, i, !itemstack.isEmpty() || flag);

            if (NeoForge.EVENT_BUS.post(event).isCanceled()) {
                return;
            }

            if (!itemstack.isEmpty() || flag)
            {
                if (itemstack.isEmpty())
                {
                    itemstack = new ItemStack(Items.ARROW);
                }

                float f = event.getCharge();
                if (!((double) f < 0.1))
                {
                    boolean flag1 = player.getAbilities().instabuild || itemstack.getItem() instanceof ArrowItem && ((ArrowItem) itemstack.getItem()).isInfinite(itemstack, pStack, player);
                    if (!pLevel.isClientSide)
                    {
                        ArrowItem arrowitem = (ArrowItem) (itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
                        AbstractArrow abstractarrow = arrowitem.createArrow(pLevel, itemstack, player, pStack);
                        abstractarrow = this.customArrow(abstractarrow);
                        abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                        abstractarrow.setBaseDamage(pEntityLiving.getAttributeValue(Attributes.ATTACK_DAMAGE));
                        if (f == 1.0F)
                        {
                            abstractarrow.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(pLevel.registryAccess().holderOrThrow(Enchantments.POWER), pEntityLiving);
                        if (j > 0)
                        {
                            abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + j);
                        }

                        int k = EnchantmentHelper.getEnchantmentLevel(pLevel.registryAccess().holderOrThrow(Enchantments.POWER), pEntityLiving);

                        pStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW)))
                        {
                            abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        pLevel.addFreshEntity(abstractarrow);
                    }

                    pLevel.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
                    if (!flag1 && !player.getAbilities().instabuild)
                    {
                        itemstack.shrink(1);
                        if (itemstack.isEmpty())
                        {
                            player.getInventory().removeItem(itemstack);
                        }
                    }

                    player.awardStat(Stats.ITEM_USED.get(this));
                }
            }
        }
    }

    public float getPowerForTime(int pCharge) {
        float f = (float)pCharge / 20.0F;
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

    public int getUseDuration(@NotNull ItemStack pStack) {
        return 72000;
    }

    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack pStack) {
        return UseAnim.BOW;
    }

    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, Player pPlayer, @NotNull InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        boolean flag = !pPlayer.getProjectile(itemstack).isEmpty();
        InteractionResultHolder<ItemStack> ret = EventHooks.onArrowNock(itemstack, pLevel, pPlayer, pHand, flag);
        if (ret != null) {
            return ret;
        } else if (!pPlayer.getAbilities().instabuild && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public AbstractArrow customArrow(AbstractArrow arrow) {
        return arrow;
    }

    public int getDefaultProjectileRange() {
        return 15;
    }
}
