import java.net.*;
import java.io.*;
import java.util.Date;

class DateServer{
	public static void main(String[] args) {
		try{
			ServerSocket ss = new ServerSocket(2345);
			Socket s = ss.accept();
			Date date = new Date();
			PrintStream out = new PrintStream(s.getOutputStream());

			out.println(date);
			s.close();
			ss.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}