package net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style;

import yesman.epicfight.world.capabilities.item.Style;

public enum MercenaryStyles implements Style
{
    MERCENARY_WEAPON_ART(false);
    final boolean visibleOffHand;
    final int id;
    MercenaryStyles(boolean visibleOffHand)
    {
        this.visibleOffHand = visibleOffHand;
        this.id = ENUM_MANAGER.assign(this);
    }


    @Override
    public boolean canUseOffhand()
    {
        return visibleOffHand;
    }

    @Override
    public int universalOrdinal()
    {
        return id;
    }
}
