package com.homework;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

/**
 * Interfața care specifică că o atracție turistică poate fi vizitată.
 */
interface Visitable {
    /**
     * Returnează orarul de vizitare al atracției.
     *
     * @return Orarul de vizitare al atracției.
     */
    Map<LocalDate, Pair<LocalTime, LocalTime>> getTimetable();

    /**
     * Returnează ora de deschidere pentru o anumită dată.
     *
     * @param date Data pentru care se dorește ora de deschidere.
     * @return Ora de deschidere pentru data specificată.
     */
    default LocalTime getOpeningHour(LocalDate date) {
        Pair<LocalTime, LocalTime> timeInterval = getTimetable().get(date);
        return timeInterval != null ? timeInterval.getFirst() : null;
    }
}
