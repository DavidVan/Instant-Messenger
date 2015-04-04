import java.util.Scanner;


public class StartClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "10.122.1.2";
		int port = 4444;
		System.out.println();
		String userName = "Hello";
		sc.close();
		Client c = new Client(host, port, userName);
		c.initialConnection();
		c.send();
		c.recieve();
		//
		//while(!c.send().contains("quit")){
		//	c.send();
		//	c.recieve();
		//}
	}
}
