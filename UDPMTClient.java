/*
      NAME:     MILAN RANPARA
      SUBJECT:  ADVANCED NETWORKING 
      ROLL:     30
      TOPIC:    UPD Multi threaded Client
*/

public class UDPMTClient
{
	private DatagramPacket packet = null;
	public UDPWorker(final DatagramPacket aPacket)
	{
		packet = aPacket;
	}
	public void run()
	{
		packet.setData(getResponse());
		DatagramSocket socket = null;
		try
		{
			socket = new DatagramSocket();
			socket.send(response);
			socket.close();
		}
		catches
		{
			termination issues ...
		}
	}
}
