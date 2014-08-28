package by.matskevich.menuturist.bean;

import by.matskevich.menuturist.enity.Ingrediente;
import by.matskevich.menuturist.persistence.DatabaseManager;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author a_matskevich
 */
@Named(value = "createIngr")
@SessionScoped
public class CreateIngrediente implements Serializable {
    
    private Ingrediente newIngr;
    
    @EJB
    DatabaseManager dm;
    
    @PostConstruct
    public void init() {
        newIngr = new Ingrediente();
    }
    
    public void createIngr() {
        dm.create(newIngr);
        this.init();
    }
    
    public void clearTab() {
        this.init();
    }

    public Ingrediente getNewIngr() {
        return newIngr;
    }

    public void setNewIngr(Ingrediente newIngr) {
        this.newIngr = newIngr;
    }
    
}
