package net.forixaim.battle_arts.core_assets.animations.types;

import net.minecraft.util.StringRepresentable;
import org.jetbrains.annotations.NotNull;

public enum PhysicalDamageType implements StringRepresentable
{
    SLASH, PUNCTURE, IMPACT;

    @Override
    public @NotNull String getSerializedName() {
        return this.name();
    }
}
