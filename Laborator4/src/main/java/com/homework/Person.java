package com.homework;

/**
 * Clasa Person reprezintă o persoană care poate fi un șofer sau un pasager.
 * Această clasă conține informații despre o persoană, cum ar fi numele, vârsta și destinația.
 */
public class Person {
    private String name; // Numele persoanei
    private int age; // Vârsta persoanei
    private String destination; // Destinația persoanei

    /**
     * Constructorul clasei Person.
     *
     * @param name         Numele persoanei.
     * @param age          Vârsta persoanei.
     * @param destination  Destinația la care se deplasează persoana.
     */
    public Person(String name, int age, String destination) {
        this.name = name;
        this.age = age;
        this.destination = destination;
    }

    /**
     * Returnează numele persoanei.
     *
     * @return Numele persoanei.
     */
    public String getName() {
        return name;
    }

    /**
     * Setează numele persoanei.
     *
     * @param name Noul nume al persoanei.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returnează vârsta persoanei.
     *
     * @return Vârsta persoanei.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setează vârsta persoanei.
     *
     * @param age Noua vârstă a persoanei.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returnează destinația persoanei.
     *
     * @return Destinația persoanei.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Setează destinația persoanei.
     *
     * @param destination Noua destinație a persoanei.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Returnează o reprezentare textuală a obiectului Person.
     *
     * @return O reprezentare textuală a obiectului Person.
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", destination='" + destination + '\'' +
                '}';
    }
}
