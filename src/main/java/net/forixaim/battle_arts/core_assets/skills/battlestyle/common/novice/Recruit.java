package net.forixaim.battle_arts.core_assets.skills.battlestyle.common.novice;

import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit.RecruitSpearAnimations;
import net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.RecruitWieldStyles;
import net.forixaim.battle_arts.core_assets.skills.weaponinnate.IronFortress;
import net.forixaim.battle_arts.initialization.registry.SkillRegistry;
import net.forixaim.battle_arts_api.battle_arts_skills.battle_style.BattleStyle;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.registries.DeferredHolder;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.client.event.EpicFightClientEventHooks;
import yesman.epicfight.api.client.input.InputManager;
import yesman.epicfight.api.client.input.PlayerInputState;
import yesman.epicfight.api.event.EntityEventListener;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.event.types.entity.TakeDamageEvent;
import yesman.epicfight.api.utils.AttackResult;
import yesman.epicfight.skill.Skill;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;
import yesman.epicfight.skill.weaponinnate.SimpleWeaponInnateSkill;
import yesman.epicfight.skill.weaponinnate.WeaponInnateSkill;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;
import yesman.epicfight.world.capabilities.entitypatch.player.PlayerPatch;
import yesman.epicfight.world.capabilities.item.Style;

import yesman.epicfight.world.damagesource.EpicFightDamageTypeTags;

import java.util.UUID;

public class Recruit extends BattleStyle
{


	private static final UUID ID = UUID.fromString("ef4b6082-30a8-49cc-9a86-fa53e811210e");

    public Recruit(SkillBuilder<?> builder)
	{
		super(builder);
	}


	@Override
	public void onInitiate(SkillContainer container, EntityEventListener eventListener)
	{
		super.onInitiate(container, eventListener);

        eventListener.registerEvent(EpicFightClientEventHooks.Control.MAPPED_MOVEMENT_INPUT_UPDATE, event -> {
            if (container.getExecutor().getOriginal().isShiftKeyDown())
            {
                Style wieldStyle = event.getEntityPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(event.getEntityPatch());
                if (wieldStyle == RecruitWieldStyles.RECRUIT_SPEAR || wieldStyle == RecruitWieldStyles.RECRUIT_SPEAR_SHIELD)
                {
                    PlayerInputState modified = event.getInputState().withForwardImpulse(0).withLeftImpulse(0).withJumping(false);
                    InputManager.setInputState(modified);
                }
            }
        }, this);

        eventListener.registerEvent(EpicFightEventHooks.Entity.TAKE_DAMAGE_INCOME, event -> {
            DamageSource damageSource = event.getDamageSource();
            boolean isFront = false;
            Vec3 sourceLocation = damageSource.getSourcePosition();
            if (sourceLocation != null) {
                Vec3 viewVector = event.getEntityPatch().getOriginal().getViewVector(1.0F);
                viewVector = viewVector.subtract(0.0F, viewVector.y, 0.0F).normalize();
                Vec3 toSourceLocation = sourceLocation.subtract(event.getEntityPatch().getOriginal().position()).normalize();
                if (toSourceLocation.dot(viewVector) > (double)0.0F) {
                    isFront = true;
                }
            }
            if (event.getEntityPatch().getHoldingItemCapability(InteractionHand.MAIN_HAND).getStyle(event.getEntityPatch()) != RecruitWieldStyles.RECRUIT_SPEAR_SHIELD)
            {
                return;
            }
            if (isFront && isBlockableState(event.getEntityPatch()))
            {
                this.guard(event, false);
            }
        }, this);
	}

	private boolean isBlockableState(LivingEntityPatch<?> playerPatch)
	{
		return (playerPatch.getCurrentLivingMotion().isSame(LivingMotions.IDLE) || playerPatch.getCurrentLivingMotion().isSame(LivingMotions.WALK) || playerPatch.getCurrentLivingMotion().isSame(LivingMotions.KNEEL) || playerPatch.getCurrentLivingMotion().isSame(LivingMotions.SNEAK)) && playerPatch.getOriginal().onGround() && !playerPatch.getOriginal().isSprinting() && !playerPatch.getEntityState().attacking();
	}

	protected boolean isBlockableSource(DamageSource damageSource, boolean advanced) {
		return damageSource.is(DamageTypes.ARROW);
	}
	protected boolean isBlockableSourceCrouching(DamageSource damageSource, boolean advanced) {
		return !damageSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && !damageSource.is(EpicFightDamageTypeTags.GUARD_PUNCTURE) && !damageSource.is(DamageTypeTags.BYPASSES_ARMOR) && !damageSource.is(DamageTypeTags.IS_PROJECTILE) && !damageSource.is(DamageTypeTags.IS_EXPLOSION) && !damageSource.is(DamageTypes.MAGIC) && !damageSource.is(DamageTypeTags.IS_FIRE);

	}

	public void guard(TakeDamageEvent.Income event, boolean advanced)
	{
		DamageSource damageSource = event.getDamageSource();
		if (this.isBlockableSource(damageSource, advanced))
		{
			event.getEntityPatch().playSound(SoundEvents.SHIELD_BLOCK, -0.05F, 0.1F);
			event.getEntityPatch().getOriginal().getOffhandItem().hurtAndBreak(1, event.getEntityPatch().getOriginal(), EquipmentSlot.OFFHAND);
			if (!event.getEntityPatch().getOriginal().getOffhandItem().isDamageableItem() && event.getEntityPatch() instanceof PlayerPatch<?> playerPatch)
                playerPatch.consumeForSkill(this, Resource.STAMINA, 0.1f);
            this.dealEvent(event.getEntityPatch(), event);
		}
		else if (event.getEntityPatch().getOriginal().isShiftKeyDown() && event.getEntityPatch().getOriginal().onGround() && this.isBlockableSourceCrouching(damageSource, advanced))
		{
			event.getEntityPatch().playSound(SoundEvents.SHIELD_BLOCK, -0.05F, 0.1F);
			event.getEntityPatch().getOriginal().getOffhandItem().hurtAndBreak(3, event.getEntityPatch().getOriginal(), EquipmentSlot.OFFHAND);
            if (!event.getEntityPatch().getOriginal().getOffhandItem().isDamageableItem() && event.getEntityPatch() instanceof PlayerPatch<?> playerPatch)
                playerPatch.consumeForSkill(this, Resource.STAMINA, 1f);
            this.dealEvent(event.getEntityPatch(), event);
		}

	}

	public void dealEvent(LivingEntityPatch<?> entityPatch, TakeDamageEvent.Income event) {
		event.cancel();
		event.setResult(AttackResult.ResultType.BLOCKED);
		EpicFightCapabilities.getUnparameterizedEntityPatch(event.getDamageSource().getEntity(), LivingEntityPatch.class).ifPresent((attackerPatch) -> attackerPatch.setLastAttackEntity(entityPatch.getOriginal()));
	}

	@Override
	public void onRemoved(SkillContainer container)
	{
		super.onRemoved(container);
	}
}
