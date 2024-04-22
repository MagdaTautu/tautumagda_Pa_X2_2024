package org.example;

import java.util.concurrent.BlockingQueue;

public class Game extends Thread {
    private int n;
    private int numberOfPlayers;
    private String[] playerNames;
    private Bag bag;

    public Game(int n, int numberOfPlayers, String[] playerNames) {
        this.n = n;
        this.numberOfPlayers = numberOfPlayers;
        this.playerNames = playerNames;
        this.bag = new Bag(n);
    }

    @Override
    public void run() {
        Player[] players = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = new Player(playerNames[i], bag, n);
            players[i].start();
        }

        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
