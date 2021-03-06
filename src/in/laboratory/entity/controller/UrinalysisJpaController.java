/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity.controller;

import in.laboratory.entity.Urinalysis;
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
public class UrinalysisJpaController implements Serializable {

    public UrinalysisJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Urinalysis urinalysis) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(urinalysis);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Urinalysis urinalysis) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            urinalysis = em.merge(urinalysis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = urinalysis.getId();
                if (findUrinalysis(id) == null) {
                    throw new NonexistentEntityException("The urinalysis with id " + id + " no longer exists.");
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
            Urinalysis urinalysis;
            try {
                urinalysis = em.getReference(Urinalysis.class, id);
                urinalysis.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The urinalysis with id " + id + " no longer exists.", enfe);
            }
            em.remove(urinalysis);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Urinalysis> findUrinalysisEntities() {
        return findUrinalysisEntities(true, -1, -1);
    }

    public List<Urinalysis> findUrinalysisEntities(int maxResults, int firstResult) {
        return findUrinalysisEntities(false, maxResults, firstResult);
    }

    private List<Urinalysis> findUrinalysisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Urinalysis.class));
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

    public Urinalysis findUrinalysis(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Urinalysis.class, id);
        } finally {
            em.close();
        }
    }

    public int getUrinalysisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Urinalysis> rt = cq.from(Urinalysis.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
