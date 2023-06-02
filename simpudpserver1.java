/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    UPD Single threaded Server
*/

import java.io.*;
import java.net.*;

public class simpudpserver1 {
    public static void main(String[] args) {
        DatagramSocket serverSocket;
        try {
            // Create a UDP socket
            serverSocket = new DatagramSocket(12345);
            System.out.println("UDP server is running...");

            byte[] receiveData = new byte[1024];
            byte[] sendData;

            while (true) {
                // Receive data from the client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Process the received data
                String message = new String(receivePacket.getData()).trim();
                System.out.println("Received from client: " + message);

                // Prepare the response data
                String response = "Hello, client!";
                sendData = response.getBytes();

                // Get the client's address and port
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                // Send the response back to the client
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
