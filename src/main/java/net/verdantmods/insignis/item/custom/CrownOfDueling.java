package net.verdantmods.insignis.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;

public class CrownOfDueling extends AbstractCrown{
    public CrownOfDueling(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void activeAbility(PlayerEntity player, ItemStack stack) {

    }

    public static Identifier getCrown(){
        return Identifier.of(Insignis.MOD_ID, "textures/entity/crown/crown_of_dueling.png");
    }
}
