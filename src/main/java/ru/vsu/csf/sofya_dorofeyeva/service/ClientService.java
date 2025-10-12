package ru.vsu.csf.sofya_dorofeyeva.service;

import ru.vsu.csf.sofya_dorofeyeva.model.Client;
import ru.vsu.csf.sofya_dorofeyeva.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

public class ClientService implements ServiceInterface<Client> {
    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Client client) {
        repository.save(client);
    }

    @Override
    public Optional<Client> findById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
