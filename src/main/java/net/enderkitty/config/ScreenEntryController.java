package net.enderkitty.config;

import dev.isxander.yacl3.api.Controller;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.ControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import dev.isxander.yacl3.api.controller.StringControllerBuilder;
import dev.isxander.yacl3.api.utils.Dimension;
import dev.isxander.yacl3.gui.AbstractWidget;
import dev.isxander.yacl3.gui.LowProfileButtonWidget;
import dev.isxander.yacl3.gui.YACLScreen;
import net.enderkitty.mixin.OptionListAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.Element;
import net.minecraft.text.Text;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ScreenEntryController extends ControllerHelper<ScreenEntry> {
    private final Controller<String> screen;
    private final Controller<Integer> x;
    private final Controller<Integer> y;
    private final Controller<Boolean> recipeBook;
    private final Controller<Integer> bookX;
    private final Controller<Integer> bookY;
    
    private boolean collapsed;
    
    public ScreenEntryController(Option<ScreenEntry> option, 
                                 Function<Option<String>, ControllerBuilder<String>> screen, 
                                 Function<Option<Integer>, ControllerBuilder<Integer>> x, 
                                 Function<Option<Integer>, ControllerBuilder<Integer>> y, 
                                 Function<Option<Boolean>, ControllerBuilder<Boolean>> recipeBook,
                                 Function<Option<Integer>, ControllerBuilder<Integer>> bookX,
                                 Function<Option<Integer>, ControllerBuilder<Integer>> bookY) {
        super(option);
        
        this.collapsed = true;
        
        this.screen = createOption("Screen:", screen,
                () -> option.pendingValue().screen(),
                value -> {
                    ScreenEntry entry = option.pendingValue();
                    option.requestSet(new ScreenEntry(value, entry.x(), entry.y(), entry.recipeBook(), entry.bookX(), entry.bookY()));
                },
                Text.translatable("config.option.list_screens")
        ).controller();
        this.x = createOption("X:", x,
                () -> option.pendingValue().x(),
                value -> {
                    ScreenEntry entry = option.pendingValue();
                    option.requestSet(new ScreenEntry(entry.screen(), value, entry.y(), entry.recipeBook(), entry.bookX(), entry.bookY()));
                },
                Text.translatable("config.option.list_x")
        ).controller();
        this.y = createOption("Y:", y,
                () -> option.pendingValue().y(),
                value -> {
                    ScreenEntry entry = option.pendingValue();
                    option.requestSet(new ScreenEntry(entry.screen(), entry.x(), value, entry.recipeBook(), entry.bookX(), entry.bookY()));
                },
                Text.translatable("config.option.list_y")
        ).controller();
        this.recipeBook = createOption("Has Recipe Book:", recipeBook,
                () -> option.pendingValue().recipeBook(),
                value -> {
                    ScreenEntry entry = option.pendingValue();
                    option.requestSet(new ScreenEntry(entry.screen(), entry.x(), entry.y(), value, entry.bookX(), entry.bookY()));
                },
                Text.translatable("config.option.list_recipeBook")
        ).controller();
        this.bookX = createOption("X with book:", bookX,
                () -> option.pendingValue().bookX(),
                value -> {
                    ScreenEntry entry = option.pendingValue();
                    option.requestSet(new ScreenEntry(entry.screen(), entry.x(), entry.y(), entry.recipeBook(), value, entry.bookY()));
                },
                Text.translatable("config.option.list_bookX")
        ).controller();
        this.bookY = createOption("Y with book:", bookY,
                () -> option.pendingValue().bookY(),
                value -> {
                    ScreenEntry entry = option.pendingValue();
                    option.requestSet(new ScreenEntry(entry.screen(), entry.x(), entry.y(), entry.recipeBook(), entry.bookX(), value));
                },
                Text.translatable("config.option.list_bookY")
        ).controller();
    }
    
    public void setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
    }
    
    @Override
    public AbstractWidget provideWidget(YACLScreen screen, Dimension<Integer> widgetDimension) {
        if (collapsed) {
            widgetDimension = widgetDimension.withHeight(20);
        } else {
            widgetDimension = widgetDimension.withHeight(140);
        }
        
        AbstractWidget screenWidget = this.screen.provideWidget(screen, widgetDimension.moved(0, 20));
        AbstractWidget xWidget = this.x.provideWidget(screen, widgetDimension.moved(0, 40));
        AbstractWidget yWidget = this.y.provideWidget(screen, widgetDimension.moved(0, 60));
        AbstractWidget recipeBookWidget = this.recipeBook.provideWidget(screen, widgetDimension.moved(0, 80));
        AbstractWidget bookXWidget = this.bookX.provideWidget(screen, widgetDimension.moved(0, 100));
        AbstractWidget bookYWidget = this.bookY.provideWidget(screen, widgetDimension.moved(0, 120));
        
        return new ControllerElement(this, screen, widgetDimension, screenWidget, xWidget, yWidget, recipeBookWidget, bookXWidget, bookYWidget);
    }
    
    
    public static class ControllerElement extends ControllerWidgetHelper<ScreenEntryController> {
        private final LowProfileButtonWidget collapseWidget;
        private final AbstractWidget screen;
        private final AbstractWidget x;
        private final AbstractWidget y;
        private final AbstractWidget recipeBook;
        private final AbstractWidget bookX;
        private final AbstractWidget bookY;
        
        public ControllerElement(ScreenEntryController control, YACLScreen yaclScreen, Dimension<Integer> dim, AbstractWidget screen, AbstractWidget x, AbstractWidget y, AbstractWidget recipeBook, AbstractWidget bookX, AbstractWidget bookY) {
            super(control, yaclScreen, dim);
            
            this.screen = screen;
            this.x = x;
            this.y = y;
            this.recipeBook = recipeBook;
            this.bookX = bookX;
            this.bookY = bookY;
            
            this.collapseWidget = new LowProfileButtonWidget(dim.x(), dim.y(), 20, 20, Text.literal(control.collapsed ? "▶" : "▼"),
                    button -> {
                        control.setCollapsed(!control.collapsed);
                        button.setMessage(Text.literal(control.collapsed ? "▶" : "▼"));
                        
                        if (yaclScreen.tabManager.getCurrentTab() instanceof YACLScreen.CategoryTab categoryTab) {
                            ((OptionListAccessor) categoryTab).getOptionList().getList().refreshOptions();
                        }
                    }
            );
        }
        
        @Override
        public void render(DrawContext graphics, int mouseX, int mouseY, float delta) {
            collapseWidget.render(graphics, mouseX, mouseY, delta);
            
            if (control.collapsed) {
                try {
                    graphics.drawText(MinecraftClient.getInstance().textRenderer,
                            Class.forName(control.option().pendingValue().screen()).getSimpleName(),
                            collapseWidget.getX() + 30, collapseWidget.getY() + 7,
                            16777215, true
                    );
                } catch (ClassNotFoundException ignored) {}
            }
            
            if (!control.collapsed) {
                screen.render(graphics, mouseX, mouseY, delta);
                x.render(graphics, mouseX, mouseY, delta);
                y.render(graphics, mouseX, mouseY, delta);
                recipeBook.render(graphics, mouseX, mouseY, delta);
                bookX.render(graphics, mouseX, mouseY, delta);
                bookY.render(graphics, mouseX, mouseY, delta);
            }
            
            control.bookX.option().setAvailable(control.option().pendingValue().recipeBook());
            control.bookY.option().setAvailable(control.option().pendingValue().recipeBook());
        }
        
        @Override
        public void setDimension(Dimension<Integer> widgetDimension) {
            Dimension<Integer> defaultWidgetsDimensions;
            
            if (control.collapsed) {
                widgetDimension = widgetDimension.withHeight(20);
                defaultWidgetsDimensions = widgetDimension;
            } else {
                widgetDimension.withHeight(120);
                defaultWidgetsDimensions = widgetDimension.withHeight(20).withX(widgetDimension.x() - 20).withWidth(widgetDimension.width() + 40);
            }
            
            collapseWidget.setX(widgetDimension.x());
            collapseWidget.setY(widgetDimension.y());
            collapseWidget.setWidth(collapseWidget.getWidth());
            
            
            screen.setDimension(defaultWidgetsDimensions.moved(0, 20));
            x.setDimension(defaultWidgetsDimensions.moved(0, 40));
            y.setDimension(defaultWidgetsDimensions.moved(0, 60));
            recipeBook.setDimension(defaultWidgetsDimensions.moved(0, 80));
            bookX.setDimension(defaultWidgetsDimensions.moved(0, 100));
            bookY.setDimension(defaultWidgetsDimensions.moved(0, 120));
            
            
            super.setDimension(widgetDimension);
        }

        @Override
        public List<Element> guiEventsListeners() {
            return Arrays.asList(collapseWidget, screen, x, y, recipeBook, bookX, bookY);
        }
    }
    
    
    public static class Builder implements ControllerBuilder<ScreenEntry> {
        protected final Option<ScreenEntry> option;
        private final Function<Option<String>, ControllerBuilder<String>> screen;
        private final Function<Option<Integer>, ControllerBuilder<Integer>> x;
        private final Function<Option<Integer>, ControllerBuilder<Integer>> y;
        private final Function<Option<Boolean>, ControllerBuilder<Boolean>> recipeBook;
        private final Function<Option<Integer>, ControllerBuilder<Integer>> bookX;
        private final Function<Option<Integer>, ControllerBuilder<Integer>> bookY;
        
        public Builder(Option<ScreenEntry> option) {
            this.option = option;
            this.screen = StringControllerBuilder::create;
            this.x = IntegerFieldControllerBuilder::create;
            this.y = IntegerFieldControllerBuilder::create;
            this.recipeBook = opt -> BooleanControllerBuilder.create(opt).yesNoFormatter();
            this.bookX = IntegerFieldControllerBuilder::create;
            this.bookY = IntegerFieldControllerBuilder::create;
        }
        
        public static Builder create(Option<ScreenEntry> option) {
            return new Builder(option);
        }
        
        @Override
        public Controller<ScreenEntry> build() {
            return new ScreenEntryController(option, screen, x, y, recipeBook, bookX, bookY);
        }
    }
}
