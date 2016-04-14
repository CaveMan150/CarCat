/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import Entity.Options;
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
public class OptionsController implements Serializable {

    public OptionsController( ) {
            this.emf = Persistence.createEntityManagerFactory("CarscatPU");

    }
    
  private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Options options) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(options);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Options options) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            options = em.merge(options);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = options.getOptionID();
                if (findOptions(id) == null) {
                    throw new NonexistentEntityException("The options with id " + id + " no longer exists.");
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
            Options options;
            try {
                options = em.getReference(Options.class, id);
                options.getOptionID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The options with id " + id + " no longer exists.", enfe);
            }
            em.remove(options);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Options> findOptionsEntities() {
        return findOptionsEntities(true, -1, -1);
    }

    public List<Options> findOptionsEntities(int maxResults, int firstResult) {
        return findOptionsEntities(false, maxResults, firstResult);
    }

    private List<Options> findOptionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Options.class));
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

    public Options findOptions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Options.class, id);
        } finally {
            em.close();
        }
    }

    public int getOptionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Options> rt = cq.from(Options.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
