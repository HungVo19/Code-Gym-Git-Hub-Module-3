package service;

import java.util.List;

public interface ICoreCRUDService<E,K> {
    List<E> findAll();
    E findById(K id);
    void save(E e);
    void deleteById(K id);
}
