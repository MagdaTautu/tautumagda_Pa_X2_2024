package com.homework;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Clasa Problem conține metode pentru rezolvarea unei probleme practice.
 * Această clasă se ocupă de generarea de persoane aleatorii, calcularea destinațiilor parcurse de șoferi,
 * calcularea unei hărți de destinații și persoanele care doresc să ajungă acolo, potrivirea șoferilor cu pasagerii,
 * și alte funcționalități asociate.
 */
public class Problem {
    private static final Faker faker = new Faker();

    /**
     * Metoda pentru generarea de persoane aleatorii.
     *
     * @param count Numărul de persoane care trebuie generate.
     * @return O listă de persoane generate aleatoriu.
     */
    public static List<Person> generateRandomPersons(int count) {
        Random random = new Random();
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                persons.add(new Driver(faker.name().fullName(), random.nextInt(50), "Destination" + random.nextInt(5)));
            } else {
                persons.add(new Passenger(faker.name().fullName(), random.nextInt(50), "Destination" + random.nextInt(5)));
            }
        }
        return persons;
    }

    /**
     * Metoda pentru calcularea destinațiilor parcurse de șoferi.
     *
     * @param persons Lista de persoane pentru care trebuie calculate destinațiile parcurse de șoferi.
     * @return O listă de destinații parcurse de șoferi, sortată și fără duplicări.
     */
    public static List<String> destinationsPassedThrough(List<Person> persons) {
        return persons.stream()
                .filter(person -> person instanceof Driver)
                .flatMap(driver -> Arrays.stream(driver.getDestination().split(",\\s*")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Metoda pentru calcularea unei hărți de destinații și persoanele care doresc să ajungă acolo.
     *
     * @param persons Lista de persoane pentru care trebuie calculată harta destinațiilor și a pasagerilor.
     * @return O mapă cu destinațiile și listele de persoane care doresc să ajungă acolo.
     */
    public static Map<String, List<Person>> destinationsAndPassengers(List<Person> persons) {
        Map<String, List<Person>> destinationMap = new HashMap<>();
        persons.forEach(person -> {
            if (person instanceof Passenger || person instanceof Driver) {
                String destination = person.getDestination();
                destinationMap.putIfAbsent(destination, new ArrayList<>());
                destinationMap.get(destination).add(person);
            }
        });
        return destinationMap;
    }

    /**
     * Metoda pentru afișarea destinațiilor și persoanelor care doresc să ajungă acolo.
     *
     * @param destinationMap Mapa cu destinațiile și listele de persoane care doresc să ajungă acolo.
     */
    public static void printDestinationsAndPeople(Map<String, List<Person>> destinationMap) {
        destinationMap.forEach((destination, people) -> {
            System.out.println(destination + ":");
            people.forEach(System.out::println);
            System.out.println();
        });
    }

    /**
     * Metoda pentru asocierea șoferilor cu pasagerii pe baza destinațiilor.
     *
     * @param persons Lista de persoane pentru care trebuie făcută asocierea.
     * @return O listă de perechi (șofer, pasager) care sunt potrivite pe baza destinațiilor.
     */
    public static List<Pair<Driver, Passenger>> matchDriversAndPassengers(List<Person> persons) {
        List<Pair<Driver, Passenger>> matches = new ArrayList<>();
        Map<String, List<Person>> destinationMap = destinationsAndPassengers(persons);

        persons.stream()
                .filter(person -> person instanceof Driver)
                .forEach(driver -> {
                    List<Person> driversForPassengers = destinationMap.get(driver.getDestination());
                    if (driversForPassengers != null && !driversForPassengers.isEmpty()) {

                        driversForPassengers.stream()
                                .filter(person -> person instanceof Passenger)
                                .map(passenger -> new Pair<>((Driver) driver, (Passenger) passenger))
                                .forEach(matches::add);

                        driversForPassengers.clear();
                    }
                });
        return matches;
    }
}
