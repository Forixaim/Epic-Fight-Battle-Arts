package net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced;

import yesman.epicfight.world.capabilities.item.Style;

public enum RoninStyles implements Style
{
    RONIN_UCHIGATANA(false),
    RONIN_UCHIGATANA_SHEATHE(false),
    ;

    final boolean OffHandUse;
    final int id;

    RoninStyles(boolean OffHandUse)
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
