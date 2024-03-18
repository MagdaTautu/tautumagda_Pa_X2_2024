package org.example;
import java.time.LocalDate;
import java.time.LocalTime;

import java.util.Map;

interface Visitable {
    Map<LocalDate, TimeInterval> getTimetable();
}
