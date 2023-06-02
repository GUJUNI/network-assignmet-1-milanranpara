/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    UPD Single threaded Server
*/

import java.io.*;
import java.net.*;
import java.util.Date;

public class simpudpserver2 {
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

                // Process the received data (expecting a request for date)
                String request = new String(receivePacket.getData()).trim();
                if (request.equals("DateRequest")) {
                    // Get the current date
                    String date = new Date().toString();

                    // Prepare the response data
                    sendData = date.getBytes();

                    // Get the client's address and port
                    InetAddress clientAddress = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();

                    // Send the response back to the client
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                    serverSocket.send(sendPacket);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
