package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.skills.combat_art.Mug;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Steal;
import net.forixaim.bs_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;

public class Thief extends BattleStyle
{
    public static Skill STEAL;
    public static Skill MUG;

    public Thief(Builder<?> builder) {
        super(builder);
        innateInactiveColor = new float[]{0.671f, 0.71f, 0.71f};
        innateSkillColor = new float[]{0.929f, 0.996f, 1};
    }

    public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker)
    {
        MUG = worker.build("mug", Mug::new, CombatArt.createCombatArt().setResource(Resource.COOLDOWN));
        STEAL = worker.build("steal", Steal::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(ThiefDaggerAnimations.STEAL)).newProperty();
    }
}
