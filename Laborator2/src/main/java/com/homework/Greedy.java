package com.homework;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Clasa care implementeaza un algoritm greedy pentru alocarea clientilor la vehicule.
 */
public class Greedy {

    /**
     * Aloca clientii la vehicule folosind un algoritm greedy.
     * @param clients Lista de clienti.
     * @param vehicles Lista de vehicule disponibile.
     * @param relation Mapa care retine asocierea dintre clienti si vehicule.
     */
    public static void allocateClients(List<Client> clients, List<Vehicle> vehicles, Map<Client, Vehicle> relation) {

        // Sorteaza clientii in ordinea timpului de inceput al vizitei
        clients.sort(Comparator.comparingInt(Client::getVisitingStartTime));

        // Parcurge fiecare client si ii atribuie un vehicul disponibil in functie de distanta minima
        for (Client client : clients) {
            Vehicle assignedVehicle = null;
            int minDistance = Integer.MAX_VALUE;

            // Parcurge fiecare vehicul si calculeaza distanta pana la locatia clientului
            for (Vehicle vehicle : vehicles) {
                int distance = calculateDistance(vehicle.getDepot(), client.getLocation());
                if (distance < minDistance) {
                    minDistance = distance;
                    assignedVehicle = vehicle;
                }
            }

            // Daca s-a gasit un vehicul disponibil, adauga clientul la vehicul si actualizeaza relatia
            if (assignedVehicle != null) {
                assignedVehicle.addClient(client);
                relation.put(client, assignedVehicle);
            }
        }
    }

    /**
     * Calculeaza o distanta fictiva intre doua locatii.
     * @param location1 Prima locatie.
     * @param location2 A doua locatie.
     * @return Distanta calculata (fictiva).
     */
    private static int calculateDistance(String location1, String location2) {
        // Aceasta metoda genereaza o distanta aleatoare intre 0 si 99 pentru simularea distantei intre doua locatii
        Random random = new Random();
        return random.nextInt(100);
    }
}
