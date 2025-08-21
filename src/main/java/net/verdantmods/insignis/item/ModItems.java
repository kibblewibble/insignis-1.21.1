package net.verdantmods.insignis.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.item.custom.BannerOfSpeed;
import net.verdantmods.insignis.item.custom.EmblemOfOffense;


public class ModItems {
    public static final Item EMBLEM_OF_OFFENSE = registerItem("emblem_of_offense", new EmblemOfOffense(new Item.Settings().maxCount(1)));
    public static final Item EMBLEM_OF_DEFENSE = registerItem("emblem_of_defense", new Item(new Item.Settings().maxCount(1)));
    public static final Item EMBLEM_OF_SUPPORT = registerItem("emblem_of_support", new Item(new Item.Settings().maxCount(1)));

    public static final Item CROWN_OF_DUELING = registerItem("crown_of_dueling", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE)));

    public static final Item BANNER_OF_SPEED = registerItem("banner_of_speed", new BannerOfSpeed(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(Insignis.MOD_ID, name), item);
    }

    public static void registerModItems()   {
        Insignis.LOGGER.info("Registering Mod Items for " + Insignis.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//        });
    }

}
