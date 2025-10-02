package net.verdantmods.insignis.entity.equipment;

import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HasEquipped {

    public static boolean isWearingTrinket(PlayerEntity player, Item item) {
        return player.getComponent(TrinketsApi.TRINKET_COMPONENT).isEquipped(item);
    }
}