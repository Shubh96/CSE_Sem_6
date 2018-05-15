import java.io.*;
import java.net.*;

public class CRCReceiver{
	public static void main(String args[]){
		try{
			ServerSocket serverSocket = new ServerSocket(1111);
			Socket clientSocket = serverSocket.accept();
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader getClientMessage = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			PrintStream sendToClient = new PrintStream(clientSocket.getOutputStream());

			String msg = getClientMessage.readLine();
			System.out.println("Sender send: " + msg);

			System.out.print("Enter the divisor: ");
			String divisor = in.readLine();
			String[] s2 = divisor.split("");

			int[] dataDivisor = new int[divisor.length()];

			for(int i = 0; i<divisor.length();i++)
				dataDivisor[i] = Integer.parseInt(s2[i]);

			String[] s = msg.split("");

			int[] data = new int[msg.length()];

			for(int i = 0; i<msg.length();i++)
				data[i] = Integer.parseInt(s[i]);

			for(int i= 0;i<msg.length();i++){
				if(data[i] == 1)
					for(int j=0;j<divisor.length();j++)
						data[i+j]^=dataDivisor[j];
			}

			for(int i = 0; i<msg.length();i++){
				if(data[i] == 1){
					System.out.print("Error exists");
					System.exit(0);
				}
			}

			System.out.println("No error in message");
			
			clientSocket.close();
			serverSocket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

/*
Output at Receiver Side:

Sender send: 11011101
Enter the divisor: 1101
No error in message. Recieved successfully.
*/