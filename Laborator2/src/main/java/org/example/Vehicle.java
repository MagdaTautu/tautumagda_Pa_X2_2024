package org.example;

import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    private String depot;
    private List<Client> clients;

    public Vehicle(Depot depot) {
        this.depot = depot.getName();
        this.clients = new ArrayList<>();
    }
    public void addClient(Client client) {
        clients.add(client);
    }


    public String getDepot() {
        return depot;
    }
    public void setDepot(String depot) {
        this.depot = depot;
    }

    public List<Client> getClients() {
        return clients;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "depot='" + depot  +  ", clients=" + clients + '}';
    }
}
