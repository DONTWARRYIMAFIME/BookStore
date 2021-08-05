package by.bookstore;

import by.bookstore.entity.Book;
import by.bookstore.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class BookTest {

    public static void main(String[] args) {
        Category fantasy = new Category("Science");

        Book book1 = new Book();

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

        System.out.println("BOOK_TEST: Transaction is completed successfully");

    }

}
