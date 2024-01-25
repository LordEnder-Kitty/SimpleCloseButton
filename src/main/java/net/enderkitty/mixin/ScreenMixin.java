package net.enderkitty.mixin;

import net.enderkitty.SimpleCloseButton;
import net.enderkitty.config.SimpleCloseButtonConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.AbstractParentElement;
import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ingame.*;
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
    @Unique private static final Identifier TEXTURE = new Identifier(SimpleCloseButton.MOD_ID, "textures/gui/close_button.png");

    @Shadow public abstract void close();
    @Shadow protected abstract <T extends Element & Drawable> T addDrawableChild(T drawableElement);
    @Shadow public int width;
    @Shadow public int height;
    @Shadow @Nullable protected MinecraftClient client;

    @Unique SimpleCloseButtonConfig config = SimpleCloseButtonConfig.INSTANCE.getConfig();

    @Unique ButtonWidget closeButton = new TexturedButtonWidget(
            this.width / 2 + 73, this.height / 2 + 80, 12, 12, 0, 0, 13, TEXTURE, button -> this.close());



    @Inject(method = "init(Lnet/minecraft/client/MinecraftClient;II)V", at = @At("TAIL"))
    public final void initCloseButtons(MinecraftClient client, int width, int height, CallbackInfo ci) {
        if (config.modEnabled) {

            if (client.currentScreen instanceof Generic3x3ContainerScreen && config.generic3x3Inventory) {
                closeButtonWidget(config.generic3x3InventoryX, config.generic3x3InventoryY);
            } else if (client.currentScreen instanceof HopperScreen && config.hopperInventory) {
                closeButtonWidget(config.hopperInventoryX, config.hopperInventoryY);
            } else if (client.currentScreen instanceof AnvilScreen && config.anvilInventory) {
                closeButtonWidget(config.anvilInventoryX, config.anvilInventoryY);
            } else if (client.currentScreen instanceof GenericContainerScreen) {
                if (MinecraftClient.getInstance().player != null) {
                    GenericContainerScreenHandler handler = (GenericContainerScreenHandler) MinecraftClient.getInstance().player.currentScreenHandler;
                    if (handler.getRows() == 3 && config.singleChestInventory) {
                        closeButtonWidget(config.singleChestInventoryX, config.singleChestInventoryY);
                    } else if (handler.getRows() == 6 && config.doubleChestInventory) {
                        closeButtonWidget(config.doubleChestInventoryX, config.doubleChestInventoryY);
                    }
                }
            } else if (client.currentScreen instanceof CraftingScreen && config.craftingTableInventory) {
                if (((CraftingScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                    closeButtonWidget(config.craftingTableRecipeBookX, config.craftingTableRecipeBookY);
                } else { closeButtonWidget(config.craftingTableInventoryX, config.craftingTableInventoryY); }
            } else if (client.currentScreen instanceof FurnaceScreen && config.furnaceInventory) {
                if (((FurnaceScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                    closeButtonWidget(config.furnaceRecipeBookX, config.furnaceRecipeBookY);
                } else { closeButtonWidget(config.furnaceInventoryX, config.furnaceInventoryY); }
            } else if (client.currentScreen instanceof SmokerScreen && config.smokerInventory) {
                if (((SmokerScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                    closeButtonWidget(config.smokerRecipeBookX, config.smokerRecipeBookY);
                } else { closeButtonWidget(config.smokerInventoryX, config.smokerInventoryY); }
            } else if (client.currentScreen instanceof BlastFurnaceScreen && config.blastFurnaceInventory) {
                if (((BlastFurnaceScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                    closeButtonWidget(config.blastFurnaceRecipeBookX, config.blastFurnaceRecipeBookY);
                } else { closeButtonWidget(config.blastFurnaceInventoryX, config.blastFurnaceInventoryY); }
            } else if (client.currentScreen instanceof InventoryScreen && config.playerInventory) {
                if (((InventoryScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                    closeButtonWidget(config.playerRecipeBookX, config.playerRecipeBookY);
                } else { closeButtonWidget(config.playerInventoryX, config.playerInventoryY); }
            } else if (client.currentScreen instanceof CreativeInventoryScreen && config.creativeInventory) {
                closeButtonWidget(config.creativeInventoryX, config.creativeInventoryY);
            } else if (client.currentScreen instanceof ShulkerBoxScreen && config.shulkerInventory) {
                closeButtonWidget(config.shulkerInventoryX, config.shulkerInventoryY);
            } else if (client.currentScreen instanceof StonecutterScreen && config.stonecutterInventory) {
                closeButtonWidget(config.stonecutterInventoryX, config.stonecutterInventoryY);
            } else if (client.currentScreen instanceof CartographyTableScreen && config.cartographyInventory) {
                closeButtonWidget(config.cartographyInventoryX, config.cartographyInventoryY);
            } else if (client.currentScreen instanceof SmithingScreen && config.smithingInventory) {
                closeButtonWidget(config.smithingInventoryX, config.smithingInventoryY);
            } else if (client.currentScreen instanceof GrindstoneScreen && config.grindstoneInventory) {
                closeButtonWidget(config.grindstoneInventoryX, config.grindstoneInventoryY);
            } else if (client.currentScreen instanceof LoomScreen && config.loomInventory) {
                closeButtonWidget(config.loomInventoryX, config.loomInventoryY);
            } else if (client.currentScreen instanceof EnchantmentScreen && config.enchantingInventory) {
                closeButtonWidget(config.enchantingInventoryX, config.enchantingInventoryY);
            } else if (client.currentScreen instanceof BrewingStandScreen && config.brewingInventory) {
                closeButtonWidget(config.brewingInventoryX, config.brewingInventoryY);
            } else if (client.currentScreen instanceof HorseScreen && config.horseInventory) {
                closeButtonWidget(config.horseInventoryX, config.horseInventoryY);
            } else if (client.currentScreen instanceof MerchantScreen && config.villagerInventory) {
                closeButtonWidget(config.villagerInventoryX, config.villagerInventoryY);
            } else if (client.currentScreen instanceof BeaconScreen && config.beaconInventory) {
                closeButtonWidget(config.beaconInventoryX, config.beaconInventoryY);
            }
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        if (config.modEnabled) {

            if (client.currentScreen instanceof CraftingScreen && ((CraftingScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.craftingTableRecipeBookX, this.height / 2 - config.craftingTableRecipeBookY);
            } else if (client.currentScreen instanceof FurnaceScreen && ((FurnaceScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.furnaceRecipeBookX, this.height / 2 - config.furnaceRecipeBookY);
            } else if (client.currentScreen instanceof SmokerScreen && ((SmokerScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.smokerRecipeBookX, this.height / 2 - config.smokerRecipeBookY);
            } else if (client.currentScreen instanceof BlastFurnaceScreen && ((BlastFurnaceScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.blastFurnaceRecipeBookX, this.height / 2 - config.blastFurnaceRecipeBookY);
            } else if (client.currentScreen instanceof InventoryScreen && ((InventoryScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.playerRecipeBookX, this.height / 2 - config.playerRecipeBookY);
            } else if (client.currentScreen instanceof CraftingScreen && !((CraftingScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.craftingTableInventoryX, this.height / 2 - config.craftingTableInventoryY);
            } else if (client.currentScreen instanceof FurnaceScreen && !((FurnaceScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.furnaceInventoryX, this.height / 2 - config.furnaceInventoryY);
            } else if (client.currentScreen instanceof SmokerScreen && !((SmokerScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.smokerInventoryX, this.height / 2 - config.smokerInventoryY);
            } else if (client.currentScreen instanceof BlastFurnaceScreen && !((BlastFurnaceScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.blastFurnaceInventoryX, this.height / 2 - config.blastFurnaceInventoryY);
            } else if (client.currentScreen instanceof InventoryScreen && !((InventoryScreen) client.currentScreen).getRecipeBookWidget().isOpen()) {
                closeButton.setPosition(this.width / 2 + config.playerInventoryX, this.height / 2 - config.playerInventoryY);
            }
        }
    }


    @Unique
    public void closeButtonWidget(int x, int y) {
        closeButton.setPosition(this.width / 2 + x, this.height / 2 - y);
        if (config.tooltip) {
            closeButton.setTooltip(Tooltip.of(Text.translatable("close-btn.button.tooltip")));
        }
        addDrawableChild(closeButton);
    }
}
