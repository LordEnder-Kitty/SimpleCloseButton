package net.enderkitty.mixin;

import dev.isxander.yacl3.gui.OptionListWidget;
import dev.isxander.yacl3.gui.YACLScreen;
import dev.isxander.yacl3.gui.tab.ListHolderWidget;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.gen.Accessor;

@Pseudo
@Environment(value = EnvType.CLIENT)
@Mixin(value = YACLScreen.CategoryTab.class, remap = false)
public interface OptionListAccessor {
    @Accessor ListHolderWidget<OptionListWidget> getOptionList();
}
