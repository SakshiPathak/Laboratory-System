/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity.controller;

import in.laboratory.entity.CompleteBloodCount;
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
public class CompleteBloodCountJpaController implements Serializable {

    public CompleteBloodCountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(CompleteBloodCount completeBloodCount) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(completeBloodCount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(CompleteBloodCount completeBloodCount) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            completeBloodCount = em.merge(completeBloodCount);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = completeBloodCount.getId();
                if (findCompleteBloodCount(id) == null) {
                    throw new NonexistentEntityException("The completeBloodCount with id " + id + " no longer exists.");
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
            CompleteBloodCount completeBloodCount;
            try {
                completeBloodCount = em.getReference(CompleteBloodCount.class, id);
                completeBloodCount.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The completeBloodCount with id " + id + " no longer exists.", enfe);
            }
            em.remove(completeBloodCount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<CompleteBloodCount> findCompleteBloodCountEntities() {
        return findCompleteBloodCountEntities(true, -1, -1);
    }

    public List<CompleteBloodCount> findCompleteBloodCountEntities(int maxResults, int firstResult) {
        return findCompleteBloodCountEntities(false, maxResults, firstResult);
    }

    private List<CompleteBloodCount> findCompleteBloodCountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(CompleteBloodCount.class));
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

    public CompleteBloodCount findCompleteBloodCount(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(CompleteBloodCount.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompleteBloodCountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<CompleteBloodCount> rt = cq.from(CompleteBloodCount.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
