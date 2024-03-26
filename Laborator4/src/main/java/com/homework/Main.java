package com.homework;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Problem.generateRandomPersons(10);

        List<String> destinationsDrivers = Problem.destinationsPassedThrough(persons);
        System.out.println("Destinations passed through by drivers: " + destinationsDrivers);


        Map<String, List<Person>> destinationsAndPassengers = Problem.destinationsAndPassengers(persons);
        Problem.printDestinationsAndPeople(destinationsAndPassengers);


        List<Pair<Driver, Passenger>> matches = Problem.matchDriversAndPassengers(persons);
        System.out.println("Matches (Driver, Passenger): " + matches);
    }
}
