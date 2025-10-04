package net.verdantmods.insignis.item.custom;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.item.HaloProvider;
//Implemented to have a color
public class BannerOfRushing extends TrinketItem implements HaloProvider {

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
        modifiers.put(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(Identifier.of(Insignis.MOD_ID, "banner_of_rushing"), .1, EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return modifiers;
    }

    //Overriden to have a color
    public Integer getColor(AbstractClientPlayerEntity entity) {
        return ColorHelper.Argb.getArgb(255, 100, 200, 200);
    }
}
