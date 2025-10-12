package ru.vsu.csf.sofya_dorofeyeva.model.enums;

import java.util.Random;

public enum ApartmentStatus {
    AVAILABLE,
    RESERVED,
    SOLD;

    private static final Random rnd = new Random();

    public static ApartmentStatus getRandomApartmentStatus() {
        ApartmentStatus[] apartmentStatuses = values();
        return apartmentStatuses[rnd.nextInt(apartmentStatuses.length)];
    }
}
