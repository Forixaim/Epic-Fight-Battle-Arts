package net.forixaim.battle_arts.core_assets.skills.combat_art;

import net.forixaim.battle_arts_api.battle_arts_skills.active.combat_arts.CombatArt;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.skill.SkillBuilder;
import yesman.epicfight.skill.SkillContainer;

public class PowerTrip extends CombatArt
{

	public PowerTrip(SkillBuilder<? extends CombatArt> builder)
	{
		super(builder);
	}

	@Override
	public void executeOnServer(SkillContainer container, FriendlyByteBuf args)
	{
		super.executeOnServer(container, args);
		AnimationManager.AnimationAccessor<? extends AttackAnimation> attack = container.getExecutor().getHoldingItemCapability(InteractionHand.MAIN_HAND).getAutoAttackMotion(container.getExecutor()).get(0);
	}
}
