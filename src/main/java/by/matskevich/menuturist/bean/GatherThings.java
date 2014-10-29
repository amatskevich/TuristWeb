package by.matskevich.menuturist.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import org.primefaces.model.DualListModel;

/**
 *
 * @author a_matskevich
 */
@Named(value = "gatherThings")
@SessionScoped
public class GatherThings implements Serializable {
    
    private DualListModel<String> things;
    
    @PostConstruct
    public void init() {
        List<String> thingsSource = new ArrayList();
        List<String> thingsTarget = new ArrayList();
        
        thingsSource.add("Газета");
        thingsSource.add("Туалетная бумага");
        thingsSource.add("Крем от солнца");
        thingsSource.add("Крем от комаров");
        thingsSource.add("Дождевик");
        thingsSource.add("Головной убор");
        thingsSource.add("Насос");
        thingsSource.add("Треного для костра");
        thingsSource.add("Аптечка");
        thingsSource.add("Сковорода");
        thingsSource.add("Котелок");
        thingsSource.add("Спальник");
        thingsSource.add("Коврик");
        thingsSource.add("Пендаль");
        thingsSource.add("Тент");
        thingsSource.add("Гермомешок");
        thingsSource.add("Открывашка");
        thingsSource.add("Спички");
        thingsSource.add("Рем-комплект");
        thingsSource.add("Скотч");
        thingsSource.add("Бечёвка");
        thingsSource.add("Топор");
        thingsSource.add("Пила");
        
        things = new DualListModel<String>(thingsSource, thingsTarget);
    }

    public DualListModel<String> getThings() {
        return things;
    }

    public void setThings(DualListModel<String> things) {
        this.things = things;
    }
    
}
