package net.verdantmods.insignis.mixin;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.verdantmods.insignis.effect.ModEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ArmorFeatureRenderer.class)
public abstract class ArmorFeatureRendererMixin <T extends LivingEntity, A extends BipedEntityModel<T>> {
    private T entity;
    @Inject(
            method = "renderArmor",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ArmorItem;getSlotType()Lnet/minecraft/entity/EquipmentSlot;")
    )
    private void captureContext(MatrixStack matrices, VertexConsumerProvider vertexConsumers, T entity, EquipmentSlot armorSlot, int light, A model, CallbackInfo ci) {
        this.entity = entity;
    }

    @Inject(
            method = "renderArmorParts",
            at = @At(value = "HEAD"),
            cancellable = true
    )
    private void armorTransparency(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, A model, int i, Identifier identifier, CallbackInfo ci) {
        if (entity.hasStatusEffect(ModEffects.ARMOR_INVISIBILITY)) {
            VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityTranslucent(identifier));
            model.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.withAlpha(0, i));
            ci.cancel();
        }
    }
}
