package ru.vsu.csf.sofya_dorofeyeva.repository;

import ru.vsu.csf.sofya_dorofeyeva.database_hashmaps.table.ClientTable;
import ru.vsu.csf.sofya_dorofeyeva.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientRepository implements RepositoryInterface<Client> {
    private final ClientTable clientTable;

    public ClientRepository(ClientTable clientTable) {
        this.clientTable = clientTable;
    }

    @Override
    public void save(Client client) {
        clientTable.getClients().put(client.getId(), client);
    }

    @Override
    public Optional<Client> findById(int id) {
        return Optional.ofNullable(clientTable.getClients().get(id));
    }

    @Override
    public List<Client> findAll() {
        return new ArrayList<>(clientTable.getClients().values());
    }

    @Override
    public void deleteById(int id) {
        clientTable.getClients().remove(id);
    }
}
