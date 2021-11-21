package org.oakbricks.nmbs;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class NoMoreBleedingSheep implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("No More Bleeding Sheep");

	// Load config 'config.properties', if it isn't present create one
	// using the lambda specified as the provider.
	public SimpleConfig CONFIG = SimpleConfig.of("no-more-bleeding-sheep").provider( this::provider ).request();

	// Custom config provider, returnes the default config content
	// if the custom provider is not specified SimpleConfig will create an empty file instead
	private String provider( String filename ) {
		return "#Disable the Wololo goal by settings disableWololoGoal to true\ndisableWololoGoalFromStarting=false";
	}

	public final boolean DISABLE_WOLOLO_GOAL = CONFIG.getOrDefault("disableWololoGoalFromStarting", false);
	@Override
	public void onInitialize() {
		LOGGER.info("No More Bleeding Sheep loaded!");
		List<String> configLines;
		try {
			configLines = Files.readAllLines(FabricLoader.getInstance().getConfigDir().resolve("no-more-bleeding-sheep.properties"));
		} catch (IOException e) {
			e.printStackTrace();
			configLines = List.of("NULL", "NULL");
		}
		LOGGER.info(configLines);
		configLines.set(1, "tele jigsaw");
		LOGGER.info(configLines);
	}
}
