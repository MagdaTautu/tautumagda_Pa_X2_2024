package com.homework;

/**
 * Clasa Pair reprezintă o pereche de două elemente de tipuri diferite.
 * Această clasă este utilizată pentru a reprezenta o asociere între doi obiecte de tipuri diferite.
 *
 * @param <A> Tipul primului element din pereche.
 * @param <B> Tipul celui de-al doilea element din pereche.
 */
public class Pair<A, B> {
    A first; // Primul element din pereche
    B second; // Al doilea element din pereche

    /**
     * Constructorul clasei Pair.
     *
     * @param first  Primul element din pereche.
     * @param second Al doilea element din pereche.
     */
    public Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Returnează primul element din pereche.
     *
     * @return Primul element din pereche.
     */
    public A getFirst() {
        return first;
    }

    /**
     * Setează primul element din pereche.
     *
     * @param first Noul primul element din pereche.
     */
    public void setFirst(A first) {
        this.first = first;
    }

    /**
     * Returnează al doilea element din pereche.
     *
     * @return Al doilea element din pereche.
     */
    public B getSecond() {
        return second;
    }

    /**
     * Setează al doilea element din pereche.
     *
     * @param second Noul al doilea element din pereche.
     */
    public void setSecond(B second) {
        this.second = second;
    }

    /**
     * Returnează o reprezentare textuală a perechii.
     *
     * @return O reprezentare textuală a perechii.
     */
    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}
