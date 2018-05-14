import java.net.*;
import java.io.*;

class ReplyMessageServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(1111);
			Socket s = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.println("Waiting for server to send message...");
			String str = br.readLine();

			System.out.println("Message recieved. Sending back the same message to the client.");
			out.println(str);

			s.close();
			ss.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
/*
Waiting for server to send message...
Message recieved. Sending back the same message to the client.
*/