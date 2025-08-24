package net.verdantmods.insignis.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> ARMOR_INVISIBILITY = registerEffect("armor_invisibility", new ArmorInvisibilityEffect());

    private static RegistryEntry<StatusEffect> registerEffect(String name, StatusEffect status_effect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Insignis.MOD_ID, name), status_effect);
    }

    public static void registerModEffects()   {
        Insignis.LOGGER.info("Registering Mod Effects for " + Insignis.MOD_ID);
    }
}
