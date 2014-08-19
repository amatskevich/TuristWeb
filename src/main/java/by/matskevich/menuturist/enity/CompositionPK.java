package by.matskevich.menuturist.enity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author a_matskevich
 */
@Embeddable
public class CompositionPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DISH")
    private Long idDish;

    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_INGREDIENTE")
    private Long idIngr;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.idDish);
        hash = 29 * hash + Objects.hashCode(this.idIngr);
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
        final CompositionPK other = (CompositionPK) obj;
        if (!Objects.equals(this.idDish, other.idDish)) {
            return false;
        }
        if (!Objects.equals(this.idIngr, other.idIngr)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CompositionPK{" + "idDish=" + idDish + ", idIngr=" + idIngr + '}';
    }

}
