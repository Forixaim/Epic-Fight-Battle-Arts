package net.forixaim.battle_arts.core_assets.capabilities;

import com.google.common.collect.ImmutableList;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.util.List;

public enum BattleStyleCategories implements WeaponCategory
{
	CHAKRAM,
	SABRE(CapabilityItem.WeaponCategories.LONGSWORD),
	RAPIER(CapabilityItem.WeaponCategories.LONGSWORD),
	CLAYMORE(CapabilityItem.WeaponCategories.GREATSWORD),
	HAND_AXE,
	BATTLE_AXE;
	final List<WeaponCategory> parents;
	final int id;
	BattleStyleCategories() {
		this.id = WeaponCategory.ENUM_MANAGER.assign(this);
		this.parents = ImmutableList.of();
	}

	BattleStyleCategories(final WeaponCategory... parents) {
		this.parents = ImmutableList.copyOf(parents);
		this.id = WeaponCategory.ENUM_MANAGER.assign(this);
	}

	@Override
	public List<WeaponCategory> getParents() {
		return WeaponCategory.super.getParents();
	}

	@Override
	public int universalOrdinal()
	{
		return this.id;
	}
}
