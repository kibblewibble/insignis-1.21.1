package net.verdantmods.insignis.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup INSIGNIS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Insignis.MOD_ID, "insignis_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.EMBLEM_OF_OFFENSE))
                    .displayName(Text.translatable("itemgroup.insignis.insignis_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.EMBLEM_OF_OFFENSE);
                        entries.add(ModItems.EMBLEM_OF_DEFENSE);
                        entries.add(ModItems.EMBLEM_OF_SUPPORT);

                        entries.add(ModBlocks.DANGER_BLOCK);
                    })
                    .build());

    public static void registerItemGroups(){
        Insignis.LOGGER.info("Registering Item Groups for " + Insignis.MOD_ID);
    }
}
