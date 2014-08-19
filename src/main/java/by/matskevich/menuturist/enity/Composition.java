package by.matskevich.menuturist.enity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author a_matskevich
 */
@Entity
@Table(name = "COMPOSITION")
public class Composition implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    private CompositionPK compPK;

    @Column(name = "QUANTITY")
    private Double quantity;
    
    @Column(name = "DESCRIPTION")
    private String desc;

    public CompositionPK getCompPK() {
        return compPK;
    }

    public void setCompPK(CompositionPK compPK) {
        this.compPK = compPK;
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
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.compPK);
        hash = 97 * hash + Objects.hashCode(this.quantity);
        hash = 97 * hash + Objects.hashCode(this.desc);
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
        if (!Objects.equals(this.compPK, other.compPK)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Composition{" + "compPK=" + compPK + '}';
    }
    
}
