package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefDaggerAnimations;
import net.forixaim.battle_arts.core_assets.skills.combat_art.Mug;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.Steal;
import net.forixaim.battle_arts.core_assets.util.NetworkUtils;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.network.EpicFightNetworkManager;
import yesman.epicfight.network.server.SPChangeSkill;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;

public class Thief extends BattleStyle
{
    public static Skill STEAL;
    public static Skill MUG;

    public Thief(Builder<?> builder) {
        super(builder);
    }

    public static void buildSkills(SkillBuildEvent.ModRegistryWorker worker)
    {
        MUG = worker.build("mug", Mug::new, CombatArt.createCombatArt().setResource(Resource.COOLDOWN));
        STEAL = worker.build("steal", Steal::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(ThiefDaggerAnimations.STEAL)).newProperty();
    }

    @Override
    public void onInitiate(SkillContainer container) {
        super.onInitiate(container);
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, MUG);
    }

    @Override
    public void onRemoved(SkillContainer container) {
        NetworkUtils.changeSkill(container.getExecutor(), BattleArtsSkillSlots.COMBAT_ART, null);
        super.onRemoved(container);
    }
}
