package ru.vsu.csf.sofya_dorofeyeva.config;

import ru.vsu.csf.sofya_dorofeyeva.controller.*;
import ru.vsu.csf.sofya_dorofeyeva.database.mysql.DatabaseConnection;
import ru.vsu.csf.sofya_dorofeyeva.repository.*;
import ru.vsu.csf.sofya_dorofeyeva.service.*;

import java.sql.Connection;
import java.sql.SQLException;

public class AppContext implements AutoCloseable {
    private final Connection connection;

    public AppContext() {
        try {
            this.connection = DatabaseConnection.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database", e);
        }
    }

    public ApartmentController apartmentController() {
        return new ApartmentController(new ApartmentService(new ApartmentRepository(connection)));
    }

    public BuildingController buildingController() {
        return new BuildingController(new BuildingService(new BuildingRepository(connection)));
    }

    public ClientController clientController() {
        return new ClientController(new ClientService(new ClientRepository(connection)));
    }

    public EmployeeController employeeController() {
        return new EmployeeController(new EmployeeService(new EmployeeRepository(connection)));
    }

    public FloorController floorController() {
        return new FloorController(new FloorService(new FloorRepository(connection)));
    }

    @Override
    public void close() {
        try {
            if (connection != null && !connection.isClosed())
                connection.close();
        } catch (SQLException e) {
            System.err.println("Error closing the connection: " + e.getMessage());
        }
    }
}
