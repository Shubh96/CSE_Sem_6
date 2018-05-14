import java.net.*;
import java.io.*;

class DateClient{
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost", 2345);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.println("Waiting for server...");

			String str = br.readLine();
			System.out.println("Server Time: " + str);

			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*OUTPUT:

Waiting for server...
Server Time: Mon May 14 16:26:00 IST 2018
*/