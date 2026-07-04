package net.forixaim.battle_arts.initialization.registry;

import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireSwordAnimations;
import net.forixaim.battle_arts.core_assets.api.actions.ApproachAction;
import net.forixaim.euclidia.mob_ai.actions.*;
import net.forixaim.euclidia.registry.helpers.ActionRegister;


import net.forixaim.euclidia.registry.helpers.DeferredAction;
import yesman.epicfight.gameasset.Animations;

public final class BattleArtsActions
{
    private BattleArtsActions()
    {
    }

    public static final ActionRegister REGISTRY = ActionRegister.create(BattleArts.MOD_ID);

    public static final DeferredAction<ApproachAction> APPROACH_SLOW = REGISTRY.registerAction("approach_slow", (rl) -> new ActionBuilder<>(new ApproachAction(1f, 2f)).neutral(ActionBuilder.Operation.SET).advanced().distanceToTarget(ActionBuilder.Operation.SET, 0.8f).herding().build(rl));
    public static final DeferredAction<FaceOpponentAction> FACE_OPPONENT = REGISTRY.registerAction("face_opponent", (rl) -> new ActionBuilder<>(new FaceOpponentAction()).neutral(ActionBuilder.Operation.SET).build(rl));
    public static final DeferredAction<StrafeAction> TEST_STRAFE = REGISTRY.registerAction("test_strafe", (rl) -> new ActionBuilder<>(new StrafeAction(20, false)).lookingAtTarget(ActionBuilder.Operation.SET, false).build(rl));
    public static final DeferredAction<GapCloserAction> CLOSE_GAP = REGISTRY.registerAction("close_gap", (rl) -> new ActionBuilder<>(new GapCloserAction(Animations.BIPED_STEP_FORWARD, 2)).neutral(ActionBuilder.Operation.SET).closeIn(ActionBuilder.Operation.SET).lookingAtTarget(ActionBuilder.Operation.SET, true).build(rl));
    public static final DeferredAction<AttackAction> HORIZONTAL_SLASH_1 = REGISTRY.registerAction("horizontal_slash1", (rl) -> new ActionBuilder<>(new AttackAction(SquireSwordAnimations.SQUIRE_SWORD_AUTO_1, 1)).neutral(ActionBuilder.Operation.SET).lookingAtTarget(ActionBuilder.Operation.SET, true).build(rl));
    public static final DeferredAction<AttackAction> HORIZONTAL_SLASH_2 = REGISTRY.registerAction("horizontal_slash2", (rl) -> new ActionBuilder<>(new AttackAction(SquireSwordAnimations.SQUIRE_SWORD_AUTO_2, 1)).neutral(ActionBuilder.Operation.SET).lookingAtTarget(ActionBuilder.Operation.SET, true).build(rl));
    public static final DeferredAction<AttackAction> HORIZONTAL_SLASH_3 = REGISTRY.registerAction("horizontal_slash3", (rl) -> new ActionBuilder<>(new AttackAction(SquireSwordAnimations.SQUIRE_SWORD_AUTO_3, 1)).neutral(ActionBuilder.Operation.SET).lookingAtTarget(ActionBuilder.Operation.SET, true).build(rl));
    public static final DeferredAction<AttackAction> DASH_ATTACK = REGISTRY.registerAction("dash_attack", (rl) -> new ActionBuilder<>(new AttackAction(SquireSwordAnimations.SQUIRE_SWORD_DASH_ATTACK, 2)).punisher(ActionBuilder.Operation.SET).lookingAtTarget(ActionBuilder.Operation.SET, true).build(rl));
    public static final DeferredAction<AttackAction> JUMP_SLASH = REGISTRY.registerAction("jump_slash", (rl) -> new ActionBuilder<>(new AttackAction(SquireSwordAnimations.SQUIRE_SWORD_HOP_ATTACK, 1)).punisher(ActionBuilder.Operation.SET).lookingAtTarget(ActionBuilder.Operation.SET, true).build(rl));
}
