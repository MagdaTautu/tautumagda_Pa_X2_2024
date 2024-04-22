package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        int n = 10;
        int nrPlayers = 2;
        String[] players = {"Player1", "Player2"};

        Game game = new Game(n, nrPlayers, players);
        game.start();

        try {
            game.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}