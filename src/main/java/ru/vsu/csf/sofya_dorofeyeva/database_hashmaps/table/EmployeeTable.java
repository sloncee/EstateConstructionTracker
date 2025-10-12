package ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table;

import ru.vsu.csf.sofya_dorofeyeva.model.Employee;
import ru.vsu.csf.sofya_dorofeyeva.model.enums.EmployeeRole;

import java.util.HashMap;
import java.util.Random;

public class EmployeeTable {
    private HashMap<Integer, Employee> employees;
    private int id;
    Random rnd = new Random();

    String[] names = {"Олег", "Сергей", "Андрей", "Иван", "Петр", "Алексей", "Георгий", "Александр", "Дмитрий", "Владислав"};
    String[] surnames = {"Кузнецов", "Соколов", "Волков", "Новиков", "Морозов", "Петров"};
    String[] nameTranslations = {"oleg", "sergey", "andrey", "ivan", "petr", "alexey", "georgiy", "alexander", "dmitriy", "vladislav"};
    String[] surnameTranslations = {"kuznetsov", "sokolov", "volkov", "novikov", "morozov", "petrov"};
    String[] domains = {"gmail.com", "mail.ru", "yandex.ru"};


    public EmployeeTable() {
        this.id = 1;
        this.employees = new HashMap<>();
    }

    public HashMap<Integer, Employee> getEmployees() {
        return employees;
    }

    public HashMap<Integer, Employee> generateEmployees() {
        employees.clear();
        this.id = 1;

        for (int i = 0; i < 15; i++) {
            Integer employeeId = id;

            String email = nameTranslations[i % nameTranslations.length] + "." + surnameTranslations[i % surnameTranslations.length] + "@" + domains[i % domains.length];
            String fullName = names[i % names.length] + " " + surnames[i % surnames.length];
            String phone = "89" + String.format("%09d", rnd.nextInt(1000000000));
            String password = String.valueOf(rnd.nextInt(9000000));
            EmployeeRole role = EmployeeRole.getRandomEmployeeRole();

            Employee employee = new Employee(employeeId, email, fullName, phone, password, role);
            employees.put(employeeId, employee);
            id++;
        }
        return employees;
    }
}
