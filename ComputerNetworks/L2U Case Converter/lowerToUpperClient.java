import java.net.*;
import java.io.*;

class lowerToUpperClient{
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost", 2345);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.print("Enter message: ");

			String str = br.readLine();
			out.println(str);

			System.out.println("Waiting for the server..");
			str = in.readLine();
			System.out.println("Message Received: " + str);

			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/* OUTPUT

Enter message: subham sarda
Waiting for the server..
Message Received: SUBHAM SARDA
*/