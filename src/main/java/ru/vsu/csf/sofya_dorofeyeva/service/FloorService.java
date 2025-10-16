package ru.vsu.csf.sofya_dorofeyeva.service;

import ru.vsu.csf.sofya_dorofeyeva.model.Floor;
import ru.vsu.csf.sofya_dorofeyeva.repository.FloorRepository;

import java.util.List;
import java.util.Optional;

public class FloorService implements ServiceInterface<Floor>{
    private final FloorRepository repository;

    public FloorService(FloorRepository repository) {
        this.repository = repository;
    }

    @Override
    public void add(Floor floor) {
        repository.add(floor);
    }

    @Override
    public void update(Floor floor) {
        repository.update(floor);
    }

    @Override
    public Optional<Floor> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Floor> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
