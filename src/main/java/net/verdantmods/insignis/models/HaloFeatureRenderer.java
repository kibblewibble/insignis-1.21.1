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
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.RotationAxis;
import net.verdantmods.insignis.Insignis;

import java.awt.*;


public class HaloFeatureRenderer extends FeatureRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    ModelPart halo;


    public HaloFeatureRenderer(FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> context, EntityModelLoader loader) {

        super(context);
        halo = loader.getModelPart(Halo.MODEL_LAYER);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, AbstractClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if(entity.hasStatusEffect(StatusEffects.INVISIBILITY)){
            return;
        }

        float time = (entity.getWorld().getTime() + tickDelta) * 1.5F;

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(headYaw));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-25));
        getContextModel().body.copyTransform(halo);
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucentCull(getTexture(entity)));
        int m = LivingEntityRenderer.getOverlay(entity, 0.0F);
        matrices.translate(0, entity.isSneaky() ? -.45F : -.75F, -.25);
        int color = ColorHelper.Argb.getArgb(255,100,255,200);

        // Save the current transformation state
        matrices.push();

        // Move to the center of where the halo will be, rotate, then move back
        matrices.translate(0, 0, 0.25); // Adjust these values based on your halo model's center
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(time));
        matrices.translate(0, 0, -0.25);

        matrices.scale(-1F, -0.001F, 1F);
        halo.render(matrices, vertexConsumer, light, m, color);
        matrices.scale(-1F, 0.001F, 1F);
        halo.render(matrices, vertexConsumer, light, m, color);

        // Restore the transformation state
        matrices.pop();
    }

    @Override
    protected Identifier getTexture(AbstractClientPlayerEntity entity){
        return Identifier.of(Insignis.MOD_ID, "textures/entity/halo.png");
    }
}
