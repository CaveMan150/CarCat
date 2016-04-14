/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package query;

import Entity.Orderdetails;
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
public class OrderdetailsController implements Serializable {

    public OrderdetailsController() {
               this.emf = Persistence.createEntityManagerFactory("CarscatPU");

               
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orderdetails orderdetails) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(orderdetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orderdetails orderdetails) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            orderdetails = em.merge(orderdetails);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = orderdetails.getDetailID();
                if (findOrderdetails(id) == null) {
                    throw new NonexistentEntityException("The orderdetails with id " + id + " no longer exists.");
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
            Orderdetails orderdetails;
            try {
                orderdetails = em.getReference(Orderdetails.class, id);
                orderdetails.getDetailID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orderdetails with id " + id + " no longer exists.", enfe);
            }
            em.remove(orderdetails);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orderdetails> findOrderdetailsEntities() {
        return findOrderdetailsEntities(true, -1, -1);
    }

    public List<Orderdetails> findOrderdetailsEntities(int maxResults, int firstResult) {
        return findOrderdetailsEntities(false, maxResults, firstResult);
    }

    private List<Orderdetails> findOrderdetailsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orderdetails.class));
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

    public Orderdetails findOrderdetails(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orderdetails.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrderdetailsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orderdetails> rt = cq.from(Orderdetails.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
