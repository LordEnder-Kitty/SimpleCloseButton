package net.enderkitty.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.RecipeBookScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Environment(value = EnvType.CLIENT)
@Mixin(RecipeBookScreen.class)
public interface RecipeBookAccessor {
    @Accessor RecipeBookWidget<?> getRecipeBook();
}
