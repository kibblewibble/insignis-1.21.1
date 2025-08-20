package net.verdantmods.insignis.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.verdantmods.insignis.Insignis;
import net.verdantmods.insignis.item.custom.BannerOfSpeed;
import net.verdantmods.insignis.item.custom.EmblemOfOffense;

import java.util.List;

public class ModItems {
    public static final Item EMBLEM_OF_OFFENSE = registerItem("emblem_of_offense", new EmblemOfOffense(new Item.Settings().maxCount(1)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.insignis.empty"));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_offense.line1").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_offense.line2").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.insignis.empty"));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_offense.line3").formatted(Formatting.DARK_GRAY,Formatting.ITALIC));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item EMBLEM_OF_DEFENSE = registerItem("emblem_of_defense", new Item(new Item.Settings().maxCount(1)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.insignis.empty"));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_defense.line1").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_defense.line2").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.insignis.empty"));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_defense.line3").formatted(Formatting.DARK_GRAY,Formatting.ITALIC));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item EMBLEM_OF_SUPPORT = registerItem("emblem_of_support", new Item(new Item.Settings().maxCount(1)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.insignis.empty"));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_support.line1").formatted(Formatting.BLUE));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_support.line2").formatted(Formatting.RED));
            tooltip.add(Text.translatable("tooltip.insignis.empty"));
            tooltip.add(Text.translatable("tooltip.insignis.emblem_of_support.line3").formatted(Formatting.DARK_GRAY,Formatting.ITALIC));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    public static final Item CROWN_OF_DUELING = registerItem("crown_of_dueling", new Item(new Item.Settings().maxCount(1).rarity(Rarity.RARE)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.insignis.empty"));
            tooltip.add(Text.translatable("tooltip.insignis.offensive_crown").formatted(Formatting.DARK_GRAY,Formatting.ITALIC));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

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
