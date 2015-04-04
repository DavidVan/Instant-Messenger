import java.util.Scanner;


public class StartClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "10.122.1.2";
		int port = 4444;
		System.out.println("Enter a name: ");
		String userName = sc.nextLine();
		Client c = new Client(host, port, userName);
		c.initialConnection();
		String status = c.send();
		c.recieve();
		
		while(!status.contains("quit")){
			status = c.send();
			c.recieve();
		}
	}
}
