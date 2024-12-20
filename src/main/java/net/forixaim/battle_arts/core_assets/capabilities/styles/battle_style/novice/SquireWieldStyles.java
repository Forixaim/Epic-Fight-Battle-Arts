package net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.novice;

import yesman.epicfight.world.capabilities.item.Style;

public enum SquireWieldStyles implements Style
{
	SQUIRE_SWORD(false);

	final boolean OffHandUse;
	final int id;

	SquireWieldStyles(boolean OffHandUse)
	{
		this.id = ENUM_MANAGER.assign(this);
		this.OffHandUse = OffHandUse;
	}

	@Override
	public boolean canUseOffhand()
	{
		return this.OffHandUse;
	}

	@Override
	public int universalOrdinal()
	{
		return this.id;
	}
}
