package net.forixaim.epic_fight_battle_styles.core_assets.api.animation.types;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.api.model.Armature;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

import java.util.Arrays;
import java.util.List;

public class WeaponIdleAnimation extends StaticAnimation
{
	protected final StaticAnimation[] animations;
	protected final Pair<Float, Float> randomInterval;

	public WeaponIdleAnimation(boolean repeatPlay, String path, Armature armature, float minInterval, float maxInterval ,StaticAnimation... additionalIdles)
	{
		super(repeatPlay, path, armature);
		randomInterval = Pair.of(minInterval, maxInterval);
		animations = additionalIdles;
	}

	public WeaponIdleAnimation(float convTime, boolean repeatPlay, String path, Armature armature, float minInterval, float maxInterval, StaticAnimation... additionalIdles)
	{
		super(convTime, repeatPlay, path, armature);
		randomInterval = Pair.of(minInterval, maxInterval);
		animations = additionalIdles;
	}

//	@Override
//	public void tick(LivingEntityPatch<?> entitypatch) {
//		if (this.)
//		super.tick(entitypatch);
//	}
}