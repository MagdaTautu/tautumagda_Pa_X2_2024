package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private int n;
    private List<Token> tokens;
    private Player[] players;
    private int currentPlayerIndex;

    public Bag(int n, Player[] players) {
        this.n = n;
        this.tokens = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.players = players;

        for (int i = 1; i <= n; i++) {
            if (i < n) {
                tokens.add(new Token(i, i + 1));
            }
        }
        Collections.shuffle(tokens);
    }

    public synchronized Token extractToken() {
        if (!tokens.isEmpty()) {
            return tokens.remove(0);
        }
        return null;
    }

    public synchronized Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    public synchronized void nextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
        notifyAll();
    }

    public int getN() {
        return n;
    }
}
