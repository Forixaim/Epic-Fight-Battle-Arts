package net.forixaim.battle_arts.core_assets.skills.weaponpassive;

import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.MountedMoveset;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import yesman.epicfight.gameasset.EpicFightSkills;
import yesman.epicfight.network.EpicFightNetworkManager;
import yesman.epicfight.network.server.SPChangeSkill;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillSlots;

public class SquireMountedWeaponPassive extends Skill implements MountedMoveset
{
    public SquireMountedWeaponPassive(SkillBuilder<? extends Skill> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container)
    {
        if (!container.getServerExecutor().getSkill(SkillSlots.BASIC_ATTACK).hasSkill(SkillRegistry.MOUNTED_ATTACK))
        {
            container.getServerExecutor().getSkillCapability().skillContainers[SkillSlots.BASIC_ATTACK.universalOrdinal()].setSkill(SkillRegistry.MOUNTED_ATTACK);
            EpicFightNetworkManager.sendToPlayer(new SPChangeSkill(SkillSlots.BASIC_ATTACK, SkillRegistry.MOUNTED_ATTACK.toString(), SPChangeSkill.State.ENABLE), container.getServerExecutor().getOriginal());
        }
        super.onInitiate(container);
    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        if (!container.getServerExecutor().getSkill(SkillSlots.BASIC_ATTACK).hasSkill(EpicFightSkills.BASIC_ATTACK))
        {
            container.getServerExecutor().getSkillCapability().skillContainers[SkillSlots.BASIC_ATTACK.universalOrdinal()].setSkill(EpicFightSkills.BASIC_ATTACK);
            EpicFightNetworkManager.sendToPlayer(new SPChangeSkill(SkillSlots.BASIC_ATTACK, EpicFightSkills.BASIC_ATTACK.toString(), SPChangeSkill.State.ENABLE), container.getServerExecutor().getOriginal());
        }
        super.onRemoved(container);
    }
}
