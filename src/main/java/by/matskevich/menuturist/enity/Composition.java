package by.matskevich.menuturist.enity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author a_matskevich
 */
@Entity
@Table(name = "COMPOSITION")
public class Composition implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(generator = "CompositionSeq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CompositionSeq", sequenceName = "SEQ_COMPOSITION", allocationSize = 1)
    @Column(name = "ID")
    @NotNull
    private Long id;
    
    @Column(name = "QUANTITY")
    private Double quantity;
    
    @Column(name = "DESCRIPTION")
    private String desc;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DISH", referencedColumnName = "ID")
    private Dish dish;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_INGREDIENTE", referencedColumnName = "ID")
    private Ingrediente ingr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Ingrediente getIngr() {
        return ingr;
    }

    public void setIngr(Ingrediente ingr) {
        this.ingr = ingr;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Composition other = (Composition) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Composition{" + "id=" + id + ", dish=" + dish + ", ingr=" + ingr + '}';
    }
    
}
