package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table.BuildingTable;
import ru.vsu.csf.sofya_dorofeyeva.model.Building;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BuildingRepository implements RepositoryInterface<Building> {
    private final BuildingTable buildingTable;

    public BuildingRepository(BuildingTable buildingTable) {
        this.buildingTable = buildingTable;
    }

    @Override
    public void save(Building building) {
        buildingTable.getBuildings().put(building.getId(), building);
    }

    @Override
    public Optional<Building> findById(int id) {
        return Optional.ofNullable(buildingTable.getBuildings().get(id));
    }

    @Override
    public List<Building> findAll() {
        return new ArrayList<>(buildingTable.getBuildings().values());
    }

    @Override
    public void deleteById(int id) {
        buildingTable.getBuildings().remove(id);
    }
}
