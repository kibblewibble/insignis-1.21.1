package net.verdantmods.insignis.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.verdantmods.insignis.Insignis;

public class ModTags {
    public static class Blocks{

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Insignis.MOD_ID, name));
        }

    }

    public static class Items{

        public static final TagKey<Item> EMBLEM = createTag("emblem");
        public static final TagKey<Item> CROWN = createTag("crown");
        public static final TagKey<Item> BANNER = createTag("banner");

        public static final TagKey<Item> OFFENSE = createTag("offense");
        public static final TagKey<Item> DEFENSE = createTag("defense");
        public static final TagKey<Item> SUPPORT = createTag("support");



        private static TagKey<Item> createTag(String name){
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Insignis.MOD_ID, name));
        }

    }

}
