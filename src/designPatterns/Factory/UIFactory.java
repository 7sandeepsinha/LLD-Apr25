package designPatterns.Factory;

import designPatterns.Factory.components.button.Button;
import designPatterns.Factory.components.dropdown.Dropdown;
import designPatterns.Factory.components.menu.Menu;

public interface UIFactory {
    Menu createMenu();
    Dropdown createDropdown();
    Button createButton();
}
