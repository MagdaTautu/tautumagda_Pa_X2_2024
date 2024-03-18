package com.homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 * Clasa care reprezintă un concert ca atracție turistică.
 * Implementează interfețele Visitable și Payable pentru a specifica orarul de vizitare și prețul biletului.
 */
class Concert extends Attraction implements Visitable, Payable {
    /**
     * Orarul concertului.
     */
    private Map<LocalDate, Pair<LocalTime, LocalTime>> timetable;
    /**
     * Prețul de intrare la concert.
     */
    private double entryFee;

    /**
     * Constructor pentru inițializarea numelui, orarului și prețului de intrare la concert.
     *
     * @param name      Numele concertului.
     * @param timetable Orarul concertului.
     * @param entryFee  Prețul de intrare la concert.
     */
    public Concert(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> timetable, double entryFee) {
        super(name);
        this.timetable = timetable;
        this.entryFee = entryFee;
    }

    /**
     * Returnează orarul concertului.
     *
     * @return Orarul concertului.
     */
    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getTimetable() {
        return timetable;
    }

    /**
     * Returnează prețul biletului pentru concert.
     *
     * @return Prețul biletului pentru concert.
     */
    @Override
    public double getTicketPrice() {
        return entryFee;
    }
}
