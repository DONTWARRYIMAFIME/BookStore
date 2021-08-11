package by.bookstore.dao;

import by.bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class JpaDAO<T,U> implements GenericDAO<T,U> {

    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public T save(T entity) {
        entityManager.getTransaction().begin();

        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);

        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public T update(T entity) {
        entityManager.getTransaction().begin();

        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public T find(Class<T> type, U id) {
        T entity = entityManager.find(type, id);

        if (entity != null)
            entityManager.refresh(entity);

        return entity;
    }

    @Override
    public List<T> findAll(Class<T> type) {
        Query query = entityManager.createQuery("SELECT u FROM " + type.getName() + " u");
        return query.getResultList();
    }

    @Override
    public void delete(Class<T> type, U id) {
        entityManager.getTransaction().begin();

        Object reference = entityManager.getReference(type, id);
        entityManager.remove(reference);

        entityManager.getTransaction().commit();
    }

    @Override
    public long count(Class<T> type) {
        Query query = entityManager.createQuery("SELECT Count(u) FROM " + type.getName() + " u");
        return (long)query.getSingleResult();
    }

    public List<T> findWithQueryName(String queryName) {
        Query query = entityManager.createNamedQuery(queryName);
        return query.getResultList();
    }

}
