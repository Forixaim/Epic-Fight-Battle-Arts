package net.forixaim.battle_arts.core_assets.client.renderer;

import net.forixaim.battle_arts.core_assets.world.projectiles.FixedArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class FixedArrowRenderer extends ArrowRenderer<FixedArrow>
{
    public FixedArrowRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FixedArrow pEntity) {
        return ResourceLocation.fromNamespaceAndPath("minecraft", "textures/entity/projectiles/arrow.png");
    }
}
