package by.bookstore;

import by.bookstore.entity.Categories;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoriesTest {

    public static void main(String[] args) {
        Categories actionAndAdventure = new Categories("Action and Adventure");
        Categories classics = new Categories("Classics");
        Categories fantasy = new Categories("Fantasy");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookStore");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(actionAndAdventure);
        entityManager.persist(classics);
        entityManager.persist(fantasy);

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

        System.out.println("CATEGORIES_TEST: Transaction is completed successfully");

    }

}
