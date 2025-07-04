package designPatterns.Factory;

import designPatterns.Factory.components.button.Button;
import designPatterns.Factory.components.dropdown.Dropdown;
import designPatterns.Factory.components.menu.Menu;

//factory for UI components
public interface UIFactory {
    Menu createMenu();
    Dropdown createDropdown();
    Button createButton();
}
