package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import net.forixaim.battle_arts.core_assets.animations.types.PowerDrawStartAnimation;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.world.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.world.FlyingShockwaveProjectile;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.damagesource.StunType;

public class SquireBowAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIRSLASH;
    public static AnimationManager.AnimationAccessor<PowerDrawStartAnimation> POWER_DRAW_START;
    public static AnimationManager.AnimationAccessor<StaticAnimation> POWER_DRAW_HOLD;
    public static AnimationManager.AnimationAccessor<AttackAnimation> POWER_DRAW_FIRE;

    public static void Build(AnimationManager.AnimationBuilder event)
    {
        IDLE = event.nextAccessor("battle_style/novice/squire/bow/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        AUTO1 = event.nextAccessor("battle_style/novice/squire/bow/auto1", access -> new BasicAttackAnimation(0.1f, 0.5f, 0.5f, 0.5f, 0.7f, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.ARROW_SHOOT)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    //Eventual Battle Bow Setup for dedicated damage.
                    return 2f;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.5f, ReusableSources.FIRE_ARROW, AnimationEvent.Side.SERVER).params(0d)));

        AUTO2 = event.nextAccessor("battle_style/novice/squire/bow/auto2", access -> new BasicAttackAnimation(0.2f, 0.25f, 0.25f, 0.3f, 1f, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.ARROW_SHOOT)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    //Eventual Battle Bow Setup for dedicated damage.
                    return 1.2f;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.25f, ReusableSources.FIRE_ARROW, AnimationEvent.Side.SERVER).params(0d)));

        DASH = event.nextAccessor("battle_style/novice/squire/bow/dash", access -> new DashAttackAnimation(0.1f, 0f, 0.05f, 0.35f, 1.5f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.NO_SOUND.get())
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    //Eventual Battle Bow Setup for dedicated damage.
                    return 1;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.65f, ReusableSources.FIRE_ARROW, AnimationEvent.Side.SERVER).params(0.2), AnimationEvent.InTimeEvent.create(0.65f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.ARROW_SHOOT)));
        AIRSLASH = event.nextAccessor("battle_style/novice/squire/bow/airslash", access -> new AirSlashAnimation(0.1f, 0.05f, 0.05f, 0.35f, 1.5f, true, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.NO_SOUND.get())
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    //Eventual Battle Bow Setup for dedicated damage.
                    return 1;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.25f, ReusableSources.FIRE_ARROW, AnimationEvent.Side.SERVER).params(-0.5), AnimationEvent.InTimeEvent.create(0.25f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.ARROW_SHOOT)));
        POWER_DRAW_START = event.nextAccessor("battle_style/novice/squire/bow/power_draw_start", access ->
                new PowerDrawStartAnimation(0.1f, access, Armatures.BIPED));

        POWER_DRAW_HOLD = event.nextAccessor("battle_style/novice/squire/bow/power_draw_hold", access ->
                new StaticAnimation(1f, true, access, Armatures.BIPED));

        POWER_DRAW_FIRE = event.nextAccessor("battle_style/novice/squire/bow/power_draw_release", access -> new AttackAnimation(0f, 0f, 0.05f, 0.35f, 1.5f, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, EpicFightSounds.NO_SOUND.get())
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    //Eventual Battle Bow Setup for dedicated damage.
                    return 1;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.0f, ReusableSources.FIRE_POWER_ARROW, AnimationEvent.Side.SERVER).params(0.0), AnimationEvent.InTimeEvent.create(0.0f, Animations.ReusableSources.PLAY_SOUND, AnimationEvent.Side.CLIENT).params(SoundEvents.ARROW_SHOOT)));
    }

    public static class ReusableSources
    {
        public static AnimationEvent.E1<Double> FIRE_ARROW = (livingEntityPatch, assetAccessor, animationParameters) ->
        {
            float ang = (float) ((livingEntityPatch.getYRot()+90)/180 * Math.PI);
            Vec3 shootVec = new Vec3(Math.cos(ang), animationParameters.first() , Math.sin(ang));
            Vec3 shootPos = livingEntityPatch.getOriginal().position().add(shootVec.x, 0, shootVec.z).add(0, 2, 0);

            if (livingEntityPatch.getOriginal().getProjectile(livingEntityPatch.getOriginal().getItemInHand(InteractionHand.MAIN_HAND)).isEmpty())
            {
                return;
            }

            Arrow projectile = EntityType.ARROW.create(livingEntityPatch.getOriginal().level());

            if (projectile != null)
            {
                projectile.setPos(shootPos);
                projectile.setOwner(livingEntityPatch.getOriginal());
                projectile.pickup = AbstractArrow.Pickup.DISALLOWED;
                projectile.shoot(shootVec.x(), shootVec.y(), shootVec.z(), 4.2f, 0);
                livingEntityPatch.getOriginal().level().addFreshEntity(projectile);
            }
        };

        public static AnimationEvent.E1<Double> FIRE_POWER_ARROW = (livingEntityPatch, assetAccessor, animationParameters) ->
        {
            float ang = (float) ((livingEntityPatch.getYRot()+90)/180 * Math.PI);
            Vec3 shootVec = new Vec3(Math.cos(ang), animationParameters.first() , Math.sin(ang));
            Vec3 shootPos = livingEntityPatch.getOriginal().position().add(shootVec.x, 0, shootVec.z).add(0, 2, 0);

            float velocity = 6.4f;
            byte pierceLevel = 1;

            if (livingEntityPatch instanceof PlayerPatch<?> playerPatch && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.CHARGE_POWER.get()))
            {
                velocity += playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.CHARGE_POWER.get());
                pierceLevel = playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.CHARGE_POWER.get()).byteValue();
            }

            if (livingEntityPatch.getOriginal().getProjectile(livingEntityPatch.getOriginal().getItemInHand(InteractionHand.MAIN_HAND)).isEmpty())
            {
                return;
            }

            Arrow projectile = EntityType.ARROW.create(livingEntityPatch.getOriginal().level());

            if (projectile != null)
            {
                projectile.setPos(shootPos);
                projectile.setOwner(livingEntityPatch.getOriginal());
                projectile.pickup = AbstractArrow.Pickup.DISALLOWED;
                projectile.setCritArrow(true);
                projectile.setBaseDamage(1.0);
                projectile.setPierceLevel(pierceLevel);
                projectile.shoot(shootVec.x(), shootVec.y(), shootVec.z(), velocity, 0);
                livingEntityPatch.getOriginal().level().addFreshEntity(projectile);
            }
        };
    }
}
