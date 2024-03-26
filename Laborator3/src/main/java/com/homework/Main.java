package com.homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<LocalDate, Pair<LocalTime, LocalTime>> churchTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024, 3, 10), new Pair<>(LocalTime.of(11, 0), LocalTime.of(20, 0)));
        churchTimetable.put(LocalDate.of(2024, 3, 11), new Pair<>(LocalTime.of(9, 0), LocalTime.of(18, 0)));
        churchTimetable.put(LocalDate.of(2024, 3, 12), new Pair<>(LocalTime.of(10, 0), LocalTime.of(18, 0)));


        Map<LocalDate, Pair<LocalTime, LocalTime>> concertTimetable = new HashMap<>();
        concertTimetable.put(LocalDate.of(2024, 3, 10), new Pair<>(LocalTime.of(20, 0), LocalTime.of(23, 0)));
        concertTimetable.put(LocalDate.of(2024, 3, 11), new Pair<>(LocalTime.of(20, 0), LocalTime.of(23, 0)));
        concertTimetable.put(LocalDate.of(2024, 3, 12), new Pair<>(LocalTime.of(20, 0), LocalTime.of(23, 0)));


        Trip trip = new Trip("New York", "March 2024", new ArrayList<>());

        Statue statue = new Statue("Statue");
        Church church = new Church("Church", churchTimetable);
        Concert concert = new Concert("Concert", concertTimetable, 18.0);


        trip.addAttraction(church);
        trip.addAttraction(statue);
        trip.addAttraction(concert);

        trip.displayVisitableNonPayableLocations();


        TravelPlan travelPlan = new TravelPlan();
        travelPlan.addPlan(church, LocalDate.of(2024, 3, 10));
        travelPlan.addPlan(concert, LocalDate.of(2024, 3, 11));

        // Print travel plan
        System.out.println("\nTravel Plan:");
        travelPlan.printTravelPlan();



    }
}