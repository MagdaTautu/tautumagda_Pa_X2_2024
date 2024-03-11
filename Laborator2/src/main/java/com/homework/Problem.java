package com.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Reprezinta problema de rutare a vehiculelor.
 */
public class Problem {
    private List<Depot> depots;

    /**
     * Constructor pentru initializarea unei noi probleme.
     */
    public Problem() {
        this.depots = new ArrayList<>();
    }

    /**
     * Adauga un depou in problema.
     * @param depot Depoul de adaugat.
     */
    public void addDepot(Depot depot) {
        // Verifica daca depoul deja exista in lista
        if (!depots.contains(depot)) {
            depots.add(depot);
        } else {
            System.out.println("Depot already exists!"); // Mesaj de avertizare in cazul in care depoul deja exista
        }
    }

    /**
     * Returneaza un tablou de vehicule care cuprinde toate vehiculele din toate depourile.
     * @return Un tablou de vehicule.
     */
    public Vehicle[] getVehicles() {
        List<Vehicle> allVehicles = new ArrayList<>();
        for (Depot depot : depots) {
            allVehicles.addAll(depot.getVehicles());
        }
        return allVehicles.toArray(new Vehicle[0]);
    }
}
