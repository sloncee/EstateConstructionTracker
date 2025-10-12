package ru.vsu.csf.sofya_dorofeyeva.controller;

import ru.vsu.csf.sofya_dorofeyeva.model.Client;
import ru.vsu.csf.sofya_dorofeyeva.service.ClientService;

import java.util.List;
import java.util.Optional;

public class ClientController implements ControllerInterface<Client> {
    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @Override
    public void save(Client apartment) {
        service.save(apartment);
    }

    @Override
    public Optional<Client> findById(int id) {
        return service.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return service.findAll();
    }

    @Override
    public void deleteById(int id) {
        service.deleteById(id);
    }
}
