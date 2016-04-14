/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import Entity.Productoptions;
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
public class ProductoptionsController implements Serializable {

    public ProductoptionsController(EntityManagerFactory emf) {
       emf =Persistence.createEntityManagerFactory("CarscatPU");
      
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Productoptions productoptions) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(productoptions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Productoptions productoptions) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            productoptions = em.merge(productoptions);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = productoptions.getProductOptionID();
                if (findProductoptions(id) == null) {
                    throw new NonexistentEntityException("The productoptions with id " + id + " no longer exists.");
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
            Productoptions productoptions;
            try {
                productoptions = em.getReference(Productoptions.class, id);
                productoptions.getProductOptionID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The productoptions with id " + id + " no longer exists.", enfe);
            }
            em.remove(productoptions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Productoptions> findProductoptionsEntities() {
        return findProductoptionsEntities(true, -1, -1);
    }

    public List<Productoptions> findProductoptionsEntities(int maxResults, int firstResult) {
        return findProductoptionsEntities(false, maxResults, firstResult);
    }

    private List<Productoptions> findProductoptionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Productoptions.class));
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

    public Productoptions findProductoptions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Productoptions.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoptionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Productoptions> rt = cq.from(Productoptions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
