package ru.vsu.csf.sofya_dorofeyeva.service;

import ru.vsu.csf.sofya_dorofeyeva.model.Employee;
import ru.vsu.csf.sofya_dorofeyeva.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeService implements ServiceInterface<Employee> {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
