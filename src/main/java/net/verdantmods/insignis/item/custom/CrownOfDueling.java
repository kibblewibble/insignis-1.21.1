package net.verdantmods.insignis.item.custom;

import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.item.HaloProvider;
//Implemented to have a crown
public class CrownOfDueling extends AbstractCrown implements HaloProvider {
    public CrownOfDueling(Item.Settings settings) {
        super(settings);
    }

    @Override
    public void activeAbility(PlayerEntity player, ItemStack stack) {

    }
    //Overriden to have a crown
    public Identifier getCrownTexture(AbstractClientPlayerEntity entity){
        return Identifier.of(Insignis.MOD_ID, "textures/entity/crown/crown_of_dueling.png");
    }
}
