package ru.vsu.csf.sofya_dorofeyeva;

import ru.vsu.csf.sofya_dorofeyeva.config.AppContext;
import ru.vsu.csf.sofya_dorofeyeva.console.Console;
import ru.vsu.csf.sofya_dorofeyeva.controller.*;
import ru.vsu.csf.sofya_dorofeyeva.repository.*;
import ru.vsu.csf.sofya_dorofeyeva.service.*;

public class Main {
    public static void main(String[] args) {
        try (AppContext context = new AppContext()) {
            Console.start(
                    context.apartmentController(),
                    context.buildingController(),
                    context.clientController(),
                    context.employeeController(),
                    context.floorController()
            );
        }
    }
}
