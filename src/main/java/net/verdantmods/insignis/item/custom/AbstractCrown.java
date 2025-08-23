package net.verdantmods.insignis.item.custom;

import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public abstract class AbstractCrown extends TrinketItem {
    public AbstractCrown(Settings settings) {
        super(settings);
    }
    public abstract void ability(PlayerEntity player, ItemStack stack);
}
