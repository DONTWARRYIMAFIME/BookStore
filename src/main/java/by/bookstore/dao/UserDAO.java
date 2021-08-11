package by.bookstore.dao;

import by.bookstore.entity.User;

import javax.persistence.EntityManager;
import java.util.List;


public class UserDAO extends JpaDAO<User, Long> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public User findById(Long id) {
        return super.find(User.class, id);
    }

    public List<User> findAll() {
        return super.findAll(User.class);
    }

    public long count() {
        return super.count(User.class);
    }

    public void delete(Long id) {
        super.delete(User.class, id);
    }

    public List<User> findWithQueryName(String queryName) {
        return super.findWithQueryName(queryName);
    }

}
