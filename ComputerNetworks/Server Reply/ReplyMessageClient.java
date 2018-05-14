import java.net.*;
import java.io.*;

class ReplyMessageClient{
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost", 2345);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.print("Enter your message: ");
			String str = in.readLine();
			out.println(str);

			System.out.println("Waiting for server reply...");
			str = br.readLine();
			System.out.println("Message from server: " + str);

			s.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
/* OUTPUT:

Enter your message: Hi there
Waiting for server reply...
Message from server: Hi there
*/