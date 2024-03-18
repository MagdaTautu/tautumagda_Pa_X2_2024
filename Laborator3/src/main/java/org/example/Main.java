package org.example;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<LocalDate, TimeInterval> churchTimetable = new HashMap<>();
        Map<LocalDate, TimeInterval> concertTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024, 3, 10), new TimeInterval(LocalTime.of(9, 35), LocalTime.of(18, 0)));
        concertTimetable.put(LocalDate.of(2024, 3, 11), new TimeInterval(LocalTime.of(19, 30), LocalTime.of(22, 0)));


        Trip trip = new Trip("New York", "March 2024", new ArrayList<>());

        Statue statue = new Statue("Statue");
        Church church = new Church("Church", churchTimetable);
        Concert concert = new Concert("Concert", concertTimetable, 25.0);


        trip.addAttraction(church);
        trip.addAttraction(statue);
        trip.addAttraction(concert);


        Collections.sort(trip.getAttractions());


        for (Attraction attraction : trip.getAttractions()) {
            System.out.println("Attraction: " + attraction.getName());
            if (attraction instanceof Visitable) {
                System.out.println("Timetable:");
                Map<LocalDate, TimeInterval> timetable = ((Visitable) attraction).getTimetable();
                for (Map.Entry<LocalDate, TimeInterval> entry : timetable.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue().getFirst() + " - " + entry.getValue().getSecond());
                }
            }
            System.out.println("-----------------------");
        }
    }
}