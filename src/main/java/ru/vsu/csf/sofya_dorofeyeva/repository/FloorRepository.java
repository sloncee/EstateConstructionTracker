package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.model.Floor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FloorRepository implements RepositoryInterface<Floor> {
    private final Connection connection;

    public FloorRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Floor floor) {
        String sql = "INSERT INTO floor(building_id, floor_number, plan_file_path) " +
                "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, floor.getBuildingId());
            stmt.setInt(2, floor.getFloorNumber());
            stmt.setString(3, floor.getPlanFilePath());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    floor.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding the floor", e);
        }
    }

    @Override
    public void update(Floor floor) {
        String sql = "UPDATE floor " +
                "SET building_id=?, floor_number=?, plan_file_path=? " +
                "WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, floor.getBuildingId());
            stmt.setInt(2, floor.getFloorNumber());
            stmt.setString(3, floor.getPlanFilePath());
            stmt.setInt(4, floor.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when updating the floor", e);
        }
    }

    @Override
    public Optional<Floor> findById(int id) {
        String sql = "SELECT * FROM floor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when searching for a floor by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Floor> findAll() {
        String sql = "SELECT * FROM floor";
        List<Floor> floors = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                floors.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when getting the list of floors", e);
        }
        return floors;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM floor WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when deleting a floor", e);
        }
    }

    private Floor mapRow(ResultSet rs) throws SQLException {
        Floor floor = new Floor();
        floor.setId(rs.getInt("id"));
        floor.setBuildingId(rs.getInt("building_id"));
        floor.setFloorNumber(rs.getInt("floor_number"));
        floor.setPlanFilePath(rs.getString("plan_file_path"));

        return floor;
    }
}
