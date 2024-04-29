package org.example;


import org.example.Bag;
import org.example.Token;

import java.util.ArrayList;
import java.util.List;

public class Player extends Thread {
    private String name;
    private Bag bag;
    private int n;
    private List<Token> sequence;
    private int score;

    public Player(String name, Bag bag, int n) {
        this.name = name;
        this.bag = bag;
        this.n = n;
        this.sequence = new ArrayList<>();
        this.score = 0;
    }

    public String getPlayerName() {
        return this.name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bag) {
                while (!bag.getCurrentPlayer().equals(this)) {
                    try {
                        bag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Token token = bag.extractToken();
                if (token == null || token.getNumber1() == n) {
                    System.out.println(name + " a terminat cu scorul: " + score);
                    System.out.println(name + " secventa finala: " + sequence);
                    bag.nextPlayer();
                    break;
                }
                sequence.add(token);
                if (token.getNumber2() == n) {
                    score++;
                }
                System.out.println(name + " a extras tokenul: " + token);
                System.out.println(name + " secventa curenta: " + sequence);
                bag.nextPlayer();
            }
        }
    }

    public int getScore() {
        return score;
    }
}
