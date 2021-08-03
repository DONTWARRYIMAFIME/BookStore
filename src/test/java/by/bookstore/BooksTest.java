package by.bookstore;

import by.bookstore.entity.Books;
import by.bookstore.entity.Categories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class BooksTest {

    public static void main(String[] args) {
        Categories fantasy = new Categories("Fantasy");

        Books book1 = new Books();

        book1.setTitle("Book's title");
        book1.setAuthor("Book's author");
        book1.setDescription("Book's description");
        book1.setIsbn("Book's isbn");
        book1.setPublishDateTime(LocalDateTime.now());
        book1.setUpdateDateTime(LocalDateTime.now());
        book1.setImageUrl("/");
        book1.setPrice(28.4);
        book1.setCategory(fantasy);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(fantasy);
        entityManager.persist(book1);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("BOOKS_TEST: Transaction is completed successfully");

    }

}
