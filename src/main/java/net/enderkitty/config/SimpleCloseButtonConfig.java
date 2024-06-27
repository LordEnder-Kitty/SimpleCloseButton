package net.enderkitty.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.enderkitty.SimpleCloseButton;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SimpleCloseButtonConfig {
    public static final ConfigClassHandler<SimpleCloseButtonConfig> HANDLER = ConfigClassHandler.createBuilder(SimpleCloseButtonConfig.class)
            .id(Identifier.of(SimpleCloseButton.MOD_ID, "simple_close_button_config"))
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(FabricLoader.getInstance().getConfigDir().resolve("simple_close_button.json"))
                    .setJson5(false)
                    .build())
            .build();
    
    
    @SerialEntry public boolean modEnabled = true;
    @SerialEntry public boolean tooltip = true;

    @SerialEntry public boolean creativeInventory = true;
    @SerialEntry public int creativeInventoryX = 97;
    @SerialEntry public int creativeInventoryY = 63;

    @SerialEntry public boolean playerInventory = true;
    @SerialEntry public int playerInventoryX = 73;
    @SerialEntry public int playerInventoryY = 80;
    @SerialEntry public int playerRecipeBookX = 150;
    @SerialEntry public int playerRecipeBookY = 80;

    @SerialEntry public boolean chestInventory = true;
    @SerialEntry public int chestInventoryX = 73;
    @SerialEntry public int chestInventoryY1 = 63;
    @SerialEntry public int chestInventoryY2 = 72;
    @SerialEntry public int chestInventoryY3 = 81;
    @SerialEntry public int chestInventoryY4 = 90;
    @SerialEntry public int chestInventoryY5 = 99;
    @SerialEntry public int chestInventoryY6 = 108;

    @SerialEntry public boolean craftingTableInventory = true;
    @SerialEntry public int craftingTableInventoryX = 73;
    @SerialEntry public int craftingTableInventoryY = 80;
    @SerialEntry public int craftingTableRecipeBookX = 150;
    @SerialEntry public int craftingTableRecipeBookY = 80;
    
    @SerialEntry public boolean crafterInventory = true;
    @SerialEntry public int crafterInventoryX = 73;
    @SerialEntry public int crafterInventoryY = 80;

    @SerialEntry public boolean shulkerInventory = true;
    @SerialEntry public int shulkerInventoryX = 73;
    @SerialEntry public int shulkerInventoryY = 81;

    @SerialEntry public boolean furnaceInventory = true;
    @SerialEntry public int furnaceInventoryX = 73;
    @SerialEntry public int furnaceInventoryY = 80;
    @SerialEntry public int furnaceRecipeBookX = 150;
    @SerialEntry public int furnaceRecipeBookY = 80;

    @SerialEntry public boolean smokerInventory = true;
    @SerialEntry public int smokerInventoryX = 73;
    @SerialEntry public int smokerInventoryY = 80;
    @SerialEntry public int smokerRecipeBookX = 150;
    @SerialEntry public int smokerRecipeBookY = 80;

    @SerialEntry public boolean blastFurnaceInventory = true;
    @SerialEntry public int blastFurnaceInventoryX = 73;
    @SerialEntry public int blastFurnaceInventoryY = 80;
    @SerialEntry public int blastFurnaceRecipeBookX = 150;
    @SerialEntry public int blastFurnaceRecipeBookY = 80;

    @SerialEntry public boolean anvilInventory = true;
    @SerialEntry public int anvilInventoryX = 73;
    @SerialEntry public int anvilInventoryY = 80;

    @SerialEntry public boolean generic3x3Inventory = true;
    @SerialEntry public int generic3x3InventoryX = 73;
    @SerialEntry public int generic3x3InventoryY = 80;

    @SerialEntry public boolean hopperInventory = true;
    @SerialEntry public int hopperInventoryX = 73;
    @SerialEntry public int hopperInventoryY = 64;

    @SerialEntry public boolean villagerInventory = true;
    @SerialEntry public int villagerInventoryX = 123;
    @SerialEntry public int villagerInventoryY = 80;

    @SerialEntry public boolean horseInventory = true;
    @SerialEntry public int horseInventoryX = 73;
    @SerialEntry public int horseInventoryY = 80;

    @SerialEntry public boolean enchantingInventory = true;
    @SerialEntry public int enchantingInventoryX = 88;
    @SerialEntry public int enchantingInventoryY = 78;

    @SerialEntry public boolean stonecutterInventory = true;
    @SerialEntry public int stonecutterInventoryX = 73;
    @SerialEntry public int stonecutterInventoryY = 80;

    @SerialEntry public boolean cartographyInventory = true;
    @SerialEntry public int cartographyInventoryX = 73;
    @SerialEntry public int cartographyInventoryY = 80;

    @SerialEntry public boolean smithingInventory = true;
    @SerialEntry public int smithingInventoryX = 73;
    @SerialEntry public int smithingInventoryY = 80;

    @SerialEntry public boolean grindstoneInventory = true;
    @SerialEntry public int grindstoneInventoryX = 73;
    @SerialEntry public int grindstoneInventoryY = 80;

    @SerialEntry public boolean loomInventory = true;
    @SerialEntry public int loomInventoryX = 73;
    @SerialEntry public int loomInventoryY = 80;

    @SerialEntry public boolean brewingInventory = true;
    @SerialEntry public int brewingInventoryX = 73;
    @SerialEntry public int brewingInventoryY = 80;

    @SerialEntry public boolean beaconInventory = false;
    @SerialEntry public int beaconInventoryX = 115;
    @SerialEntry public int beaconInventoryY = 105;


    public static Screen makeScreen(Screen parent) {
        return YetAnotherConfigLib.create(HANDLER, (defaults, config, builder) -> builder
                        .title(Text.translatable("config.title"))
                        .category(ConfigCategory.createBuilder()
                                .name(Text.translatable("config.title"))

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("config.option.modEnabled.name"))
                                        .description(OptionDescription.of(Text.translatable("config.option.modEnabled.desc")))
                                        .binding(defaults.modEnabled, () -> config.modEnabled, value -> config.modEnabled = value)
                                        .controller(TickBoxControllerBuilder::create).build())

                                .option(Option.<Boolean>createBuilder()
                                        .name(Text.translatable("config.option.tooltip.name"))
                                        .description(OptionDescription.of(Text.translatable("config.option.tooltip.desc")))
                                        .binding(defaults.tooltip, () -> config.tooltip, value -> config.tooltip = value)
                                        .controller(TickBoxControllerBuilder::create).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.creativeInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.creativeInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.creativeInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.creativeInventory.option.toggle.desc")))
                                                .binding(defaults.creativeInventory, () -> config.creativeInventory, value -> config.creativeInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.creativeInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.creativeInventory.option.posX.desc")))
                                                .binding(defaults.creativeInventoryX, () -> config.creativeInventoryX, value -> config.creativeInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.creativeInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.creativeInventory.option.posY.desc")))
                                                .binding(defaults.creativeInventoryY, () -> config.creativeInventoryY, value -> config.creativeInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.survivalInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.survivalInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.survivalInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.survivalInventory.option.toggle.desc")))
                                                .binding(defaults.playerInventory, () -> config.playerInventory, value -> config.playerInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.survivalInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.survivalInventory.option.posX.desc")))
                                                .binding(defaults.playerInventoryX, () -> config.playerInventoryX, value -> config.playerInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.survivalInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.survivalInventory.option.posY.desc")))
                                                .binding(defaults.playerInventoryY, () -> config.playerInventoryY, value -> config.playerInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.survivalInventory.option.bookPosX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.survivalInventory.option.bookPosX.desc")))
                                                .binding(defaults.playerRecipeBookX, () -> config.playerRecipeBookX, value -> config.playerRecipeBookX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.survivalInventory.option.bookPosY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.survivalInventory.option.bookPosY.desc")))
                                                .binding(defaults.playerRecipeBookY, () -> config.playerRecipeBookY, value -> config.playerRecipeBookY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.chestInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.chestInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.toggle.desc")))
                                                .binding(defaults.chestInventory, () -> config.chestInventory, value -> config.chestInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.posX.desc")))
                                                .binding(defaults.chestInventoryX, () -> config.chestInventoryX, value -> config.chestInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.posY1.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.posY1.desc")))
                                                .binding(defaults.chestInventoryY1, () -> config.chestInventoryY1, value -> config.chestInventoryY1 = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.posY2.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.posY2.desc")))
                                                .binding(defaults.chestInventoryY2, () -> config.chestInventoryY2, value -> config.chestInventoryY2 = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.posY3.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.posY3.desc")))
                                                .binding(defaults.chestInventoryY3, () -> config.chestInventoryY3, value -> config.chestInventoryY3 = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.posY4.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.posY4.desc")))
                                                .binding(defaults.chestInventoryY4, () -> config.chestInventoryY4, value -> config.chestInventoryY4 = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.posY5.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.posY5.desc")))
                                                .binding(defaults.chestInventoryY5, () -> config.chestInventoryY5, value -> config.chestInventoryY5 = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.chestInventory.option.posY6.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.chestInventory.option.posY6.desc")))
                                                .binding(defaults.chestInventoryY6, () -> config.chestInventoryY6, value -> config.chestInventoryY6 = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())
                                
                                
                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.craftingInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.craftingInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.craftingInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.craftingInventory.option.toggle.desc")))
                                                .binding(defaults.craftingTableInventory, () -> config.craftingTableInventory, value -> config.craftingTableInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.craftingInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.craftingInventory.option.posX.desc")))
                                                .binding(defaults.craftingTableInventoryX, () -> config.craftingTableInventoryX, value -> config.craftingTableInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.craftingInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.craftingInventory.option.posY.desc")))
                                                .binding(defaults.craftingTableInventoryY, () -> config.craftingTableInventoryY, value -> config.craftingTableInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.craftingInventory.option.bookPosX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.craftingInventory.option.bookPosX.desc")))
                                                .binding(defaults.craftingTableRecipeBookX, () -> config.craftingTableRecipeBookX, value -> config.craftingTableRecipeBookX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.craftingInventory.option.bookPosY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.craftingInventory.option.bookPosX.desc")))
                                                .binding(defaults.craftingTableRecipeBookY, () -> config.craftingTableRecipeBookY, value -> config.craftingTableRecipeBookY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())
                                
                                
                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.crafterInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.crafterInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.crafterInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.crafterInventory.option.toggle.desc")))
                                                .binding(defaults.crafterInventory, () -> config.crafterInventory, value -> config.crafterInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.crafterInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.crafterInventory.option.posX.desc")))
                                                .binding(defaults.crafterInventoryX, () -> config.crafterInventoryX, value -> config.crafterInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.crafterInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.crafterInventory.option.posY.desc")))
                                                .binding(defaults.crafterInventoryY, () -> config.crafterInventoryY, value -> config.crafterInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.shulkerInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.shulkerInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.shulkerInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.shulkerInventory.option.toggle.desc")))
                                                .binding(defaults.shulkerInventory, () -> config.shulkerInventory, value -> config.shulkerInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.shulkerInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.shulkerInventory.option.posX.desc")))
                                                .binding(defaults.shulkerInventoryX, () -> config.shulkerInventoryX, value -> config.shulkerInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.shulkerInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.shulkerInventory.option.posY.desc")))
                                                .binding(defaults.shulkerInventoryY, () -> config.shulkerInventoryY, value -> config.shulkerInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.furnaceInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.furnaceInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.furnaceInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.furnaceInventory.option.toggle.desc")))
                                                .binding(defaults.furnaceInventory, () -> config.furnaceInventory, value -> config.furnaceInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.furnaceInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.furnaceInventory.option.posX.desc")))
                                                .binding(defaults.furnaceInventoryX, () -> config.furnaceInventoryX, value -> config.furnaceInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.furnaceInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.furnaceInventory.option.posY.desc")))
                                                .binding(defaults.furnaceInventoryY, () -> config.furnaceInventoryY, value -> config.furnaceInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.furnaceInventory.option.bookPosX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.furnaceInventory.option.bookPosX.desc")))
                                                .binding(defaults.furnaceRecipeBookX, () -> config.furnaceRecipeBookX, value -> config.furnaceRecipeBookX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.furnaceInventory.option.bookPosY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.furnaceInventory.option.bookPosY.desc")))
                                                .binding(defaults.furnaceRecipeBookY, () -> config.furnaceRecipeBookY, value -> config.furnaceRecipeBookY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.smokerInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.smokerInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.smokerInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smokerInventory.option.toggle.desc")))
                                                .binding(defaults.smokerInventory, () -> config.smokerInventory, value -> config.smokerInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smokerInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smokerInventory.option.posX.desc")))
                                                .binding(defaults.smokerInventoryX, () -> config.smokerInventoryX, value -> config.smokerInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smokerInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smokerInventory.option.posY.desc")))
                                                .binding(defaults.smokerInventoryY, () -> config.smokerInventoryY, value -> config.smokerInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smokerInventory.option.bookPosX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smokerInventory.option.bookPosX.desc")))
                                                .binding(defaults.smokerRecipeBookX, () -> config.smokerRecipeBookX, value -> config.smokerRecipeBookX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smokerInventory.option.bookPosY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smokerInventory.option.bookPosY.desc")))
                                                .binding(defaults.smokerRecipeBookY, () -> config.smokerRecipeBookY, value -> config.smokerRecipeBookY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.blastFurnaceInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.blastFurnaceInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.blastFurnaceInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.blastFurnaceInventory.option.toggle.desc")))
                                                .binding(defaults.blastFurnaceInventory, () -> config.blastFurnaceInventory, value -> config.blastFurnaceInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.blastFurnaceInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.blastFurnaceInventory.option.posX.desc")))
                                                .binding(defaults.blastFurnaceInventoryX, () -> config.blastFurnaceInventoryX, value -> config.blastFurnaceInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.blastFurnaceInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.blastFurnaceInventory.option.posY.desc")))
                                                .binding(defaults.blastFurnaceInventoryY, () -> config.blastFurnaceInventoryY, value -> config.blastFurnaceInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.blastFurnaceInventory.option.bookPosX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.blastFurnaceInventory.option.bookPosX.desc")))
                                                .binding(defaults.blastFurnaceRecipeBookX, () -> config.blastFurnaceRecipeBookX, value -> config.blastFurnaceRecipeBookX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.blastFurnaceInventory.option.bookPosY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.blastFurnaceInventory.option.bookPosY.desc")))
                                                .binding(defaults.blastFurnaceRecipeBookY, () -> config.blastFurnaceRecipeBookY, value -> config.blastFurnaceRecipeBookY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.anvilInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.anvilInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.anvilInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.anvilInventory.option.toggle.desc")))
                                                .binding(defaults.anvilInventory, () -> config.anvilInventory, value -> config.anvilInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.anvilInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.anvilInventory.option.posX.desc")))
                                                .binding(defaults.anvilInventoryX, () -> config.anvilInventoryX, value -> config.anvilInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.anvilInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.anvilInventory.option.posY.desc")))
                                                .binding(defaults.anvilInventoryY, () -> config.anvilInventoryY, value -> config.anvilInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.literal("3x3 Inventory")).collapsed(true)
                                        .description(OptionDescription.of(Text.literal("3x3 inventories are ones such as droppers and dispensers. I don't know how to separate them so you'll have to deal with them sharing settings.")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.3x3Inventory.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.3x3Inventory.desc")))
                                                .binding(defaults.generic3x3Inventory, () -> config.generic3x3Inventory, value -> config.generic3x3Inventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.3x3Inventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.3x3Inventory.option.posX.desc")))
                                                .binding(defaults.generic3x3InventoryX, () -> config.generic3x3InventoryX, value -> config.generic3x3InventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.3x3Inventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.3x3Inventory.option.posY.desc")))
                                                .binding(defaults.generic3x3InventoryY, () -> config.generic3x3InventoryY, value -> config.generic3x3InventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.hopperInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.hopperInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.hopperInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.hopperInventory.option.toggle.desc")))
                                                .binding(defaults.hopperInventory, () -> config.hopperInventory, value -> config.hopperInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.hopperInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.hopperInventory.option.posX.desc")))
                                                .binding(defaults.hopperInventoryX, () -> config.hopperInventoryX, value -> config.hopperInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.hopperInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.hopperInventory.option.posY.desc")))
                                                .binding(defaults.hopperInventoryY, () -> config.hopperInventoryY, value -> config.hopperInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.villagerInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.villagerInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.villagerInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.villagerInventory.option.toggle.desc")))
                                                .binding(defaults.villagerInventory, () -> config.villagerInventory, value -> config.villagerInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.villagerInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.villagerInventory.option.posX.desc")))
                                                .binding(defaults.villagerInventoryX, () -> config.villagerInventoryX, value -> config.villagerInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.villagerInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.villagerInventory.option.posY.desc")))
                                                .binding(defaults.villagerInventoryY, () -> config.villagerInventoryY, value -> config.villagerInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.mountInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.mountInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.mountInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.mountInventory.option.toggle.desc")))
                                                .binding(defaults.brewingInventory, () -> config.brewingInventory, value -> config.brewingInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.mountInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.mountInventory.option.posX.desc")))
                                                .binding(defaults.brewingInventoryX, () -> config.brewingInventoryX, value -> config.brewingInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.mountInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.mountInventory.option.posY.desc")))
                                                .binding(defaults.brewingInventoryY, () -> config.brewingInventoryY, value -> config.brewingInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.enchantInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.enchantInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.enchantInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.enchantInventory.option.toggle.desc")))
                                                .binding(defaults.enchantingInventory, () -> config.enchantingInventory, value -> config.enchantingInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.enchantInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.enchantInventory.option.posX.desc")))
                                                .binding(defaults.enchantingInventoryX, () -> config.enchantingInventoryX, value -> config.enchantingInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.enchantInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.enchantInventory.option.posY.desc")))
                                                .binding(defaults.enchantingInventoryY, () -> config.enchantingInventoryY, value -> config.enchantingInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.stonecutterInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.stonecutterInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.stonecutterInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.stonecutterInventory.option.toggle.desc")))
                                                .binding(defaults.stonecutterInventory, () -> config.stonecutterInventory, value -> config.stonecutterInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.stonecutterInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.stonecutterInventory.option.posX.desc")))
                                                .binding(defaults.stonecutterInventoryX, () -> config.stonecutterInventoryX, value -> config.stonecutterInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.stonecutterInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.stonecutterInventory.option.posY.desc")))
                                                .binding(defaults.stonecutterInventoryY, () -> config.stonecutterInventoryY, value -> config.stonecutterInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.cartographyInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.cartographyInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.cartographyInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.cartographyInventory.option.toggle.desc")))
                                                .binding(defaults.cartographyInventory, () -> config.cartographyInventory, value -> config.cartographyInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.cartographyInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.cartographyInventory.option.posX.desc")))
                                                .binding(defaults.cartographyInventoryX, () -> config.cartographyInventoryX, value -> config.cartographyInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.cartographyInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.cartographyInventory.option.posY.desc")))
                                                .binding(defaults.cartographyInventoryY, () -> config.cartographyInventoryY, value -> config.cartographyInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.smithingInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.smithingInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.smithingInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smithingInventory.option.toggle.desc")))
                                                .binding(defaults.smithingInventory, () -> config.smithingInventory, value -> config.smithingInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smithingInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smithingInventory.option.posX.desc")))
                                                .binding(defaults.smithingInventoryX, () -> config.smithingInventoryX, value -> config.smithingInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smithingInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smithingInventory.option.posY.desc")))
                                                .binding(defaults.smithingInventoryY, () -> config.smithingInventoryY, value -> config.smithingInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.grindstoneInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.grindstoneInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.grindstoneInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.grindstoneInventory.option.toggle.desc")))
                                                .binding(defaults.grindstoneInventory, () -> config.grindstoneInventory, value -> config.grindstoneInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.grindstoneInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.grindstoneInventory.option.posX.desc")))
                                                .binding(defaults.grindstoneInventoryX, () -> config.grindstoneInventoryX, value -> config.grindstoneInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.grindstoneInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.grindstoneInventory.option.posY.desc")))
                                                .binding(defaults.grindstoneInventoryY, () -> config.grindstoneInventoryY, value -> config.grindstoneInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.loomInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.loomInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.loomInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.loomInventory.option.toggle.desc")))
                                                .binding(defaults.loomInventory, () -> config.loomInventory, value -> config.loomInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.loomInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.loomInventory.option.posX.desc")))
                                                .binding(defaults.loomInventoryX, () -> config.loomInventoryX, value -> config.loomInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.loomInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.loomInventory.option.posY.desc")))
                                                .binding(defaults.loomInventoryY, () -> config.loomInventoryY, value -> config.loomInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.brewingInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.brewingInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.brewingInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.brewingInventory.option.toggle.desc")))
                                                .binding(defaults.brewingInventory, () -> config.brewingInventory, value -> config.brewingInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.brewingInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.brewingInventory.option.posX.desc")))
                                                .binding(defaults.brewingInventoryX, () -> config.brewingInventoryX, value -> config.brewingInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.brewingInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.brewingInventory.option.posY.desc")))
                                                .binding(defaults.brewingInventoryY, () -> config.brewingInventoryY, value -> config.brewingInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.beaconInventory.name")).collapsed(true)
                                        .description(OptionDescription.of(Text.translatable("config.group.beaconInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.beaconInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.beaconInventory.option.toggle.desc")))
                                                .binding(defaults.beaconInventory, () -> config.beaconInventory, value -> config.beaconInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.beaconInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.beaconInventory.option.posX.desc")))
                                                .binding(defaults.beaconInventoryX, () -> config.beaconInventoryX, value -> config.beaconInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.beaconInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.beaconInventory.option.posY.desc")))
                                                .binding(defaults.beaconInventoryY, () -> config.beaconInventoryY, value -> config.beaconInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())

                                .build())).generateScreen(parent);
    }
}
