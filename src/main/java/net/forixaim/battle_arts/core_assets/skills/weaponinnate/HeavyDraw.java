package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireBowAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import yesman.epicfight.client.events.engine.ControlEngine;
import yesman.epicfight.client.input.EpicFightKeyMappings;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.network.server.SPSkillExecutionFeedback;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillCategories;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.guard.GuardSkill;
import yesman.epicfight.skill.modules.ChargeableSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

@SuppressWarnings("unchecked")
public class HeavyDraw extends WeaponInnateSkill implements ChargeableSkill
{
    private static final UUID EVENT_UUID = UUID.fromString("8e362474-0233-4827-930b-63c0920c1878");
    public HeavyDraw(SkillBuilder<? extends WeaponInnateSkill> builder)
    {
        super(builder);
    }

    @Override
    public void onInitiate(SkillContainer container)
    {
        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.SERVER_ITEM_USE_EVENT, EVENT_UUID, event ->
        {
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.CHARGING.get()))
            {
                event.setCanceled(true);
            }
        });

        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_HURT, EVENT_UUID, event ->
        {
            if (event.getPlayerPatch().isStunned()) {
                container.getDataManager().setDataSync(BattleArtsDataKeys.CHARGING.get(), false);
                container.getDataManager().setDataSync(BattleArtsDataKeys.PULLING.get(), false);
                container.getDataManager().setDataSync(BattleArtsDataKeys.PULL_LEVEL.get(), 0.0f);
            }
        });

        container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID, event ->
        {
            if (container.getDataManager().getDataValue(BattleArtsDataKeys.CHARGING.get()))
            {
                event.getMovementInput().jumping = false;
                event.getMovementInput().leftImpulse = 0;
                event.getMovementInput().forwardImpulse = 0;
            }
        });
        super.onInitiate(container);
    }

    @Override
    public void onRemoved(SkillContainer container)
    {
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.TAKE_DAMAGE_EVENT_HURT, EVENT_UUID);
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.SERVER_ITEM_USE_EVENT, EVENT_UUID);
        container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, EVENT_UUID);
        super.onRemoved(container);
    }

    @Override
    public void startHolding(SkillContainer container)
    {
        if (!container.getExecutor().isLogicalClient())
        {
            container.getExecutor().getSkill(this).getDataManager().setDataSync(BattleArtsDataKeys.CHARGING.get(), true);
        }
        container.getExecutor().playAnimationSynchronized(SquireBowAnimations.POWER_DRAW_START, 0);
    }

    @Override
    public void resetHolding(SkillContainer container)
    {
        PlayerPatch<?> playerPatch = container.getExecutor();
        if (!playerPatch.isLogicalClient())
        {
            playerPatch.getSkill(this).getDataManager().setDataSync(BattleArtsDataKeys.CHARGING.get(), false);
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
    public void onStopHolding(SkillContainer container, SPSkillExecutionFeedback feedbackPacket)
    {
        container.getDataManager().setDataSync(BattleArtsDataKeys.CHARGING.get(), false);
        container.getDataManager().setDataSync(BattleArtsDataKeys.CHARGE_POWER.get(), ((float)container.getServerExecutor().getChargingAmount() / 20f));
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
