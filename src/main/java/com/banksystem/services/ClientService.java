package com.banksystem.services;

import com.banksystem.models.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    public List<Client> getUsers() {
        List<Client> lists = new ArrayList<>();
        Client client1 = new Client(1L, "John", "Ben");
        Client client2 = new Client(2L, "Makhlouk", "Oussama");
        Client client3 = new Client(3L, "Erguiti", "Imane");
        lists.add(client1);
        lists.add(client2);
        lists.add(client3);
        return lists;
    }
}
