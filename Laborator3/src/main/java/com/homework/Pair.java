package com.homework;

/**
 * Clasa care reprezintă o pereche de obiecte de tipuri diferite.
 *
 * @param <T> Tipul primului element al perechii.
 * @param <U> Tipul celui de-al doilea element al perechii.
 */
public class Pair<T, U> {
    /**
     * Primul element al perechii.
     */
    private T first;
    /**
     * Cel de-al doilea element al perechii.
     */
    private U second;

    /**
     * Constructor pentru inițializarea perechii.
     *
     * @param first  Primul element al perechii.
     * @param second Cel de-al doilea element al perechii.
     */
    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returnează primul element al perechii.
     *
     * @return Primul element al perechii.
     */
    public T getFirst() {
        return first;
    }

    /**
     * Returnează cel de-al doilea element al perechii.
     *
     * @return Cel de-al doilea element al perechii.
     */
    public U getSecond() {
        return second;
    }
}
