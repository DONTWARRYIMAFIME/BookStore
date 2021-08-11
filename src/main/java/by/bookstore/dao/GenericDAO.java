package by.bookstore.dao;

import java.util.List;

public interface GenericDAO<T, U> {

    T save(T t);

    T update(T t);

    T find(Class<T> type, U id);

    List<T> findAll(Class<T> type);

    void delete(Class<T> type, U id);

    long count(Class<T> type);

}
