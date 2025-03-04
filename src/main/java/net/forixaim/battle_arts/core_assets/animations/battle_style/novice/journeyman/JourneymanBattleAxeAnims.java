package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.hitboxes.JourneymanHitboxes;
import net.forixaim.battle_arts.core_assets.capabilities.BattleArtsWeapons;
import net.forixaim.battle_arts.core_assets.capabilities.BattleStyleCategories;
import net.forixaim.battle_arts.initialization.registry.SoundRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.utils.HitEntityList;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.world.damagesource.StunType;

public class JourneymanBattleAxeAnims
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> JMAN_BAXE_IDLE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> JMAN_BAXE_WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> JMAN_BAXE_RUN;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JMAN_BAXE_AUTO_1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> JMAN_BAXE_AUTO_2;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> JMAN_BAXE_DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> JMAN_BAXE_AIR_ATTACK;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> SEISMIC_IMPACT;

    public static void Build(AnimationManager.AnimationBuilder event)
    {
        JMAN_BAXE_IDLE = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "idle"), accessor -> new StaticAnimation(true, accessor, Armatures.BIPED));

        JMAN_BAXE_WALK = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "walk"), accessor -> new MovementAnimation(0.1f, true, accessor, Armatures.BIPED));

        JMAN_BAXE_RUN = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "run"), accessor -> new MovementAnimation(0.2f, true, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.2f));

        JMAN_BAXE_AUTO_1 = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "auto1"), accessor -> new BasicAttackAnimation(0.2f, 0.0f, 0.4f, 0.6f, 1.0f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.1f)));

        JMAN_BAXE_AUTO_2 = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "auto2"), accessor -> new BasicAttackAnimation(0.5f, 0.0f, 0.55f, 0.65f, 2.0f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.2f))
                .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2));

        JMAN_BAXE_DASH_ATTACK = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "dash_attack"), accessor -> new AirSlashAnimation(0.2f, 0.0f, 1.15f, 1.25f, 3.0f, false, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(1.7f))
                .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 2)
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false)
                .addProperty(AnimationProperty.AttackAnimationProperty.ATTACK_SPEED_FACTOR, 0.5f)
                .addEvents(

                        AnimationEvent.InTimeEvent.create(1.25f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.CLIENT).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.get().toolR, 2.0, 2F)));

        JMAN_BAXE_AIR_ATTACK = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "airslash"), accessor -> new DashAttackAnimation(0.5f, 0.0f, 0.4f, 0.6f, 2.5f, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS,2)
                .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false));

        SEISMIC_IMPACT = event.nextAccessor(JourneymanAnimations.jmanAnimationPath(BattleStyleCategories.BATTLE_AXE, "seismic_impact"),
                access -> new AirSlashAnimation(0.5f, access, Armatures.BIPED,
                        new AttackAnimation.Phase(0.0f, 0.0f, 1.4f, 1.6f, 1.6f, 1.6f, Armatures.BIPED.get().toolR, null
                        ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(2f)),
                        new AttackAnimation.Phase(1.6f, 0.0f, 1.6f, 1.7f, 3.0f, 4.0f, Armatures.BIPED.get().rootJoint, JourneymanHitboxes.SEISMIC_IMPACT)
                                .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f))
                                .addProperty(AnimationProperty.AttackPhaseProperty.MAX_STRIKES_MODIFIER, ValueModifier.setter(10))
                                .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.NO_SOUND.get())
                                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.KNOCKDOWN))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER,
                                (dynamicAnimation, livingEntityPatch, v, v1, v2) -> 1.2f)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.45f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundRegistry.JUMP.get()),
                                AnimationEvent.InTimeEvent.create(1.5f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE,
                                AnimationEvent.Side.CLIENT)
                                .params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.get().toolR, 3.0, 2F
                                ))
        );

    }
}
