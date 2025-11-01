package net.forixaim.battle_arts.core_assets.skills.battlestyle;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.CoreAPIDataKeys;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.entity.eventlistener.DealDamageEvent;
import yesman.epicfight.world.entity.eventlistener.MovementInputEvent;

import java.util.function.Consumer;

public class CommonEvents
{
    public static void BUILD_METER(DealDamageEvent.Hurt event) {
        if (event.getPlayerPatch().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().hasData(CoreAPIDataKeys.METER_FILL.get()) && event.getPlayerPatch().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getSkill() instanceof BattleStyle battleStyle)
        {
            float meterFill = (event.getDamageSource().calculateImpact() + event.getDamageSource().calculateDamageAgainst(event.getPlayerPatch().getOriginal(), event.getTarget(), event.getAttackDamage())) * (1 + Math.min(10, EnchantmentHelper.getEnchantmentLevel(Enchantments.SWEEPING_EDGE, event.getPlayerPatch().getOriginal())) * 0.3f);
            float maxMeter = battleStyle.getMaxMeter() * 100;
            float currentMeter = event.getPlayerPatch().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().getDataValue(CoreAPIDataKeys.METER_FILL.get());

            meterFill += currentMeter;

            final float finalMeterFill = Math.min(meterFill, maxMeter);

            LogUtils.getLogger().debug("meterFill: {}", finalMeterFill);

            event.getPlayerPatch().getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().setDataSync(CoreAPIDataKeys.METER_FILL.get(), finalMeterFill);
        }
    }

    public static final Consumer<MovementInputEvent> LOCK_MOVEMENT_USING_ITEM = event -> {
        if (event.getPlayerPatch().getOriginal().isUsingItem())
        {
            event.getMovementInput().forwardImpulse = 0;
            event.getMovementInput().leftImpulse = 0;
            event.getMovementInput().jumping = false;
        }
    };

    public static final Consumer<MovementInputEvent> LOCK_MOVEMENT_GUARDING = event -> {
        if (event.getPlayerPatch().getHoldingSkill() instanceof GuardSkill)
        {
            event.getMovementInput().forwardImpulse = 0;
            event.getMovementInput().leftImpulse = 0;
            event.getMovementInput().jumping = false;
        }
    };
}
