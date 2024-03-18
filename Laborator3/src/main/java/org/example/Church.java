package org.example;

import java.time.LocalDate;
import java.util.Map;

class Church extends Attraction implements Visitable {
    private Map<LocalDate, TimeInterval> openingHours;

    public Church(String name, Map<LocalDate, TimeInterval> openingHours) {
        super(name);
        this.openingHours = openingHours;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return openingHours;
    }
}
