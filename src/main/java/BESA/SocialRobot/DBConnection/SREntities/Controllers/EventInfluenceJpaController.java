/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BESA.SocialRobot.DBConnection.SREntities.Controllers;

import BESA.SocialRobot.DBConnection.SREntities.Controllers.exceptions.NonexistentEntityException;
import BESA.SocialRobot.DBConnection.SREntities.Controllers.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import BESA.SocialRobot.DBConnection.SREntities.EmotionalEntities.EmotionAxisConf;
import BESA.SocialRobot.DBConnection.SREntities.EmotionalEntities.EventInfluence;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author tesispepper
 */
public class EventInfluenceJpaController implements Serializable {

    public EventInfluenceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EventInfluence eventInfluence) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EmotionAxisConf emotionalAxisConfigId = eventInfluence.getEmotionalAxisConfigId();
            if (emotionalAxisConfigId != null) {
                emotionalAxisConfigId = em.getReference(emotionalAxisConfigId.getClass(), emotionalAxisConfigId.getId());
                eventInfluence.setEmotionalAxisConfigId(emotionalAxisConfigId);
            }
            em.persist(eventInfluence);
            if (emotionalAxisConfigId != null) {
                emotionalAxisConfigId.getEventInfluenceList().add(eventInfluence);
                emotionalAxisConfigId = em.merge(emotionalAxisConfigId);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEventInfluence(eventInfluence.getId()) != null) {
                throw new PreexistingEntityException("EventInfluence " + eventInfluence + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EventInfluence eventInfluence) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EventInfluence persistentEventInfluence = em.find(EventInfluence.class, eventInfluence.getId());
            EmotionAxisConf emotionalAxisConfigIdOld = persistentEventInfluence.getEmotionalAxisConfigId();
            EmotionAxisConf emotionalAxisConfigIdNew = eventInfluence.getEmotionalAxisConfigId();
            if (emotionalAxisConfigIdNew != null) {
                emotionalAxisConfigIdNew = em.getReference(emotionalAxisConfigIdNew.getClass(), emotionalAxisConfigIdNew.getId());
                eventInfluence.setEmotionalAxisConfigId(emotionalAxisConfigIdNew);
            }
            eventInfluence = em.merge(eventInfluence);
            if (emotionalAxisConfigIdOld != null && !emotionalAxisConfigIdOld.equals(emotionalAxisConfigIdNew)) {
                emotionalAxisConfigIdOld.getEventInfluenceList().remove(eventInfluence);
                emotionalAxisConfigIdOld = em.merge(emotionalAxisConfigIdOld);
            }
            if (emotionalAxisConfigIdNew != null && !emotionalAxisConfigIdNew.equals(emotionalAxisConfigIdOld)) {
                emotionalAxisConfigIdNew.getEventInfluenceList().add(eventInfluence);
                emotionalAxisConfigIdNew = em.merge(emotionalAxisConfigIdNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = eventInfluence.getId();
                if (findEventInfluence(id) == null) {
                    throw new NonexistentEntityException("The eventInfluence with id " + id + " no longer exists.");
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
            EventInfluence eventInfluence;
            try {
                eventInfluence = em.getReference(EventInfluence.class, id);
                eventInfluence.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The eventInfluence with id " + id + " no longer exists.", enfe);
            }
            EmotionAxisConf emotionalAxisConfigId = eventInfluence.getEmotionalAxisConfigId();
            if (emotionalAxisConfigId != null) {
                emotionalAxisConfigId.getEventInfluenceList().remove(eventInfluence);
                emotionalAxisConfigId = em.merge(emotionalAxisConfigId);
            }
            em.remove(eventInfluence);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EventInfluence> findEventInfluenceEntities() {
        return findEventInfluenceEntities(true, -1, -1);
    }

    public List<EventInfluence> findEventInfluenceEntities(int maxResults, int firstResult) {
        return findEventInfluenceEntities(false, maxResults, firstResult);
    }

    private List<EventInfluence> findEventInfluenceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EventInfluence.class));
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

    public EventInfluence findEventInfluence(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EventInfluence.class, id);
        } finally {
            em.close();
        }
    }

    public int getEventInfluenceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EventInfluence> rt = cq.from(EventInfluence.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
