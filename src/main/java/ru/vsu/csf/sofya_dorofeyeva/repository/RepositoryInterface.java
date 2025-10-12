package ru.vsu.csf.sofya_dorofeyeva.repository;

import java.util.List;
import java.util.Optional;

public interface RepositoryInterface<T> {
    void save(T entity);
    Optional<T> findById(int id);
    List<T> findAll();
    void deleteById(int id);
}
