package net.verdantmods.insignis.item;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.verdantmods.insignis.Insignis;

import java.util.Objects;
//Use this interface for items that should have a halo, crown or color
public interface HaloProvider {
    //Override this to have a halo
    default Identifier getHaloTexture(AbstractClientPlayerEntity entity){
        return null;
    }
    //Override this to have a crown
    default Identifier getCrownTexture(AbstractClientPlayerEntity entity){
        return null;
    }
    //Override this to have a color
    default Integer getColor(AbstractClientPlayerEntity entity){
        return null;
    }
    //Call this to get the Halo texture from all the player's trinkets
    static Identifier getHalo(AbstractClientPlayerEntity entity){
        return entity.getComponent(TrinketsApi.TRINKET_COMPONENT)
                //Get the equipped trinkets that may have a halo
                .getEquipped(stack -> stack.getItem() instanceof HaloProvider)
                .stream()
                .map(slotReferenceItemStackPair -> ((HaloProvider) slotReferenceItemStackPair.getRight().getItem()).getHaloTexture(entity))
                //Keep only trinkets with halos
                .filter(Objects::nonNull)
                //If no halo is found return the default blank one
                .findFirst().orElse(Identifier.of(Insignis.MOD_ID, "textures/entity/no_halo.png"));
    //This goes for the getCrown and getHaloColor too
    }

    static Identifier getCrown(AbstractClientPlayerEntity entity){
        return entity.getComponent(TrinketsApi.TRINKET_COMPONENT)
                .getEquipped(stack -> stack.getItem() instanceof HaloProvider)
                .stream()
                .map(slotReferenceItemStackPair -> ((HaloProvider) slotReferenceItemStackPair.getRight().getItem()).getCrownTexture(entity))
                .filter(Objects::nonNull)
                .findFirst().orElse(Identifier.of(Insignis.MOD_ID, "textures/entity/no_halo.png"));
    }

    static int getHaloColor(AbstractClientPlayerEntity entity){
        return entity.getComponent(TrinketsApi.TRINKET_COMPONENT)
                .getEquipped(stack -> stack.getItem() instanceof HaloProvider)
                .stream()
                .map(slotReferenceItemStackPair -> ((HaloProvider) slotReferenceItemStackPair.getRight().getItem()).getColor(entity))
                .filter(identifier -> identifier != null)
                .findFirst().orElse(ColorHelper.Argb.getArgb(255, 255,255,255));
    }
}
