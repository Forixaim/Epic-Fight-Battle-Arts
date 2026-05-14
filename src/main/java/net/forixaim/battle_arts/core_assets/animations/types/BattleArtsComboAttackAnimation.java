package net.forixaim.battle_arts.core_assets.animations.types;

import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.*;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

import java.util.Locale;

public class BattleArtsComboAttackAnimation extends BattleArtsAttackAnimation
{

    @Override
    public boolean isComboAttackAnimation() {
        return true;
    }

    public BattleArtsComboAttackAnimation(float transitionTime, float antic, float preDelay, float contact, float recovery, @Nullable Collider collider, Joint colliderJoint, AnimationManager.AnimationAccessor<BattleArtsComboAttackAnimation> accessor, AssetAccessor<? extends Armature> armature) {
        super(transitionTime, antic, preDelay, contact, recovery, collider, colliderJoint, accessor, armature);
    }

    public BattleArtsComboAttackAnimation(float transitionTime, AnimationManager.AnimationAccessor<? extends BattleArtsComboAttackAnimation> accessor, AssetAccessor<? extends Armature> armature, Phase... phases) {
        super(transitionTime, accessor, armature, phases);
    }
    public BattleArtsComboAttackAnimation(float convertTime, String path, AssetAccessor<? extends Armature> armature, Phase... phases) {
        super(convertTime, path, armature, phases);
    }



    @Override
    public void postInit() {
        super.postInit();

        if (!this.properties.containsKey(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED)) {
            float basisSpeed = Float.parseFloat(String.format(Locale.US, "%.2f", (1.0F / this.getTotalTime())));
            this.addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, basisSpeed);
        }
    }
    @Override
    protected Vec3 getCoordVector(LivingEntityPatch<?> entitypatch, AssetAccessor<? extends DynamicAnimation> dynamicAnimation) {
        Vec3 vec3 = super.getCoordVector(entitypatch, dynamicAnimation);

        if (entitypatch.shouldBlockMoving() && this.getProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE).orElse(false)) {
            vec3 = vec3.scale(0.0F);
        }

        return vec3;
    }
}
