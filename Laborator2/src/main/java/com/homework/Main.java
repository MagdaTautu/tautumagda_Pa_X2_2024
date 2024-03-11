package com.homework;


import java.util.*;

import static com.homework.Greedy.allocateClients;


public class Main {
    private static List<Client> generateRandomClients() {
        List<Client> clients = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            String name = "Client" + (i + 1);
            String location = "Location" + (i + 1);
            int visitingStartTime = random.nextInt(24);
            int visitingEndTime = visitingStartTime + random.nextInt(24 - visitingStartTime);
            Client client = new Client(name, location, visitingStartTime, visitingEndTime, clientType.REGULAR);
            clients.add(client);
        }

        return clients;
    }
    public static void main(String[] args) {

        Problem problem = new Problem();


        Depot depot1 = new Depot("Depot 1");
        Depot depot2 = new Depot("Depot 2");


        Truck truck1 = new Truck("Truck1",100);
        Truck truck2 = new Truck("Truck2",120);
        Drone drone1 = new Drone("Drone1",60);

        depot1.addVehicle(truck1);
        depot2.addVehicle(truck2);
        depot1.addVehicle(drone1);

        problem.addDepot(depot1);
        problem.addDepot(depot2);


       /* Vehicle[] allVehicles = problem.getVehicles();
        System.out.println("All vehicles:");
        for (Vehicle vehicle : allVehicles) {
            if (vehicle instanceof Truck) {
                System.out.println("Truck: " + vehicle.getVehicleName() + ", Capacity: " + ((Truck) vehicle).getCapacity() + ", Depot: " + vehicle.getDepot());
            }
            else if (vehicle instanceof Drone) {
                System.out.println("Drone: " + vehicle.getVehicleName() + ", Flight Duration: " + ((Drone) vehicle).getDuration() + ", Depot: " + vehicle.getDepot());
            }
        }*/
        List<Vehicle> vehicles = Arrays.asList(truck1, truck2);
        List<Client> clients = generateRandomClients();

        Map<Client, Vehicle> relation = new HashMap<>();

        allocateClients(clients, vehicles, relation);

        for (Map.Entry<Client, Vehicle> entry : relation.entrySet()) {
            System.out.println("Client: " + entry.getKey().getName() + " allocated to Vehicle: " + entry.getValue().getVehicleName() );
        }
    }
}