package net.forixaim.battle_arts.core_assets.client.particle;

import com.mojang.brigadier.StringReader;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.FriendlyByteBuf;
import org.jetbrains.annotations.NotNull;
import yesman.epicfight.api.client.animation.property.TrailInfo;

import java.util.Objects;

public class TrailParticleType extends ParticleType<TrailParticleType> implements ParticleOptions {

    public static final Codec<TrailParticleType> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("entity_id").forGetter(o -> 1)
    ).apply(instance, TrailParticleType::new));

    private final TrailInfo entityId;
    private final TrailParticleType type;

    public static final Deserializer<TrailParticleType> DESERIALIZER = new Deserializer<>() {
        @Override
        public @NotNull TrailParticleType fromCommand(@NotNull ParticleType<TrailParticleType> type, StringReader reader) {
            return new TrailParticleType(TrailInfo.builder().create(), false);
        }

        @Override
        public @NotNull TrailParticleType fromNetwork(@NotNull ParticleType<TrailParticleType> type, FriendlyByteBuf buf) {
            return new TrailParticleType(TrailInfo.builder().create(), false);
        }
    };

    public TrailParticleType(TrailInfo entityId, boolean override) {
        super(override, DESERIALIZER);
        this.type = null;
        this.entityId = entityId;
    }

    public TrailParticleType(boolean override) {
        super(override, DESERIALIZER);
        this.type = null;
        this.entityId = null;
    }

    public TrailParticleType(TrailInfo entityId) {
        this(entityId, false);
    }

    public TrailParticleType(TrailInfo entityId, TrailParticleType type) {
        super(true, DESERIALIZER);
        this.entityId = entityId;
        this.type = type;
    }

    public TrailParticleType(Integer integer) {
        super(false, DESERIALIZER);
        this.type = null;
        this.entityId = null;
    }

    public void writeToNetwork(@NotNull FriendlyByteBuf pBuffer)
    {
        pBuffer.writeVarInt(1);
    }

    public @NotNull String writeToString() {
        return Objects.requireNonNull(BuiltInRegistries.PARTICLE_TYPE.getKey(this)).toString();
    }

    @Override
    public @NotNull Codec<TrailParticleType> codec() {
        return CODEC;
    }

    public @NotNull TrailParticleType getType() {
        return type != null ? type : this;
    }

    public TrailInfo getTrailInfo() {
        return entityId != null ? entityId : TrailInfo.builder().create();
    }
}