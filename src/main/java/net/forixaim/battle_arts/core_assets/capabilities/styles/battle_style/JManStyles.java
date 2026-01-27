package net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style;

import yesman.epicfight.world.capabilities.item.Style;

public enum JManStyles implements Style
{
    JMAN_BAXE(false);

    final boolean OffHandUse;
    final int id;

    JManStyles(boolean OffHandUse)
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