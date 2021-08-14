package by.bookstore.dao;

import java.util.List;

public interface GenericDAO<T, U> {

    T save(T t);

    T update(T t);

    T find(U id);

    List<T> findAll();

    void delete(U id);

    long count();

}
