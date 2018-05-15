import java.io.*;
import java.net.*;

public class CRCSender{
	public static void main(String args[]){
		try{
			String msg, divisor, toSend = "";
			Socket cs = new Socket("localhost", 1111);
			PrintStream out = new PrintStream(cs.getOutputStream());
		
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter the message: ");
			msg = in.readLine();
			System.out.print("Enter the divisor: ");
			divisor = in.readLine();

			String[] s = msg.split("");
			String[] s2 = divisor.split("");

			int[] data = new int[msg.length()+divisor.length()-1];
			int[] dataDivisor = new int[divisor.length()];

			for(int i = 0; i<msg.length();i++)
				data[i] = Integer.parseInt(s[i]);
			
			for(int i = 0; i<divisor.length();i++)
				dataDivisor[i] = Integer.parseInt(s2[i]);

			System.out.println();

			for(int i= 0;i<msg.length();i++){
				if(data[i] == 1)
					for(int j=0;j<divisor.length();j++)
						data[i+j]^=dataDivisor[j];
			}

			System.out.println();

			System.out.print("CRC: ");

			for(int i = 0; i<msg.length()+divisor.length()-1;i++){
				System.out.print(data[i]);
			}

			for(int i=0;i<msg.length();i++){
				toSend = toSend + s[i];
			}

			for(int i=0;i<divisor.length()-1;i++){
				toSend = toSend + data[msg.length()+i];
			}
	
			System.out.println();
			System.out.println("Message with CRC: " + toSend);
			out.println(toSend);
			cs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}

/*
Output at Sender Side:

Enter the message: 11011
Enter the divisor: 1101

CRC: 00000101
Message with CRC: 11011101
*/