package by.matskevich.menuturist.persistence;

import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author a_matskevich
 */
@EJB(name = "DatabaseManager",
        beanInterface = DatabaseManager.class)
@Stateless
@LocalBean
public class DatabaseManager {
    
    @PersistenceContext(unitName = "menuTuristPU")
    protected EntityManager em;

    public EntityManager getEm() {
        return em;
    }
    
    public <X extends Object> X findUnique(CriteriaQuery<X> query) throws PersistenceException {
        return em.createQuery(query).getSingleResult();
    }
    
    public <X extends Object> X find(Class<X> type, Object id) {
        return em.find(type, id);
    }
    
    public <X extends Object> List<X> find(CriteriaQuery<X> query) {
        return em.createQuery(query).getResultList();
    }
    
    public <X extends Object> X save(X obj) throws PersistenceException {
        return em.merge(obj);
    }
    
    public void delete(Object obj) throws PersistenceException {
        em.remove(obj);
    }
    
    public <X extends Object> List<X> createNamedQuery(Class<X> type, String queryName) throws PersistenceException {
        return em.createNamedQuery(queryName, type).getResultList();
    }
    
    public <X extends Object> List<X> createNamedQuery(Class<X> type, String queryName, Map<String, Object> paramMap) throws PersistenceException, NoSuchMethodException {
        throw new NoSuchMethodException();
    }
    
    
}
