import java.util.Scanner;


public class StartClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = sc.nextLine();
		int port = sc.nextInt();
		System.out.println();
		String userName = sc.nextLine();
		sc.close();
		Client c = new Client(host, port, userName);
		c.initialConnection();
		c.send();
		while(!c.send().contains("quit")){
			c.send();
			c.recieve();
		}
	}
}
