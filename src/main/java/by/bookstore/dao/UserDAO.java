package by.bookstore.dao;

import by.bookstore.entity.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAO extends JpaDAO<User> implements GenericDAO<User, Long> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public User create(User user) {
        return super.create(user);
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User get(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> listAll() {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
