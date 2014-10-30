package by.matskevich.menuturist.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author a_matskevich
 */
@Named(value = "gatherThings")
@SessionScoped
public class GatherThings implements Serializable {
    
    private List<String> thingsSource;
    private String[] selectedSource;
    private List<String> thingsTarget;
    private String[] selectedTarget;
    
    @PostConstruct
    public void init() {
        thingsSource = new ArrayList();
        thingsTarget = new ArrayList();
        
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
        
    }
    
    public void addAllThings() {
        thingsTarget.addAll(thingsSource);
        thingsSource.clear();
        selectedSource = null;
        selectedTarget = null;
    }
    
    public void addThings() {
        thingsTarget.addAll(Arrays.asList(selectedSource));
        thingsSource.removeAll(Arrays.asList(selectedSource));
        selectedSource = null;
    }
    
    public void removeThings() {
        thingsSource.addAll(Arrays.asList(selectedTarget));
        thingsTarget.removeAll(Arrays.asList(selectedTarget));
        selectedTarget = null;
    }
    
    public void removeAllThings() {
        thingsSource.addAll(thingsTarget);
        thingsTarget.clear();
        selectedSource = null;
        selectedTarget = null;
    }

    public List<String> getThingsSource() {
        return thingsSource;
    }

    public void setThingsSource(List<String> thingsSource) {
        this.thingsSource = thingsSource;
    }

    public List<String> getThingsTarget() {
        return thingsTarget;
    }

    public void setThingsTarget(List<String> thingsTarget) {
        this.thingsTarget = thingsTarget;
    }

    public String[] getSelectedSource() {
        return selectedSource;
    }

    public void setSelectedSource(String[] selectedSource) {
        this.selectedSource = selectedSource;
    }

    public String[] getSelectedTarget() {
        return selectedTarget;
    }

    public void setSelectedTarget(String[] selectedTarget) {
        this.selectedTarget = selectedTarget;
    }
    
}
