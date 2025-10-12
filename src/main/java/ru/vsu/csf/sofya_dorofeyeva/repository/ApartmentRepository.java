package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table.ApartmentTable;
import ru.vsu.csf.sofya_dorofeyeva.model.Apartment;

import java.util.*;

public class ApartmentRepository implements RepositoryInterface<Apartment> {
    private final ApartmentTable apartmentTable;

    public ApartmentRepository(ApartmentTable apartmentTable) {
        this.apartmentTable = apartmentTable;
    }

    @Override
    public void save(Apartment apartment) {
        apartmentTable.getApartments().put(apartment.getId(), apartment);
    }

    @Override
    public Optional<Apartment> findById(int id) {
        return Optional.ofNullable(apartmentTable.getApartments().get(id));
    }

    @Override
    public List<Apartment> findAll() {
        return new ArrayList<>(apartmentTable.getApartments().values());
    }

    @Override
    public void deleteById(int id) {
        apartmentTable.getApartments().remove(id);
    }
}
