import java.net.*;
import java.io.*;

class DisplayDateClient{
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost", 1111);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.println("Waiting for server to response...");

			String str = br.readLine();
			System.out.println("Server responded. Fetching Server Time...");
			System.out.println("Server Time: " + str);

			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*
Waiting for server to response...
Server responded. Fetching Server Time...
Server Time: Wed May 09 21:07:57 IST 2018
*/