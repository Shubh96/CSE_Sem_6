import java.net.*;
import java.io.*;

class ReplyMessageServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(2345);
			Socket s = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintStream out = new PrintStream(s.getOutputStream());

			String str = br.readLine();

			System.out.println("Replying to the client");
			out.println(str);

			s.close();
			ss.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
/* OUTPUT:

Replying to the client
*/