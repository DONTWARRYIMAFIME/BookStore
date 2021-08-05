package by.bookstore;

import by.bookstore.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CustomerTest {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setEmail("ulas.kastsiukovich@gmail.com");
        customer.setFullName("Ulas Kastsiukovich");
        customer.setAddress("Chichurina 12");
        customer.setCity("Minsk");
        customer.setCountry("Belarus");
        customer.setPhoneNumber("+375291747481");
        customer.setZipCode("220055");
        customer.setPassword("12345678");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("USER_TEST: Transaction is completed successfully");


    }

}
