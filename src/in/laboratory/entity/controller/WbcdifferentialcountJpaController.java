/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity.controller;

import in.laboratory.entity.controller.exceptions.NonexistentEntityException;
import in.laboratory.gui.Wbcdifferentialcount;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author sakshi
 */
public class WbcdifferentialcountJpaController implements Serializable {

    public WbcdifferentialcountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Wbcdifferentialcount wbcdifferentialcount) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(wbcdifferentialcount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Wbcdifferentialcount wbcdifferentialcount) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            wbcdifferentialcount = em.merge(wbcdifferentialcount);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = wbcdifferentialcount.getId();
                if (findWbcdifferentialcount(id) == null) {
                    throw new NonexistentEntityException("The wbcdifferentialcount with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Wbcdifferentialcount wbcdifferentialcount;
            try {
                wbcdifferentialcount = em.getReference(Wbcdifferentialcount.class, id);
                wbcdifferentialcount.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The wbcdifferentialcount with id " + id + " no longer exists.", enfe);
            }
            em.remove(wbcdifferentialcount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Wbcdifferentialcount> findWbcdifferentialcountEntities() {
        return findWbcdifferentialcountEntities(true, -1, -1);
    }

    public List<Wbcdifferentialcount> findWbcdifferentialcountEntities(int maxResults, int firstResult) {
        return findWbcdifferentialcountEntities(false, maxResults, firstResult);
    }

    private List<Wbcdifferentialcount> findWbcdifferentialcountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Wbcdifferentialcount.class));
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

    public Wbcdifferentialcount findWbcdifferentialcount(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Wbcdifferentialcount.class, id);
        } finally {
            em.close();
        }
    }

    public int getWbcdifferentialcountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Wbcdifferentialcount> rt = cq.from(Wbcdifferentialcount.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
