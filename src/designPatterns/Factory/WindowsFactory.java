package designPatterns.Factory;

import designPatterns.Factory.components.button.Button;
import designPatterns.Factory.components.button.IoSButton;
import designPatterns.Factory.components.button.WindowsButton;
import designPatterns.Factory.components.dropdown.Dropdown;
import designPatterns.Factory.components.dropdown.IosDropdown;
import designPatterns.Factory.components.dropdown.WindowsDropdown;
import designPatterns.Factory.components.menu.IosMenu;
import designPatterns.Factory.components.menu.Menu;
import designPatterns.Factory.components.menu.WindowsMenu;

public class WindowsFactory implements UIFactory{
    @Override
    public Menu createMenu() {
        return new WindowsMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new WindowsDropdown();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
