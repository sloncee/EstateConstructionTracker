package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table.FloorTable;
import ru.vsu.csf.sofya_dorofeyeva.model.Floor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FloorRepository implements RepositoryInterface<Floor> {
    private final FloorTable floorTable;

    public FloorRepository(FloorTable floorTable) {
        this.floorTable = floorTable;
    }

    @Override
    public void save(Floor floor) {
        floorTable.getFloors().put(floor.getId(), floor);
    }

    @Override
    public Optional<Floor> findById(int id) {
        return Optional.ofNullable(floorTable.getFloors().get(id));
    }

    @Override
    public List<Floor> findAll() {
        return new ArrayList<>(floorTable.getFloors().values());
    }

    @Override
    public void deleteById(int id) {
        floorTable.getFloors().remove(id);
    }
}
