package com.example.laborator6;

import java.io.Serializable;

/**
 * Clasa care reprezintă un bastonaș în jocul pozițional.
 */
public class Stick implements Serializable {
    private int startX; // Coordonata x a punctului de start al bastonașului
    private int startY; // Coordonata y a punctului de start al bastonașului
    private int endX; // Coordonata x a punctului de sfârșit al bastonașului
    private int endY; // Coordonata y a punctului de sfârșit al bastonașului

    /**
     * Constructor pentru inițializarea unui bastonaș cu coordonatele de start și de sfârșit specificate.
     * @param startX Coordonata x a punctului de start al bastonașului
     * @param startY Coordonata y a punctului de start al bastonașului
     * @param endX Coordonata x a punctului de sfârșit al bastonașului
     * @param endY Coordonata y a punctului de sfârșit al bastonașului
     */
    public Stick(int startX, int startY, int endX, int endY) {
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    /**
     * Metodă pentru obținerea coordonatei x a punctului de start al bastonașului.
     * @return Coordonata x a punctului de start
     */
    public int getStartX() {
        return startX;
    }

    /**
     * Metodă pentru obținerea coordonatei y a punctului de start al bastonașului.
     * @return Coordonata y a punctului de start
     */
    public int getStartY() {
        return startY;
    }

    /**
     * Metodă pentru obținerea coordonatei x a punctului de sfârșit al bastonașului.
     * @return Coordonata x a punctului de sfârșit
     */
    public int getEndX() {
        return endX;
    }

    /**
     * Metodă pentru obținerea coordonatei y a punctului de sfârșit al bastonașului.
     * @return Coordonata y a punctului de sfârșit
     */
    public int getEndY() {
        return endY;
    }

}
