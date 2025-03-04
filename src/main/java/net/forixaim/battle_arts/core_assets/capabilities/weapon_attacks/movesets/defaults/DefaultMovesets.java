package net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.defaults;

import net.forixaim.battle_arts.EpicFightBattleArts;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.advanced.RoninMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.JManMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.RecruitMoveSets;
import net.forixaim.battle_arts.core_assets.capabilities.weapon_attacks.movesets.novice.SquireMoveSets;
import net.forixaim.efm_ex.api.events.MoveSetDefinitionRegistryEvent;
import net.forixaim.efm_ex.api.moveset.MoveSet;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSkills;

@SuppressWarnings("unchecked")
@Mod.EventBusSubscriber(modid = EpicFightBattleArts.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DefaultMovesets
{

    public static MoveSet.MoveSetBuilder BattleAxeDefault;
    public static MoveSet.MoveSetBuilder Sabre2H;


    @SubscribeEvent
    public static void registerMovesets(MoveSetDefinitionRegistryEvent event)
    {
        event.getMoveSets().put(EpicFightBattleArts.MOD_ID, DefaultMovesets::build);
    }

    public static void build()
    {
        RecruitMoveSets.build();
        SquireMoveSets.build();
        JManMoveSets.build();
        RoninMoveSets.Build();

        BattleAxeDefault = MoveSet.builder()
                .addLivingMotionsRecursive(Animations.BIPED_HOLD_LONGSWORD,
                        LivingMotions.IDLE, LivingMotions.SNEAK, LivingMotions.KNEEL,
                        LivingMotions.JUMP, LivingMotions.SWIM)
                .addLivingMotionsRecursive(Animations.BIPED_WALK_LONGSWORD,
                        LivingMotions.WALK, LivingMotions.CHASE)
                .addLivingMotionModifier(LivingMotions.RUN, Animations.BIPED_RUN_LONGSWORD)
                .addLivingMotionModifier(LivingMotions.BLOCK, Animations.LONGSWORD_GUARD)
                .addAutoAttacks(
                        Animations.LONGSWORD_AUTO1,
                        Animations.LONGSWORD_AUTO2,
                        Animations.LONGSWORD_AUTO3,
                        Animations.LONGSWORD_DASH,
                        Animations.LONGSWORD_AIR_SLASH
                )
                .addInnateSkill(itemStack -> EpicFightSkills.SWEEPING_EDGE);

        Sabre2H = MoveSet.builder()
                .addLivingMotionsRecursive(Animations.BIPED_HOLD_LONGSWORD,
                        LivingMotions.IDLE, LivingMotions.SNEAK, LivingMotions.KNEEL,
                        LivingMotions.JUMP, LivingMotions.SWIM)
                .addLivingMotionsRecursive(Animations.BIPED_WALK_LONGSWORD,
                        LivingMotions.WALK, LivingMotions.CHASE)
                .addLivingMotionModifier(LivingMotions.RUN, Animations.BIPED_RUN_LONGSWORD)
                .addLivingMotionModifier(LivingMotions.BLOCK, Animations.LONGSWORD_GUARD)
                .addAutoAttacks(
                        Animations.LONGSWORD_AUTO1,
                        Animations.LONGSWORD_AUTO2,
                        Animations.LONGSWORD_AUTO3,
                        Animations.LONGSWORD_DASH,
                        Animations.LONGSWORD_AIR_SLASH
                )
                .addInnateSkill(itemStack -> EpicFightSkills.SHARP_STAB);
    }
}
