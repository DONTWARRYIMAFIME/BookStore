package by.bookstore;

import by.bookstore.entity.Book;
import by.bookstore.entity.Category;
import by.bookstore.entity.Customer;
import by.bookstore.entity.Review;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class ReviewTest {

    public static void main(String[] args) {

        Category category = new Category("ReviewTest");

        by.bookstore.entity.Book book1 = new Book();

        book1.setTitle("Book's title for ReviewTest");
        book1.setAuthor("Book's author");
        book1.setDescription("Book's description");
        book1.setIsbn("Book's isbn");
        book1.setPublishDateTime(LocalDateTime.now());
        book1.setUpdateDateTime(LocalDateTime.now());
        book1.setImageUrl("/");
        book1.setPrice(13.37);
        book1.setCategory(category);

        Customer customer = new Customer();
        customer.setEmail("Customer.ReviewTest@gmail.com");
        customer.setFullName("Customer for ReviewTest");
        customer.setAddress("Address");
        customer.setCity("Minsk");
        customer.setCountry("Belarus");
        customer.setPhoneNumber("*phone number*");
        customer.setZipCode("220055");
        customer.setPassword("12345678");

        ////
        Review review = new Review();
        review.setBook(book1);
        review.setCustomer(customer);
        review.setComment("Test comment for review");
        review.setRating(9.3F);
        review.setReviewDateTime(LocalDateTime.now());
        review.setHeadline("Review's headline");
        ////

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(category);
        entityManager.persist(book1);
        entityManager.persist(customer);
        entityManager.persist(review);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("REVIEW_TEST: Transaction is completed successfully");


    }

}
