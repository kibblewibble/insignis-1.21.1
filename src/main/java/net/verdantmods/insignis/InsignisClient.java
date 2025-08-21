package net.verdantmods.insignis;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EntityType;
import net.verdantmods.insignis.models.Halo;
import net.verdantmods.insignis.models.HaloFeatureRenderer;

public class InsignisClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(Halo.MODEL_LAYER, Halo::getTexturedModelData);
        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(((entityType, entityRenderer, registrationHelper, context) -> {
            if (entityType.equals(EntityType.PLAYER)) {
                registrationHelper.register(new HaloFeatureRenderer((FeatureRendererContext<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>>) entityRenderer, context.getModelLoader()));
            }
        }));
    }
}
