/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity.controller;

import in.laboratory.entity.WBCDifferentialCount;
import in.laboratory.entity.controller.exceptions.NonexistentEntityException;
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
public class WBCDifferentialCountJpaController implements Serializable {

    public WBCDifferentialCountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(WBCDifferentialCount WBCDifferentialCount) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(WBCDifferentialCount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(WBCDifferentialCount WBCDifferentialCount) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            WBCDifferentialCount = em.merge(WBCDifferentialCount);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = WBCDifferentialCount.getId();
                if (findWBCDifferentialCount(id) == null) {
                    throw new NonexistentEntityException("The wBCDifferentialCount with id " + id + " no longer exists.");
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
            WBCDifferentialCount WBCDifferentialCount;
            try {
                WBCDifferentialCount = em.getReference(WBCDifferentialCount.class, id);
                WBCDifferentialCount.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The WBCDifferentialCount with id " + id + " no longer exists.", enfe);
            }
            em.remove(WBCDifferentialCount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<WBCDifferentialCount> findWBCDifferentialCountEntities() {
        return findWBCDifferentialCountEntities(true, -1, -1);
    }

    public List<WBCDifferentialCount> findWBCDifferentialCountEntities(int maxResults, int firstResult) {
        return findWBCDifferentialCountEntities(false, maxResults, firstResult);
    }

    private List<WBCDifferentialCount> findWBCDifferentialCountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(WBCDifferentialCount.class));
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

    public WBCDifferentialCount findWBCDifferentialCount(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(WBCDifferentialCount.class, id);
        } finally {
            em.close();
        }
    }

    public int getWBCDifferentialCountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<WBCDifferentialCount> rt = cq.from(WBCDifferentialCount.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
