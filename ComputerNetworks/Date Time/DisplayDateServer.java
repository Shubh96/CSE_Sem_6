import java.net.*;
import java.io.*;
import java.util.Date;

class DisplayDateServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(1111);
			Socket s = ss.accept();
			Date d = new Date();
			PrintStream out = new PrintStream(s.getOutputStream());

			out.println(d);
			s.close();
			ss.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}