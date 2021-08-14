package by.bookstore.dao;

import by.bookstore.entity.User;

import javax.persistence.EntityManager;
import java.util.Map;
import java.util.Optional;


public class UserDAO extends JpaDAO<User, Long> {

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Optional<User> findById(Long userId) {
        return Optional.ofNullable(super.find(userId));
    }

    public Optional<User> findByEmail(String email) {
        return super.findWithQueryName("User.findByEmail", Map.of("email", email)).findFirst();
    }

    public Optional<User> findByPhoneNumber(String phoneNumber) {
        return super.findWithQueryName("User.findByPhoneNumber", Map.of("phoneNumber", phoneNumber)).findFirst();
    }

}
