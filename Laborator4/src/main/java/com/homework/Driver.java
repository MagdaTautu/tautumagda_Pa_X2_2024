package com.homework;

/**
 * Clasa Driver reprezintă un șofer care este o subclasă a clasei Person.
 * Această clasă conține informații despre un șofer, cum ar fi numele, vârsta și destinația.
 */
public class Driver extends Person {

    /**
     * Constructorul clasei Driver.
     *
     * @param name Numele șoferului.
     * @param age Vârsta șoferului.
     * @param destination Destinația la care se deplasează șoferul.
     */
    public Driver(String name, int age, String destination) {
        super(name, age, destination);
    }

    /**
     * Returnează o reprezentare textuală a obiectului Driver.
     *
     * @return O reprezentare textuală a obiectului Driver.
     */
    @Override
    public String toString() {
        return "Driver{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", destination='" + getDestination() + '\'' +
                '}';
    }
}
