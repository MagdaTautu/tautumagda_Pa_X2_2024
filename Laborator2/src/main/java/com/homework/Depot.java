package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clasa care reprezinta un depou.
 */
public class Depot {
    private String name;
    private List<Vehicle> vehicles;

    /**
     * Constructor pentru initializarea unui depou.
     * @param name Numele depoului.
     */
    public Depot(String name) {
        this.name = name;
        this.vehicles = new ArrayList<>();
    }

    /**
     * Returneaza numele depoului.
     * @return Numele depoului.
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele depoului.
     * @param name Noul nume al depoului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Adauga un vehicul la lista de vehicule a depoului.
     * @param vehicle Vehiculul de adaugat.
     */
    public void addVehicle(Vehicle vehicle) {
        if (!vehicles.contains(vehicle)) {
            vehicles.add(vehicle);
            vehicle.setDepot(this.name);
        }
    }

    /**
     * Returneaza lista de vehicule a depoului.
     * @return Lista de vehicule.
     */
    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Returneaza o reprezentare sub forma de string a depoului.
     * @return String care contine informatii despre depou.
     */
    @Override
    public String toString() {
        return "Depot{" + "name='" + name + '\'' + '}';
    }

    /**
     * Suprascrie metoda equals pentru a compara depourile dupa numele lor.
     * @param o Obiectul de comparat.
     * @return True daca obiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Depot depot = (Depot) o;
        return Objects.equals(name, depot.name);
    }

    /**
     * Suprascrie metoda hashCode.
     * @return Valoarea hash code pentru depou.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
