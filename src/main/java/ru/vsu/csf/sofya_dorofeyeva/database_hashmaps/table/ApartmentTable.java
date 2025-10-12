package ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table;

import ru.vsu.csf.sofya_dorofeyeva.model.Apartment;
import ru.vsu.csf.sofya_dorofeyeva.model.enums.ApartmentStatus;

import java.util.HashMap;
import java.util.Random;

public class ApartmentTable {
    private HashMap<Integer, Apartment> apartments;
    private int id;
    Random rnd = new Random();


    public ApartmentTable() {
        this.id = 1;
        this.apartments = new HashMap<>();
    }

    public HashMap<Integer, Apartment> getApartments() {
        return apartments;
    }

    public HashMap<Integer, Apartment> generateApartments() {
        apartments.clear();
        this.id = 1;

        for (int i = 0; i < 100; i++) {
            Integer apartmentId = id;

            int floorId = rnd.nextInt(11);
            Integer entrance = null;
            int apartmentNumber = rnd.nextInt(201);
            float totalArea = 25 + rnd.nextFloat() * 75;
            float livingArea = totalArea * (0.7f + rnd.nextFloat() * 0.2f);
            int roomsCount = rnd.nextInt(6);
            int price = (150 + rnd.nextInt(1501)) * 10000;
            ApartmentStatus status = ApartmentStatus.getRandomApartmentStatus();
            Integer clientId = null;
            Integer employeeId = null;

            Apartment apartment = new Apartment(apartmentId, floorId, entrance, apartmentNumber, totalArea, livingArea, roomsCount, price, status, clientId, employeeId);
            apartments.put(apartmentId, apartment);
            id++;
        }
        return apartments;
    }
}
