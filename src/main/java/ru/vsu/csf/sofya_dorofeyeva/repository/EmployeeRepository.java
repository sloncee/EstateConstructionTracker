package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.model.Employee;
import ru.vsu.csf.sofya_dorofeyeva.model.enums.EmployeeRole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements RepositoryInterface<Employee> {
    private final Connection connection;

    public EmployeeRepository(Connection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Employee employee) {
        String sql = "INSERT INTO employee(email, full_name, phone, password, role) " +
                "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, employee.getEmail());
            stmt.setString(2, employee.getFullName());
            stmt.setString(3, employee.getPhone());
            stmt.setString(4, employee.getPassword());
            stmt.setString(5, employee.getRole().name());
            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    employee.setId(rs.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error adding the employee", e);
        }
    }

    @Override
    public void update(Employee employee) {
        String sql = "UPDATE employee " +
                "SET email=?, full_name=?, phone=?, password=?, role=? " +
                "WHERE id=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, employee.getEmail());
            stmt.setString(2, employee.getFullName());
            stmt.setString(3, employee.getPhone());
            stmt.setString(4, employee.getPassword());
            stmt.setString(5, employee.getRole().name());
            stmt.setInt(6, employee.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when updating the employee", e);
        }
    }

    @Override
    public Optional<Employee> findById(int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when searching for an employee by id", e);
        }
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                employees.add(mapRow(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error when getting the list of employees", e);
        }
        return employees;
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error when deleting an employee", e);
        }
    }

    private Employee mapRow(ResultSet rs) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setEmail(rs.getString("email"));
        employee.setFullName(rs.getString("full_name"));
        employee.setPhone(rs.getString("phone"));
        employee.setPassword(rs.getString("password"));
        employee.setRole(parseRole(rs.getString("role")));

        return employee;
    }

    private EmployeeRole parseRole(String roleStr) {
        if (roleStr == null) return null;
        try {
            return EmployeeRole.valueOf(roleStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
