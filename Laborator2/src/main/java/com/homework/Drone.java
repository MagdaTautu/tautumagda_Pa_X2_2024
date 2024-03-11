package com.homework;

/**
 * Clasa care reprezinta un drona.
 */
class Drone extends Vehicle {
    private int duration;

    /**
     * Constructor pentru initializarea unei drone.
     * @param droneName Numele dronei.
     * @param duration Durata maxima de zbor a dronei.
     */
    public Drone(String droneName, int duration) {
        super(droneName);
        this.duration = duration;
    }

    /**
     * Returneaza durata maxima de zbor a dronei.
     * @return Durata maxima de zbor a dronei.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Seteaza durata maxima de zbor a dronei.
     * @param duration Noua durata maxima de zbor a dronei.
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }
}
