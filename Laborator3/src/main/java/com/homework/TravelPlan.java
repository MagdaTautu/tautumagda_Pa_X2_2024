package com.homework;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Clasa care reprezintă un plan de călătorie.
 */
public class TravelPlan {
    /**
     * Maparea atracțiilor cu datele în care acestea sunt planificate pentru vizitare.
     */
    private Map<Attraction, LocalDate> plan;

    /**
     * Constructor pentru inițializarea planului de călătorie.
     */
    public TravelPlan() {
        plan = new HashMap<>();
    }

    /**
     * Adaugă o atracție în planul de călătorie pentru o anumită dată.
     *
     * @param attraction Atracția de adăugat în planul de călătorie.
     * @param date       Data la care se planifică vizita la atracție.
     */
    public void addPlan(Attraction attraction, LocalDate date) {
        plan.put(attraction, date);
    }

    /**
     * Afișează planul de călătorie.
     */
    public void printTravelPlan() {
        for (Map.Entry<Attraction, LocalDate> entry : plan.entrySet()) {
            System.out.println("În data de " + entry.getValue() + " vizitează " + entry.getKey().getName());
        }
    }
}
