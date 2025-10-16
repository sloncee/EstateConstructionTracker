package ru.vsu.csf.sofya_dorofeyeva.model;

import ru.vsu.csf.sofya_dorofeyeva.model.enums.ApartmentStatus;

public class Apartment {
    private int id;
    private int floorId;
    private Integer entrance;
    private int apartmentNumber;
    private float totalArea;
    private float livingArea;
    private int roomsCount;
    private int price;
    private ApartmentStatus status;
    private Integer clientId;
    private Integer employeeId;


    public Apartment(int id, int floorId, Integer entrance, int apartmentNumber, float totalArea, float livingArea, int roomsCount, int price, ApartmentStatus status, Integer clientId, Integer employeeId) {
        this.id = id;
        this.floorId = floorId;
        this.entrance = entrance;
        this.apartmentNumber = apartmentNumber;
        this.totalArea = totalArea;
        this.livingArea = livingArea;
        this.roomsCount = roomsCount;
        this.price = price;
        this.status = status;
        this.clientId = clientId;
        this.employeeId = employeeId;
    }

    public Apartment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getEntrance() {
        return entrance;
    }

    public void setEntrance(int entrance) {
        this.entrance = entrance;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(int apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    public float getLivingArea() {
        return livingArea;
    }

    public void setLivingArea(float livingArea) {
        this.livingArea = livingArea;
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ApartmentStatus getStatus() {
        return status;
    }

    public void setStatus(ApartmentStatus status) {
        this.status = status;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "apartmentId=" + id +
                ", floorId=" + floorId +
                ", entrance=" + entrance +
                ", apartmentNumber=" + apartmentNumber +
                ", totalArea=" + totalArea +
                ", livingArea=" + livingArea +
                ", roomsCount=" + roomsCount +
                ", price=" + price +
                ", status=" + status +
                ", clientId=" + clientId +
                ", employeeId=" + employeeId +
                '}';
    }
}
