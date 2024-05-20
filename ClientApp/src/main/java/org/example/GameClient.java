package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main(String[] args) {
        final String SERVER_IP = "127.0.0.1";
        final int SERVER_PORT = 5000;

        try (
                Socket socket = new Socket(SERVER_IP, SERVER_PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in))
        ) {
            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String userInput;

            System.out.println("Connected to server. Type 'exit' to quit.");

            while ((userInput = in.readLine()) != null) {
                out.println(userInput);
                if (userInput.equals("exit")) {
                    break;
                }
                String serverResponse = serverIn.readLine();
                System.out.println("Server response: " + serverResponse);
            }
        } catch (UnknownHostException e) {
            System.err.println("Unknown host: " + SERVER_IP);
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}