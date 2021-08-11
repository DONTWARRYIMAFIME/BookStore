package by.bookstore.dao;

import by.bookstore.entity.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static UserDAO userDAO;

    @BeforeAll
    static void setupClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        entityManager = entityManagerFactory.createEntityManager();
        userDAO = new UserDAO(entityManager);
    }

    @Test
    void createValidUser() {
        User user = new User();
        user.setFirstName("Ulas");
        user.setLastName("Kastsiukovich");
        user.setPhoneNumber("+375291747481");
        user.setDob(LocalDate.of(2001, Month.JULY, 31));
        user.setEmail("ulas.kastsiukovich@gmail.com");
        user.setImageUrl("/");
        user.setPassword("12345678");

        User createdUser = userDAO.save(user);

        assertTrue(createdUser.getUserId() > 0);
    }

    @Test
    void createDuplicatedUser() {
        User user = new User();
        user.setFirstName("Ulas");
        user.setLastName("Kastsiukovich");
        user.setPhoneNumber("+375291747481");
        user.setDob(LocalDate.of(2001, Month.JULY, 31));
        user.setEmail("ulas.kastsiukovich@gmail.com");
        user.setImageUrl("/");
        user.setPassword("12345678");

        assertThrows(PersistenceException.class, () -> userDAO.save(user));
    }

    @Test
    void createUserWithoutFields() {
        User user = new User();
        assertThrows(PersistenceException.class, () -> userDAO.save(user));
    }

    @Test
    void updateValidUser() {
        User user = new User();
        user.setUserId(6L);
        user.setFirstName("Ulas");
        user.setLastName("Kastsiukovich");
        user.setPhoneNumber("+375291747481");
        user.setDob(LocalDate.of(2001, Month.JULY, 31));
        user.setEmail("ulas.kastsiukovich@gmail.com");
        user.setImageUrl("/");
        user.setPassword("qwerty");

        user = userDAO.update(user);

        String expected = "qwerty";
        String actual = user.getPassword();

        assertEquals(expected, actual);
    }

    @Test
    void updateUserWithInvalidId() {
        User user = new User();
        user.setUserId(-123L);
        user.setFirstName("Ulas");
        user.setLastName("Kastsiukovich");
        user.setPhoneNumber("+375291747481");
        user.setDob(LocalDate.of(2001, Month.JULY, 31));
        user.setEmail("ulas.kastsiukovich@gmail.com");
        user.setImageUrl("/");
        user.setPassword("qwerty");

        assertThrows(PersistenceException.class, () -> userDAO.update(user));
    }

    @Test
    void findByIdWithCorrectId() {
        long id = 2;
        User user = userDAO.findById(id);

        assertNotNull(user);
    }

    @Test
    void findByIdWithIncorrectId() {
        long id = -5;
        User user = userDAO.findById(id);

        assertNull(user);
    }

    @Test
    void deleteCorrectUser() {
        long id = 6;
        userDAO.delete(id);

        User user = userDAO.findById(id);
        assertNull(user);
    }

    @Test
    void deleteIncorrectUser() {
        long id = -5;
        assertThrows(EntityNotFoundException.class, () -> userDAO.delete(id));
    }

    @Test
    void findAllUsers() {
        List<User> users = userDAO.findAll();

        if (users != null) {
            for (User user : users) {
                System.out.println(user);
            }
        }

        assertNotNull(users);
    }

    @Test
    void customQueryFindAllUsers() {
        List<User> users = userDAO.findWithQueryName("User.findAll");

        if (users != null) {
            for (User user : users) {
                System.out.println(user);
            }
        }

        assertNotNull(users);
    }

    @Test
    void countUsers() {
        long count = userDAO.count();
        System.out.println("Count : " + count);
        assertTrue(count > 0);
    }

    @AfterAll
    static void tearDownClass() {
        entityManager.close();
        entityManagerFactory.close();
    }

}