package ru.vsu.csf.sofya_dorofeyeva.config;

import ru.vsu.csf.sofya_dorofeyeva.controller.*;
import ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.EstateDatabase;
import ru.vsu.csf.sofya_dorofeyeva.repository.*;
import ru.vsu.csf.sofya_dorofeyeva.service.*;

public class AppContext {
    private final EstateDatabase database = new EstateDatabase();

    public AppContext() {
        database.generateAllData();
    }

    public ApartmentController apartmentController() {
        return new ApartmentController(new ApartmentService(new ApartmentRepository(database.getApartmentTable())));
    }

    public BuildingController buildingController() {
        return new BuildingController(new BuildingService(new BuildingRepository(database.getBuildingTable())));
    }

    public ClientController clientController() {
        return new ClientController(new ClientService(new ClientRepository(database.getClientTable())));
    }

    public EmployeeController employeeController() {
        return new EmployeeController(new EmployeeService(new EmployeeRepository(database.getEmployeeTable())));
    }

    public FloorController floorController() {
        return new FloorController(new FloorService(new FloorRepository(database.getFloorTable())));
    }
}
