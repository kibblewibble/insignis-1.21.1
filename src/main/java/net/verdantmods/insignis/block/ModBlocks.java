package net.verdantmods.insignis.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;

public class ModBlocks {

    public static final Block DANGER_BLOCK = registerBlock("danger_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(1.5F, 6.0F)
                    .requiresTool()
                    .sounds(BlockSoundGroup.POLISHED_TUFF)));

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Insignis.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(Insignis.MOD_ID, name),
                new BlockItem(block,new Item.Settings()));
    }

    public static void registerModBlocks(){
        Insignis.LOGGER.info("Registering Mod Blocks for " + Insignis.MOD_ID);
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//        });
    }

}
