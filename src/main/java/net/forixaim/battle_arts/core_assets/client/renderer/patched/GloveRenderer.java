package net.forixaim.battle_arts.core_assets.client.renderer.patched;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import yesman.epicfight.api.animation.Joint;
import yesman.epicfight.api.utils.math.MathUtils;
import yesman.epicfight.api.utils.math.OpenMatrix4f;
import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
import yesman.epicfight.model.armature.HumanoidArmature;
import yesman.epicfight.model.armature.types.ToolHolderArmature;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

public class GloveRenderer extends RenderItemBase
{
    private final boolean alwaysInHand;


    public GloveRenderer(JsonElement jsonElement)
    {
        super(jsonElement);
        JsonObject jsonObj = jsonElement.getAsJsonObject();

        this.alwaysInHand = jsonObj.has("alwaysInHand") && GsonHelper.getAsBoolean(jsonObj, "alwaysInHand");

    }

    @Override
    public void renderItemInHand(ItemStack stack, LivingEntityPatch<?> entitypatch, InteractionHand hand, OpenMatrix4f[] poses, MultiBufferSource buffer, PoseStack poseStack, int packedLight, float partialTicks)
    {
        OpenMatrix4f modelMatrix = this.getCorrectionMatrix(entitypatch, InteractionHand.MAIN_HAND, poses);
        poseStack.pushPose();
        MathUtils.mulStack(poseStack, modelMatrix);
        itemRenderer.renderStatic(stack, ItemDisplayContext.THIRD_PERSON_RIGHT_HAND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, buffer, null, 0);
        poseStack.popPose();
    }

    @Override
    public OpenMatrix4f getCorrectionMatrix(LivingEntityPatch<?> entitypatch, InteractionHand hand, OpenMatrix4f[] poses)
    {
        Joint parentJoint = null;

        if (this.alwaysInHand) {
            if (entitypatch.getArmature() instanceof HumanoidArmature armature) {
                parentJoint = hand == InteractionHand.MAIN_HAND ? armature.handR : armature.handL;
            }

            if (parentJoint == null) {
                parentJoint = entitypatch.getArmature().rootJoint;
            }
        } else {
            parentJoint = entitypatch.getParentJointOfHand(hand);
        }

        switch (hand) {
            case MAIN_HAND -> {
                this.transformHolder.load(this.mainhandCorrectionTransforms.getOrDefault(parentJoint.getName(), GLOBAL_MAINHAND_ITEM_TRANSFORMS.get(parentJoint.getName())));
            }
            case OFF_HAND -> {
                this.transformHolder.load(this.offhandCorrectionTransforms.getOrDefault(parentJoint.getName(), GLOBAL_OFFHAND_ITEM_TRANSFORMS.get(parentJoint.getName())));
            }
        }

        this.transformHolder.mulFront(poses[parentJoint.getId()]);

        return this.transformHolder;
    }
}
