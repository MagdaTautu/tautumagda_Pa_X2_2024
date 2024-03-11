package com.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa abstracta care reprezinta un vehicul.
 */
abstract class Vehicle {
    private String depot;
    private List<Client> clients;
    private String vehicleName;

    /**
     * Constructor pentru initializarea unui vehicul.
     * @param vehicleName Numele vehiculului.
     */
    public Vehicle(String vehicleName) {
        this.clients = new ArrayList<>();
        this.vehicleName = vehicleName;
    }

    /**
     * Adauga un client la lista de clienti a vehiculului.
     * @param client Clientul de adaugat.
     */
    public void addClient(Client client) {
        clients.add(client);
    }

    /**
     * Returneaza numele vehiculului.
     * @return Numele vehiculului.
     */
    public String getVehicleName() {
        return vehicleName;
    }

    /**
     * Seteaza numele vehiculului.
     * @param vehicleName Noul nume al vehiculului.
     */
    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /**
     * Returneaza depoul la care este atribuit vehiculul.
     * @return Numele depoului.
     */
    public String getDepot() {
        return depot;
    }

    /**
     * Seteaza depoul la care este atribuit vehiculul.
     * @param depot Noul depou al vehiculului.
     */
    public void setDepot(String depot) {
        this.depot = depot;
    }

    /**
     * Returneaza lista de clienti ai vehiculului.
     * @return Lista de clienti.
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Seteaza lista de clienti a vehiculului.
     * @param clients Noua lista de clienti.
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    /**
     * Returneaza o reprezentare sub forma de string a vehiculului.
     * @return String care contine informatii despre vehicul.
     */
    @Override
    public String toString() {
        return "Vehicle{" + "depot='" + depot  +  ", clients=" + clients + '}';
    }
}
