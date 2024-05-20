package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        final int PORT = 5000;
        GameServer server = new GameServer(PORT);
        server.start();
    }
}