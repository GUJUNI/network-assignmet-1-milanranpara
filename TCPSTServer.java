/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    TCP Single threaded Server
*/

import java.io.*; 
import java.net.*;
class TCPSTServer
{ 
    public static void main(String ar[])throws Exception 
    { 
        ServerSocket ss=new ServerSocket(777); 
        Socket s=ss.accept(); 
        System.out.println("Connection Established"); 
        OutputStream obj=s.getOutputStream(); 
        PrintStream ps=new PrintStream(obj); 
        String str="Hello Client"; 
        ps.println(str); 
        ps.println("Bye"); 
        ps.close(); 
        ss.close(); 
        s.close(); 
    } 
}