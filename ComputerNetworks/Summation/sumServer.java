import java.io.*;
import java.net.*;

class sumServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(2345);
			Socket s = ss.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());

			String clientMsg = in.readLine();																//Client message

			String[] numbers = clientMsg.split(" ");
			int sum = 0;
			for(int i = 0; i<numbers.length;i++){
				sum = sum + Integer.parseInt(numbers[i]);
			}

			out.println(sum);																		//Sending to client

			s.close();																				//Closing socket
			ss.close();																				//Closing server socket
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*OUTPUT:

Waiting for client to send message...
Message Received. Doing summation.
Sending summation to client...
Done.
*/