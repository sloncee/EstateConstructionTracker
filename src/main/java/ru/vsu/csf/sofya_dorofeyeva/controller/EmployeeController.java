package ru.vsu.csf.sofya_dorofeyeva.controller;

import ru.vsu.csf.sofya_dorofeyeva.model.Employee;
import ru.vsu.csf.sofya_dorofeyeva.service.EmployeeService;

import java.util.List;
import java.util.Optional;

public class EmployeeController implements ControllerInterface<Employee> {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @Override
    public void add(Employee employee) {
        service.add(employee);
    }

    @Override
    public void update(Employee employee) {
        service.update(employee);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return service.findById(id);
    }

    @Override
    public List<Employee> findAll() {
        return service.findAll();
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}
