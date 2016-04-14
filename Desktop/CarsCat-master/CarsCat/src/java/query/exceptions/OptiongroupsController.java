/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import Entity.Optiongroups;
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
public class OptiongroupsController implements Serializable {

   
    public OptiongroupsController() {
                  this.emf = Persistence.createEntityManagerFactory("CarscatPU");

    }
    private EntityManagerFactory emf = null;
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Optiongroups optiongroups) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(optiongroups);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Optiongroups optiongroups) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            optiongroups = em.merge(optiongroups);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = optiongroups.getOptionGroupID();
                if (findOptiongroups(id) == null) {
                    throw new NonexistentEntityException("The optiongroups with id " + id + " no longer exists.");
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
            Optiongroups optiongroups;
            try {
                optiongroups = em.getReference(Optiongroups.class, id);
                optiongroups.getOptionGroupID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The optiongroups with id " + id + " no longer exists.", enfe);
            }
            em.remove(optiongroups);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Optiongroups> findOptiongroupsEntities() {
        return findOptiongroupsEntities(true, -1, -1);
    }

    public List<Optiongroups> findOptiongroupsEntities(int maxResults, int firstResult) {
        return findOptiongroupsEntities(false, maxResults, firstResult);
    }

    private List<Optiongroups> findOptiongroupsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Optiongroups.class));
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

    public Optiongroups findOptiongroups(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Optiongroups.class, id);
        } finally {
            em.close();
        }
    }

    public int getOptiongroupsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Optiongroups> rt = cq.from(Optiongroups.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
