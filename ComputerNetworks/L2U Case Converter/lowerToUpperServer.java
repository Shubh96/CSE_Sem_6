import java.net.*;
import java.io.*;

class lowerToUpperServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(1111);
			Socket s = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.println("Waiting for clients message...");
			String str = br.readLine();

			System.out.println("Message Recieved. Coverting to uppercase and sending...");

			out.println(str.toUpperCase());
			System.out.println("Done.");

			s.close();
			ss.close();			

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
/*
Waiting for clients message...
Message Recieved. Coverting to uppercase and sending...
Done.
*/