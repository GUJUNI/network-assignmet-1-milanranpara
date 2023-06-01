/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    TCP Single threaded Client
*/

import java.io.*; 
import java.net.*; 
    class simptcpclient1 
    { 
        public static void main(String ar[])throws Exception 
        { 
            Socket s=new Socket("localhost",777); 
            InputStream obj=s.getInputStream(); 
            BufferedReader br=new BufferedReader(new InputStreamReader(obj)); 
            String str; 
            while((str=br.readLine())!=null) 
            { 
                System.out.println("From Server: "+str); 
            } 
            br.close(); 
            s.close(); 
        }
    }   
