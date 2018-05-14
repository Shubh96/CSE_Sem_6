import java.io.*;
import java.net.*;

class sumClient{
	public static void main(String[] args) {
		try{
			Socket s = new Socket("localhost", 2345);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			PrintStream out = new PrintStream(s.getOutputStream());

			System.out.print("Enter space separated numbers: ");
			String numberString = br.readLine();																	//Taking User Input

			out.println(numberString);																			//Sending to server

			String sum;
			sum = in.readLine();																		//Getting server response

			System.out.println("Sum: " + sum);

			s.close();																					//Closing Socket
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*OUTPUT:

Enter space separated numbers: 12 11 21 7
Sum: 51
*/