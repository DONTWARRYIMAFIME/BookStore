package by.bookstore;

import by.bookstore.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoryTest {

    public static void main(String[] args) {
        Category actionAndAdventure = new Category("Action and Adventure");
        Category classics = new Category("Classics");
        Category fantasy = new Category("Fantasy");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(actionAndAdventure);
        entityManager.persist(classics);
        entityManager.persist(fantasy);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("CATEGORY_TEST: Transaction is completed successfully");

    }

}
