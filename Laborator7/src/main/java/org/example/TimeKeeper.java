package org.example;
import org.example.Game;

import java.util.concurrent.TimeUnit;

public class TimeKeeper extends Thread {
    private final Game game;
    private final long startTime;
    private final long timeLimit;

    public TimeKeeper(Game game, long timeLimit) {
        this.game = game;
        this.startTime = System.currentTimeMillis();
        this.timeLimit = timeLimit;
    }

    public TimeKeeper(Game game) {
        this(game, TimeUnit.MINUTES.toMillis(5));
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= timeLimit) {
                System.out.println("Time limit exceeded. Stopping the game.");
                game.interruptPlayers();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Game ended due to time limit.");
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
