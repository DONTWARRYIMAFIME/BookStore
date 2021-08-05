package by.bookstore.dao;

import java.util.List;

public interface GenericDAO<T, U> {

    T create(T t);

    T update(T t);

    T get(U id);

    void delete(U id);

    List<T> listAll();

    long count();

}
