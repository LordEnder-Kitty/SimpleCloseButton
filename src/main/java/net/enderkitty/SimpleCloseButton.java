package net.enderkitty;

import net.enderkitty.config.SimpleCloseButtonConfig;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleCloseButton implements ModInitializer {
	public static final String MOD_ID = "close-btn";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		SimpleCloseButtonConfig.INSTANCE.load();
	}
}
