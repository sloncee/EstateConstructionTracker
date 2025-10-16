package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.model.Building;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BuildingRepository implements RepositoryInterface<Building> {
    private final Connection connection;

    public BuildingRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Building building) {
        String sql = "INSERT INTO building(address, residential_complex_name, floors_count, entrances_count, construction_start_date, planned_completion_date, commissioning_date) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, building.getAddress());
            stmt.setString(2, building.getResidentialComplexName());
            stmt.setObject(3, building.getFloorsCount(), Types.INTEGER);
            stmt.setObject(4, building.getEntrancesCount(), Types.INTEGER);
            stmt.setDate(5, building.getConstructionStartDate() != null
                    ? Date.valueOf(building.getConstructionStartDate())
                    : null);
            stmt.setDate(6, building.getPlannedCompletionDate() != null
                    ? Date.valueOf(building.getPlannedCompletionDate())
                    : null);
            stmt.setDate(7, building.getCommissioningDate() != null
                    ? Date.valueOf(building.getCommissioningDate())
                    : null);
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    building.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding the building", e);
        }
    }

    @Override
    public void update(Building building) {
        String sql = "UPDATE building " +
                "SET address=?, residential_complex_name=?, floors_count=?, entrances_count=?, construction_start_date=?, planned_completion_date=?, commissioning_date=? " +
                "WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, building.getAddress());
            stmt.setString(2, building.getResidentialComplexName());
            stmt.setObject(3, building.getFloorsCount(), Types.INTEGER);
            stmt.setObject(4, building.getEntrancesCount(), Types.INTEGER);
            stmt.setDate(5, building.getConstructionStartDate() != null
                    ? Date.valueOf(building.getConstructionStartDate())
                    : null);
            stmt.setDate(6, building.getPlannedCompletionDate() != null
                    ? Date.valueOf(building.getPlannedCompletionDate())
                    : null);
            stmt.setDate(7, building.getCommissioningDate() != null
                    ? Date.valueOf(building.getCommissioningDate())
                    : null);
            stmt.setInt(8, building.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when updating the building", e);
        }
    }

    @Override
    public Optional<Building> findById(int id) {
        String sql = "SELECT * FROM building WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when searching for a building by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Building> findAll() {
        String sql = "SELECT * FROM building";
        List<Building> buildings = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                buildings.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when getting the list of buildings", e);
        }
        return buildings;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM building WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when deleting a building", e);
        }
    }

    private Building mapRow(ResultSet rs) throws SQLException {
        Building building = new Building();
        building.setId(rs.getInt("id"));
        building.setAddress(rs.getString("address"));
        building.setResidentialComplexName(rs.getString("residential_complex_name"));
        building.setFloorsCount((Integer) rs.getObject("floors_count"));
        building.setEntrancesCount((Integer) rs.getObject("entrances_count"));

        Date constructionDate = rs.getDate("construction_start_date");
        Date plannedDate = rs.getDate("planned_completion_date");
        Date commissioningDate = rs.getDate("commissioning_date");

        building.setConstructionStartDate(
                constructionDate != null ? constructionDate.toLocalDate() : null);
        building.setPlannedCompletionDate(
                plannedDate != null ? plannedDate.toLocalDate() : null);
        building.setCommissioningDate(
                commissioningDate != null ? commissioningDate.toLocalDate() : null);

        return building;
    }
}
