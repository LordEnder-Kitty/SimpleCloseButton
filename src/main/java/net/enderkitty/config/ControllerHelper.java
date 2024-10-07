package net.enderkitty.config;

import dev.isxander.yacl3.api.Controller;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import dev.isxander.yacl3.api.controller.ControllerBuilder;
import net.minecraft.text.Text;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class ControllerHelper<T> implements Controller<T> {
    private final Option<T> option;
    
    public ControllerHelper(Option<T> option) {
        this.option = option;
    }
    
    @Override
    public Option<T> option() {
        return option;
    }
    @Override
    public Text formatValue() {
        return Text.empty();
    }


    public static <T> Option<T> createOption(String name, Function<Option<T>, ControllerBuilder<T>> controllerBuilder, Supplier<T> get, Consumer<T> set, Text desc) {
        return Option.<T>createBuilder()
                .name(Text.literal(name))
                .binding(get.get(), get, set)
                .description(OptionDescription.of(desc))
                .instant(true)
                .controller(controllerBuilder)
                .build();
    }
}
