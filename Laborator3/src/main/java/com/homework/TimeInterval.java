package com.homework;

import java.time.LocalTime;

/**
 * Clasa care reprezintă un interval de timp.
 */
public class TimeInterval extends Pair<LocalTime, LocalTime> {
    /**
     * Constructor pentru inițializarea intervalului de timp.
     *
     * @param startTime Ora de început a intervalului de timp.
     * @param endTime   Ora de sfârșit a intervalului de timp.
     */
    public TimeInterval(LocalTime startTime, LocalTime endTime) {
        super(startTime, endTime);
    }
}
