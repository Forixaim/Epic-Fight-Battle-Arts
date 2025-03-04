package net.forixaim.battle_arts.core_assets.world;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.forixaim.battle_arts.EpicFightBattleArts;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class FlyingShockwaveRenderer extends EntityRenderer<FlyingShockwaveProjectile>
{
    private final Model model;

    public FlyingShockwaveRenderer(EntityRendererProvider.Context pContext)
    {
        super(pContext);
        this.model = new FlyingShockwaveModel<>(pContext.bakeLayer(ModelLayers.FLYING_SHOCKWAVE));
    }

    @Override
    public void render(FlyingShockwaveProjectile pEntity, float pEntityYaw, float pPartialTick, PoseStack pPoseStack, @NotNull MultiBufferSource pBuffer, int pPackedLight)
    {
        pPoseStack.pushPose();
        pPoseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.yRotO, pEntity.getYRot()) - 90.0F));
        pPoseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(pPartialTick, pEntity.xRotO, pEntity.getXRot()) + 90.0F));
        VertexConsumer idk_what_this_is = ItemRenderer.getFoilBufferDirect(pBuffer, this.model.renderType(this.getTextureLocation(pEntity)), false, pEntity.isFoil());
        this.model.renderToBuffer(pPoseStack, idk_what_this_is, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
        super.render(pEntity, pEntityYaw, pPartialTick, pPoseStack, pBuffer, pPackedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull FlyingShockwaveProjectile flyingShockwaveProjectile)
    {
        return new ResourceLocation(EpicFightBattleArts.MOD_ID, "textures/projectiles/flying_shockwave.png");
    }
}
