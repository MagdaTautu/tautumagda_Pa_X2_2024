package com.homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 * Clasa care reprezintă o biserică ca atracție turistică.
 * Implementează interfața Visitable pentru a specifica orarul de vizitare.
 */
class Church extends Attraction implements Visitable {
    /**
     * Orarul de deschidere al bisericii.
     */
    private Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours;

    /**
     * Constructor pentru inițializarea numelui și orarului de deschidere al bisericii.
     *
     * @param name Numele bisericii.
     * @param openingHours Orarul de deschidere al bisericii.
     */
    public Church(String name, Map<LocalDate, Pair<LocalTime, LocalTime>> openingHours) {
        super(name);
        this.openingHours = openingHours;
    }

    /**
     * Returnează orarul de deschidere al bisericii.
     *
     * @return Orarul de deschidere al bisericii.
     */
    @Override
    public Map<LocalDate, Pair<LocalTime, LocalTime>> getTimetable() {
        return openingHours;
    }
}
