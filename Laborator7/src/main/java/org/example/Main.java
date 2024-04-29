package org.example;


public class Main {
    public static void main(String[] args) {
        int n = 10;
        int nrPlayers = 2;
        String[] playerNames = {"Player1", "Player2"};

        Player[] playerObjects = new Player[nrPlayers];

        Bag bag = new Bag(n, playerObjects);
        for (int i = 0; i < nrPlayers; i++) {
            playerObjects[i] = new Player(playerNames[i], bag, n);
        }

        Game game = new Game(n, nrPlayers, playerObjects);
        game.start();

        try {
            game.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

