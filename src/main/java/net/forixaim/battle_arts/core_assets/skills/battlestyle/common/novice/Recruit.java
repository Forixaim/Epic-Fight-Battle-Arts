package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit.RecruitSpearAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice.RecruitWieldStyles;
import net.forixaim.battle_arts.core_assets.skills.BattleArtsDataKeys;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.IronFortress;
import net.forixaim.bs_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.ChatType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.phys.Vec3;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.SkillBuildEvent;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.SkillDataKey;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.ServerPlayerPatch;
import yesman.epicfight.world.entity.eventlistener.HurtEvent;
import yesman.epicfight.world.entity.eventlistener.PlayerEventListener;

import java.awt.*;
import java.util.UUID;

public class Recruit extends BattleStyle
{
	public static Skill IRON_FORTRESS;
	public static Skill PUNCTURE_SWIPE;

	private static final UUID ID = UUID.fromString("ef4b6082-30a8-49cc-9a86-fa53e811210e");

    public Recruit(Builder<?> builder)
	{
		super(builder);
		innateInactiveColor = new float[]{0.271f, 0.212f, 0.133f};
		innateSkillColor = new float[]{1f, 0.561f, 0f};
	}


	public static void RegisterInnates(SkillBuildEvent.ModRegistryWorker worker)
	{
		PUNCTURE_SWIPE = worker.build("puncture_swipe", SimpleWeaponInnateSkill::new, SimpleWeaponInnateSkill.createSimpleWeaponInnateBuilder().setAnimations(RecruitSpearAnimations.RECRUIT_SPEAR_SHIELD_DUAL_PUNCTURE)).newProperty();
		IRON_FORTRESS = worker.build("iron_fortress", IronFortress::new, IronFortress.createWeaponInnateBuilder().setActivateType(ActivateType.DURATION)).newProperty();
	}

	@Override
	public SkillDataKey<Boolean> getSneakIsDisabledKey()
	{
		return BattleArtsDataKeys.SNEAK_MOVE_LOCK.get();
	}

	@Override
	public void onInitiate(SkillContainer container)
	{
		super.onInitiate(container);

		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, ID, (event) ->
		{
			if (container.getExecutor().getOriginal().isShiftKeyDown())
			{
				if (event.getPlayerPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(event.getPlayerPatch()) == RecruitWieldStyles.RECRUIT_SPEAR)
				{
					event.getMovementInput().forwardImpulse = 0;
					event.getMovementInput().leftImpulse = 0;
					event.getMovementInput().jumping = false;
				}
			}
		});

		container.getExecutor().getEventListener().addEventListener(PlayerEventListener.EventType.HURT_EVENT_PRE, ID, event ->
		{
			DamageSource damageSource = event.getDamageSource();
			boolean isFront = false;
			Vec3 sourceLocation = damageSource.getSourcePosition();
			if (sourceLocation != null) {
				Vec3 viewVector = event.getPlayerPatch().getOriginal().getViewVector(1.0F);
				viewVector = viewVector.subtract(0.0F, viewVector.y, 0.0F).normalize();
				Vec3 toSourceLocation = sourceLocation.subtract(event.getPlayerPatch().getOriginal().position()).normalize();
				if (toSourceLocation.dot(viewVector) > (double)0.0F) {
					isFront = true;
				}
			}
			if (event.getPlayerPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(event.getPlayerPatch()) != RecruitWieldStyles.RECRUIT_SPEAR_SHIELD)
			{
				return;
			}
			if (isFront && isBlockableState(event.getPlayerPatch()))
			{
				this.guard(event, false);
			}
		}, 1);
	}

	private boolean isBlockableState(ServerPlayerPatch playerPatch)
	{
		return (playerPatch.getCurrentLivingMotion().isSame(LivingMotions.IDLE) || playerPatch.getCurrentLivingMotion().isSame(LivingMotions.WALK) || playerPatch.getCurrentLivingMotion().isSame(LivingMotions.KNEEL) || playerPatch.getCurrentLivingMotion().isSame(LivingMotions.SNEAK)) && playerPatch.getOriginal().onGround() && !playerPatch.getOriginal().isSprinting() && !playerPatch.getEntityState().attacking();
	}

	protected boolean isBlockableSource(DamageSource damageSource, boolean advanced) {
		return damageSource.is(DamageTypes.ARROW);
	}

	public void guard(HurtEvent.Pre event,boolean advanced)
	{
		DamageSource damageSource = event.getDamageSource();
		if (this.isBlockableSource(damageSource, advanced))
		{
			event.getPlayerPatch().playSound(SoundEvents.SHIELD_BLOCK, -0.05F, 0.1F);
			event.getPlayerPatch().getOriginal().getOffhandItem().hurt(1, event.getPlayerPatch().getOriginal().getRandom(), event.getPlayerPatch().getOriginal());
			if (event.getPlayerPatch().getOriginal().getOffhandItem().getDamageValue() >= event.getPlayerPatch().getOriginal().getOffhandItem().getMaxDamage())
			{
				event.getPlayerPatch().getOriginal().getOffhandItem().hurtAndBreak(1, event.getPlayerPatch().getOriginal(), entity -> {});
			}
			this.dealEvent(event.getPlayerPatch(), event);
		}

	}

	public void dealEvent(PlayerPatch<?> playerpatch, HurtEvent.Pre event) {
		event.setCanceled(true);
		event.setResult(AttackResult.ResultType.BLOCKED);
		EpicFightCapabilities.getUnparameterizedEntityPatch(event.getDamageSource().getEntity(), LivingEntityPatch.class).ifPresent((attackerPatch) -> attackerPatch.setLastAttackEntity(playerpatch.getOriginal()));
	}

	@Override
	public void onRemoved(SkillContainer container)
	{
		super.onRemoved(container);
		container.getExecutor().getEventListener().removeListener(PlayerEventListener.EventType.MOVEMENT_INPUT_EVENT, ID);
	}

	@Override
	public void updateContainer(SkillContainer container)
	{
		super.updateContainer(container);
		if (!container.getExecutor().getOriginal().isShiftKeyDown() && container.getExecutor().isLogicalClient())
		{
			container.getDataManager().setDataSync(getSneakIsDisabledKey(), false, (LocalPlayer) container.getExecutor().getOriginal());
		}
	}
}
