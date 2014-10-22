package by.matskevich.menuturist.bean;

import by.matskevich.menuturist.enity.Composition;
import by.matskevich.menuturist.enity.Dish;
import by.matskevich.menuturist.enity.Ingrediente;
import by.matskevich.menuturist.persistence.DatabaseManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.DragDropEvent;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author a_matskevich
 */
@Named(value = "createDish")
@SessionScoped
public class CreateDish implements Serializable {
    
    private List<Ingrediente> ingrList;
    private List<Ingrediente> ingrDropList;
    private List<Composition> compList;
    private List<Dish> dishList;
    private Dish newDish;
    
    @EJB
    DatabaseManager dm;
    
    @PostConstruct
    public void init() {
        ingrList = dm.findAll(Ingrediente.class);
        dishList = dm.findAll(Dish.class);
        ingrDropList = new ArrayList<Ingrediente>();
        compList = new ArrayList<Composition>();
        newDish = new Dish();
    }
    
    public void onIngredienteDrop(DragDropEvent ddEvent) {
        Ingrediente ingr = ((Ingrediente) ddEvent.getData());
        Composition comp = new Composition();
        comp.setDish(newDish);
        comp.setIngr(dm.findById(ingr.getId(), Ingrediente.class));
        compList.add(comp);
//        ingrDropList.add(dm.findById(ingr.getId(), Ingrediente.class));
        ingrList.remove(ingr);
    }
    
    public void createDish() {
        for (Composition comp : compList) {
            if (comp.getQuantity() == null || comp.getQuantity() < 0.001 || comp.getQuantity() > 999) {
                return;
            }
        }
        newDish.setIngrCountList(compList);
        dm.create(newDish);
        this.init();
    }
    
    public void clearTab() {
        this.init();
    }
    
    public void onRowEdit(RowEditEvent event) {
        Dish selected = (Dish) event.getObject();
        dm.save(selected);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("SAVE", "Изменения сохранены"));
        RequestContext.getCurrentInstance().update("mainForm:growl");
    }

    public void onRowCancel() {
    }

    public List<Ingrediente> getIngrList() {
        return ingrList;
    }

    public void setIngrList(List<Ingrediente> ingrList) {
        this.ingrList = ingrList;
    }

    public List<Ingrediente> getIngrDropList() {
        return ingrDropList;
    }

    public void setIngrDropList(List<Ingrediente> ingrDropList) {
        this.ingrDropList = ingrDropList;
    }

    public Dish getNewDish() {
        return newDish;
    }

    public void setNewDish(Dish newDish) {
        this.newDish = newDish;
    }

    public List<Composition> getCompList() {
        return compList;
    }

    public void setCompList(List<Composition> compList) {
        this.compList = compList;
    }

    public List<Dish> getDishList() {
        return dishList;
    }

    public void setDishList(List<Dish> dishList) {
        this.dishList = dishList;
    }
    
}
