package ru.vsu.csf.sofya_dorofeyeva.model;

public class Floor {
    private int id;
    private int buildingId;
    private int floorNumber;
    private String planFilePath;


    public Floor(int id, int buildingId, int floorNumber, String planFilePath) {
        this.id = id;
        this.buildingId = buildingId;
        this.floorNumber = floorNumber;
        this.planFilePath = planFilePath;
    }

    public Floor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getPlanFilePath() {
        return planFilePath;
    }

    public void setPlanFilePath(String planFilePath) {
        this.planFilePath = planFilePath;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "floorId=" + id +
                ", buildingId=" + buildingId +
                ", floorNumber=" + floorNumber +
                ", planFilePath='" + planFilePath + '\'' +
                '}';
    }
}
