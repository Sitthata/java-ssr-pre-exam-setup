package sit.int202.preexamsetup.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceException;
import sit.int202.preexamsetup.entities.Office;
import sit.int202.preexamsetup.utils.EntityManagerBuilder;

import java.util.List;

public class OfficeRepository {
    EntityManager em;

    public EntityManager getEntityManager() {
        if (em == null || !em.isOpen()) {
            em = EntityManagerBuilder.getEntityManager();
        }
        return em;
    }

    public Office findById(String id) {
        return getEntityManager().find(Office.class, id);
    }

    public List<Office> findAll() {
        return getEntityManager()
                .createNamedQuery("Office.findAll", Office.class)
                .getResultList();
    }

    public void create(Office office) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().commit();
            em.persist(office);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void update(Office office) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(office);
            em.getTransaction().commit();
        } catch (PersistenceException e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
