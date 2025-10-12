package ru.vsu.csf.sofya_dorofeyeva.controller;

import ru.vsu.csf.sofya_dorofeyeva.model.Building;
import ru.vsu.csf.sofya_dorofeyeva.service.BuildingService;

import java.util.List;
import java.util.Optional;

public class BuildingController implements ControllerInterface<Building> {
    private final BuildingService service;

    public BuildingController(BuildingService service) {
        this.service = service;
    }

    @Override
    public void save(Building building) {
        service.save(building);
    }

    @Override
    public Optional<Building> findById(int id) {
        return service.findById(id);
    }

    @Override
    public List<Building> findAll() {
        return service.findAll();
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}
