package ru.vsu.csf.sofya_dorofeyeva.database_hashmaps;

import ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table.*;

public class EstateDatabase {
    private ApartmentTable apartmentTable;
    private BuildingTable buildingTable;
    private ClientTable clientTable;
    private EmployeeTable employeeTable;
    private FloorTable floorTable;


    public EstateDatabase() {
        this.apartmentTable = new ApartmentTable();
        this.buildingTable = new BuildingTable();
        this.clientTable = new ClientTable();
        this.employeeTable = new EmployeeTable();
        this.floorTable = new FloorTable();
    }

    public void generateAllData() {
        this.buildingTable.generateBuildings();
        this.floorTable.generateFloors();
        this.employeeTable.generateEmployees();
        this.clientTable.generateClients();
        this.apartmentTable.generateApartments();
    }

    public ApartmentTable getApartmentTable() {
        return apartmentTable;
    }

    public void setApartmentTable(ApartmentTable apartmentTable) {
        this.apartmentTable = apartmentTable;
    }

    public BuildingTable getBuildingTable() {
        return buildingTable;
    }

    public void setBuildingTable(BuildingTable buildingTable) {
        this.buildingTable = buildingTable;
    }

    public ClientTable getClientTable() {
        return clientTable;
    }

    public void setClientTable(ClientTable clientTable) {
        this.clientTable = clientTable;
    }

    public EmployeeTable getEmployeeTable() {
        return employeeTable;
    }

    public void setEmployeeTable(EmployeeTable employeeTable) {
        this.employeeTable = employeeTable;
    }

    public FloorTable getFloorTable() {
        return floorTable;
    }

    public void setFloorTable(FloorTable floorTable) {
        this.floorTable = floorTable;
    }
}
