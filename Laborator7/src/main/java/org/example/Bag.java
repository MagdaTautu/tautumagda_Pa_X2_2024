package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private int n;
    private List<Token> tokens;

    public Bag(int n) {
        this.n = n;
        tokens = new ArrayList<>();
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

    public int getN() {
        return n;
    }
}
