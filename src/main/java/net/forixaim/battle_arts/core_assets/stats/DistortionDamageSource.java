package net.forixaim.battle_arts.core_assets.stats;

import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DistortionDamageSource extends DamageSource
{
    public DistortionDamageSource(Holder<DamageType> pType, @Nullable Entity pEntity)
    {
        super(pType, pEntity);
    }

    public DistortionDamageSource(Holder<DamageType> pType)
    {
        super(pType);
    }

    @Override
    public @NotNull Component getLocalizedDeathMessage(@NotNull LivingEntity pLivingEntity)
    {
        return Component.translatable("death.player.battle_arts.distortion", pLivingEntity.getDisplayName());
    }
}
