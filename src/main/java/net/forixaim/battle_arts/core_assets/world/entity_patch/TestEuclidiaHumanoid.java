package net.forixaim.battle_arts.core_assets.world.entity_patch;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.world.entities.TestEuclidiaEntity;
import net.forixaim.battle_arts.core_assets.world.entity_patch.euclidia.biases.BattleArtsMobBiases;
import net.forixaim.battle_arts.initialization.registry.BattleArtsActions;
import net.forixaim.euclidia.entity_patch.EuclidiaHumanoidMobPatch;
import net.forixaim.euclidia.mob_ai.core.AIController;
import net.forixaim.euclidia.mob_ai.core.BossBrain;
import net.minecraft.world.entity.player.Player;
import yesman.epicfight.api.animation.Animator;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.world.capabilities.entitypatch.Faction;
import yesman.epicfight.world.capabilities.entitypatch.mob.ZombiePatch;

public class TestEuclidiaHumanoid extends EuclidiaHumanoidMobPatch<TestEuclidiaEntity>
{
    AIController aiController = new AIController(new BossBrain(BattleArtsMobBiases.RUSHDOWN), this, track -> track instanceof Player);
    public TestEuclidiaHumanoid(TestEuclidiaEntity original, Faction faction)
    {
        super(original, faction);
        BattleArts.LOGGER.info("test euclidia humanoid created");
        aiController.setAvailableActions(BattleArtsActions.FACE_OPPONENT, BattleArtsActions.CLOSE_GAP, BattleArtsActions.DASH_ATTACK, BattleArtsActions.JUMP_SLASH, BattleArtsActions.HORIZONTAL_SLASH_1, BattleArtsActions.HORIZONTAL_SLASH_2, BattleArtsActions.HORIZONTAL_SLASH_3, BattleArtsActions.TEST_STRAFE);
    }

    @Override
    public boolean waiting()
    {
        return false;
    }

    @Override
    protected void initAnimator(Animator animator)
    {
        super.initAnimator(animator);
        animator.addLivingAnimation(LivingMotions.IDLE, Animations.ZOMBIE_IDLE);
        animator.addLivingAnimation(LivingMotions.WALK, Animations.ZOMBIE_WALK);
        animator.addLivingAnimation(LivingMotions.CHASE, Animations.ZOMBIE_CHASE);
        animator.addLivingAnimation(LivingMotions.FALL, Animations.BIPED_FALL);
        animator.addLivingAnimation(LivingMotions.MOUNT, Animations.BIPED_MOUNT);
        animator.addLivingAnimation(LivingMotions.DEATH, Animations.BIPED_DEATH);
    }

    @Override
    public AIController controller()
    {
        return aiController;
    }

    @Override
    public void onHit()
    {

    }

    @Override
    public void updateMotion(boolean considerInaction)
    {
        commonAggressiveMobUpdateMotion(considerInaction);
    }
}
