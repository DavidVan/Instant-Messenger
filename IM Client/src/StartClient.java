import java.util.Scanner;


public class StartClient {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = sc.nextLine();
		int port = sc.nextInt();
		sc.close();
		Client c = new Client(host, port);
		c.initialConnection();
	}
}
