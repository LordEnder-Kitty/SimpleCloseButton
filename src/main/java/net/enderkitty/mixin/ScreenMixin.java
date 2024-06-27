package net.enderkitty.mixin;

import net.enderkitty.SimpleCloseButton;
import net.enderkitty.config.SimpleCloseButtonConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.ButtonTextures;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.*;
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
    @Unique ButtonWidget closeButton = new TexturedButtonWidget(this.width / 2 + 73, this.height / 2 + 80, 12, 12, TEXTURES, button -> this.close());
    @Unique SimpleCloseButtonConfig config = SimpleCloseButtonConfig.HANDLER.instance();
    
    
    @Shadow public abstract void close();
    @Shadow protected abstract <T extends Element & Drawable> T addDrawableChild(T drawableElement);
    @Shadow public int width;
    @Shadow public int height;
    @Shadow @Nullable protected MinecraftClient client;
    
    
    @Inject(method = "init(Lnet/minecraft/client/MinecraftClient;II)V", at = @At("TAIL"))
    public final void initCloseButtons(MinecraftClient client, int width, int height, CallbackInfo ci) {
        addButtonEntry(Generic3x3ContainerScreen.class, config.generic3x3Inventory, config.generic3x3InventoryX, config.generic3x3InventoryY);
        addButtonEntry(HopperScreen.class, config.hopperInventory, config.hopperInventoryX, config.hopperInventoryY);
        addButtonEntry(AnvilScreen.class, config.anvilInventory, config.anvilInventoryX, config.anvilInventoryY);
        
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
        
        addButtonEntry(CrafterScreen.class, config.crafterInventory, config.crafterInventoryX, config.crafterInventoryY);
        addButtonWithBookEntry(CraftingScreen.class, config.craftingTableInventory, config.craftingTableInventoryX, config.craftingTableInventoryY, config.craftingTableRecipeBookX, config.craftingTableRecipeBookY);
        addButtonWithBookEntry(FurnaceScreen.class, config.furnaceInventory, config.furnaceInventoryX, config.furnaceInventoryY, config.furnaceRecipeBookX, config.furnaceRecipeBookY);
        addButtonWithBookEntry(SmokerScreen.class, config.smokerInventory, config.smokerInventoryX, config.smokerInventoryY, config.craftingTableRecipeBookX, config.craftingTableRecipeBookY);
        addButtonWithBookEntry(BlastFurnaceScreen.class, config.blastFurnaceInventory, config.blastFurnaceInventoryX, config.blastFurnaceInventoryY, config.blastFurnaceRecipeBookX, config.blastFurnaceRecipeBookY);
        addButtonWithBookEntry(InventoryScreen.class, config.playerInventory, config.playerInventoryX, config.playerInventoryY, config.playerRecipeBookX, config.playerRecipeBookY);
        addButtonEntry(CreativeInventoryScreen.class, config.creativeInventory, config.creativeInventoryX, config.creativeInventoryY);
        addButtonEntry(ShulkerBoxScreen.class, config.shulkerInventory, config.shulkerInventoryX, config.shulkerInventoryY);
        addButtonEntry(StonecutterScreen.class, config.stonecutterInventory, config.stonecutterInventoryX, config.stonecutterInventoryY);
        addButtonEntry(CartographyTableScreen.class, config.cartographyInventory, config.cartographyInventoryX, config.cartographyInventoryY);
        addButtonEntry(SmithingScreen.class, config.smithingInventory, config.smithingInventoryX, config.smithingInventoryY);
        addButtonEntry(GrindstoneScreen.class, config.grindstoneInventory, config.grindstoneInventoryX, config.grindstoneInventoryY);
        addButtonEntry(LoomScreen.class, config.loomInventory, config.loomInventoryX, config.loomInventoryY);
        addButtonEntry(EnchantmentScreen.class, config.enchantingInventory, config.enchantingInventoryX, config.enchantingInventoryY);
        addButtonEntry(BrewingStandScreen.class, config.brewingInventory, config.brewingInventoryX, config.brewingInventoryY);
        addButtonEntry(HorseScreen.class, config.horseInventory, config.horseInventoryX, config.horseInventoryY);
        addButtonEntry(MerchantScreen.class, config.villagerInventory, config.villagerInventoryX, config.villagerInventoryY);
        addButtonEntry(BeaconScreen.class, config.beaconInventory, config.beaconInventoryX, config.beaconInventoryY);
    }
    
    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        addTickingButtonAdjustment(CraftingScreen.class, config.craftingTableInventoryX, config.craftingTableInventoryY, config.craftingTableRecipeBookX, config.craftingTableRecipeBookY);
        addTickingButtonAdjustment(FurnaceScreen.class, config.furnaceInventoryX, config.furnaceInventoryY, config.furnaceRecipeBookX, config.furnaceRecipeBookY);
        addTickingButtonAdjustment(SmokerScreen.class, config.smokerInventoryX, config.smokerInventoryY, config.smokerRecipeBookX, config.smokerRecipeBookY);
        addTickingButtonAdjustment(BlastFurnaceScreen.class, config.blastFurnaceInventoryX, config.blastFurnaceInventoryY, config.blastFurnaceRecipeBookX, config.blastFurnaceRecipeBookY);
        addTickingButtonAdjustment(InventoryScreen.class, config.playerInventoryX, config.playerInventoryY, config.playerRecipeBookX, config.playerRecipeBookY);
    }
    
    
    @Unique
    public void closeButtonWidget(int x, int y) {
        if (client != null && client.currentScreen != null) {
            closeButton.setPosition(this.width / 2 + x, this.height / 2 - y);
            if (config.tooltip) closeButton.setTooltip(Tooltip.of(Text.translatable("close-btn.button.tooltip")));
            addDrawableChild(closeButton);
        }
    }
    
    @Unique
    public void addButtonEntry(Class<? extends Screen> screen, boolean configToggle, int x, int y) {
        if (config.modEnabled) {
            if (client != null && client.currentScreen != null && client.currentScreen.getClass() == screen && configToggle) {
                closeButtonWidget(x, y);
            }
        }
    }
    @Unique
    public void addButtonWithBookEntry(Class<? extends Screen> screen, boolean configToggle, int x, int y, int bookOpenX, int bookOpenY) {
        if (config.modEnabled) {
            if (client != null && client.currentScreen != null && client.currentScreen.getClass() == screen && configToggle) {
                if (client.currentScreen instanceof RecipeBookProvider screenWithBook && screenWithBook.getRecipeBookWidget().isOpen()) {
                    closeButtonWidget(bookOpenX, bookOpenY);
                } else closeButtonWidget(x, y);
            }
        }
    }
    @Unique 
    public void addTickingButtonAdjustment(Class<? extends Screen> screen, int closedX, int closedY, int openX, int openY) {
        if (config.modEnabled) {
            if (client != null && client.currentScreen != null && client.currentScreen.getClass() == screen && client.currentScreen instanceof RecipeBookProvider screenWithBook) {
                if (screenWithBook.getRecipeBookWidget().isOpen()) {
                    closeButton.setPosition(this.width / 2 + openX, this.height / 2 - openY);
                } else {
                    closeButton.setPosition(this.width / 2 + closedX, this.height / 2 - closedY);
                }
            }
        }
    }
}
