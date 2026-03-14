package net.forixaim.battle_arts.core_assets.client.particle;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.api.client.animation.property.TrailInfo;

public class TrailParticleType extends SimpleParticleType {
    private final TrailInfo entityId;
    private final TrailParticleType type;


    public TrailParticleType(boolean override) {
        super(override);
        this.type = null;
        this.entityId = null;
    }

    @Override
    public @NotNull MapCodec<SimpleParticleType> codec() {
        return MapCodec.unit(this::getType);
    }

    public TrailParticleType(TrailInfo entityId, TrailParticleType type) {
        super(true);
        this.entityId = entityId;
        this.type = type;
    }


    @Override
    public @NotNull StreamCodec<RegistryFriendlyByteBuf, SimpleParticleType> streamCodec() {
        return StreamCodec.unit(this);
    }

    public @NotNull TrailParticleType getType() {
        return type != null ? type : this;
    }

    public TrailInfo getTrailInfo() {
        return entityId != null ? entityId : TrailInfo.builder().create();
    }
}