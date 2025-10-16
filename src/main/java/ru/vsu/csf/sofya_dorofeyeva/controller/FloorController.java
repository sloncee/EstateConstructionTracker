package ru.vsu.csf.sofya_dorofeyeva.controller;

import ru.vsu.csf.sofya_dorofeyeva.model.Floor;
import ru.vsu.csf.sofya_dorofeyeva.service.FloorService;

import java.util.List;
import java.util.Optional;

public class FloorController implements ControllerInterface<Floor> {
    private final FloorService service;

    public FloorController(FloorService service) {
        this.service = service;
    }

    @Override
    public void add(Floor floor) {
        service.add(floor);
    }

    @Override
    public void update(Floor floor) {
        service.update(floor);
    }

    @Override
    public Optional<Floor> findById(int id) {
        return service.findById(id);
    }

    @Override
    public List<Floor> findAll() {
        return service.findAll();
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}
