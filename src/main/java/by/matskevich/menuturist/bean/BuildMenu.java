package by.matskevich.menuturist.bean;

import by.matskevich.menuturist.enity.Ingrediente;
import by.matskevich.menuturist.object.Dish;
import by.matskevich.menuturist.object.MenuItem;
import by.matskevich.menuturist.object.MenuItemEnum;
import by.matskevich.menuturist.persistence.DatabaseManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.DragDropEvent;

/**
 *
 * @author a_matskevich
 */
@Named(value = "builMenu")
@SessionScoped
public class BuildMenu implements Serializable {

    @Inject
    Application apppBean;

    @EJB
    DatabaseManager dm;

    private List<Dish> dishList;
    private List<Dish> breakfastDishList;
    private List<Dish> lunchDishList;
    private List<Dish> dinnerDishList;
    private List<MenuItem> menu;
    private int numberDay;

    private List<Ingrediente> ingrList;

    @PostConstruct
    public void init() {
        breakfastDishList = new ArrayList<Dish>();
        lunchDishList = new ArrayList<Dish>();
        dinnerDishList = new ArrayList<Dish>();
        menu = new ArrayList<MenuItem>();
        numberDay = 1;

        dishList = new ArrayList<Dish>();
        dishList.add(new Dish("Овсяная каша"));
        dishList.add(new Dish("Гречневая каша"));
        dishList.add(new Dish("Шашлык"));
        dishList.add(new Dish("Кисель"));
        dishList.add(new Dish("Чай"));
        dishList.add(new Dish("Дымлама"));
        dishList.add(new Dish("Бутерброды"));
        dishList.add(new Dish("Картошка тушеная"));
        dishList.add(new Dish("Макароны по флотски"));
    }
    
    public void onTemp() {
        System.err.println("TEMP:");
        List<by.matskevich.menuturist.enity.Dish> items = dm.findDishByAll(Long.valueOf(1l), null, null);
        for (by.matskevich.menuturist.enity.Dish item : items) {
            System.err.println(item.getName());
        }
    }

    public void onBreakfastDishDrop(DragDropEvent ddEvent) {
        Dish dish = ((Dish) ddEvent.getData());

        breakfastDishList.add(new Dish(dish.getName()));
    }

    public void onLunchDishDrop(DragDropEvent ddEvent) {
        Dish dish = ((Dish) ddEvent.getData());

        lunchDishList.add(new Dish(dish.getName()));
    }

    public void onDinnerDishDrop(DragDropEvent ddEvent) {
        Dish dish = ((Dish) ddEvent.getData());

        dinnerDishList.add(new Dish(dish.getName()));
    }

    public void addDayMenu() {
        for (Dish dish : breakfastDishList) {
            menu.add(new MenuItem(numberDay, MenuItemEnum.BREAKFAST, dish));
        }
        for (Dish dish : lunchDishList) {
            menu.add(new MenuItem(numberDay, MenuItemEnum.LUNCH, dish));
        }
        for (Dish dish : dinnerDishList) {
            menu.add(new MenuItem(numberDay, MenuItemEnum.DINNER, dish));
        }
        numberDay++;
        breakfastDishList = new ArrayList<Dish>();
        lunchDishList = new ArrayList<Dish>();
        dinnerDishList = new ArrayList<Dish>();
    }

    // <editor-fold defaultstate="collapsed" desc="getters and setters">
    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    public int getNumberDay() {
        return numberDay;
    }

    public void setNumberDay(int numberDay) {
        this.numberDay = numberDay;
    }

    public List<Dish> getBreakfastDishList() {
        return breakfastDishList;
    }

    public void setBreakfastDishList(List<Dish> breakfastDishList) {
        this.breakfastDishList = breakfastDishList;
    }

    public List<Dish> getLunchDishList() {
        return lunchDishList;
    }

    public void setLunchDishList(List<Dish> lunchDishList) {
        this.lunchDishList = lunchDishList;
    }

    public List<Dish> getDinnerDishList() {
        return dinnerDishList;
    }

    public void setDinnerDishList(List<Dish> dinnerDishList) {
        this.dinnerDishList = dinnerDishList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
    // </editor-fold>

}
