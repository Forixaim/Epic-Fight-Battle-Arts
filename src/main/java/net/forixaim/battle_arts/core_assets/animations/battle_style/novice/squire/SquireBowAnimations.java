package net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire;

import net.forixaim.battle_arts.core_assets.animations.types.PowerDrawStartAnimation;
import net.forixaim.battle_arts.core_assets.items.weapons.ranged.BattleBowItem;
import net.forixaim.battle_arts.initialization.registry.BattleArtsDataKeys;
import net.forixaim.battle_arts.initialization.registry.BattleArtsProjectiles;
import net.forixaim.battle_arts.core_assets.world.projectiles.FixedArrow;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationEvent;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.gameasset.Armatures;
import yesman.epicfight.gameasset.ColliderPreset;
import yesman.epicfight.registry.entries.EpicFightAttributes;
import yesman.epicfight.skill.SkillSlots;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.damagesource.StunType;

public class SquireBowAnimations
{
    public static AnimationManager.AnimationAccessor<StaticAnimation> IDLE;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO1;
    public static AnimationManager.AnimationAccessor<ComboAttackAnimation> AUTO2;
    public static AnimationManager.AnimationAccessor<DashAttackAnimation> DASH;
    public static AnimationManager.AnimationAccessor<AirSlashAnimation> AIRSLASH;
    public static AnimationManager.AnimationAccessor<PowerDrawStartAnimation> POWER_DRAW_START;
    public static AnimationManager.AnimationAccessor<StaticAnimation> POWER_DRAW_HOLD;
    public static AnimationManager.AnimationAccessor<AttackAnimation> POWER_DRAW_FIRE;

    public static void Build(AnimationManager.AnimationBuilder event)
    {
        IDLE = event.nextAccessor("battle_style/novice/squire/bow/idle", access -> new StaticAnimation(0.2f, true, access, Armatures.BIPED));
        AUTO1 = event.nextAccessor("battle_style/novice/squire/bow/auto1", access -> new ComboAttackAnimation(0.1f, 0.5f, 0.5f, 0.5f, 0.7f, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.ARROW_SHOOT)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    if (livingEntityPatch instanceof ServerPlayerPatch playerPatch && v2 < 0.5 &&
                            playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING)
                            && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULL_LEVEL))
                    {
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSync(BattleArtsDataKeys.PULLING, true);
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSyncF(BattleArtsDataKeys.PULL_LEVEL, data -> data + 0.25f);
                    }
                    //Eventual Battle Bow Setup for dedicated damage.
                    if (livingEntityPatch.getOriginal().getMainHandItem().getItem() instanceof BattleBowItem)
                        return v;
                    return 3f;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.5f, ReusableSources.FIRE_ARROW_COMBO, AnimationEvent.Side.SERVER).params(1.2f)));

        AUTO2 = event.nextAccessor("battle_style/novice/squire/bow/auto2", access -> new ComboAttackAnimation(0.2f, 0.25f, 0.25f, 0.3f, 1f, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.ARROW_SHOOT)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    if (livingEntityPatch instanceof ServerPlayerPatch playerPatch && v2 < 0.25 &&
                            playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING)
                            && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULL_LEVEL))
                    {
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSync(BattleArtsDataKeys.PULLING, true);
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSyncF(BattleArtsDataKeys.PULL_LEVEL, data -> data + 0.7f);
                    }
                    //Eventual Battle Bow Setup for dedicated damage.
                    if (livingEntityPatch.getOriginal().getMainHandItem().getItem() instanceof BattleBowItem)
                        return v;
                    return 2f;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.25f, ReusableSources.FIRE_ARROW_COMBO, AnimationEvent.Side.SERVER).params(1.5f)));

        DASH = event.nextAccessor("battle_style/novice/squire/bow/dash", access -> new DashAttackAnimation(0.1f, 0f, 0.05f, 0.35f, 1.5f, ColliderPreset.BATTOJUTSU_DASH, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.ARROW_SHOOT)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    if (livingEntityPatch instanceof ServerPlayerPatch playerPatch && v2 < 0.65 && v2 > 0.3 &&
                            playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING)
                            && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULL_LEVEL)
                    )
                    {
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSync(BattleArtsDataKeys.PULLING, true);
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSyncF(BattleArtsDataKeys.PULL_LEVEL, data -> data + 0.7f);
                    }
                    //Eventual Battle Bow Setup for dedicated damage.
                    if (livingEntityPatch.getOriginal().getMainHandItem().getItem() instanceof BattleBowItem)
                        return v;
                    return 2;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.65f, ReusableSources.FIRE_ARROW, AnimationEvent.Side.SERVER).params(0.2, 1.5f)));
        AIRSLASH = event.nextAccessor("battle_style/novice/squire/bow/airslash", access -> new AirSlashAnimation(0.1f, 0.05f, 0.05f, 0.35f, 1.5f, true, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.ARROW_SHOOT)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    if (livingEntityPatch instanceof ServerPlayerPatch playerPatch && v2 < 0.25 &&
                            playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING)
                            && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULL_LEVEL))
                    {
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSync(BattleArtsDataKeys.PULLING, true);
                        playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSyncF(BattleArtsDataKeys.PULL_LEVEL, data -> data + 0.7f);
                    }
                    //Eventual Battle Bow Setup for dedicated damage.
                    if (livingEntityPatch.getOriginal().getMainHandItem().getItem() instanceof BattleBowItem)
                        return v;
                    return 2;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.25f, ReusableSources.FIRE_ARROW, AnimationEvent.Side.SERVER).params(-0.5, 2f)));
        POWER_DRAW_START = event.nextAccessor("battle_style/novice/squire/bow/power_draw_start", access ->
                new PowerDrawStartAnimation(0.1f, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true));

        POWER_DRAW_HOLD = event.nextAccessor("battle_style/novice/squire/bow/power_draw_hold", access ->
                new StaticAnimation(1f, true, access, Armatures.BIPED)
                        .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true));
        POWER_DRAW_FIRE = event.nextAccessor("battle_style/novice/squire/bow/power_draw_release", access -> new AttackAnimation(0f, 0f, 0.05f, 0.35f, 1.5f, null, Armatures.BIPED.get().rootJoint, access, Armatures.BIPED)
                .addProperty(AnimationProperty.AttackPhaseProperty.STUN_TYPE, StunType.LONG)
                .addProperty(AnimationProperty.AttackPhaseProperty.SWING_SOUND, SoundEvents.ARROW_SHOOT)
                .addProperty(AnimationProperty.StaticAnimationProperty.FIXED_HEAD_ROTATION, true)
                .addProperty(AnimationProperty.StaticAnimationProperty.PLAY_SPEED_MODIFIER, (dynamicAnimation, livingEntityPatch, v, v1, v2) ->
                {
                    //Eventual Battle Bow Setup for dedicated damage.
                    if (livingEntityPatch.getOriginal().getMainHandItem().getItem() instanceof BattleBowItem)
                        return v;
                    return 1;
                })
                .addEvents(AnimationEvent.InTimeEvent.create(0.0f, ReusableSources.FIRE_POWER_ARROW, AnimationEvent.Side.SERVER).params(0.0)));
    }

    public static class ReusableSources
    {
        @SuppressWarnings("unchecked")
        public static AnimationEvent.E2<Double, Float> FIRE_ARROW = (livingEntityPatch, assetAccessor, animationParameters) ->
        {
            float ang = (float) ((livingEntityPatch.getYRot()+90)/180 * Math.PI);
            Vec3 shootVec = new Vec3(Math.cos(ang), animationParameters.first() , Math.sin(ang));
            Vec3 shootPos = livingEntityPatch.getOriginal().position().add(shootVec.x, 0, shootVec.z).add(0, 1.5, 0);
            double velocity = livingEntityPatch.getOriginal().getAttributeValue(EpicFightAttributes.IMPACT);
            float multiplier = 1;

            if (animationParameters.second() != null)
            {
                multiplier = animationParameters.second();
            }

            FixedArrow projectile = BattleArtsProjectiles.FIXED_ARROW.get().create(livingEntityPatch.getOriginal().level());

            if (livingEntityPatch instanceof ServerPlayerPatch playerPatch && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING))
            {
                playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSync(BattleArtsDataKeys.PULLING, false);
                playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSyncF(BattleArtsDataKeys.PULL_LEVEL, data -> 0.0f);
            }

            if (projectile != null)
            {
                if (assetAccessor.get().isComboAttackAnimation()) {
                    projectile.setAttack((AnimationManager.AnimationAccessor<? extends AttackAnimation>) assetAccessor);
                    AttackAnimation.Phase faze = ((AttackAnimation)assetAccessor.get()).phases[0];
                    projectile.setPhase(faze);
                }

                projectile.setPos(shootPos);
                projectile.setFixedDamage((float) livingEntityPatch.getOriginal().getAttributeValue(Attributes.ATTACK_DAMAGE) * multiplier);
                projectile.setOwner(livingEntityPatch.getOriginal());
                projectile.pickup = AbstractArrow.Pickup.DISALLOWED;
                projectile.shoot(shootVec.x(), shootVec.y(), shootVec.z(), 2f + (float)velocity, 0);
                livingEntityPatch.getOriginal().level().addFreshEntity(projectile);
            }
        };

        public static AnimationEvent.E1<Float> FIRE_ARROW_COMBO = (livingEntityPatch, assetAccessor, animationParameters) ->
        {
            float ang = (float) ((livingEntityPatch.getYRot()+90)/180 * Math.PI);
            double vert = livingEntityPatch.getOriginal().getLookAngle().normalize().y();
            Vec3 shootVec = new Vec3(Math.cos(ang), vert , Math.sin(ang));
            Vec3 shootPos = livingEntityPatch.getOriginal().position().add(shootVec.x, 0, shootVec.z).add(0, 1.5, 0);
            double velocity = livingEntityPatch.getOriginal().getAttributeValue(EpicFightAttributes.IMPACT);
            float multiplier = 1;

            if (animationParameters.first() != null)
            {
                multiplier = animationParameters.first();
            }

            FixedArrow projectile = BattleArtsProjectiles.FIXED_ARROW.get().create(livingEntityPatch.getOriginal().level());

            if (livingEntityPatch instanceof ServerPlayerPatch playerPatch && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.PULLING))
            {
                playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSync(BattleArtsDataKeys.PULLING, false);
                playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSyncF(BattleArtsDataKeys.PULL_LEVEL, data -> 0.0f);
            }

            if (projectile != null)
            {
                if (assetAccessor.get().isComboAttackAnimation()) {
                    projectile.setAttack((AnimationManager.AnimationAccessor<? extends AttackAnimation>) assetAccessor);
                    AttackAnimation.Phase faze = ((AttackAnimation)assetAccessor.get()).phases[0];
                    projectile.setPhase(faze);
                }

                projectile.setPos(shootPos);
                projectile.setFixedDamage((float) livingEntityPatch.getOriginal().getAttributeValue(Attributes.ATTACK_DAMAGE) * multiplier);
                projectile.setOwner(livingEntityPatch.getOriginal());
                projectile.pickup = AbstractArrow.Pickup.DISALLOWED;
                projectile.shoot(shootVec.x(), shootVec.y(), shootVec.z(), 2f + (float)velocity, 0);
                livingEntityPatch.getOriginal().level().addFreshEntity(projectile);
            }
        };

        public static AnimationEvent.E1<Double> FIRE_POWER_ARROW = (livingEntityPatch, assetAccessor, animationParameters) ->
        {
            float ang = (float) ((livingEntityPatch.getYRot()+90)/180 * Math.PI);
            Vec3 shootVec = new Vec3(Math.cos(ang), animationParameters.first() , Math.sin(ang));
            Vec3 shootPos = livingEntityPatch.getOriginal().position().add(shootVec.x, 0, shootVec.z).add(0, 1.5, 0);

            byte pierceLevel = 1;
            float chargePower = 0;

            if (livingEntityPatch instanceof ServerPlayerPatch playerPatch)
            {
                playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSync(BattleArtsDataKeys.PULLING, false);
                playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().setDataSyncF(BattleArtsDataKeys.PULL_LEVEL, data -> 0.0f);
            }

            if (livingEntityPatch instanceof PlayerPatch<?> playerPatch && playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().hasData(BattleArtsDataKeys.CHARGE_POWER))
            {
                pierceLevel = playerPatch.getSkill(SkillSlots.WEAPON_INNATE).getDataManager().getDataValue(BattleArtsDataKeys.CHARGE_POWER).byteValue();
                chargePower = playerPatch.getChargingTicks() / 20f;
            }

            Arrow projectile = EntityType.ARROW.create(livingEntityPatch.getOriginal().level());

            if (projectile != null)
            {
                projectile.setPos(shootPos);
                projectile.setOwner(livingEntityPatch.getOriginal());
                projectile.pickup = AbstractArrow.Pickup.DISALLOWED;
                projectile.setCritArrow(true);
                projectile.setBaseDamage((float) livingEntityPatch.getOriginal().getAttributeValue(Attributes.ATTACK_DAMAGE) * 0.5f);
                projectile.shoot(shootVec.x(), shootVec.y(), shootVec.z(), 5.5f + chargePower, 0);
                livingEntityPatch.getOriginal().level().addFreshEntity(projectile);
            }
        };
    }
}
