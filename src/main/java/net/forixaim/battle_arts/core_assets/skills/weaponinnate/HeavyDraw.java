package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireBowAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.minecraft.client.KeyMapping;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.client.input.InputManager;
import yesman.epicfight.api.client.input.PlayerInputState;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.client.input.EpicFightKeyMappings;
import yesman.epicfight.network.server.SPSkillFeedback;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.modules.ChargeableSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;

public class HeavyDraw extends WeaponInnateSkill implements ChargeableSkill
{
    public HeavyDraw(WeaponInnateSkill.Builder<?> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container, EntityEventListener eventListener)
    {
        eventListener.registerEvent(EpicFightEventHooks.Player.USE_ITEM, event -> {
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.CHARGING))
            {
                event.cancel();
            }
        }, this);

        eventListener.registerEvent(EpicFightEventHooks.Entity.TAKE_DAMAGE_POST, event -> {
            if (event.getEntityPatch().isStunned()) {
                container.getDataManager().setDataSync(BattleArtsDataKeys.CHARGING, false);
                container.getDataManager().setDataSync(BattleArtsDataKeys.PULLING, false);
                container.getDataManager().setDataSync(BattleArtsDataKeys.PULL_LEVEL, 0.0f);
            }
        }, this);

        eventListener.registerEvent(EpicFightClientEventHooks.Control.MAPPED_MOVEMENT_INPUT_UPDATE, event -> {
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.CHARGING))
            {
                PlayerInputState modified = event.getInputState().withLeftImpulse(0).withLeftImpulse(0).withJumping(false);
                InputManager.setInputState(modified);
            }
        }, this);
        super.onInitiate(container, eventListener);
    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        super.onRemoved(container);
    }

    @Override
    public void startHolding(SkillContainer container)
    {
        if (!container.getExecutor().isLogicalClient())
        {
            container.getExecutor().getSkill(this).getDataManager().setDataSync(BattleArtsDataKeys.CHARGING, true);
        }
        container.getExecutor().playAnimationSynchronized(SquireBowAnimations.POWER_DRAW_START, 0);
    }

    @Override
    public void resetHolding(SkillContainer container)
    {
        PlayerPatch<?> playerPatch = container.getExecutor();
        if (!playerPatch.isLogicalClient())
        {
            playerPatch.getSkill(this).getDataManager().setDataSync(BattleArtsDataKeys.CHARGING, false);
            playerPatch.stopPlaying(SquireBowAnimations.POWER_DRAW_HOLD);
            playerPatch.stopPlaying(SquireBowAnimations.POWER_DRAW_START);
        }
        else
        {
            playerPatch.getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_HOLD);
            playerPatch.getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_START);
        }

    }

    @Override
    public int getAllowedMaxChargingTicks()
    {
        return 120;
    }

    @Override
    public int getMaxChargingTicks()
    {
        return 60;
    }

    @Override
    public int getMinChargingTicks()
    {
        return 20;
    }

    @Override
    public void onStopHolding(SkillContainer container,  SPSkillFeedback feedbackPacket)
    {
        container.getDataManager().setDataSync(BattleArtsDataKeys.CHARGING, false);
        container.getDataManager().setDataSync(BattleArtsDataKeys.CHARGE_POWER, ((float)container.getServerExecutor().getChargingTicks() / 20f));
        container.getServerExecutor().getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_HOLD);
        container.getServerExecutor().getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_START);
        container.getServerExecutor().playAnimationSynchronized(SquireBowAnimations.POWER_DRAW_FIRE, 0);
        this.cancelOnServer(container, null);
    }

    @Override
    public KeyMapping getKeyMapping()
    {
        return EpicFightKeyMappings.WEAPON_INNATE_SKILL;
    }
}
