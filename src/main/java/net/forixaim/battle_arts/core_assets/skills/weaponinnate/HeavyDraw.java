package net.forixaim.battle_arts.core_assets.skills.weaponinnate;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireBowAnimations;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.client.events.engine.ControllEngine;
import yesman.epicfight.client.input.EpicFightKeyMappings;
import yesman.epicfight.client.world.capabilites.entitypatch.player.LocalPlayerPatch;
import yesman.epicfight.network.server.SPSkillExecutionFeedback;
import yesman.epicfight.skill.ChargeableSkill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SteelWhirlwindSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.util.UUID;

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
        super.onRemoved(container);
    }

    @Override
    public void chargingTick(PlayerPatch<?> caster)
    {
        ChargeableSkill.super.chargingTick(caster);
    }

    @Override
    public void startCharging(PlayerPatch<?> playerPatch)
    {
        if (!playerPatch.isLogicalClient())
        {
            playerPatch.getSkill(this).getDataManager().setDataSync(BattleArtsDataKeys.CHARGING.get(), true, (ServerPlayer) playerPatch.getOriginal());
        }
        playerPatch.playAnimationSynchronized(SquireBowAnimations.POWER_DRAW_START, 0);
    }

    @Override
    public void resetCharging(PlayerPatch<?> playerPatch)
    {
        if (!playerPatch.isLogicalClient())
        {
            playerPatch.getSkill(this).getDataManager().setDataSync(BattleArtsDataKeys.CHARGING.get(), false, (ServerPlayer) playerPatch.getOriginal());
        }
        playerPatch.getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_HOLD);
        playerPatch.getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_START);
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
    public void castSkill(ServerPlayerPatch serverPlayerPatch, SkillContainer skillContainer, int i, SPSkillExecutionFeedback spSkillExecutionFeedback, boolean b)
    {
        skillContainer.getDataManager().setDataSync(BattleArtsDataKeys.CHARGING.get(), false, serverPlayerPatch.getOriginal());
        skillContainer.getDataManager().setDataSync(BattleArtsDataKeys.CHARGE_POWER.get(), ((float)serverPlayerPatch.getChargingAmount() / 20f), serverPlayerPatch.getOriginal());

        serverPlayerPatch.getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_HOLD);
        serverPlayerPatch.getAnimator().stopPlaying(SquireBowAnimations.POWER_DRAW_START);
        serverPlayerPatch.playAnimationSynchronized(SquireBowAnimations.POWER_DRAW_FIRE, 0);
    }

    @Override
    public void gatherChargingArguemtns(LocalPlayerPatch localPlayerPatch, ControllEngine controllEngine, FriendlyByteBuf friendlyByteBuf)
    {

    }

    @Override
    public KeyMapping getKeyMapping()
    {
        return EpicFightKeyMappings.WEAPON_INNATE_SKILL;
    }
}
