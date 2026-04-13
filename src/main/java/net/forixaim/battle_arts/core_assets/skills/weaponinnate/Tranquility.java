package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;

public class Tranquility extends WeaponInnateSkill
{

    public Tranquility(SkillBuilder<? extends WeaponInnateSkill> builder)
    {
        super(builder);
    }

    @Override
    public boolean canExecute(SkillContainer container)
    {
        return super.canExecute(container) && container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).hasSkill(AdvancedBattleStyles.RONIN);
    }

    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args)
    {
        super.executeOnServer(container, args);
        if (container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().hasData(BattleArtsDataKeys.TRANQUILITY_SHEATH.get()))
        {
            if (container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().getDataValue(BattleArtsDataKeys.TRANQUILITY_SHEATH.get()))
            {
                container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).requestCasting(container.getServerExecutor(), args);
                container.getServerExecutor().playAnimationSynchronized(RoninUchigatanaAnimations.RONIN_UCHIGATANA_SHEATHE, 0.0F);
                LogUtils.getLogger().debug("Current Style {}",container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()).toString());

            }
            else
            {
                container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).requestCasting(container.getServerExecutor(), args);
                container.getServerExecutor().playAnimationSynchronized(RoninUchigatanaAnimations.RONIN_UCHIGATANA_UNSHEATHE, 0.0F);

                LogUtils.getLogger().debug("Current Style {}, Sheathed: {}",container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()).toString(), container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().getDataValue(BattleArtsDataKeys.TRANQUILITY_SHEATH.get()));
            }
        }

    }
}
