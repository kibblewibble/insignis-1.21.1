package net.verdantmods.insignis.models;

import net.minecraft.client.model.ModelPart;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.verdantmods.insignis.Insignis;

import java.awt.*;


public class HaloFeatureRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    ModelPart halo;

    public int convertToArgb(int r, int g, int b, int alpha) {
        // Shifts the alpha value to the highest 8 bits (24-31)
        alpha = (alpha << 24) & 0xFF000000;
        // Shifts the red value to the next 8 bits (16-23)
        r = (r << 16) & 0x00FF0000;
        // Shifts the green value to the next 8 bits (8-15)
        g = (g << 8) & 0x0000FF00;
        // Masks out everything not blue for the lowest 8 bits (0-7)
        b = b & 0x000000FF;

        // Combines all channels into a single integer using bitwise OR
        return alpha | r | g | b;
    }


    public HaloFeatureRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> context, EntityModelLoader loader) {

        super(context);
        halo = loader.getModelPart(Halo.MODEL_LAYER);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-35));
        getContextModel().body.copyTransform(halo);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentCull(getTexture(entity)));
        int m = LivingEntityRenderer.getOverlay(entity, 0.0F);
        matrices.translate(0, entity.isSneaky() ? -.45F : -.75F, -.25);
        matrices.scale(1F, 0F, 1F);
        int color = convertToArgb(255,255,255,255);
        halo.render(matrices, vertexConsumer, light, m, color);
    }

    @Override
    protected Identifier getTexture(AbstractClientPlayerEntity entity){
        return Identifier.of(Insignis.MOD_ID, "textures/entity/halo.png");
    }
}
