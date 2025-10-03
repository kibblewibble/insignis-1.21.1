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
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.item.HaloProvider;

//Implemented to have a halo
public class EmblemOfOffense extends TrinketItem implements HaloProvider {
    public EmblemOfOffense(Settings settings) {
        super(settings);
    }

    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {

        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);
        modifiers.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(Identifier.of(Insignis.MOD_ID, "emblem_of_offense"), 1, EntityAttributeModifier.Operation.ADD_VALUE));
        modifiers.put(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(Identifier.of(Insignis.MOD_ID, "emblem_of_offense"), -.5, EntityAttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }
    //Overriden to have a halo
    public Identifier getHaloTexture(AbstractClientPlayerEntity entity){
        return Identifier.of(Insignis.MOD_ID, "textures/entity/halo/halo_of_offense.png");
    }
}

