import java.net.*;
import java.io.*;

class lowerToUpperClient{
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost", 1111);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.print("Enter the message: ");

			String str = in.readLine();
			out.println(str);

			System.out.println("Waiting for the server to return the message in uppercase...");
			str = br.readLine();
			System.out.println("Sever reponded. Message Recieved: " + str);

			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*
Enter the message: make this uppercase
Waiting for the server to return the message in uppercase...
Sever reponded. Message Recieved: MAKE THIS UPPERCASE
*/