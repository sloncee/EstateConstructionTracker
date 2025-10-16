package ru.vsu.csf.sofya_dorofeyeva.database.hashmaps.table;

import ru.vsu.csf.sofya_dorofeyeva.model.Floor;

import java.util.HashMap;
import java.util.Random;

public class FloorTable {
    private HashMap<Integer, Floor> floors;
    private int id;
    Random rnd = new Random();


    public FloorTable() {
        this.id = 1;
        this.floors = new HashMap<>();
    }

    public HashMap<Integer, Floor> getFloors() {
        return floors;
    }

    public HashMap<Integer, Floor> generateFloors() {
        floors.clear();
        this.id = 1;

        for (int i = 0; i < 50; i++) {
            Integer floorId = id;

             int buildingId = rnd.nextInt(21);
             int floorNumber = rnd.nextInt(10);
             String planFilePath = "plans/floor" + floorId + ".png";;

            Floor floor = new Floor(floorId, buildingId, floorNumber, planFilePath);
            floors.put(floorId, floor);
            id++;
        }
        return floors;
    }
}
