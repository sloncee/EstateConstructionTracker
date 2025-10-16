package ru.vsu.csf.sofya_dorofeyeva.database.hashmaps.table;

import ru.vsu.csf.sofya_dorofeyeva.model.Client;

import java.util.HashMap;
import java.util.Random;

public class ClientTable {
    private HashMap<Integer, Client> clients;
    private int id;
    Random rnd = new Random();

    String[] names = {"Олег", "Сергей", "Андрей", "Иван", "Петр", "Алексей", "Георгий", "Александр", "Дмитрий", "Владислав"};
    String[] surnames = {"Чернов", "Андреев", "Перов", "Попов", "Белов", "Шестопалов"};
    String[] nameTranslations = {"oleg", "sergey", "andrey", "ivan", "petr", "alexey", "georgiy", "alexander", "dmitriy", "vladislav"};
    String[] surnameTranslations = {"chernov", "andreev", "perov", "popov", "belov", "shestopalov"};
    String[] domains = {"gmail.com", "mail.ru", "yandex.ru"};


    public ClientTable() {
        this.id = 1;
        this.clients = new HashMap<>();
    }

    public HashMap<Integer, Client> getClients() {
        return clients;
    }

    public HashMap<Integer, Client> generateClients() {
        clients.clear();
        this.id = 1;

        for (int i = 0; i < 80; i++) {
            Integer clientId = id;

            String email = nameTranslations[i % nameTranslations.length] + "." + surnameTranslations[i % surnameTranslations.length] + "@" + domains[i % domains.length];
            String fullName = names[i % names.length] + " " + surnames[i % surnames.length];
            String phone = "89" + String.format("%09d", rnd.nextInt(1000000000));

            Client client = new Client(clientId, email, fullName, phone);
            clients.put(clientId, client);
            id++;
        }
        return clients;
    }
}
