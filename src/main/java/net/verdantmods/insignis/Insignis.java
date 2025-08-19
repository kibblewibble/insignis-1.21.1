package net.verdantmods.insignis;

import net.fabricmc.api.ModInitializer;
import net.verdantmods.insignis.item.ModItemGroups;
import net.verdantmods.insignis.item.ModItems;
import net.verdantmods.insignis.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Insignis implements ModInitializer {
	public static final String MOD_ID = "insignis";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}