package net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist;

import it.unimi.dsi.fastutil.ints.IntIntPair;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackPhaseProperties;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsAttackAnimation;
import net.forixaim.battle_arts.core_assets.animations.types.BattleArtsWalkAnimation;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.animation.types.procedural.HumanoidWalkAnimation;
import yesman.epicfight.api.physics.ik.InverseKinematicsSimulator;
import yesman.epicfight.api.utils.TimePairList;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.ValueModifier;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.gameasset.*;
import yesman.epicfight.registry.entries.EpicFightSkillDataKeys;
import yesman.epicfight.registry.entries.EpicFightSkills;
import yesman.epicfight.registry.entries.EpicFightSounds;
import yesman.epicfight.skill.SkillDataManager;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.damagesource.StunType;

import java.util.List;

public class DuelistSwordAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> WALK;
    public static AnimationManager.AnimationAccessor<MovementAnimation> RUN;
    public static AnimationManager.AnimationAccessor<StaticAnimation> GUARD;
    public static AnimationManager.AnimationAccessor<EmoteAnimation> BRANDISH;

    public static AnimationManager.AnimationAccessor<SelectiveAnimation> GUARD_SET;

    public static AnimationManager.AnimationAccessor<StaticAnimation> PARRY_STANCE1;
    public static AnimationManager.AnimationAccessor<StaticAnimation> PARRY_STANCE2;

    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_HIT;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_1;
    public static AnimationManager.AnimationAccessor<GuardAnimation> GUARD_PARRY_2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO3;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH_ATTACK;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIR_ATTACK;
    public static AnimationManager.AnimationAccessor<BattleArtsAttackAnimation> KNEE_SMASH;
    public static AnimationManager.AnimationAccessor<AttackAnimation> QUAD_STING;
    public static AnimationManager.AnimationAccessor<BattleArtsAttackAnimation> PIERCING_FALCON;
    public static AnimationManager.AnimationAccessor<BattleArtsAttackAnimation> SHOOTING_STAR;

    public static void build(AnimationManager.AnimationBuilder builder)
    {
        IDLE = builder.nextAccessor("battle_style/advanced/duelist/sword/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        BRANDISH = builder.nextAccessor("battle_style/advanced/duelist/sword/brandish", access -> new EmoteAnimation(0.2f, true, access, Armatures.BIPED));
        GUARD = builder.nextAccessor("battle_style/advanced/duelist/sword/guard", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        PARRY_STANCE1 = builder.nextAccessor("battle_style/advanced/duelist/sword/parry_stance1", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        PARRY_STANCE2 = builder.nextAccessor("battle_style/advanced/duelist/sword/parry_stance2", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        GUARD_SET = builder.nextAccessor("battle_style/advanced/duelist/sword/guard_set", access -> new SelectiveAnimation(
                livingEntityPatch -> {
                    if (livingEntityPatch instanceof PlayerPatch<?> playerPatch)
                    {
                        SkillDataManager dataManager = playerPatch.getSkill(SkillSlots.GUARD).getDataManager();
                        if (playerPatch.getSkill(SkillSlots.GUARD).hasSkill(EpicFightSkills.PARRYING.get()) && dataManager.hasData(EpicFightSkillDataKeys.PARRY_MOTION_COUNTER))
                        {
                            return (dataManager.getDataValue(EpicFightSkillDataKeys.PARRY_MOTION_COUNTER) % 2) + 1;
                        }
                    }
                    return 0;
                }, access, GUARD, PARRY_STANCE2, PARRY_STANCE1
        ));

        GUARD_HIT = builder.nextAccessor("battle_style/advanced/duelist/sword/guard_hit", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_1 = builder.nextAccessor("battle_style/advanced/duelist/sword/parry1", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));
        GUARD_PARRY_2 = builder.nextAccessor("battle_style/advanced/duelist/sword/parry2", access -> new GuardAnimation(0.0f, access, Armatures.BIPED));

        WALK = builder.nextAccessor("battle_style/advanced/duelist/sword/walk", access -> new MovementAnimation(0.2f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.IK_DEFINITION, List.of(
                        InverseKinematicsSimulator.InverseKinematicsDefinition.create(Armatures.BIPED.get().thighL, Armatures.BIPED.get().legL, Armatures.BIPED.get().legR, IntIntPair.of(0, 2), 0.05f, 0, new boolean[]{true, true}),
                        InverseKinematicsSimulator.InverseKinematicsDefinition.create(Armatures.BIPED.get().thighR, Armatures.BIPED.get().legR, Armatures.BIPED.get().legL, IntIntPair.of(0, 2), 0.05f, 0, new boolean[]{true, true})
                ))
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 2f));

        RUN = builder.nextAccessor("battle_style/advanced/duelist/sword/run", access -> new MovementAnimation(0.2f, true, access, Armatures.BIPED)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                        v * 1.3f));

        KNEE_SMASH = builder.nextAccessor("battle_style/advanced/duelist/sword/knee_smash", access ->
                new BattleArtsAttackAnimation(0.05f, 0.0f, 0.0f, 0.1f, 0.9f, ColliderPreset.FIST, Armatures.BIPED.get().kneeR, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1.0)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 0.0)
                        .addProperty(AnimationProperty.AttackPhaseProperty.HIT_SOUND, EpicFightSounds.BLUNT_HIT_HARD.get())
                        .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.NEUTRALIZE)
                        .addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.2f))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                1));

        AUTO1 = builder.nextAccessor("battle_style/advanced/duelist/sword/auto1", access ->
                new ComboAttackAnimation(0.05f, 0.0f, 0.1f, 0.2f, 0.3f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 4)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                1));
        AUTO2 = builder.nextAccessor("battle_style/advanced/duelist/sword/auto2", access ->
                new ComboAttackAnimation(0.05f, 0.0f, 0.1f, 0.2f, 0.3f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 4)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                1));

        AUTO3 = builder.nextAccessor("battle_style/advanced/duelist/sword/auto3", access ->
                new ComboAttackAnimation(0.05f, 0.0f, 0.1f, 0.2f, 1.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.AttackAnimationProperty.EXTRA_COLLIDERS, 1)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                1));

        DASH_ATTACK = builder.nextAccessor("battle_style/advanced/duelist/sword/dash_attack", access ->
                new DashAttackAnimation(0.2f, 0.0f, 0.3f, 0.45f, 1.9f, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 1));

        AIR_ATTACK = builder.nextAccessor("battle_style/advanced/duelist/sword/aerial", access ->
                new AirSlashAnimation(0.2f, 0.0f, 0.5f, 0.6f, 1.9f, false, null, Armatures.BIPED.get().toolR, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, false)

                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 1.3f));

        QUAD_STING = builder.nextAccessor("battle_style/advanced/duelist/sword/quadsting", access ->
                new AttackAnimation(0.2f, access, Armatures.BIPED, new AttackAnimation.Phase(
                        0.0f, 0.0f, 0.5f, 0.6f, 0.65f, 0.65f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.5f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD), new AttackAnimation.Phase(
                        0.65f, 0.0f, 0.65f, 0.75f, 0.8f, 0.8f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.6f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD), new AttackAnimation.Phase(
                        0.8f, 0.0f, 0.8f, 0.9f, 1.1f, 1.1f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.7f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.HOLD), new AttackAnimation.Phase(
                        1.1f, 0.0f, 1.1f, 1.2f, 2f, 2f, Armatures.BIPED.get().toolR, null
                ).addProperty(AnimationProperty.AttackPhaseProperty.DAMAGE_MODIFIER, ValueModifier.multiplier(0.9f)).addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG))
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v * 0.4f));

        PIERCING_FALCON = builder.nextAccessor("battle_style/advanced/duelist/sword/piercing_falcon", access ->
                new BattleArtsAttackAnimation(0.2f, 0.2f, 0.2f, 0.3f, 0.4f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, 40d)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1d)
                        .addProperty(AnimationProperty.AttackPhaseProperty.IMPACT_MODIFIER, ValueModifier.setter(4))
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                                v)
                        .addEvents(
                                AnimationEvent.InTimeEvent.create(0.2f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(EpicFightSounds.ROCKET_JUMP.get())));

        SHOOTING_STAR = builder.nextAccessor("battle_style/advanced/duelist/sword/shooting_star", access ->
                new BattleArtsAttackAnimation(0.2f, 0.6f, 0.5f, 0.6f, 1.9f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_ANGLE, -40d)
                        .addProperty(BattleArtsAttackPhaseProperties.KNOCKBACK_POWER, 1d)
                        .addProperty(AnimationProperty.AttackAnimationProperty.FIXED_MOVE_DISTANCE, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.MOVE_VERTICAL, true)
                        .addProperty(AnimationProperty.ActionAnimationProperty.NO_GRAVITY_TIME, TimePairList.create(0.0f, 0.5f))
                        .addState(EntityState.SKILL_EXECUTABLE, false)
                        .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, speed, prevElapsedTime, elapsedTime) ->
                                {
                                    if (elapsedTime >= 0.5F && elapsedTime < 0.6F) {
                                        float dpx = (float) livingEntityPatch.getOriginal().getX();
                                        float dpy = (float) livingEntityPatch.getOriginal().getY();
                                        float dpz = (float) livingEntityPatch.getOriginal().getZ();

                                        for(BlockState block = livingEntityPatch.getOriginal().level().getBlockState(new BlockPos.MutableBlockPos(dpx, dpy, dpz)); (block.getBlock() instanceof BushBlock || block.isAir()) && !block.is(Blocks.VOID_AIR); block = livingEntityPatch.getOriginal().level().getBlockState(new BlockPos.MutableBlockPos(dpx, dpy, dpz))) {
                                            --dpy;
                                        }

                                        float distanceToGround = (float)Math.max(Math.abs(livingEntityPatch.getOriginal().getY() - (double)dpy) - (double)1.0F, 0.0F);
                                        LivingEntity livingentity = livingEntityPatch.getOriginal();
                                        Vec3f direction = new Vec3f(2.5F, -1.5F, 0.0F);
                                        OpenMatrix4f rotation = new OpenMatrix4f().rotate(-(float)Math.toRadians(livingEntityPatch.getOriginal().yBodyRotO + 90.0F), new Vec3f(0.0F, 1.0F, 0.0F));
                                        OpenMatrix4f.transform3v(rotation, direction, direction);
                                        if (distanceToGround > 0.5F) {
                                            livingentity.move(MoverType.SELF, direction.toDoubleVector());
                                            return 0.025F;
                                        } else {
                                            return speed * 0.7f;
                                        }
                                    } else {
                                        return speed * 0.7f;
                                    }
                                })
                        .addEvents(AnimationEvent.InTimeEvent.create(0.5f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(EpicFightSounds.ROCKET_JUMP.get())
                                ,AnimationEvent.InTimeEvent.create(0.6f, Animations.ReusableSources.FRACTURE_GROUND_SIMPLE, AnimationEvent.Side.SERVER).params(new Vec3f(0.0F, -0.24F, -2.0F), Armatures.BIPED.get().rootJoint, 1.2, 1F)));



    }
}
