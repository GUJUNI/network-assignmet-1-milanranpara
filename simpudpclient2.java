/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    UPD Single threaded Client
*/

import java.io.*;
import java.net.*;

public class simpudpclient2 {
    public static void main(String[] args) {
        DatagramSocket clientSocket;
        try {
            // Create a UDP socket
            clientSocket = new DatagramSocket();

            // Server address and port
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 12345;

            // Prepare the request message
            String request = "DateRequest";
            byte[] sendData = request.getBytes();

            // Send the request to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket);

            // Receive the response from the server
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            // Process and print the response (which should be the current date)
            String response = new String(receivePacket.getData()).trim();
            System.out.println("Today's date: " + response);

            // Close the socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
