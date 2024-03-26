package com.homework;

/**
 * Clasa Passenger reprezintă un pasager care este o subclasă a clasei Person.
 * Această clasă conține informații despre un pasager, cum ar fi numele, vârsta și destinația.
 */
public class Passenger extends Person {

    /**
     * Constructorul clasei Passenger.
     *
     * @param name         Numele pasagerului.
     * @param age          Vârsta pasagerului.
     * @param destination  Destinația la care se deplasează pasagerul.
     */
    public Passenger(String name, int age, String destination) {
        super(name, age, destination);
    }

    /**
     * Returnează o reprezentare textuală a obiectului Passenger.
     *
     * @return O reprezentare textuală a obiectului Passenger.
     */
    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", destination='" + getDestination() + '\'' +
                '}';
    }
}
