package net.verdantmods.insignis.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.verdantmods.insignis.Insignis;

public class ModItems {
    public static final Item EMBLEM_OF_OFFENSE = registerItem("emblem_of_offense", new Item(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item EMBLEM_OF_DEFENSE = registerItem("emblem_of_defense", new Item(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));
    public static final Item EMBLEM_OF_SUPPORT = registerItem("emblem_of_support", new Item(new Item.Settings().maxCount(1).rarity(Rarity.UNCOMMON)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Insignis.MOD_ID, name), item);
    }

    public static void registerModItems()   {
        Insignis.LOGGER.info("Registering Mod Items for " + Insignis.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//        });
    }

}
