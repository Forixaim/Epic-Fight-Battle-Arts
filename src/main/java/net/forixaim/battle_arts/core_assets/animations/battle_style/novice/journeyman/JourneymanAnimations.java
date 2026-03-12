package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman;

import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.KnockbackComboAttackAnimation;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.WeaponCategory;
import yesman.epicfight.world.damagesource.StunType;

public class JourneymanAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> JMAN_UNARMED_IDLE;
    public static AnimationManager.AnimationAccessor<StaticAnimation> JMAN_UNARMED_GUARD;
    public static AnimationManager.AnimationAccessor<GuardAnimation> JMAN_UNARMED_GUARD_HIT;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> JMAN_UNARMED_AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> JMAN_UNARMED_AUTO2;
    public static AnimationManager.AnimationAccessor<KnockbackComboAttackAnimation> JMAN_UNARMED_DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> JMAN_SLEDGEHAMMER;
    public static AnimationManager.AnimationAccessor<AttackAnimation> JMAN_SUPPRESSING_BLOW;


    public static String jmanAnimationPath(WeaponCategory category, String entry)
    {
        return "battle_style/novice/journeyman/" + category.toString().toLowerCase() + "/" + entry;
    }


    public static void listenAnims(AnimationManager.AnimationBuilder event)
    {
        JourneymanBattleAxeAnims.Build(event);
        JourneymanAxeAnims.Build(event);

        JMAN_UNARMED_IDLE = event.nextAccessor(
                "battle_style/novice/journeyman/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        JMAN_UNARMED_GUARD = event.nextAccessor("battle_style/novice/journeyman/guard", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        JMAN_UNARMED_GUARD_HIT = event.nextAccessor("battle_style/novice/journeyman/guard_hit", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));

        JMAN_UNARMED_AUTO1 = event.nextAccessor("battle_style/novice/journeyman/auto1", access -> new ComboAttackAnimation(0.2f, 0.0f, 0.05f, 0.15f, 0.5f, ColliderPreset.FIST, Armatures.BIPED.get().handR, access, Armatures.BIPED).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 2f));
        JMAN_UNARMED_AUTO2 = event.nextAccessor("battle_style/novice/journeyman/auto2", access -> new ComboAttackAnimation(0.3f, 0.0f, 0.05f, 0.15f, 0.5f, ColliderPreset.FIST, Armatures.BIPED.get().handL, access, Armatures.BIPED).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 2f));
        JMAN_UNARMED_DASH = event.nextAccessor("battle_style/novice/journeyman/dash", access -> new KnockbackComboAttackAnimation(0.3f, 0.0f, 0.1f, 0.3f, 2.4f, ColliderPreset.FIST, Armatures.BIPED.get().handR, access, Armatures.BIPED)
                .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 70.0)
                .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.0)
                .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 4.0f));
        JMAN_SLEDGEHAMMER = event.nextAccessor("battle_style/novice/journeyman/sledgehammer", access -> new AirSlashAnimation(
                0.2f, 0.0f, 0.3f, 0.45f, 1f, false, null, Armatures.BIPED.get().handR, access, Armatures.BIPED
        ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2)).addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.WHOOSH_BIG.get()).addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get()).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1f));
        JMAN_SUPPRESSING_BLOW = event.nextAccessor("battle_style/novice/journeyman/suppressing_blow", access -> new AttackAnimation(0.3f, 0.0f, 0.5f, 0.65f, 1.6f, ColliderPreset.FIST, Armatures.BIPED.get().handR, access, Armatures.BIPED).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NEUTRALIZE).addState(EntityState.SKILL_EXECUTABLE, false).addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1f));
    }
}
