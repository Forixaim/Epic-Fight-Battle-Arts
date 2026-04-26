package net.forixaim.battle_arts.core_assets.animations.types;

import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.procedural.HumanoidWalkAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.api.physics.ik.InverseKinematicsSimulatable;
import yesman.epicfight.api.physics.ik.InverseKinematicsSimulator;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.api.utils.math.Vec3f;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

public class BattleArtsWalkAnimation extends HumanoidWalkAnimation {
    public BattleArtsWalkAnimation(boolean isRepeat, AnimationManager.AnimationAccessor<? extends MovementAnimation> accessor, AssetAccessor<? extends Armature> armature) {
        super(isRepeat, accessor, armature);
    }

    public BattleArtsWalkAnimation(float transitionTime, boolean isRepeat, AnimationManager.AnimationAccessor<? extends MovementAnimation> accessor, AssetAccessor<? extends Armature> armature) {
        super(transitionTime, isRepeat, accessor, armature);
    }

    public BattleArtsWalkAnimation(float transitionTime, boolean isRepeat, String path, AssetAccessor<? extends Armature> armature) {
        super(transitionTime, isRepeat, path, armature);
    }

    @Override
    public void tick(LivingEntityPatch<?> entitypatch) {
        super.tick(entitypatch);

        if (entitypatch instanceof InverseKinematicsSimulatable ikSimulatable) {
            if (!(entitypatch.getAnimator().getPlayerFor(null).getAnimation().get() == this)) return;

            Vec3 entitypos = ikSimulatable.toEntity().position();
            OpenMatrix4f toWorld = OpenMatrix4f.mul(OpenMatrix4f.createTranslation((float)entitypos.x, (float)entitypos.y, (float)entitypos.z), ikSimulatable.getModelMatrix(1.0F), null);

            for (InverseKinematicsSimulator.BakedInverseKinematicsDefinition bakedIKInfo : this.getProperty(AnimationProperty.StaticAnimationProperty.BAKED_IK_DEFINITION).orElse(null)) {
                if (!ikSimulatable.getIKSimulator().isRunning(bakedIKInfo.endJoint())) continue;

                InverseKinematicsSimulator.InverseKinematicsObject ikObject = ikSimulatable.getIKSimulator().getRunningObject(bakedIKInfo.endJoint()).get();
                Vec3f clipStart = bakedIKInfo.endPosition().copy().add(0.0F, 2.5F, 0.0F).multiply(-1.0F, 1.0F, -1.0F);
                Vec3f finalTargetpos = this.getRayCastedTipPosition(ikSimulatable, clipStart, toWorld, 8.0F, bakedIKInfo.rayLeastHeight());

                if (ikObject.isOnWorking()) {
                    ikObject.newTargetPosition(finalTargetpos);
                } else {
                    InverseKinematicsSimulator.InverseKinematicsObject opponentIKObject = ikSimulatable.getIKSimulator().getRunningObject(bakedIKInfo.opponentJoint()).get();

                    if (opponentIKObject != null && !opponentIKObject.isOnWorking()) {
                        Vec3f footpos = ikObject.getTipPosition(1.0F);

                        if (footpos.distanceSqr(finalTargetpos) > 15.0D) {
                            this.startPartAnimation(bakedIKInfo, ikObject, this.clipAnimation(bakedIKInfo.terminalBoneTransform(), bakedIKInfo), finalTargetpos);
                        }
                    }
                }
            }
        }
    }
}
