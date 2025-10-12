package ru.vsu.csf.sofya_dorofeyeva.console;

import ru.vsu.csf.sofya_dorofeyeva.controller.*;
import ru.vsu.csf.sofya_dorofeyeva.model.*;
import ru.vsu.csf.sofya_dorofeyeva.model.enums.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Console {

    public static void start(ApartmentController apartmentController, BuildingController buildingController, ClientController clientController, EmployeeController employeeController, FloorController floorController) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1. Apartments");
            System.out.println("2. Buildings");
            System.out.println("3. Clients");
            System.out.println("4. Employees");
            System.out.println("5. Floors");
            System.out.println("0. Exit");
            System.out.print("Choose entity: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> handleEntityMenu(scanner, apartmentController, "Apartment");
                case "2" -> handleEntityMenu(scanner, buildingController, "Building");
                case "3" -> handleEntityMenu(scanner, clientController, "Client");
                case "4" -> handleEntityMenu(scanner, employeeController, "Employee");
                case "5" -> handleEntityMenu(scanner, floorController, "Floor");
                case "0" -> running = false;
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
        System.out.println("Exiting program.");
    }

    private static <T> void handleEntityMenu(Scanner scanner, ControllerInterface<T> controller, String entityName) {
        boolean back = false;

        while (!back) {
            System.out.println("\n=== " + entityName + " Menu ===");
            System.out.println("1. Show all");
            System.out.println("2. Find by ID");
            System.out.println("3. Add");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");
            System.out.print("Choose action: ");

            String action = scanner.nextLine();

            switch (action) {
                case "1" -> controller.findAll().forEach(System.out::println);
                case "2" -> {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    controller.findById(id).ifPresentOrElse(
                            System.out::println,
                            () -> System.out.println(entityName + " not found")
                    );
                }
                case "3" -> {

                    addEntity(scanner, controller, entityName);
                }
                case "4" -> updateEntity(scanner, controller, entityName);
                case "5" -> {
                    System.out.print("Enter ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    controller.deleteById(id);
                    System.out.println(entityName + " deleted");
                }
                case "0" -> back = true;
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static <T> void addEntity(Scanner scanner, ControllerInterface<T> controller, String entityName) {
        switch (entityName) {
            case "Apartment" -> {
                System.out.print("Enter apartment ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter floor ID: ");
                int floorId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter entrance (0 if none): ");
                String entranceInput = scanner.nextLine();
                Integer entrance = entranceInput.isEmpty() || entranceInput.equals("0") ? null : Integer.parseInt(entranceInput);
                System.out.print("Enter apartment number: ");
                int apartmentNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter total area: ");
                float totalArea = Float.parseFloat(scanner.nextLine());
                System.out.print("Enter living area: ");
                float livingArea = Float.parseFloat(scanner.nextLine());
                System.out.print("Enter rooms count: ");
                int roomsCount = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter price: ");
                int price = Integer.parseInt(scanner.nextLine());
                Apartment apartment = new Apartment(id, floorId, entrance, apartmentNumber, totalArea, livingArea, roomsCount, price, ApartmentStatus.AVAILABLE, null, null);
                controller.save((T) apartment);
                System.out.println("Apartment added.");
            }
            case "Building" -> {
                System.out.print("Enter building ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter address: ");
                String address = scanner.nextLine();
                System.out.print("Enter residential complex name: ");
                String complexName = scanner.nextLine();
                System.out.print("Enter number of floors: ");
                Integer floorsCount = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter number of entrances: ");
                Integer entrancesCount = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter construction start date (yyyy-mm-dd): ");
                LocalDate startDate = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter planned completion date (yyyy-mm-dd): ");
                LocalDate plannedDate = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter commissioning date (yyyy-mm-dd): ");
                LocalDate commissioningDate = LocalDate.parse(scanner.nextLine());
                Building building = new Building(id, address, complexName, floorsCount, entrancesCount, startDate, plannedDate, commissioningDate);
                controller.save((T) building);
                System.out.println("Building added.");
            }
            case "Client" -> {
                System.out.print("Enter client ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter full name: ");
                String fullName = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();
                Client client = new Client(id, email, fullName, phone);
                controller.save((T) client);
                System.out.println("Client added.");
            }
            case "Employee" -> {
                System.out.print("Enter employee ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter full name: ");
                String fullName = scanner.nextLine();
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();
                System.out.print("Enter password: ");
                String password = scanner.nextLine();
                System.out.print("Enter role (ADMIN, MANAGER, AGENT): ");
                EmployeeRole role = EmployeeRole.valueOf(scanner.nextLine().toUpperCase());
                Employee employee = new Employee(id, email, fullName, phone, password, role);
                controller.save((T) employee);
                System.out.println("Employee added.");
            }
            case "Floor" -> {
                System.out.print("Enter floor ID: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter building ID: ");
                int buildingId = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter floor number: ");
                int floorNumber = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter plan file path: ");
                String planFilePath = scanner.nextLine();
                Floor floor = new Floor(id, buildingId, floorNumber, planFilePath);
                controller.save((T) floor);
                System.out.println("Floor added.");
            }
        }
    }

    private static <T> void updateEntity(Scanner scanner, ControllerInterface<T> controller, String entityName) {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        controller.findById(id).ifPresentOrElse(entity -> {
            switch (entityName) {
                case "Apartment" -> {
                    Apartment apt = (Apartment) entity;
                    System.out.print("New floor ID (" + apt.getFloorId() + "): ");
                    String input = scanner.nextLine();
                    if (!input.isEmpty()) apt.setFloorId(Integer.parseInt(input));
                    System.out.print("New entrance (" + apt.getEntrance() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) apt.setEntrance(input.equals("0") ? null : Integer.parseInt(input));
                    System.out.print("New apartment number (" + apt.getApartmentNumber() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) apt.setApartmentNumber(Integer.parseInt(input));
                    System.out.print("New total area (" + apt.getTotalArea() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) apt.setTotalArea(Float.parseFloat(input));
                    System.out.print("New living area (" + apt.getLivingArea() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) apt.setLivingArea(Float.parseFloat(input));
                    System.out.print("New rooms count (" + apt.getRoomsCount() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) apt.setRoomsCount(Integer.parseInt(input));
                    System.out.print("New price (" + apt.getPrice() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) apt.setPrice(Integer.parseInt(input));
                    controller.save((T) apt);
                    System.out.println("Apartment updated.");
                }
                case "Building" -> {
                    Building b = (Building) entity;
                    System.out.print("New address (" + b.getAddress() + "): ");
                    String input = scanner.nextLine();
                    if (!input.isEmpty()) b.setAddress(input);
                    System.out.print("New residential complex name (" + b.getResidentialComplexName() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) b.setResidentialComplexName(input);
                    System.out.print("New number of floors (" + b.getFloorsCount() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) b.setFloorsCount(Integer.parseInt(input));
                    System.out.print("New number of entrances (" + b.getEntrancesCount() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) b.setEntrancesCount(Integer.parseInt(input));
                    System.out.print("New construction start date (" + b.getConstructionStartDate() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) b.setConstructionStartDate(LocalDate.parse(input));
                    System.out.print("New planned completion date (" + b.getPlannedCompletionDate() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) b.setPlannedCompletionDate(LocalDate.parse(input));
                    System.out.print("New commissioning date (" + b.getCommissioningDate() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) b.setCommissioningDate(LocalDate.parse(input));
                    controller.save((T) b);
                    System.out.println("Building updated.");
                }
                case "Client" -> {
                    Client c = (Client) entity;
                    System.out.print("New full name (" + c.getFullName() + "): ");
                    String input = scanner.nextLine();
                    if (!input.isEmpty()) c.setFullName(input);
                    System.out.print("New email (" + c.getEmail() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) c.setEmail(input);
                    System.out.print("New phone (" + c.getPhone() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) c.setPhone(input);
                    controller.save((T) c);
                    System.out.println("Client updated.");
                }
                case "Employee" -> {
                    Employee e = (Employee) entity;
                    System.out.print("New full name (" + e.getFullName() + "): ");
                    String input = scanner.nextLine();
                    if (!input.isEmpty()) e.setFullName(input);
                    System.out.print("New email (" + e.getEmail() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) e.setEmail(input);
                    System.out.print("New phone (" + e.getPhone() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) e.setPhone(input);
                    System.out.print("New password: ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) e.setPassword(input);
                    System.out.print("New role (" + e.getRole() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) e.setRole(EmployeeRole.valueOf(input.toUpperCase()));
                    controller.save((T) e);
                    System.out.println("Employee updated.");
                }
                case "Floor" -> {
                    Floor f = (Floor) entity;
                    System.out.print("New building ID (" + f.getBuildingId() + "): ");
                    String input = scanner.nextLine();
                    if (!input.isEmpty()) f.setBuildingId(Integer.parseInt(input));
                    System.out.print("New floor number (" + f.getFloorNumber() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) f.setFloorNumber(Integer.parseInt(input));
                    System.out.print("New plan file path (" + f.getPlanFilePath() + "): ");
                    input = scanner.nextLine();
                    if (!input.isEmpty()) f.setPlanFilePath(input);
                    controller.save((T) f);
                    System.out.println("Floor updated.");
                }
            }
        }, () -> System.out.println(entityName + " not found"));
    }
}
