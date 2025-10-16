package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements RepositoryInterface<Client> {
    private final Connection connection;

    public ClientRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Client client) {
        String sql = "INSERT INTO client(email, full_name, phone) " +
                "VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, client.getEmail());
            stmt.setString(2, client.getFullName());
            stmt.setString(3, client.getPhone());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    client.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding the client", e);
        }
    }

    @Override
    public void update(Client client) {
        String sql = "UPDATE client " +
                "SET email=?, full_name=?, phone=? " +
                "WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getEmail());
            stmt.setString(2, client.getFullName());
            stmt.setString(3, client.getPhone());
            stmt.setInt(4, client.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when updating the client", e);
        }
    }

    @Override
    public Optional<Client> findById(int id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when searching for a client by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Client> findAll() {
        String sql = "SELECT * FROM client";
        List<Client> clients = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                clients.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when getting the list of clients", e);
        }
        return clients;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM client WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when deleting a client", e);
        }
    }

    private Client mapRow(ResultSet rs) throws SQLException {
        Client client = new Client();
        client.setId(rs.getInt("id"));
        client.setEmail(rs.getString("email"));
        client.setFullName(rs.getString("full_name"));
        client.setPhone(rs.getString("phone"));

        return client;
    }
}
