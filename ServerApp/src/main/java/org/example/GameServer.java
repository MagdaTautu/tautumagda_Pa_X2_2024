package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer{
    private final int PORT;

    public GameServer(int port) {
        this.PORT = port;
    }

    public void start() throws IOException{
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                System.out.println("Server started. Waiting for a client...");

                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                new ClientThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}