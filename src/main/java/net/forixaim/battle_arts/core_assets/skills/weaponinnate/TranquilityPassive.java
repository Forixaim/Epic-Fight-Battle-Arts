package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.bs_api.battle_arts_skills.BattleArtsSkillSlots;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class TranquilityPassive extends Skill
{
    public TranquilityPassive(SkillBuilder<? extends Skill> builder)
    {
        super(builder);
    }
}
