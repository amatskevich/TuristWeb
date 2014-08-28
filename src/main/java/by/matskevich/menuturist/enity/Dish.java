package by.matskevich.menuturist.enity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author a_matskevich
 */
@Entity
@Table(name = "DISH")
public class Dish implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "DishSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DishSeq", sequenceName = "SEQ_DISH", allocationSize = 1)
    @Column(name = "ID")
    @NotNull
    private Long id;
    
    @Column(name = "NAME")
    @NotNull
    private String name;
    
    @Column(name = "DESCRIPTION")
    private String description;
    
    @OneToMany(mappedBy = "dish", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Composition> ingrCountList;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Composition> getIngrCountList() {
        return ingrCountList;
    }

    public void setIngrCountList(List<Composition> ingrCountList) {
        this.ingrCountList = ingrCountList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dish)) {
            return false;
        }
        Dish other = (Dish) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dish{" + "id=" + id + ", name=" + name + '}';
    }
    
}
