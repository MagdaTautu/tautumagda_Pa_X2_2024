package org.example;

import org.example.TimeKeeper;

public class Game extends Thread {
    private final int n;
    private final int numberOfPlayers;

    private Bag bag;
    private Player[] players;
    private TimeKeeper timeKeeper;

    public Game(int n, int numberOfPlayers, Player[] players) {
        this.n = n;
        this.numberOfPlayers = numberOfPlayers;
        this.players = players;
        this.bag = new Bag(n, players);
        this.timeKeeper = new TimeKeeper(this);
    }

    @Override
    public void run() {
        timeKeeper.start();

        for (Player player : players) {
            player.start();
            System.out.println(player.getPlayerName() + " joined");
        }

        for (Player player : players) {
            try {
                player.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Player[] getPlayers() {
        return players;
    }

    public void interruptPlayers() {
        for (Player player : players) {
            player.interrupt();
        }
    }
}
