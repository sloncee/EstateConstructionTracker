package ru.vsu.csf.sofya_dorofeyeva.controller;

import java.util.List;
import java.util.Optional;

public interface ControllerInterface<T> {
    void add(T entity);
    void update(T entity);
    Optional<T> findById(int id);
    List<T> findAll();
    void deleteById(int id);
}
