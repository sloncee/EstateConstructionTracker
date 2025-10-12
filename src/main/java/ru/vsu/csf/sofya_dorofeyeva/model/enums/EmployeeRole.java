package ru.vsu.csf.sofya_dorofeyeva.model.enums;

import java.util.Random;

public enum EmployeeRole {
    ADMIN,
    MANAGER,
    AGENT;

    private static final Random rnd = new Random();

    public static EmployeeRole getRandomEmployeeRole() {
        EmployeeRole[] employeeRoles = values();
        return employeeRoles[rnd.nextInt(employeeRoles.length)];
    }
}
