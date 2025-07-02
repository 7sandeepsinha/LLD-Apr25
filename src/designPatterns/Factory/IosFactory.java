package designPatterns.Factory;

import designPatterns.Factory.components.button.AndroidButton;
import designPatterns.Factory.components.button.Button;
import designPatterns.Factory.components.button.IoSButton;
import designPatterns.Factory.components.dropdown.AndroidDropdown;
import designPatterns.Factory.components.dropdown.Dropdown;
import designPatterns.Factory.components.dropdown.IosDropdown;
import designPatterns.Factory.components.menu.AndriodMenu;
import designPatterns.Factory.components.menu.IosMenu;
import designPatterns.Factory.components.menu.Menu;

public class IosFactory implements UIFactory{
    @Override
    public Menu createMenu() {
        return new IosMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new IosDropdown();
    }

    @Override
    public Button createButton() {
        return new IoSButton();
    }
}
