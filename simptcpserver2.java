/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    TCP Single threaded Server
*/

import java.io.*;
import java.net.*;

public class simptcpserver2 {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("TCP server is running...");

            while (true) {
                // Wait for a client to connect
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Create input and output streams for the client socket
                BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());

                // Read the actor's name from the client
                String actor = inFromClient.readLine();
                System.out.println("Received actor: " + actor);

                // Lookup the actor's latest movie based on the actor's name
                String movie = lookupLatestMovie(actor);

                // Send the actor's latest movie back to the client
                outToClient.writeBytes(movie + '\n');
                System.out.println("Sent latest movie: " + movie);

                // Close the client socket
                clientSocket.close();
                System.out.println("Client disconnected: " + clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String lookupLatestMovie(String actor) {
        // Add your logic here to lookup the actor's latest movie based on the actor's name
        // This can be done using a database, API, or any other data source
        // For simplicity, let's assume a few hardcoded mappings

        switch (actor.toLowerCase()) {
            case "leonardo dicaprio":
                return "Once Upon a Time in Hollywood";
            case "scarlett johansson":
                return "Black Widow";
            case "tom hanks":
                return "News of the World";
            default:
                return "Unknown";
        }
    }
}

