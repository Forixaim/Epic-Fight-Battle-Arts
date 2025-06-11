package net.forixaim.battle_arts.core_assets.capabilities.styles.battle_style.advanced;

import yesman.epicfight.world.capabilities.item.Style;

public enum ThiefStyles implements Style {
    THIEF_WEAPON(false);

    final int id;
    final boolean offHandUse;

    ThiefStyles(boolean offHandUse) {
        id = Style.ENUM_MANAGER.assign(this);
        this.offHandUse = offHandUse;
    }

    @Override
    public boolean canUseOffhand() {
        return offHandUse;
    }

    @Override
    public int universalOrdinal() {
        return id;
    }
}
