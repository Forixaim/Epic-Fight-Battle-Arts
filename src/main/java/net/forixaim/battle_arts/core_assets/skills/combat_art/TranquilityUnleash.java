package net.forixaim.battle_arts.core_assets.skills.combat_art;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninUchigatanaAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced.RoninStyles;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.battlestyle.common.advanced.AdvancedBattleStyles;
import net.forixaim.bs_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.bs_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.world.capabilities.item.Style;

public class TranquilityUnleash extends CombatArt
{

    public TranquilityUnleash(SkillBuilder<? extends CombatArt> builder)
    {
        super(builder);
    }

    @Override
    public boolean canExecute(SkillContainer container)
    {
        return container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).hasSkill(AdvancedBattleStyles.RONIN) &&
                (container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == RoninStyles.RONIN_UCHIGATANA_SHEATHE ||
        container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor()) == RoninStyles.RONIN_UCHIGATANA);
    }

    @Override
    public void executeOnServer(SkillContainer container, FriendlyByteBuf args)
    {
        super.executeOnServer(container, args);

        Style weaponStyle = container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(container.getExecutor());

        if (weaponStyle == RoninStyles.RONIN_UCHIGATANA_SHEATHE)
        {
            container.getExecutor().playAnimationSynchronized(RoninUchigatanaAnimations.FLYING_SHOCKWAVE, 0);
        }
        else if (weaponStyle == RoninStyles.RONIN_UCHIGATANA)
        {
            container.getExecutor().playAnimationSynchronized(RoninUchigatanaAnimations.FLASH_CLEAVE, 0);
            container.getExecutor().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().setDataSync(BattleArtsDataKeys.BATTO_SHEATH.get(), true, container.getServerExecutor().getOriginal());
            container.getServerExecutor().modifyLivingMotionByCurrentItem();
        }
    }
}
