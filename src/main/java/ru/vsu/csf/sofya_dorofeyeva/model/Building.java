package ru.vsu.csf.sofya_dorofeyeva.model;

import java.time.LocalDate;

public class Building {
    private int id;
    private String address;
    private String residentialComplexName;
    private Integer floorsCount;
    private Integer entrancesCount;
    private LocalDate constructionStartDate;
    private LocalDate plannedCompletionDate;
    private LocalDate commissioningDate;


    public Building(int id, String address, String residentialComplexName, Integer floorsCount, Integer entrancesCount, LocalDate constructionStartDate, LocalDate plannedCompletionDate, LocalDate commissioningDate) {
        this.id = id;
        this.address = address;
        this.residentialComplexName = residentialComplexName;
        this.floorsCount = floorsCount;
        this.entrancesCount = entrancesCount;
        this.constructionStartDate = constructionStartDate;
        this.plannedCompletionDate = plannedCompletionDate;
        this.commissioningDate = commissioningDate;
    }

    public Building() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getResidentialComplexName() {
        return residentialComplexName;
    }

    public void setResidentialComplexName(String residentialComplexName) {
        this.residentialComplexName = residentialComplexName;
    }

    public int getFloorsCount() {
        return floorsCount;
    }

    public void setFloorsCount(int floorsCount) {
        this.floorsCount = floorsCount;
    }

    public int getEntrancesCount() {
        return entrancesCount;
    }

    public void setEntrancesCount(int entrancesCount) {
        this.entrancesCount = entrancesCount;
    }

    public LocalDate getConstructionStartDate() {
        return constructionStartDate;
    }

    public void setConstructionStartDate(LocalDate constructionStartDate) {
        this.constructionStartDate = constructionStartDate;
    }

    public LocalDate getPlannedCompletionDate() {
        return plannedCompletionDate;
    }

    public void setPlannedCompletionDate(LocalDate plannedCompletionDate) {
        this.plannedCompletionDate = plannedCompletionDate;
    }

    public LocalDate getCommissioningDate() {
        return commissioningDate;
    }

    public void setCommissioningDate(LocalDate commissioningDate) {
        this.commissioningDate = commissioningDate;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingId=" + id +
                ", address='" + address + '\'' +
                ", residentialComplexName='" + residentialComplexName + '\'' +
                ", floorsCount=" + floorsCount +
                ", entrancesCount=" + entrancesCount +
                ", constructionStartDate=" + constructionStartDate +
                ", plannedCompletionDate=" + plannedCompletionDate +
                ", commissioningDate=" + commissioningDate +
                '}';
    }
}
