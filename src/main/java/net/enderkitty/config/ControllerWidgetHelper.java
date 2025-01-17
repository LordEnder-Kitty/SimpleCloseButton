// Credit: Imajo24I, Mob-Armor-Trims under MIT License
package net.enderkitty.config;

import dev.isxander.yacl3.api.Controller;
import dev.isxander.yacl3.api.utils.Dimension;
import dev.isxander.yacl3.gui.YACLScreen;
import dev.isxander.yacl3.gui.controllers.ControllerWidget;
import net.minecraft.client.gui.Element;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Helper class for {@link ControllerWidget}. <br>
 * Overrides many of the methods like {@link ControllerWidget#mouseMoved} to reduce boilerplate code. <br>
 * Make sure to override {@link ControllerWidget#render} and {@link ControllerWidget#setDimension}
 */
public abstract class ControllerWidgetHelper<T extends Controller<?>> extends ControllerWidget<T> {
    protected ControllerWidgetHelper(T control, YACLScreen screen, Dimension<Integer> dim) {
        super(control, screen, dim);
    }
    
    /**
     * Returns all {@link Element} used in this Widget
     */
    public abstract List<Element> guiEventsListeners();
    
    /**
     * Applies a consumer to all widgets
     */
    public void forWidget(Consumer<Element> action) {
        guiEventsListeners().forEach(action);
    }
    
    /**
     * Checks if any widget matches the predicate
     */
    public boolean anyWidgetMatches(Predicate<Element> action) {
        return guiEventsListeners().stream().anyMatch(action);
    }
    
    @Override
    protected int getHoveredControlWidth() {
        return getUnhoveredControlWidth();
    }
    
    /**
     * Called when the mouse is moved within the GUI element.
     *
     * @param mouseX the X coordinate of the mouse.
     * @param mouseY the Y coordinate of the mouse.
     */
    @Override
    public void mouseMoved(double mouseX, double mouseY) {
        forWidget(widget -> widget.mouseMoved(mouseX, mouseY));
        super.mouseMoved(mouseX, mouseY);
    }
    
    /**
     * Called when a mouse button is clicked within the GUI element.
     * <p>
     *
     * @param mouseX the X coordinate of the mouse.
     * @param mouseY the Y coordinate of the mouse.
     * @param button the button that was clicked.
     * @return {@code true} if the event is consumed, {@code false} otherwise.
     */
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        return anyWidgetMatches(widget -> widget.mouseClicked(mouseX, mouseY, button)) || super.mouseClicked(mouseX, mouseY, button);
    }
    
    /**
     * Called when a mouse button is released within the GUI element.
     * <p>
     *
     * @param mouseX the X coordinate of the mouse.
     * @param mouseY the Y coordinate of the mouse.
     * @param button the button that was released.
     * @return {@code true} if the event is consumed, {@code false} otherwise.
     */
    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        return anyWidgetMatches(widget -> widget.mouseReleased(mouseX, mouseY, button)) || super.mouseReleased(mouseX, mouseY, button);
    }
    
    /**
     * Called when the mouse is dragged within the GUI element.
     * <p>
     *
     * @param mouseX the X coordinate of the mouse.
     * @param mouseY the Y coordinate of the mouse.
     * @param button the button that is being dragged.
     * @param dragX  the X distance of the drag.
     * @param dragY  the Y distance of the drag.
     * @return {@code true} if the event is consumed, {@code false} otherwise.
     */
    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        return anyWidgetMatches(widget -> widget.mouseDragged(mouseX, mouseY, button, dragX, dragY)) || super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }
    
    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        return anyWidgetMatches(widget -> widget.mouseScrolled(mouseX, mouseY, scrollX, scrollY)) || super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
    }
    
    /**
     * Called when a keyboard key is pressed within the GUI element.
     * <p>
     *
     * @param keyCode   the key code of the pressed key.
     * @param scanCode  the scan code of the pressed key.
     * @param modifiers the keyboard modifiers.
     * @return {@code true} if the event is consumed, {@code false} otherwise.
     */
    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        return anyWidgetMatches(widget -> widget.keyPressed(keyCode, scanCode, modifiers)) || super.keyPressed(keyCode, scanCode, modifiers);
    }
    
    /**
     * Called when a keyboard key is released within the GUI element.
     * <p>
     *
     * @param keyCode   the key code of the released key.
     * @param scanCode  the scan code of the released key.
     * @param modifiers the keyboard modifiers.
     * @return {@code true} if the event is consumed, {@code false} otherwise.
     */
    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        return anyWidgetMatches(widget -> widget.keyReleased(keyCode, scanCode, modifiers)) || super.keyReleased(keyCode, scanCode, modifiers);
    }
    
    /**
     * Called when a character is typed within the GUI element.
     * <p>
     *
     * @param codePoint the code point of the typed character.
     * @param modifiers the keyboard modifiers.
     * @return {@code true} if the event is consumed, {@code false} otherwise.
     */
    @Override
    public boolean charTyped(char codePoint, int modifiers) {
        return anyWidgetMatches(widget -> widget.charTyped(codePoint, modifiers)) || super.charTyped(codePoint, modifiers);
    }
    
    @Override
    public boolean isFocused() {
        return anyWidgetMatches(Element::isFocused);
    }
    
    @Override
    public void setFocused(boolean focused) {
        forWidget(widget -> widget.setFocused(focused));
    }
    
    /**
     * {@return the narration priority}
     */
    @Override
    public @NotNull SelectionType getType() {
        return SelectionType.HOVERED;
    }
    
    /**
     * Updates the narration output with the current narration information.
     *
     * @param narrationElementOutput the output to update with narration information.
     */
    @Override
    public void appendNarrations(NarrationMessageBuilder narrationElementOutput) {}
}
