package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


import java.util.concurrent.BlockingQueue;

public class Player extends Thread {
    private String name;
    private Bag bag;
    private int n;
    private int score;

    Player(String name, Bag bag, int n) {
        this.name = name;
        this.bag = bag;
        this.n = n;
        this.score = 0;
    }

    public void run() {
        while (true) {
            Token token = bag.extractToken();
            if (token == null || token.getNumber1() == n) {
                System.out.println(name + " are punctajul punctajul " + score);
                break;
            }
            if (token.getNumber1() == n) {
                score++;
            }
            System.out.println(name + " a extras token(" + token.getNumber1() + ", " + token.getNumber2() + ")");
        }
    }
    public int getScore() {
        return score;
    }
}
