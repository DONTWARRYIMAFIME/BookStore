package by.bookstore;

import by.bookstore.entity.Book;
import by.bookstore.entity.Category;
import by.bookstore.entity.OrderDetail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class OrderDetailTest {

    public static void main(String[] args) {

        Category fantasy = new Category("OrderDetailTest");

        by.bookstore.entity.Book book1 = new Book();

        book1.setTitle("Book's title for test order details");
        book1.setAuthor("Book's author");
        book1.setDescription("Book's description");
        book1.setIsbn("Book's isbn");
        book1.setPublishDateTime(LocalDateTime.now());
        book1.setUpdateDateTime(LocalDateTime.now());
        book1.setImageUrl("/");
        book1.setPrice(228.322);
        book1.setCategory(fantasy);

        ////
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setBook(book1);
        orderDetail.setQuantity(6);
        orderDetail.setSubtotal(book1.getPrice() * 6);
        ////

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(fantasy);
        entityManager.persist(book1);
        entityManager.persist(orderDetail);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("ORDER_DETAILS_TEST: Transaction is completed successfully");


    }

}
