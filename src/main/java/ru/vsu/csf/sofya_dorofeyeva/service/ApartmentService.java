package ru.vsu.csf.sofya_dorofeyeva.service;

import ru.vsu.csf.sofya_dorofeyeva.model.Apartment;
import ru.vsu.csf.sofya_dorofeyeva.repository.ApartmentRepository;

import java.util.List;
import java.util.Optional;

public class ApartmentService implements ServiceInterface<Apartment> {
    private final ApartmentRepository repository;

    public ApartmentService(ApartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Apartment apartment) {
        repository.add(apartment);
    }

    @Override
    public void update(Apartment apartment) {
        repository.update(apartment);
    }

    @Override
    public Optional<Apartment> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Apartment> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
