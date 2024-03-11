package org.example;

public class Main {
    public static void main(String[] args) {
        Depot depot = new Depot("First Depot");
        Vehicle vehicle = new Vehicle(depot);
        Client client1 = new Client("Client1", 8, 12, clientType.REGULAR);
        Client client2 = new Client("Client2", 9, 14, clientType.PREMIUM);

        vehicle.addClient(client1);
        vehicle.addClient(client2);

        System.out.println("Depot: " + depot);
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Client 1: " + client1);
        System.out.println("Client 2: " + client2);
    }
}