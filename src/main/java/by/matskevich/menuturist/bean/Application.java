package by.matskevich.menuturist.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author a_matskevich
 */
@Named(value = "appBean")
@SessionScoped
public class Application implements Serializable {
    
    private static final String BUILD_MENU = "/WEB-INF/composition/buildMenu.xhtml";
    private static final String BUILD_DISH = "/WEB-INF/composition/buildDish.xhtml";
    private static final String GATHER_THINGS = "/WEB-INF/composition/gatherThings.xhtml";
    
    private String includeSrc;
    
    @PostConstruct
    public void init() {
        includeSrc = BUILD_MENU;
    }
    
    public void changeIncludeSrc() {
        String str = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("src");
        this.includeSrc = str;
    }

    public String getIncludeSrc() {
        return includeSrc;
    }

    public void setIncludeSrc(String includeSrc) {
        this.includeSrc = includeSrc;
    }

    public String getBUILD_MENU() {
        return BUILD_MENU;
    }

    public String getBUILD_DISH() {
        return BUILD_DISH;
    }

    public String getGATHER_THINGS() {
        return GATHER_THINGS;
    }
    
}