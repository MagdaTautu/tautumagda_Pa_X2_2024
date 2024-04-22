package com.example.laborator6;

import java.io.Serializable;

/**
 * Clasa care reprezintă un jucător în jocul pozițional.
 */
public class Player {
    /**
     * Enumerație pentru culoarea pietrelor jucătorului.
     */
    public enum StoneColor implements Serializable {
        RED, // Culoarea roșie
        BLUE // Culoarea albastră
    }

    private StoneColor color; // Culoarea jucătorului

    /**
     * Constructor pentru inițializarea unui jucător cu o anumită culoare.
     * @param color Culoarea jucătorului
     */
    public Player(StoneColor color) {
        this.color = color;
    }

    /**
     * Metodă pentru obținerea culorii pietrelor jucătorului.
     * @return Culoarea pietrelor jucătorului
     */
    public StoneColor getColor() {
        return color;
    }

    /**
     * Metodă pentru setarea culorii pietrelor jucătorului.
     * @param color Noua culoare a pietrelor jucătorului
     */
    public void setColor(StoneColor color) {
        this.color = color;
    }
}
