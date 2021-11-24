package org.oakbricks.nmbs;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoMoreBleedingSheep implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("No More Bleeding Sheep");

	public SimpleConfig CONFIG = SimpleConfig.of("no-more-bleeding-sheep").provider(this::provider).request();

	private String provider(String filename) {
		return "#Disable the Wololo goal by settings disableWololoGoal to true\ndisableWololoGoalFromStarting=false";
	}

	public final boolean DISABLE_WOLOLO_GOAL = CONFIG.getOrDefault("disableWololoGoalFromStarting", false);
	@Override
	public void onInitialize() {
		LOGGER.info("No More Bleeding Sheep loaded!");
	}
}
