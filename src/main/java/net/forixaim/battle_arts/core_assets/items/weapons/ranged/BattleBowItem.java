package net.forixaim.battle_arts.core_assets.items.weapons.ranged;

import net.forixaim.battle_arts.core_assets.animations.battle_style.BattleStyleRegistry;
import net.forixaim.battle_arts.core_assets.items.weapons.melee.special.SpecialTiers;
import net.forixaim.battle_arts.initialization.registry.BattleArtsEntities;
import net.forixaim.battle_arts.core_assets.world.projectiles.FixedArrow;
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
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.world.damagesource.StunType;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class BattleBowItem extends BowItem
{
    private final Tier tier;
    public Tier getTier() {
        return this.tier;
    }

    public int getEnchantmentValue() {
        return this.tier.getEnchantmentValue();
    }

    public boolean isValidRepairItem(@NotNull ItemStack ingredient, @NotNull ItemStack self) {
        return this.tier.getRepairIngredient().test(self) || super.isValidRepairItem(ingredient, self);
    }

    public BattleBowItem(Tier pTier, Properties pProperties)
    {
        super(pProperties);
        this.tier = pTier;

    }

    @Override
    public <T extends LivingEntity> int damageItem(@NotNull ItemStack stack, int amount, @Nullable T entity, @NotNull Consumer<Item> onBroken) {
        return getTier() != SpecialTiers.STEEL ? 0 : amount;
    }


    public boolean canAttackBlock(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, Player pPlayer) {
        return !pPlayer.isCreative();
    }


    public float getNockProgress(ItemStack stack, LivingEntity shooter)
    {
        return shooter.getTicksUsingItem() / (20.0F * 1);
    }

    @Override
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

                float f = getBattleArtsPowerForTime(event.getCharge());
                if (!((double) f < 0.1))
                {
                    boolean flag1 = player.getAbilities().instabuild || itemstack.getItem() instanceof ArrowItem && ((ArrowItem) itemstack.getItem()).isInfinite(itemstack, pStack, player);
                    if (!pLevel.isClientSide)
                    {
                        FixedArrow fixedArrow = BattleArtsEntities.FIXED_ARROW.get().create(pLevel);
                        fixedArrow.setAttack(BattleStyleRegistry.BOW_BASE_DAMAGE);
                        fixedArrow.setPos(player.position().add(0, 1.5, 0));
                        fixedArrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
                        fixedArrow.setPhase(new AttackAnimation.Phase(InteractionHand.MAIN_HAND, Joint.EMPTY, ColliderPreset.BIPED_BODY_COLLIDER)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.setter((float) player.getAttributeValue(Attributes.ATTACK_DAMAGE)))
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NEUTRALIZE));
                        if (f == 1.0F)
                        {
                            fixedArrow.setCritArrow(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(pLevel.registryAccess().holderOrThrow(Enchantments.POWER), pEntityLiving);
                        if (j > 0)
                        {
                            fixedArrow.setBaseDamage(fixedArrow.getBaseDamage() + j);
                        }

                        pStack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                        if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW)))
                        {
                            fixedArrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                        }

                        pLevel.addFreshEntity(fixedArrow);
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

    public float getBattleArtsPowerForTime(int pCharge) {
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
        } else if (!pPlayer.hasInfiniteMaterials() && !flag) {
            return InteractionResultHolder.fail(itemstack);
        } else {
            pPlayer.startUsingItem(pHand);
            return InteractionResultHolder.consume(itemstack);
        }
    }

    public @NotNull Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

    public int getDefaultProjectileRange() {
        return 15;
    }
}
