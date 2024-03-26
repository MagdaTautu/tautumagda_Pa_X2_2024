package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = generateRandomPersons(10);


        List<Driver> drivers = persons.stream()
                .filter(person -> person instanceof Driver)
                .map(person -> (Driver) person)
                .collect(Collectors.toCollection(LinkedList::new));

        TreeSet<Passenger> passengers = persons.stream()
                .filter(person -> person instanceof Passenger)
                .map(person -> (Passenger) person)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getName))));


        drivers.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("Drivers sorted by age:");
        drivers.forEach(driver -> System.out.println(driver.getName() + " - " + driver.getAge()));


        System.out.println("\nPassengers sorted by name:");
        passengers.forEach(passenger -> System.out.println(passenger.getName()));
    }
    private static List<Person> generateRandomPersons(int count) {
        Random random = new Random();
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                persons.add(new Driver("Driver" + i, random.nextInt(50), "Destination" + random.nextInt(5)));
            } else {
                persons.add(new Passenger("Passenger" + i, random.nextInt(50), "Destination" + random.nextInt(5)));
            }
        }
        return persons;
    }
}
