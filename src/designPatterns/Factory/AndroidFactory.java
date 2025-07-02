package designPatterns.Factory;

import designPatterns.Factory.components.button.AndroidButton;
import designPatterns.Factory.components.button.Button;
import designPatterns.Factory.components.dropdown.AndroidDropdown;
import designPatterns.Factory.components.dropdown.Dropdown;
import designPatterns.Factory.components.menu.AndriodMenu;
import designPatterns.Factory.components.menu.Menu;

public class AndroidFactory implements UIFactory{
    @Override
    public Menu createMenu() {
        return new AndriodMenu();
    }

    @Override
    public Dropdown createDropdown() {
        return new AndroidDropdown();
    }

    @Override
    public Button createButton() {
        return new AndroidButton();
    }
}
