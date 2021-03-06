package by.bookstore;

import by.bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.Month;

public class UserTest {

    public static void main(String[] args) {
        User user1 = new User();
        user1.setFirstName("Ulas");
        user1.setLastName("Kastsiukovich");
        user1.setPhoneNumber("+375291747481");
        user1.setDob(LocalDate.of(2001, Month.JULY, 31));
        user1.setEmail("ulas.kastsiukovich@gmail.com");
        user1.setImageUrl("/");
        user1.setPassword("12345678");

        User user2 = new User();
        user2.setFirstName("Artem");
        user2.setLastName("Marchenko");
        user2.setPhoneNumber("+375297778899");
        user2.setDob(LocalDate.of(2002, Month.JUNE, 5));
        user2.setEmail("Artem.Marchenko@gmail.com");
        user2.setImageUrl("/");
        user2.setPassword("12345678");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(user1);
        entityManager.persist(user2);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("USER_TEST: Transaction is completed successfully");

    }

}
