/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import Entity.Productcategories;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import query.exceptions.NonexistentEntityException;

/**
 *
 * @author Falbe
 */
public class ProductcategoriesController implements Serializable {

    public ProductcategoriesController(EntityManagerFactory emf) {
        this.emf = Persistence.createEntityManagerFactory("CarscatPU");
    }
    
  private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productcategories productcategories) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productcategories);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productcategories productcategories) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productcategories = em.merge(productcategories);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productcategories.getCategoryID();
                if (findProductcategories(id) == null) {
                    throw new NonexistentEntityException("The productcategories with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Productcategories productcategories;
            try {
                productcategories = em.getReference(Productcategories.class, id);
                productcategories.getCategoryID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productcategories with id " + id + " no longer exists.", enfe);
            }
            em.remove(productcategories);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productcategories> findProductcategoriesEntities() {
        return findProductcategoriesEntities(true, -1, -1);
    }

    public List<Productcategories> findProductcategoriesEntities(int maxResults, int firstResult) {
        return findProductcategoriesEntities(false, maxResults, firstResult);
    }

    private List<Productcategories> findProductcategoriesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productcategories.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Productcategories findProductcategories(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productcategories.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductcategoriesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productcategories> rt = cq.from(Productcategories.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
