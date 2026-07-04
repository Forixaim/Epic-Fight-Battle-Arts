package net.forixaim.battle_arts.core_assets.api.actions;

import net.forixaim.euclidia.mob_ai.actions.IAction;
import net.forixaim.euclidia.mob_ai.core.AIController;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

public class ApproachAction implements IAction
{
    final float speed;
    final float distance;
    public ApproachAction(final float speed, final float distance)
    {
        this.speed = speed;
        this.distance = distance;
    }

    @Override
    public boolean isGapCloser()
    {
        return true;
    }

    @Override
    public void start(LivingEntityPatch<?> livingEntityPatch, AIController aiController)
    {
        LivingEntity target = aiController.getBossBrain().selectPrimaryTarget(aiController.getBossBrain().getBossBias());
        if(target != null && livingEntityPatch.getOriginal() instanceof PathfinderMob pathfinderMob)
        {
            livingEntityPatch.rotateTo(target, 360, true);
            pathfinderMob.getNavigation().moveTo(target, speed);
        }
    }

    @Override
    public void tick(LivingEntityPatch<?> livingEntityPatch, AIController aiController)
    {
        LivingEntity target = aiController.getBossBrain().selectPrimaryTarget(aiController.getBossBrain().getBossBias());
        float distance = livingEntityPatch.getOriginal().distanceTo(target);
        if (distance < this.distance)
            aiController.stopAction();
    }

    @Override
    public void stop(LivingEntityPatch<?> livingEntityPatch, AIController aiController)
    {

    }

    @Override
    public boolean continuous()
    {
        return true;
    }

    @Override
    public boolean interruptible(LivingEntityPatch<?> livingEntityPatch, AIController aiController)
    {
        return false;
    }
}
