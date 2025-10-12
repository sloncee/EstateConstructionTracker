package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table.EmployeeTable;
import ru.vsu.csf.sofya_dorofeyeva.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeRepository implements RepositoryInterface<Employee> {
    private final EmployeeTable employeeTable;

    public EmployeeRepository(EmployeeTable employeeTable) {
        this.employeeTable = employeeTable;
    }

    @Override
    public void save(Employee employee) {
        employeeTable.getEmployees().put(employee.getId(), employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return Optional.ofNullable(employeeTable.getEmployees().get(id));
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employeeTable.getEmployees().values());
    }

    @Override
    public void deleteById(int id) {
        employeeTable.getEmployees().remove(id);
    }
}
