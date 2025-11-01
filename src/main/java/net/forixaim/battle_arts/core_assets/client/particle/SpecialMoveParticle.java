package net.forixaim.battle_arts.core_assets.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;

public class SpecialMoveParticle extends TextureSheetParticle
{
    protected final SpriteSet sprite;

    protected SpecialMoveParticle(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet pSpriteSet) {
        super(pLevel, pX, pY, pZ);
        this.quadSize *= 20f;
        sprite = pSpriteSet;
        this.setSpriteFromAge(sprite);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprite);
        }
    }

    @Override
    public @NotNull ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    public record Provider(SpriteSet sprites) implements ParticleProvider<SimpleParticleType> {

        @Override
        public Particle createParticle(@NotNull SimpleParticleType typeIn, @NotNull ClientLevel worldIn,
                                       double x, double y, double z,
                                       double xSpeed, double ySpeed, double zSpeed) {
            return new SpecialMoveParticle(worldIn, x, y, z, sprites);

        }
    }
}
