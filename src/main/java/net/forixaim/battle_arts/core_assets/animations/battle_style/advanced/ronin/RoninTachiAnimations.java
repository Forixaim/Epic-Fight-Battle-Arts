package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin;

import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.world.capabilities.item.CapabilityItem;

public class RoninTachiAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> TACHI_IDLE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO3;


    public static void onRegister(AnimationManager.AnimationBuilder event)
    {
        TACHI_IDLE = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "idle"), access ->
                new StaticAnimation(true, access, Armatures.BIPED));
        WALK = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "walk"), access -> new MovementAnimation(
                true, access, Armatures.BIPED
        ));
        RUN = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "run"), access -> new MovementAnimation(
                true, access, Armatures.BIPED
        ));
        AUTO1 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "auto1"), access ->
                new BasicAttackAnimation(0.1f, 0.0f, 0.6f, 0.75f, 1f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
        AUTO2 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "auto2"), access ->
                new BasicAttackAnimation(0.1f, 0.0f, 0.9f, 1f, 1.3f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
        AUTO3 = event.nextAccessor(RoninAnimations.roninAnimationPath(CapabilityItem.WeaponCategories.TACHI, "auto3"), access ->
                new BasicAttackAnimation(0.1f, 0.0f, 1.1f, 1.35f, 1.6f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f));
    }
}
