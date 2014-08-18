package by.matskevich.menuturist.object;

import java.util.Map;

/**
 *
 * @author a_matskevich
 * Блюдо
 */
public class Dish {
    
    private String name;
    private Map<Product, Double> composition;

    public Dish(String name) {
        this.name = name;
    }

    public Dish(String name, Map<Product, Double> composition) {
        this.name = name;
        this.composition = composition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Product, Double> getComposition() {
        return composition;
    }

    public void setComposition(Map<Product, Double> composition) {
        this.composition = composition;
    }
    
}