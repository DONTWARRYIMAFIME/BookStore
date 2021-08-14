package by.bookstore.dao;

import by.bookstore.entity.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class UserDAO extends JpaDAO<User, Long> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public List<User> findWithQueryName(String queryName) {
        return super.findWithQueryName(queryName);
    }

    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(super.find(userId));
    }

    public Optional<User> findByEmail(String email) {
        List<User> users = super.findWithQueryName("User.findByEmail", Map.of("email", email));
        User user = !users.isEmpty() ? users.get(0) : null;
        return Optional.ofNullable(user);
    }

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        List<User> users = super.findWithQueryName("User.findByEmail", Map.of("phoneNumber", phoneNumber));
        User user = !users.isEmpty() ? users.get(0) : null;
        return Optional.ofNullable(user);
    }

}
