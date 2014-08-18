package by.matskevich.menuturist.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author a_matskevich
 */
@Named(value = "appBean")
@SessionScoped
public class Application implements Serializable {
    
    @PostConstruct
    public void init() {
    }
}