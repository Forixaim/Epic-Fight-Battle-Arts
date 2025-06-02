package net.forixaim.battle_arts.core_assets.animations.types;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireBowAnimations;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.ActionAnimation;
import yesman.epicfight.api.animation.types.DynamicAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.asset.AssetAccessor;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

public class PowerDrawStartAnimation extends ActionAnimation
{

    public PowerDrawStartAnimation(float transitionTime, AnimationManager.AnimationAccessor<? extends ActionAnimation> accessor, AssetAccessor<? extends Armature> armature)
    {
        super(transitionTime, accessor, armature);
    }

    public PowerDrawStartAnimation(float transitionTime, float postDelay, AnimationManager.AnimationAccessor<? extends ActionAnimation> accessor, AssetAccessor<? extends Armature> armature)
    {
        super(transitionTime, postDelay, accessor, armature);
    }

    public PowerDrawStartAnimation(float transitionTime, float postDelay, String path, AssetAccessor<? extends Armature> armature)
    {
        super(transitionTime, postDelay, path, armature);
    }

    @Override
    public void end(LivingEntityPatch<?> entitypatch, AssetAccessor<? extends DynamicAnimation> nextAnimation, boolean isEnd)
    {
        if (isEnd)
        {
            entitypatch.playAnimationSynchronized(SquireBowAnimations.POWER_DRAW_HOLD, 0);
        }
        super.end(entitypatch, nextAnimation, isEnd);
    }
}
