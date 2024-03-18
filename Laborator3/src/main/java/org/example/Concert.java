package org.example;

import java.time.LocalDate;
import java.util.Map;

class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> timetable;
    private double entryFee;

    public Concert(String name, Map<LocalDate, TimeInterval> timetable, double entryFee) {
        super(name);
        this.timetable = timetable;
        this.entryFee = entryFee;
    }

    @Override
    public Map<LocalDate,TimeInterval> getTimetable() {
        return timetable;
    }


    @Override
    public double getTicketPrice() {
        return entryFee;
    }
}
