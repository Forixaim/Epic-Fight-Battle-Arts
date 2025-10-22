package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerSpearAnimations;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;

public class Lancer extends BattleStyle
{
    public static Skill DASHING_IMPALE;

    public static void buildSkill(SkillBuildEvent.ModRegistryWorker worker)
    {
        DASHING_IMPALE = worker.build("dashing_impale", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder()
                .setAnimations(LancerSpearAnimations.DASHING_IMPALE)).newProperty();
    }

    public Lancer(Builder<?> builder)
    {
        super(builder);
    }
}
