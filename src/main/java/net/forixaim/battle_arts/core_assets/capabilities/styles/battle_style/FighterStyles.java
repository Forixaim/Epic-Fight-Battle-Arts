package net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style;

import yesman.epicfight.world.capabilities.item.Style;

public enum FighterStyles implements Style
{
    FIGHTER_WEAPON_ART(false);
    final boolean OffHandUse;
    final int id;
    FighterStyles(boolean OffHandUse)
    {
        this.id = ENUM_MANAGER.assign(this);
        this.OffHandUse = OffHandUse;
    }

    @Override
    public int universalOrdinal()
    {
        return this.id;
    }

    @Override
    public boolean canUseOffhand()
    {
        return this.OffHandUse;
    }
}
