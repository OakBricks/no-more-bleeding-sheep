package org.oakbricks.nmbs;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoMoreBleedingSheep implements ModInitializer {
	private static Logger LOGGER = LogManager.getLogger("No More Bleeding Sheep");
	@Override
	public void onInitialize() {
		LOGGER.info("Mod loaded!");
	}
}
