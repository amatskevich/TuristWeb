package by.matskevich.menuturist.bean;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author a_matskevich
 */
@Named
@SessionScoped
public class CenterBuildMenu implements Serializable {
    
    @Inject
    Application appBean;
    @Inject
    BuildMenu left;
}