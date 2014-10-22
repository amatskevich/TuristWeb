package by.matskevich.menuturist.bean;

import by.matskevich.menuturist.enity.Ingrediente;
import by.matskevich.menuturist.persistence.DatabaseManager;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author a_matskevich
 */
@Named(value = "createIngr")
@SessionScoped
public class CreateIngrediente implements Serializable {

    private Ingrediente newIngr;
    private List<Ingrediente> ingredienteList;

    @EJB
    DatabaseManager dm;

    @PostConstruct
    public void init() {
        newIngr = new Ingrediente();
        ingredienteList = dm.findAll(Ingrediente.class);
    }

    public void createIngr() {
        System.err.println("create");
        dm.create(newIngr);
        this.init();
    }

    public void clearTab() {
        this.init();
    }

    public void onRowEdit(RowEditEvent event) {
        Ingrediente selected = (Ingrediente) event.getObject();
        dm.save(selected);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("SAVE", "Изменения сохранены"));
        RequestContext.getCurrentInstance().update("mainForm:growl");
    }

    public void onRowCancel() {
    }

    public Ingrediente getNewIngr() {
        return newIngr;
    }

    public void setNewIngr(Ingrediente newIngr) {
        this.newIngr = newIngr;
    }

    public List<Ingrediente> getIngredienteList() {
        return ingredienteList;
    }

    public void setIngredienteList(List<Ingrediente> ingredienteList) {
        this.ingredienteList = ingredienteList;
    }

}
