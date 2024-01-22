package net.enderkitty.config;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.IntegerSliderControllerBuilder;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import dev.isxander.yacl3.config.ConfigEntry;
import dev.isxander.yacl3.config.ConfigInstance;
import dev.isxander.yacl3.config.GsonConfigInstance;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class SimpleCloseButtonConfig {
    public static final ConfigInstance<SimpleCloseButtonConfig> INSTANCE = GsonConfigInstance.createBuilder(SimpleCloseButtonConfig.class)
            .setPath(FabricLoader.getInstance().getConfigDir().resolve("simple_close_button.json")).build();

    @ConfigEntry public boolean modEnabled = true;
    @ConfigEntry public boolean tooltip = true;

    @ConfigEntry public boolean creativeInventory = true;
    @ConfigEntry public int creativeInventoryX = 97;
    @ConfigEntry public int creativeInventoryY = 63;

    @ConfigEntry public boolean playerInventory = true;
    @ConfigEntry public int playerInventoryX = 73;
    @ConfigEntry public int playerInventoryY = 80;
    @ConfigEntry public int playerRecipeBookX = 150;
    @ConfigEntry public int playerRecipeBookY = 80;

    @ConfigEntry public boolean singleChestInventory = true;
    @ConfigEntry public int singleChestInventoryX = 73;
    @ConfigEntry public int singleChestInventoryY = 81;

    @ConfigEntry public boolean doubleChestInventory = true;
    @ConfigEntry public int doubleChestInventoryX = 73;
    @ConfigEntry public int doubleChestInventoryY = 108;

    @ConfigEntry public boolean craftingTableInventory = true;
    @ConfigEntry public int craftingTableInventoryX = 73;
    @ConfigEntry public int craftingTableInventoryY = 80;
    @ConfigEntry public int craftingTableRecipeBookX = 150;
    @ConfigEntry public int craftingTableRecipeBookY = 80;

    @ConfigEntry public boolean shulkerInventory = true;
    @ConfigEntry public int shulkerInventoryX = 73;
    @ConfigEntry public int shulkerInventoryY = 81;

    @ConfigEntry public boolean furnaceInventory = true;
    @ConfigEntry public int furnaceInventoryX = 73;
    @ConfigEntry public int furnaceInventoryY = 80;
    @ConfigEntry public int furnaceRecipeBookX = 150;
    @ConfigEntry public int furnaceRecipeBookY = 80;

    @ConfigEntry public boolean smokerInventory = true;
    @ConfigEntry public int smokerInventoryX = 73;
    @ConfigEntry public int smokerInventoryY = 80;
    @ConfigEntry public int smokerRecipeBookX = 150;
    @ConfigEntry public int smokerRecipeBookY = 80;

    @ConfigEntry public boolean blastFurnaceInventory = true;
    @ConfigEntry public int blastFurnaceInventoryX = 73;
    @ConfigEntry public int blastFurnaceInventoryY = 80;
    @ConfigEntry public int blastFurnaceRecipeBookX = 150;
    @ConfigEntry public int blastFurnaceRecipeBookY = 80;

    @ConfigEntry public boolean anvilInventory = true;
    @ConfigEntry public int anvilInventoryX = 73;
    @ConfigEntry public int anvilInventoryY = 80;

    @ConfigEntry public boolean generic3x3Inventory = true;
    @ConfigEntry public int generic3x3InventoryX = 73;
    @ConfigEntry public int generic3x3InventoryY = 80;

    @ConfigEntry public boolean hopperInventory = true;
    @ConfigEntry public int hopperInventoryX = 73;
    @ConfigEntry public int hopperInventoryY = 64;

    @ConfigEntry public boolean villagerInventory = true;
    @ConfigEntry public int villagerInventoryX = 123;
    @ConfigEntry public int villagerInventoryY = 80;

    @ConfigEntry public boolean horseInventory = true;
    @ConfigEntry public int horseInventoryX = 73;
    @ConfigEntry public int horseInventoryY = 80;

    @ConfigEntry public boolean enchantingInventory = true;
    @ConfigEntry public int enchantingInventoryX = 88;
    @ConfigEntry public int enchantingInventoryY = 78;

    @ConfigEntry public boolean stonecutterInventory = true;
    @ConfigEntry public int stonecutterInventoryX = 73;
    @ConfigEntry public int stonecutterInventoryY = 80;

    @ConfigEntry public boolean cartographyInventory = true;
    @ConfigEntry public int cartographyInventoryX = 73;
    @ConfigEntry public int cartographyInventoryY = 80;

    @ConfigEntry public boolean smithingInventory = true;
    @ConfigEntry public int smithingInventoryX = 73;
    @ConfigEntry public int smithingInventoryY = 80;

    @ConfigEntry public boolean grindstoneInventory = true;
    @ConfigEntry public int grindstoneInventoryX = 73;
    @ConfigEntry public int grindstoneInventoryY = 80;

    @ConfigEntry public boolean loomInventory = true;
    @ConfigEntry public int loomInventoryX = 73;
    @ConfigEntry public int loomInventoryY = 80;

    @ConfigEntry public boolean brewingInventory = true;
    @ConfigEntry public int brewingInventoryX = 73;
    @ConfigEntry public int brewingInventoryY = 80;

    @ConfigEntry public boolean beaconInventory = false;
    @ConfigEntry public int beaconInventoryX = 115;
    @ConfigEntry public int beaconInventoryY = 105;


    public static Screen makeScreen(Screen parent) {
        return YetAnotherConfigLib.create(INSTANCE, (defaults, config, builder) -> builder
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.creativeInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.survivalInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.smallChestInventory.name"))
                                        .description(OptionDescription.of(Text.translatable("config.group.smallChestInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.smallChestInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smallChestInventory.option.toggle.desc")))
                                                .binding(defaults.singleChestInventory, () -> config.singleChestInventory, value -> config.singleChestInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smallChestInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smallChestInventory.option.posX.desc")))
                                                .binding(defaults.singleChestInventoryX, () -> config.singleChestInventoryX, value -> config.singleChestInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.smallChestInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.smallChestInventory.option.posY.desc")))
                                                .binding(defaults.singleChestInventoryY, () -> config.singleChestInventoryY, value -> config.singleChestInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.largeChestInventory.name"))
                                        .description(OptionDescription.of(Text.translatable("config.group.largeChestInventory.desc")))

                                        .option(Option.<Boolean>createBuilder()
                                                .name(Text.translatable("config.group.largeChestInventory.option.toggle.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.largeChestInventory.option.toggle.desc")))
                                                .binding(defaults.doubleChestInventory, () -> config.doubleChestInventory, value -> config.doubleChestInventory = value)
                                                .controller(TickBoxControllerBuilder::create).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.largeChestInventory.option.posX.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.largeChestInventory.option.posX.desc")))
                                                .binding(defaults.doubleChestInventoryX, () -> config.doubleChestInventoryX, value -> config.doubleChestInventoryX = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-480, 468).step(1)).build())
                                        .option(Option.<Integer>createBuilder()
                                                .name(Text.translatable("config.group.largeChestInventory.option.posY.name"))
                                                .description(OptionDescription.of(Text.translatable("config.group.largeChestInventory.option.posY.desc")))
                                                .binding(defaults.doubleChestInventoryY, () -> config.doubleChestInventoryY, value -> config.doubleChestInventoryY = value)
                                                .controller(opt -> IntegerSliderControllerBuilder.create(opt).range(-258, 270).step(1)).build()).build())


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.craftingInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.shulkerInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.furnaceInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.smokerInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.blastFurnaceInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.anvilInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.literal("3x3 Inventory"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.hopperInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.villagerInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.mountInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.enchantInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.stonecutterInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.cartographyInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.smithingInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.grindstoneInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.loomInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.brewingInventory.name"))
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


                                .group(OptionGroup.createBuilder().name(Text.translatable("config.group.beaconInventory.name"))
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
