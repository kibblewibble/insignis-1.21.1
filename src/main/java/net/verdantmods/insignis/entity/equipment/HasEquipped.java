package net.verdantmods.insignis.entity.equipment;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HasEquipped {

    public static boolean isWearingInSlot(PlayerEntity player, EquipmentSlot slot, Item item) {
        ItemStack stack = player.getEquippedStack(slot);
        return stack.getItem() == item;
    }
}