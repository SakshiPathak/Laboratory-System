/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity.controller;

import in.laboratory.entity.Biochemistry;
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
public class BiochemistryJpaController implements Serializable {

    public BiochemistryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Biochemistry biochemistry) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(biochemistry);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Biochemistry biochemistry) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            biochemistry = em.merge(biochemistry);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = biochemistry.getId();
                if (findBiochemistry(id) == null) {
                    throw new NonexistentEntityException("The biochemistry with id " + id + " no longer exists.");
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
            Biochemistry biochemistry;
            try {
                biochemistry = em.getReference(Biochemistry.class, id);
                biochemistry.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The biochemistry with id " + id + " no longer exists.", enfe);
            }
            em.remove(biochemistry);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Biochemistry> findBiochemistryEntities() {
        return findBiochemistryEntities(true, -1, -1);
    }

    public List<Biochemistry> findBiochemistryEntities(int maxResults, int firstResult) {
        return findBiochemistryEntities(false, maxResults, firstResult);
    }

    private List<Biochemistry> findBiochemistryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Biochemistry.class));
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

    public Biochemistry findBiochemistry(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Biochemistry.class, id);
        } finally {
            em.close();
        }
    }

    public int getBiochemistryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Biochemistry> rt = cq.from(Biochemistry.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
