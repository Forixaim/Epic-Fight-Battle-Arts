package net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.unique;

import yesman.epicfight.world.capabilities.item.Style;

public enum FencerStyles implements Style
{
    FENCER_WEAPON_ART(false);
    final boolean OffHandUse;
    final int id;
    FencerStyles(boolean OffHandUse)
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
