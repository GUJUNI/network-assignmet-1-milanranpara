/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    UPD Multi threaded Server
*/

import java.net.*;
import java.io.*;

public class mludpserver1
{
    public static void main (final String[] args)
    {
        while(isRunning)
        {
            final byte[] buffer = new byte[BUFFER_SIZE];
            final DatagramPacket receivedQuery = new DatagramPacket(buffer, buffer.length);
            try
            {
                final DatagramSocket server = new DatagramSocket(PORT);
                server.receive(receivedQuery);
                final Worker worker = new UDPWorker(receivedQuery);
                executor.execute(worker);
            }
            catches
            {
                termination issues ...
            }
        }
    }
}