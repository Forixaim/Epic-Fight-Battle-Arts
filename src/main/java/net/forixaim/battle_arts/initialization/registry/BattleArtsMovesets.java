package net.forixaim.battle_arts.initialization.registry;

import com.yesman.epicparcool.ParcoolLivingMotions;
import net.forixaim.battle_arts.BattleArts;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistDualbladesAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistSwordAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.fighter.FighterBattleaxeAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerHeavySpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerSpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryGreatswordAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninTachiAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAxeAnims;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanBattleAxeAnims;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit.RecruitSpearAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.*;
import net.minecraft.world.item.UseAnim;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.ex_cap.data.Moveset;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.registry.deferred.MovesetRegister;
import yesman.epicfight.registry.deferred.holders.DeferredMoveset;
import yesman.epicfight.skill.guard.GuardSkill;

public final class BattleArtsMovesets
{
    public static final MovesetRegister REGISTRY = MovesetRegister.create(BattleArts.MOD_ID);

    public static final class Squire
    {
        public static final DeferredMoveset SQUIRE_SWORD = REGISTRY.registerMoveset("squire_sword",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.MOUNT, SquireMountAnimations.IDLE)
                        .addLivingMotionModifier(LivingMotions.IDLE, SquireSwordAnimations.IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, SquireSwordAnimations.SQUIRE_SWORD_WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, SquireSwordAnimations.SQUIRE_SWORD_RUN)
                        .addLivingMotionModifier(LivingMotions.JUMP, SquireSwordAnimations.JUMP)
                        .addLivingMotionModifier(LivingMotions.KNEEL, SquireSwordAnimations.SQUIRE_SWORD_CROUCH)
                        .addLivingMotionModifier(LivingMotions.SNEAK, SquireSwordAnimations.SQUIRE_SWORD_CROUCH_WALK)
                        .addLivingMotionModifier(LivingMotions.BLOCK, SquireSwordAnimations.GUARD_SET)
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD,
                                SquireSwordAnimations.GUARD_HIT
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD_BREAK,
                                Animations.BIPED_COMMON_NEUTRALIZED
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                SquireSwordAnimations.PARRY_1,
                                SquireSwordAnimations.PARRY_2
                        )
                        .addComboAttacks(
                                SquireSwordAnimations.SQUIRE_SWORD_AUTO_1,
                                SquireSwordAnimations.SQUIRE_SWORD_AUTO_2,
                                SquireSwordAnimations.SQUIRE_SWORD_AUTO_3,
                                SquireSwordAnimations.SQUIRE_SWORD_DASH_ATTACK,
                                SquireSwordAnimations.SQUIRE_SWORD_HOP_ATTACK
                        )
                        .addMountAttacks(
                                SquireMountAnimations.AUTO1,
                                SquireMountAnimations.AUTO2
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.HEAVY_BLOW.get())
        );

        public static final DeferredMoveset SQUIRE_BOW = REGISTRY.registerMoveset("squire_bow",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.AIM, Animations.BIPED_BOW_AIM)
                        .addLivingMotionModifier(LivingMotions.SHOT, Animations.BIPED_BOW_SHOT)
                        .addLivingMotionsRecursive(
                                SquireBowAnimations.IDLE,
                                LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.KNEEL
                        )
                        .setMotionPredicate((livingEntityPatch, interactionHand) ->
                                livingEntityPatch.getOriginal().isUsingItem() &&
                                        livingEntityPatch.getOriginal().getUseItem().getUseAnimation() == UseAnim.BOW
                                        ? LivingMotions.AIM : null
                        )
                        .addComboAttacks(
                                SquireBowAnimations.AUTO1,
                                SquireBowAnimations.AUTO2,
                                SquireBowAnimations.DASH,
                                SquireBowAnimations.AIRSLASH
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.POWER_DRAW.get())
        );

        public static final DeferredMoveset SQUIRE_GREATSWORD = REGISTRY.registerMoveset("squire_greatsword", () -> Moveset.builder()
                .addLivingMotionModifier(LivingMotions.IDLE, SquireGreatswordAnimations.IDLE)
                .addLivingMotionModifier(LivingMotions.WALK, SquireGreatswordAnimations.WALK)
                .addLivingMotionModifier(LivingMotions.RUN, SquireGreatswordAnimations.RUN)
                .addLivingMotionModifier(LivingMotions.KNEEL, SquireGreatswordAnimations.CROUCH)
                .addLivingMotionModifier(LivingMotions.SNEAK, SquireGreatswordAnimations.CROUCH_WALK));

        public static final DeferredMoveset SQUIRE_DAGGER = REGISTRY.registerMoveset("squire_dagger",
                () -> Moveset.builder()
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD,
                                Animations.SWORD_GUARD_HIT
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD_BREAK,
                                Animations.BIPED_COMMON_NEUTRALIZED
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                Animations.SWORD_GUARD_ACTIVE_HIT1,
                                Animations.SWORD_GUARD_ACTIVE_HIT2,
                                Animations.SWORD_GUARD_ACTIVE_HIT3
                        )
                        .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SWORD_GUARD)
                        .addLivingMotionsRecursive(
                                SquireDaggerAnimations.IDLE,
                                LivingMotions.IDLE, LivingMotions.JUMP
                        )
                        .addLivingMotionModifier(LivingMotions.WALK, SquireDaggerAnimations.WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, SquireDaggerAnimations.RUN)
                        .addLivingMotionModifier(LivingMotions.KNEEL, SquireDaggerAnimations.CROUCH)
                        .addLivingMotionModifier(LivingMotions.SNEAK, SquireDaggerAnimations.CROUCH_WALK)
                        .addComboAttacks(
                                SquireDaggerAnimations.AUTO1,
                                SquireDaggerAnimations.AUTO2,
                                SquireDaggerAnimations.AUTO3,
                                SquireDaggerAnimations.DASH,
                                SquireDaggerAnimations.SPIKE
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.HARD_THRUST.get())
        );
    }

    public static final class Recruit
    {
        public static final DeferredMoveset RECRUIT_MOVESET = REGISTRY.registerMoveset("recruit_moveset",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.IDLE, RecruitSpearAnimations.IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, RecruitSpearAnimations.WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, RecruitSpearAnimations.RUN)
                        .addLivingMotionModifier(LivingMotions.KNEEL, RecruitSpearAnimations.CROUCH)
                        .addLivingMotionModifier(LivingMotions.BLOCK, RecruitSpearAnimations.GUARD)
                        .addComboAttacks(
                                RecruitSpearAnimations.AUTO1,
                                RecruitSpearAnimations.AUTO2,
                                RecruitSpearAnimations.DASH_ATTACK,
                                RecruitSpearAnimations.JUMP_ATTACK
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD,
                                RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_HIT
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_PARRY,
                                RecruitSpearAnimations.RECRUIT_SPEAR_GUARD_PARRY_2
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.IRON_FORTRESS.get())
        );

        public static final DeferredMoveset RECRUIT_MOVESET_SHIELDED = REGISTRY.registerMoveset("recruit_moveset_shielded",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.IDLE, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_RUN)
                        .addLivingMotionModifier(LivingMotions.KNEEL, RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_CROUCH)
                        .addComboAttacks(
                                RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO1,
                                RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO2,
                                RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AUTO3,
                                RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_DASH,
                                RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_AIRSLASH
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.PUNCTURE_SWIPE.get())
        );
    }

    public static final class Journeyman {
        public static final DeferredMoveset JOURNEYMAN_AXE = REGISTRY.registerMoveset("journeyman_axe",
                () -> Moveset.builder()
                        .addLivingMotionsRecursive(
                                JourneymanAxeAnims.IDLE,
                                LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN
                        )
                        .addLivingMotionModifier(LivingMotions.BLOCK, Animations.SWORD_GUARD)
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD,
                                Animations.SWORD_GUARD_HIT
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                Animations.SWORD_GUARD_ACTIVE_HIT1,
                                Animations.SWORD_GUARD_ACTIVE_HIT2,
                                Animations.SWORD_GUARD_ACTIVE_HIT3
                        )
                        .addComboAttacks(
                                JourneymanAxeAnims.AUTO1,
                                JourneymanAxeAnims.AUTO2,
                                JourneymanAxeAnims.AUTO3,
                                JourneymanAxeAnims.DASH,
                                JourneymanAxeAnims.AIRSLASH
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.RECURVE_AXE.get())
        );

        public static final DeferredMoveset JOURNEYMAN_BATTLE_AXE = REGISTRY.registerMoveset("journeyman_battle_axe",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.IDLE, JourneymanBattleAxeAnims.JMAN_BAXE_IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, JourneymanBattleAxeAnims.JMAN_BAXE_WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, JourneymanBattleAxeAnims.JMAN_BAXE_RUN)
                        .addLivingMotionModifier(LivingMotions.BLOCK, JourneymanBattleAxeAnims.JMAN_BAXE_GUARD)
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD,
                                JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_HIT
                        )
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_PARRY1,
                                JourneymanBattleAxeAnims.JMAN_BAXE_GUARD_PARRY2
                        )
                        .addComboAttacks(
                                JourneymanBattleAxeAnims.JMAN_BAXE_AUTO_1,
                                JourneymanBattleAxeAnims.JMAN_BAXE_AUTO_2,
                                JourneymanBattleAxeAnims.JMAN_BAXE_AIR_ATTACK,
                                JourneymanBattleAxeAnims.JMAN_BAXE_DASH_ATTACK
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.SEISMIC_IMPACT.get())
        );

        public static final DeferredMoveset JOURNEYMAN_UNARMED = REGISTRY.registerMoveset("journeyman_unarmed",
                () -> Moveset.builder()
                        .addLivingMotionsRecursive(
                                JourneymanAnimations.JMAN_UNARMED_IDLE,
                                LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.KNEEL
                        )
                        .addLivingMotionModifier(LivingMotions.BLOCK, JourneymanAnimations.JMAN_UNARMED_GUARD)
                        .addGuardAnimations(
                                GuardSkill.BlockType.GUARD,
                                JourneymanAnimations.JMAN_UNARMED_GUARD_HIT
                        )
                        .addComboAttacks(
                                JourneymanAnimations.JMAN_UNARMED_AUTO1,
                                JourneymanAnimations.JMAN_UNARMED_AUTO2,
                                JourneymanAnimations.JMAN_UNARMED_DASH,
                                JourneymanAnimations.JMAN_SLEDGEHAMMER
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.SUPPRESSING_BLOW.get())
        );
    }

    public static final class Duelist {
        public static final DeferredMoveset DUELIST_SWORD = REGISTRY.registerMoveset("duelist_sword",
                () -> Moveset.builder()
                        .addLivingMotionsRecursive(DuelistSwordAnimations.IDLE,
                                LivingMotions.IDLE, LivingMotions.SNEAK, LivingMotions.KNEEL)
                        .addLivingMotionsRecursive(DuelistSwordAnimations.WALK, LivingMotions.WALK)
                        .addLivingMotionsRecursive(DuelistSwordAnimations.RUN, LivingMotions.RUN)
                        .addLivingMotionModifier(LivingMotions.BLOCK, DuelistSwordAnimations.GUARD_SET)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, DuelistSwordAnimations.GUARD_HIT)
                        .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD,
                                DuelistSwordAnimations.GUARD_PARRY_1, DuelistSwordAnimations.GUARD_PARRY_2)
                        .revelationAttack(DuelistSwordAnimations.KNEE_SMASH)
                        .addComboAttacks(
                                DuelistSwordAnimations.AUTO1,
                                DuelistSwordAnimations.AUTO2,
                                DuelistSwordAnimations.AUTO3,
                                DuelistSwordAnimations.DASH_ATTACK,
                                DuelistSwordAnimations.AIR_ATTACK
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.QUAD_STING.get())
        );

        public static final DeferredMoveset DUELIST_DUALBLADES = REGISTRY.registerMoveset("duelist_dualblade",
                () -> Moveset.builder()
                        .addLivingMotionsRecursive(DuelistDualbladesAnimations.IDLE,
                                LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.RUN, LivingMotions.SNEAK, LivingMotions.KNEEL)
                        .addLivingMotionModifier(LivingMotions.BLOCK, DuelistDualbladesAnimations.GUARD)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, DuelistDualbladesAnimations.GUARD_HIT)
                        .revelationAttack(DuelistSwordAnimations.KNEE_SMASH)
                        .addGuardAnimations(GuardSkill.BlockType.ADVANCED_GUARD,
                                DuelistDualbladesAnimations.PARRY1, DuelistDualbladesAnimations.PARRY2)
                        .addComboAttacks(
                                DuelistDualbladesAnimations.AUTO1,
                                DuelistDualbladesAnimations.AUTO2,
                                DuelistDualbladesAnimations.AUTO3,
                                DuelistSwordAnimations.DASH_ATTACK,
                                DuelistDualbladesAnimations.AIRSLAM
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.RELENTLESS_PUNCTURE.get())
        );
    }

    public static class Lancer {
        public static final DeferredMoveset LANCER_SPEAR = REGISTRY.registerMoveset("lancer_spear",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.IDLE, LancerSpearAnimations.IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, LancerSpearAnimations.WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, LancerSpearAnimations.RUN)
                        .addLivingMotionModifier(LivingMotions.BLOCK, LancerSpearAnimations.GUARD)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, LancerSpearAnimations.GUARD_HIT)
                        .addComboAttacks(
                                LancerSpearAnimations.AUTO1,
                                LancerSpearAnimations.AUTO2,
                                LancerSpearAnimations.AUTO3,
                                LancerSpearAnimations.DASH,
                                LancerSpearAnimations.AIRSLASH
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.DASHING_IMPALE.get())
        );

        public static final DeferredMoveset LANCER_HEAVY_SPEAR = REGISTRY.registerMoveset("lancer_heavy_spear",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.IDLE, LancerHeavySpearAnimations.IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, LancerHeavySpearAnimations.WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, LancerHeavySpearAnimations.RUN)
                        .addLivingMotionModifier(LivingMotions.BLOCK, LancerSpearAnimations.GUARD)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, LancerSpearAnimations.GUARD_HIT)
                        .addComboAttacks(
                                LancerHeavySpearAnimations.AUTO1,
                                LancerHeavySpearAnimations.AUTO2,
                                LancerHeavySpearAnimations.AUTO3,
                                LancerHeavySpearAnimations.DASH,
                                LancerSpearAnimations.AIRSLASH
                        )
        );
    }

    public static final class Mercenary {
        public static final DeferredMoveset MERCENARY_GREATSWORD = REGISTRY.registerMoveset("mercenary_greatsword",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.IDLE, MercenaryGreatswordAnimations.IDLE)
                        .addLivingMotionsRecursive(
                                MercenaryGreatswordAnimations.IDLE,
                                LivingMotions.SNEAK, LivingMotions.SWIM, LivingMotions.FLY
                        )
                        .addLivingMotionModifier(LivingMotions.KNEEL, MercenaryGreatswordAnimations.CROUCH)
                        .addLivingMotionsRecursive(
                                MercenaryGreatswordAnimations.WALK,
                                LivingMotions.WALK, LivingMotions.CHASE
                        )
                        .addLivingMotionModifier(LivingMotions.RUN, MercenaryGreatswordAnimations.RUN)
                        .addLivingMotionModifier(LivingMotions.BLOCK, MercenaryGreatswordAnimations.GUARD)
                        .addLivingMotionModifier(ParcoolLivingMotions.FAST_RUN, MercenaryGreatswordAnimations.SPRINT)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, MercenaryGreatswordAnimations.GUARD_HIT)
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                MercenaryGreatswordAnimations.GUARD_PARRY_1,
                                MercenaryGreatswordAnimations.GUARD_PARRY_2
                        )
                        .addComboAttacks(
                                MercenaryGreatswordAnimations.AUTO1,
                                MercenaryGreatswordAnimations.AUTO2,
                                MercenaryGreatswordAnimations.AUTO3,
                                MercenaryGreatswordAnimations.AUTO4,
                                MercenaryGreatswordAnimations.DASH_ATTACK,
                                MercenaryGreatswordAnimations.AIRSLAM
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.FIERCE_UPPER.get())
        );
    }

    public static final class Ronin {
        public static final DeferredMoveset RONIN_UCHIGATANA = REGISTRY.registerMoveset("ronin_uchigatana",
                () -> Moveset.builder()
                        .addLivingMotionsRecursive(
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_IDLE,
                                LivingMotions.IDLE, LivingMotions.JUMP, LivingMotions.CHASE, LivingMotions.SWIM, LivingMotions.RUN
                        )
                        .addLivingMotionModifier(LivingMotions.WALK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_WALK)
                        .addLivingMotionModifier(LivingMotions.BLOCK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_GUARD)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE_GUARD_HIT)
                        .shouldRenderSheath(livingEntityPatch -> true)
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.TRANQUILITY.get())
        );

        public static final DeferredMoveset RONIN_UCHIGATANA_SHEATHED = REGISTRY.registerMoveset("ronin_uchigatana_sheathed",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.BLOCK, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD)
                        .addLivingMotionsRecursive(
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_IDLE,
                                LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.JUMP,
                                LivingMotions.CHASE, LivingMotions.SWIM, LivingMotions.RUN
                        )
                        .addLivingMotionModifier(LivingMotions.RUN, RoninUchigatanaAnimations.RONIN_UCHIGATANA_RUN)
                        .addComboAttacks(
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO1,
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO2,
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_AUTO3,
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_DASH,
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_AIRSLASH
                        )
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_HIT)
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_PARRY_1,
                                RoninUchigatanaAnimations.RONIN_UCHIGATANA_GUARD_PARRY_2
                        )
                        .shouldRenderSheath(livingEntityPatch -> true)
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.TRANQUILITY.get())
        );

        public static final DeferredMoveset RONIN_TACHI = REGISTRY.registerMoveset("ronin_tachi",
                () -> Moveset.builder()
                        .addComboAttacks(
                                RoninTachiAnimations.AUTO1,
                                RoninTachiAnimations.AUTO2,
                                RoninTachiAnimations.AUTO3,
                                RoninTachiAnimations.DASH_ATTACK,
                                RoninTachiAnimations.AIRSLASH
                        )
                        .addLivingMotionModifier(LivingMotions.IDLE, RoninTachiAnimations.TACHI_IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, RoninTachiAnimations.WALK)
                        .addLivingMotionModifier(LivingMotions.RUN, RoninTachiAnimations.RUN)
                        .addLivingMotionModifier(LivingMotions.BLOCK, RoninTachiAnimations.TACHI_GUARD)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, RoninTachiAnimations.TACHI_GUARD_HIT)
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                RoninTachiAnimations.TACHI_PARRY_1,
                                RoninTachiAnimations.TACHI_PARRY_2
                        )
                        .shouldRenderSheath(livingEntityPatch -> true)
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.BLOSSOM_SLASH.get())
        );
    }

    public static final class Thief {
        public static final DeferredMoveset THIEF_DAGGER = REGISTRY.registerMoveset("thief_dagger",
                () -> Moveset.builder()
                        .addLivingMotionsRecursive(
                                ThiefDaggerAnimations.IDLE,
                                LivingMotions.IDLE, LivingMotions.WALK, LivingMotions.SNEAK, LivingMotions.RUN, LivingMotions.KNEEL
                        )
                        .addLivingMotionModifier(LivingMotions.BLOCK, ThiefDaggerAnimations.GUARD)
                        .addGuardAnimations(GuardSkill.BlockType.GUARD, ThiefDaggerAnimations.GUARD_HIT)
                        .addGuardAnimations(
                                GuardSkill.BlockType.ADVANCED_GUARD,
                                ThiefDaggerAnimations.GUARD_PARRY_1,
                                ThiefDaggerAnimations.GUARD_PARRY_2
                        )
                        .addComboAttacks(
                                ThiefDaggerAnimations.AUTO1,
                                ThiefDaggerAnimations.AUTO2,
                                ThiefDaggerAnimations.AUTO3,
                                ThiefDaggerAnimations.DASH_ATTACK,
                                ThiefDaggerAnimations.AIRSLASH
                        )
                        .addInnateSkill((itemStack, playerPatch) -> BattleArtsSkills.STEAL.get())
        );
    }

    public static final class Fighter {
        public static final DeferredMoveset FIGHTER_BATTLE_AXE = REGISTRY.registerMoveset("fighter_battle_axe",
                () -> Moveset.builder()
                        .addLivingMotionModifier(LivingMotions.IDLE, FighterBattleaxeAnimations.IDLE)
                        .addLivingMotionModifier(LivingMotions.WALK, FighterBattleaxeAnimations.WALK)
        );
    }
}
