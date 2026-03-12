package net.forixaim.battle_arts.core_assets.skills.battlestyle;

import com.mojang.logging.LogUtils;
import net.forixaim.battle_arts_api.battle_arts_skills.BattleArtsSkillSlots;
import net.forixaim.battle_arts_api.battle_arts_skills.CoreAPIDataKeys;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import yesman.epicfight.api.client.event.types.control.MappedMovementInputUpdateEvent;
import yesman.epicfight.api.client.input.InputManager;
import yesman.epicfight.api.client.input.PlayerInputState;
import yesman.epicfight.api.event.types.entity.DealDamageEvent;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;

public class CommonEvents
{
    public static void BUILD_METER(DealDamageEvent.Post event) {
        if (event.getEntityPatch() instanceof ServerPlayerPatch player) {
            if (player.getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().hasData(CoreAPIDataKeys.METER_FILL) && player.getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getSkill() instanceof BattleStyle battleStyle)
            {
                float meterFill = (event.getDamageSource().calculateImpact() + event.getDamageSource().calculateDamageAgainst(player.getOriginal(), event.getTarget(), event.getModifiedDamage())) * (1 + Math.min(10, EnchantmentHelper.getEnchantmentLevel(player.getOriginal().level().registryAccess().holderOrThrow(Enchantments.SWEEPING_EDGE), player.getOriginal())) * 0.3f);
                float maxMeter = battleStyle.getMaxMeter() * 100;
                float currentMeter = player.getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().getDataValue(CoreAPIDataKeys.METER_FILL);

                meterFill += currentMeter;

                final float finalMeterFill = Math.min(meterFill, maxMeter);

                LogUtils.getLogger().debug("meterFill: {}", finalMeterFill);

                player.getSkill(BattleArtsSkillSlots.BATTLE_STYLE).getDataManager().setDataSync(CoreAPIDataKeys.METER_FILL, finalMeterFill);
            }
        }

    }

    public static void LOCK_MOVEMENT_USING_ITEM(MappedMovementInputUpdateEvent event) {
        if (event.getEntityPatch().getOriginal().isUsingItem())
        {
            lockMovement(event);
        }
    }

    private static void lockMovement(MappedMovementInputUpdateEvent event) {
        PlayerInputState state = event.getInputState().withForwardImpulse(0).withLeftImpulse(0).withJumping(false);
        InputManager.setInputState(state);
    }

    public static void LOCK_MOVEMENT_GUARDING(MappedMovementInputUpdateEvent event) {
        if (event.getEntityPatch() instanceof LocalPlayerPatch playerPatch)
        {
            if (playerPatch.getHoldingSkill() instanceof GuardSkill)
            {
                lockMovement(event);
            }
        }
    }
}
