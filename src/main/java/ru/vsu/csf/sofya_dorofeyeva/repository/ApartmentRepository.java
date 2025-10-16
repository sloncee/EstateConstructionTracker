package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.model.Apartment;
import ru.vsu.csf.sofya_dorofeyeva.model.enums.ApartmentStatus;

import java.sql.*;
import java.util.*;

public class ApartmentRepository implements RepositoryInterface<Apartment> {
    private final Connection connection;

    public ApartmentRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Apartment apartment) {
        String sql = "INSERT INTO apartment(floor_id, entrance, apartment_number, total_area, living_area, rooms_count, price, status, client_id, employee_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, apartment.getFloorId());
            stmt.setObject(2, apartment.getEntrance(), Types.INTEGER);
            stmt.setInt(3, apartment.getApartmentNumber());
            stmt.setFloat(4, apartment.getTotalArea());
            stmt.setFloat(5, apartment.getLivingArea());
            stmt.setInt(6, apartment.getRoomsCount());
            stmt.setInt(7, apartment.getPrice());
            stmt.setString(8, apartment.getStatus().name());
            stmt.setObject(9, apartment.getClientId(), Types.INTEGER);
            stmt.setObject(10, apartment.getEmployeeId(), Types.INTEGER);

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    apartment.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding the apartment", e);
        }
    }

    @Override
    public void update(Apartment apartment) {
        String sql = "UPDATE apartment " +
                "SET floor_id=?, entrance=?, apartment_number=?, total_area=?, living_area=?, rooms_count=?, price=?, status=?, client_id=?, employee_id=? " +
                "WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, apartment.getFloorId());
            stmt.setObject(2, apartment.getEntrance(), Types.INTEGER);
            stmt.setInt(3, apartment.getApartmentNumber());
            stmt.setFloat(4, apartment.getTotalArea());
            stmt.setFloat(5, apartment.getLivingArea());
            stmt.setInt(6, apartment.getRoomsCount());
            stmt.setInt(7, apartment.getPrice());
            stmt.setString(8, apartment.getStatus().name());
            stmt.setObject(9, apartment.getClientId(), Types.INTEGER);
            stmt.setObject(10, apartment.getEmployeeId(), Types.INTEGER);
            stmt.setInt(11, apartment.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when updating the apartment", e);
        }
    }

    @Override
    public Optional<Apartment> findById(int id) {
        String sql = "SELECT * FROM apartment WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when searching for an apartment by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Apartment> findAll() {
        String sql = "SELECT * FROM apartment";
        List<Apartment> apartments = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                apartments.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when getting the list of apartments", e);
        }
        return apartments;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM apartment WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when deleting an apartment", e);
        }
    }

    private Apartment mapRow(ResultSet rs) throws SQLException {
        Apartment apartment = new Apartment();
        apartment.setId(rs.getInt("id"));
        apartment.setFloorId(rs.getInt("floor_id"));
        apartment.setEntrance((Integer) rs.getObject("entrance"));
        apartment.setApartmentNumber(rs.getInt("apartment_number"));
        apartment.setTotalArea(rs.getFloat("total_area"));
        apartment.setLivingArea(rs.getFloat("living_area"));
        apartment.setRoomsCount(rs.getInt("rooms_count"));
        apartment.setPrice(rs.getInt("price"));
        apartment.setStatus(parseStatus(rs.getString("status")));
        apartment.setClientId((Integer) rs.getObject("client_id"));
        apartment.setEmployeeId((Integer) rs.getObject("employee_id"));
        return apartment;
    }

    private ApartmentStatus parseStatus(String statusStr) {
        if (statusStr == null) return null;
        try {
            return ApartmentStatus.valueOf(statusStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
