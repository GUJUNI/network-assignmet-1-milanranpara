/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    TCP Single threaded Client
*/

import java.io.*;
import java.net.*;

public class simptcpclient2 {
    public static void main(String[] args) {
        try {
            // Create a client socket and connect to the server
            Socket clientSocket = new Socket("localhost", 12345);

            // Create input and output streams for the client socket
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            // Create a BufferedReader to read user input from the console
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            // Prompt the user to enter an actor's name
            System.out.print("Enter an actor's name: ");
            String actor = inFromUser.readLine();

            // Send the actor's name to the server
            outToServer.writeBytes(actor + '\n');

            // Receive the actor's latest movie from the server
            String movie = inFromServer.readLine();

            // Print the actor's latest movie
            System.out.println("Latest movie: " + movie);

            // Close the client socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

