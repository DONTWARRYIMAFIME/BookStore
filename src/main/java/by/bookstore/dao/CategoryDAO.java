package by.bookstore.dao;

import by.bookstore.entity.Category;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CategoryDAO extends JpaDAO<Category, Long> {

    public CategoryDAO(EntityManager entityManager) {
        super(entityManager);
    }

    public Optional<Category> findByName(String name) {
        return super.findWithQueryName("Category.findByName").findFirst();
    }

}
