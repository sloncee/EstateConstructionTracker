package ru.vsu.csf.sofya_dorofeyeva.service;

import ru.vsu.csf.sofya_dorofeyeva.model.Building;
import ru.vsu.csf.sofya_dorofeyeva.repository.BuildingRepository;

import java.util.List;
import java.util.Optional;

public class BuildingService implements ServiceInterface<Building> {
    private final BuildingRepository repository;

    public BuildingService(BuildingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Building building) {
        repository.add(building);
    }

    @Override
    public void update(Building building) {
        repository.update(building);
    }

    @Override
    public Optional<Building> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Building> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
