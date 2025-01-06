package net.enderkitty.mixin;

import net.enderkitty.SimpleCloseButton;
import net.enderkitty.config.ScreenEntry;
import net.enderkitty.config.SimpleCloseButtonConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;
import net.minecraft.client.gui.screen.recipebook.RecipeBookProvider;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TexturedButtonWidget;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Environment(value= EnvType.CLIENT)
@Mixin(Screen.class)
public abstract class ScreenMixin extends AbstractParentElement implements Drawable {
    @Unique private static final ButtonTextures TEXTURES = new ButtonTextures(
            Identifier.of(SimpleCloseButton.MOD_ID, "widget/close_button"), 
            Identifier.of(SimpleCloseButton.MOD_ID, "widget/close_button_highlighted")
    );
    @Unique ButtonWidget closeButton = new TexturedButtonWidget(this.width / 2 + 73, this.height / 2 + 80, 12, 12, TEXTURES, button -> {
        if (Screen.hasShiftDown()) MinecraftClient.getInstance().setScreen(null); else this.close();
    });
    @Unique SimpleCloseButtonConfig config = SimpleCloseButtonConfig.HANDLER.instance();
    
    
    @Shadow public abstract void close();
    @Shadow protected abstract <T extends Element & Drawable> T addDrawableChild(T drawableElement);
    @Shadow public int width;
    @Shadow public int height;
    @Shadow @Nullable protected MinecraftClient client;
    
    
    @Inject(method = "init(Lnet/minecraft/client/MinecraftClient;II)V", at = @At("TAIL"))
    public final void initCloseButtons(MinecraftClient client, int width, int height, CallbackInfo ci) {
        if (config.modEnabled && client.currentScreen instanceof GenericContainerScreen && config.chestInventory && MinecraftClient.getInstance().player != null) {
            GenericContainerScreenHandler handler = (GenericContainerScreenHandler) MinecraftClient.getInstance().player.currentScreenHandler;
            switch (handler.getRows()) {
                case 1 -> closeButtonWidget(config.chestInventoryX, config.chestInventoryY1);
                case 2 -> closeButtonWidget(config.chestInventoryX, config.chestInventoryY2);
                case 3 -> closeButtonWidget(config.chestInventoryX, config.chestInventoryY3);
                case 4 -> closeButtonWidget(config.chestInventoryX, config.chestInventoryY4);
                case 5 -> closeButtonWidget(config.chestInventoryX, config.chestInventoryY5);
                case 6 -> closeButtonWidget(config.chestInventoryX, config.chestInventoryY6);
            }
        }
        
        if (config.modEnabled) {
            for (ScreenEntry screenEntry : config.screens) {
                if (client.currentScreen != null && client.currentScreen.getClass().getCanonicalName() != null
                        && client.currentScreen.getClass().getCanonicalName().equals(screenEntry.screen())) {
                    if (screenEntry.recipeBook() && client.currentScreen instanceof RecipeBookProvider screenWithBook && screenWithBook.getRecipeBookWidget().isOpen()) {
                        closeButtonWidget(screenEntry.bookX(), screenEntry.bookY());
                    } else {
                        closeButtonWidget(screenEntry.x(), screenEntry.y());
                    }
                }
            }
        }
    }
    
    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        if (config.modEnabled) {
            for (ScreenEntry screenEntry : config.screens) {
                if (client != null && client.currentScreen != null && client.currentScreen.getClass().getCanonicalName() != null
                        && client.currentScreen.getClass().getCanonicalName().equals(screenEntry.screen())
                        && screenEntry.recipeBook() && client.currentScreen instanceof RecipeBookProvider screenWithBook) {
                    if (screenWithBook.getRecipeBookWidget().isOpen()) {
                        closeButton.setPosition(this.width / 2 + screenEntry.bookX(), this.height / 2 - screenEntry.bookY());
                    } else {
                        closeButton.setPosition(this.width / 2 + screenEntry.x(), this.height / 2 - screenEntry.y());
                    }
                }
            }
        }
    }
    
    @Unique
    public void closeButtonWidget(int x, int y) {
        if (client != null && client.currentScreen != null) {
            closeButton.setPosition(this.width / 2 + x, this.height / 2 - y);
            if (config.tooltip) closeButton.setTooltip(Tooltip.of(Text.translatable("simple-close-button.button.tooltip")));
            addDrawableChild(closeButton);
        }
    }
}
