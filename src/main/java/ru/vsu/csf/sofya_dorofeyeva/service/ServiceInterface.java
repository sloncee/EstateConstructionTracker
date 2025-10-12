package ru.vsu.csf.sofya_dorofeyeva.service;

import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {
    void save(T entity);
    Optional<T> findById(int id);
    List<T> findAll();
    void deleteById(int id);
}
