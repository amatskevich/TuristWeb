package by.matskevich.menuturist.bean;

import by.matskevich.menuturist.enity.Composition;
import by.matskevich.menuturist.enity.Dish;
import by.matskevich.menuturist.enity.Ingrediente;
import by.matskevich.menuturist.object.MenuItem;
import by.matskevich.menuturist.object.MenuItemEnum;
import by.matskevich.menuturist.persistence.DatabaseManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
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
@Named(value = "buildMenu")
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
    private int countPeople;
    
    private HashMap<Ingrediente, Double> listProvisions;

    private List<Ingrediente> ingrList;

    @PostConstruct
    public void init() {
        breakfastDishList = new ArrayList<Dish>();
        lunchDishList = new ArrayList<Dish>();
        dinnerDishList = new ArrayList<Dish>();
        menu = new ArrayList<MenuItem>();
        numberDay = 1;
        countPeople = 1;
        
        listProvisions = new HashMap<Ingrediente, Double>();

        dishList = dm.findAll(Dish.class);
    }
    
    public void onTemp() {
        System.err.println("TEMP:");
    }
    
    public void calcIngr() {
        for (MenuItem menuItem : menu) {
            Dish dish = menuItem.getDish();
            for (Composition comp : dish.getIngrCountList()) {
                if (listProvisions.containsKey(comp.getIngr())) {
                    listProvisions.put(comp.getIngr(), listProvisions.get(comp.getIngr()) + (comp.getQuantity() * countPeople));
                } else {
                    listProvisions.put(comp.getIngr(), comp.getQuantity() * countPeople);
                }
            }
        }
        
        Set<Ingrediente> keys = listProvisions.keySet();
        for (Ingrediente temp1 : keys) {
            System.err.print(temp1.getName() + "    ");
            System.err.println(listProvisions.get(temp1));
        }
    }

    public void onBreakfastDishDrop(DragDropEvent ddEvent) {
        Dish dish = ((Dish) ddEvent.getData());

        breakfastDishList.add(dm.findById(dish.getId(), Dish.class));
    }

    public void onLunchDishDrop(DragDropEvent ddEvent) {
        Dish dish = ((Dish) ddEvent.getData());

        lunchDishList.add(dm.findById(dish.getId(), Dish.class));
    }

    public void onDinnerDishDrop(DragDropEvent ddEvent) {
        Dish dish = ((Dish) ddEvent.getData());

        dinnerDishList.add(dm.findById(dish.getId(), Dish.class));
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
    
    public int getCountPeople() {
        return countPeople;
    }

    public void setCountPeople(int countPeople) {
        this.countPeople = countPeople;
    }
    
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
