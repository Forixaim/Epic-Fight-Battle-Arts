package net.forixaim.battle_arts.core_assets.animations.battle_style;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.fighter.FighterAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.lancer.LancerAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.mercenary.MercenaryAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.ronin.RoninAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.thief.ThiefAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.journeyman.JourneymanAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.recruit.RecruitAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.novice.squire.SquireAnimations;
import net.forixaim.battle_arts.core_assets.animations.battle_style.unique.iron_lotus.IronLotusAnimations;
import net.forixaim.battle_arts.core_assets.animations.other.DraconicInstinctAnimations;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.animation.types.AttackAnimation;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.Armatures;

public class BattleStyleRegistry
{
	///Do not use
	public static AnimationManager.AnimationAccessor<AttackAnimation> BOW_BASE_DAMAGE;
	public static void Listen(AnimationManager.AnimationBuilder event)
	{
		build(event);
        FighterAnimations.listen(event);
		DraconicInstinctAnimations.build(event);
		JourneymanAnimations.listenAnims(event);
		RecruitAnimations.Build(event);
		SquireAnimations.Build(event);
		RoninAnimations.Listen(event);
		ThiefAnimations.listen(event);
		DuelistAnimations.listen(event);
		IronLotusAnimations.Build(event);
		MercenaryAnimations.listen(event);
		LancerAnimations.listen(event);
	}

	public static void build(AnimationManager.AnimationBuilder builder)
	{
		BOW_BASE_DAMAGE = builder.nextAccessor("bow_damage_dummy", access -> new AttackAnimation(0, 0, 0, 0, 0, null, Joint.EMPTY, access, Armatures.BIPED));
	}
}
