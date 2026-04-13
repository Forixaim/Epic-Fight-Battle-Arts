package net.forixaim.battle_arts.core_assets.animations.battle_style;

import net.forixaim.battle_arts.core_assets.animations.battle_style.advanced.duelist.DuelistAnimations;
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

public class BattleStyleRegistry
{
	public static void Listen(AnimationManager.AnimationBuilder event)
	{
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
}
