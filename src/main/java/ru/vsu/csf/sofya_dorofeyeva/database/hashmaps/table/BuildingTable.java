package ru.vsu.csf.sofya_dorofeyeva.database.hashmaps.table;

import ru.vsu.csf.sofya_dorofeyeva.model.Building;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Random;

public class BuildingTable {
    private HashMap<Integer, Building> buildings;
    private int id;
    Random rnd = new Random();

    String[] residentialComplexNames = {"Солнечный", "Южный", "Современный"};
    String[] streetsNames = {"Народная", "Труда", "Речная", "Зеленая", "Дачная"};
    String[] citesNames = {"Воронеж", "Липецк", "Курск", "Белгород"};


    public BuildingTable() {
        this.id = 1;
        this.buildings = new HashMap<>();
    }

    public HashMap<Integer, Building> getBuildings() {
        return buildings;
    }

    public HashMap<Integer, Building> generateBuildings() {
        buildings.clear();
        this.id = 1;

        for (int i = 0; i < 20; i++) {
            Integer buildingId = id;

            String address = "г. " + citesNames[i % citesNames.length] + ", ул. " + streetsNames[i % streetsNames.length] + ", д. " + rnd.nextInt(100);
            String residentialComplexName = "ЖК" + residentialComplexNames[i % residentialComplexNames.length];
            Integer floorsCount = null;
            Integer entrancesCount = null;
            LocalDate constructionStartDate = LocalDate.now().minusYears(rnd.nextInt(14)).minusMonths(rnd.nextInt(12));
            LocalDate plannedCompletionDate = constructionStartDate.plusYears(rnd.nextInt(15));
            LocalDate commissioningDate = plannedCompletionDate.plusMonths(rnd.nextInt(12));

            Building building = new Building(buildingId, address, residentialComplexName, floorsCount, entrancesCount, constructionStartDate, plannedCompletionDate, commissioningDate);
            buildings.put(buildingId, building);
            id++;
        }
        return buildings;
    }
}
