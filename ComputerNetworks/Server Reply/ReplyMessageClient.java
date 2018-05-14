import java.net.*;
import java.io.*;

class ReplyMessageClient{
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost", 1111);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.print("Enter your message: ");
			String str = in.readLine();
			out.println(str);

			System.out.println("Waiting for server to send back message...");
			str = br.readLine();
			System.out.println("Message recieved from server: " + str);

			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
/*
Enter your message: Baka Here :D
Waiting for server to send back message...
Message recieved from server: Baka Here :D
*/