package com.homework;

import java.util.Objects;

// Enum pentru tipul de client
enum clientType {
    REGULAR,
    PREMIUM
}

/**
 * Reprezinta un client in sistem.
 */
public class Client {
    private String name;
    private int visitingStartTime;
    private int visitingEndTime;
    private clientType type;
    private String location;

    /**
     * Constructor pentru crearea unui client nou.
     * @param name Numele clientului.
     * @param location Locatia clientului.
     * @param visitingStartTime Timpul de inceput al vizitei pentru client.
     * @param visitingEndTime Timpul de sfarsit al vizitei pentru client.
     * @param type Tipul clientului (regulat sau premium).
     */
    public Client(String name, String location, int visitingStartTime, int visitingEndTime, clientType type) {
        this.name = name;
        this.visitingStartTime = visitingStartTime;
        this.visitingEndTime = visitingEndTime;
        this.type = type;
        this.location = location;
    }

    /**
     * Returneaza locatia clientului.
     * @return Locatia clientului.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Returneaza numele clientului.
     * @return Numele clientului.
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele clientului.
     * @param name Noul nume al clientului.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returneaza timpul de inceput al vizitei pentru client.
     * @return Timpul de inceput al vizitei pentru client.
     */
    public int getVisitingStartTime() {
        return visitingStartTime;
    }

    /**
     * Seteaza timpul de inceput al vizitei pentru client.
     * @param visitingStartTime Noul timp de inceput al vizitei pentru client.
     */
    public void setVisitingStartTime(int visitingStartTime) {
        this.visitingStartTime = visitingStartTime;
    }

    /**
     * Returneaza timpul de sfarsit al vizitei pentru client.
     * @return Timpul de sfarsit al vizitei pentru client.
     */
    public int getVisitingEndTime() {
        return visitingEndTime;
    }

    /**
     * Seteaza timpul de sfarsit al vizitei pentru client.
     * @param visitingEndTime Noul timp de sfarsit al vizitei pentru client.
     */
    public void setVisitingEndTime(int visitingEndTime) {
        this.visitingEndTime = visitingEndTime;
    }

    /**
     * Returneaza tipul clientului.
     * @return Tipul clientului.
     */
    public clientType getType() {
        return type;
    }

    /**
     * Seteaza tipul clientului.
     * @param type Noul tip al clientului.
     */
    public void setType(clientType type) {
        this.type = type;
    }

    /**
     * Suprascrie metoda equals pentru a compara clientii dupa numele lor.
     * @param o Obiectul de comparat.
     * @return True daca obiectele sunt egale, false in caz contrar.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name);
    }

    /**
     * Suprascrie metoda hashCode.
     * @return Valoarea hash code pentru client.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
