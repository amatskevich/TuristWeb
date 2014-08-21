package by.matskevich.menuturist.persistence;

import by.matskevich.menuturist.enity.Dish;
import by.matskevich.menuturist.enity.Dish_;
import by.matskevich.menuturist.enity.Ingrediente;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

/**
 *
 * @author a_matskevich
 */
@Stateless
@LocalBean
public class DatabaseManager {

    @PersistenceContext(unitName = "menuTuristPU")
    protected EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    //-----------------------------------------------------
    public <X extends Object> List<X> findAll(Class<X> type) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<X> query = builder.createQuery(type);
//	@SuppressWarnings("unused")
        Root<X> root = query.from(type);
        return em.createQuery(query).getResultList();
    }
    
    public <X extends Object> X findById(Long Id, Class<X> type) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<X> query = builder.createQuery(type);
//	@SuppressWarnings("unused")
        Root<X> root = query.from(type);
        query.select(root).where(builder.equal(root.get("id").as(Long.class), Id));
        
        return em.createQuery(query).getSingleResult();
    }

//    public List<Dish> findDishByAll(Long id, String name, String description) {
//        CriteriaBuilder builder = em.getCriteriaBuilder();
//        CriteriaQuery<Dish> query = builder.createQuery(Dish.class);
//        Root<Dish> root = query.from(Dish.class);
//        query.select(root).where(builder.like(root.get(Dish_.name).as(String.class), "ШАШЛЫК"));
//        List<Predicate> criteria = new ArrayList<Predicate>();
//        if (id != null) {
//            criteria.add(builder.equal(root.get("id"), id));
//        }
//        if (name != null) {
//            criteria.add(builder.equal(root.get("name"), name));
//        }
//        if (description != null) {
//            criteria.add(builder.equal(root.get("description"), description));
//        }
//        if (criteria.size() == 1) {
//            query.where(criteria.get(0));
//        } else {
//            query.where(builder.and(criteria.toArray(new Predicate[0])));
//        }
//	query.orderBy(
//			builder.desc(root.get("year")), 
//			builder.desc(root.get("month")),
//			builder.asc(root.get("person"))
//		);
//        return em.createQuery(query).getResultList();
//    }

    //---------------------------------------------------
//    public <X extends Object> X save(X obj) throws PersistenceException {
//        return em.merge(obj);
//    }
//
//    public void delete(Object obj) throws PersistenceException {
//        em.remove(obj);
//    }
//
//    public <X extends Object> List<X> createNamedQuery(Class<X> type, String queryName) throws PersistenceException {
//        return em.createNamedQuery(queryName, type).getResultList();
//    }
//
//    public <X extends Object> List<X> createNamedQuery(Class<X> type, String queryName, Map<String, Object> paramMap) throws PersistenceException, NoSuchMethodException {
//        throw new NoSuchMethodException();
//    }

}
