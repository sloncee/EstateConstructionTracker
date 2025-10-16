package ru.vsu.csf.sofya_dorofeyeva.controller;

import ru.vsu.csf.sofya_dorofeyeva.model.Apartment;
import ru.vsu.csf.sofya_dorofeyeva.service.ApartmentService;

import java.util.List;
import java.util.Optional;

public class ApartmentController implements ControllerInterface<Apartment> {
    private final ApartmentService service;

    public ApartmentController(ApartmentService service) {
        this.service = service;
    }

    @Override
    public void add(Apartment apartment) {
        service.add(apartment);
    }

    @Override
    public void update(Apartment apartment) {
        service.update(apartment);
    }

    @Override
    public Optional<Apartment> findById(int id) {
        return service.findById(id);
    }

    @Override
    public List<Apartment> findAll() {
        return service.findAll();
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}
