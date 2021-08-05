package by.bookstore;

import by.bookstore.entity.BookOrder;
import by.bookstore.entity.Customer;
import by.bookstore.entity.type.OrderStatus;
import by.bookstore.entity.type.PaymentMethod;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class BookOrderTest {

    public static void main(String[] args) {

        Customer customer = new Customer();
        customer.setEmail("test.customer@gmail.com");
        customer.setFullName("FirstName LastName");
        customer.setAddress("Address");
        customer.setCity("City");
        customer.setCountry("Country");
        customer.setPhoneNumber("+375*********");
        customer.setZipCode("XXXXX-YYYY");
        customer.setPassword("12345678");

        BookOrder order1 = new BookOrder();
        order1.setCustomer(customer);
        order1.setOrderDateTime(LocalDateTime.now());
        order1.setOrderTotal(38.9);
        order1.setRecipientFullName(customer.getFullName());
        order1.setRecipientPhoneNumber(customer.getPhoneNumber());
        order1.setShippingAddress(customer.getAddress());
        order1.setPaymentMethod(PaymentMethod.PAY_PAL);
        order1.setStatus(OrderStatus.IN_PROGRESS);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.persist(order1);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("BOOK_ORDER_TEST: Transaction is completed successfully");

    }

}
