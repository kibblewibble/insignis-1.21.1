package net.verdantmods.insignis.item.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.verdantmods.insignis.Insignis;

import javax.swing.text.html.parser.Entity;

public class BannerOfRushing extends TrinketItem {

    public BannerOfRushing(Settings settings) {
        super(settings);
    }

//    private boolean isWithinRange(BlockPos center, BlockPos target, int range) {
//        if (Math.abs(center.getX() - target.getX()) <= range &&
//                Math.abs(center.getY() - target.getY()) <= range &&
//                Math.abs(center.getZ() - target.getZ()) <= range) {
//            return true;
//        } else {return false;}
//    }
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);

//        if(this.isWithinRange(BlockPos.))
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(Insignis.MOD_ID, "emblem_of_offense"), .1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return modifiers;
    }
}
