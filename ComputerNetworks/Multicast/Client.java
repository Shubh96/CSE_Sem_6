import java.io.*;
import java.net.*;

class Client{
	public static void main(String[] args) {
		try{
			InetAddress group = InetAddress.getByName("224.0.0.1");
			MulticastSocket s = new MulticastSocket(1234);

			String msg = "Hello, this is a multicast message.";

			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 1234);

			s.send(packet);
			s.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}