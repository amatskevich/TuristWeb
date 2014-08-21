package by.matskevich.menuturist.object;

import by.matskevich.menuturist.enity.Dish;

/**
 *
 * @author a_matskevich
 */
public class MenuItem {
    
    private final int numDay;
    private final MenuItemEnum nameItem;
    private final Dish dish;

    public MenuItem(int numDay, MenuItemEnum nameItem, Dish dish) {
        this.numDay = numDay;
        this.nameItem = nameItem;
        this.dish = dish;
    }

    public int getNumDay() {
        return numDay;
    }

    public MenuItemEnum getNameItem() {
        return nameItem;
    }

    public Dish getDish() {
        return dish;
    }
    
}
