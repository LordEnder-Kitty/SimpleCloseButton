package net.enderkitty;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import net.enderkitty.config.SimpleCloseButtonConfig;

public class ModMenuImpl implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return SimpleCloseButtonConfig::makeScreen;
    }
}
