import java.net.*;

class ShowHostName{
	public static void main(String[] args) {
		try {
            InetAddress host = InetAddress.getLocalHost();
            String hostName = host.getHostName();
            System.out.println("Current IP address : " + host);
            System.out.println("Current Host name : " + hostName);
 
        }catch (Exception e) {
 
            e.printStackTrace();
        }
	}
}

/*OUTPUT:

Current IP address : Shubh96/127.0.1.1
Current Hostname : Shubh96
*/