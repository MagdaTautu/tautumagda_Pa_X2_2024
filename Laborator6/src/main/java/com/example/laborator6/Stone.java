package com.example.laborator6;
import java.io.Serializable;

/**
 * Clasa care reprezintă o piatră în joc.
 */
public class Stone implements Serializable {
    private int x; // Coordonata x a poziției pietrei
    private int y; // Coordonata y a poziției pietrei
    private StoneColor color; // Culoarea pietrei

    /**
     * Enumerația pentru culorile pietrelor.
     */
    public enum StoneColor implements Serializable {
        RED, // Culoare roșie
        BLUE // Culoare albastră
    }

    /**
     * Constructor pentru crearea unei noi pietre.
     *
     * @param x     Coordonata x a poziției pietrei.
     * @param y     Coordonata y a poziției pietrei.
     * @param color Culoarea pietrei.
     */
    public Stone(int x, int y, StoneColor color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    /**
     * Returnează coordonata x a pietrei.
     *
     * @return Coordonata x a pietrei.
     */
    public int getX() {
        return x;
    }

    /**
     * Returnează coordonata y a pietrei.
     *
     * @return Coordonata y a pietrei.
     */
    public int getY() {
        return y;
    }

    /**
     * Returnează culoarea pietrei.
     *
     * @return Culoarea pietrei.
     */
    public StoneColor getColor() {
        return color;
    }
}