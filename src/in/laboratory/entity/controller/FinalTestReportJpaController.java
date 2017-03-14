/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.laboratory.entity.controller;

import in.laboratory.entity.FinalTestReport;
import in.laboratory.entity.controller.exceptions.NonexistentEntityException;
import in.laboratory.gui.Finaltestreport_1;
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
public class FinalTestReportJpaController implements Serializable {

    public FinalTestReportJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FinalTestReport finalTestReport) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(finalTestReport);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FinalTestReport finalTestReport) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            finalTestReport = em.merge(finalTestReport);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = finalTestReport.getId();
                if (findFinalTestReport(id) == null) {
                    throw new NonexistentEntityException("The finalTestReport with id " + id + " no longer exists.");
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
            FinalTestReport finalTestReport;
            try {
                finalTestReport = em.getReference(FinalTestReport.class, id);
                finalTestReport.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The finalTestReport with id " + id + " no longer exists.", enfe);
            }
            em.remove(finalTestReport);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FinalTestReport> findFinalTestReportEntities() {
        return findFinalTestReportEntities(true, -1, -1);
    }

    public List<FinalTestReport> findFinalTestReportEntities(int maxResults, int firstResult) {
        return findFinalTestReportEntities(false, maxResults, firstResult);
    }

    private List<FinalTestReport> findFinalTestReportEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FinalTestReport.class));
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

    public FinalTestReport findFinalTestReport(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FinalTestReport.class, id);
        } finally {
            em.close();
        }
    }

    public int getFinalTestReportCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FinalTestReport> rt = cq.from(FinalTestReport.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void create(Finaltestreport_1 finaltestreport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
