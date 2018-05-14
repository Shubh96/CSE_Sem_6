import java.net.*;
import java.io.*;

class lowerToUpperServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(2345);
			Socket s = ss.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());

			String str = in.readLine();

			System.out.println("Converting...");

			out.println(str.toUpperCase());
			System.out.println("Message Sent");

			s.close();
			ss.close();			

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
/* OUTPUT

Converting...
Message Sent
*/