package com.homework;

/**
 * Reprezinta o clasa pentru camioane.
 */
class Truck extends Vehicle {
    private int capacity;

    /**
     * Constructor pentru initializarea unui camion.
     * @param truckName Numele camionului.
     * @param capacity Capacitatea camionului.
     */
    public Truck(String truckName, int capacity) {
        super(truckName);
        this.capacity = capacity;
    }

    /**
     * Returneaza capacitatea camionului.
     * @return Capacitatea camionului.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Seteaza capacitatea camionului.
     * @param capacity Noua capacitate a camionului.
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
