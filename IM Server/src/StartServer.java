import java.util.Scanner;


public class StartServer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int port = 4444;
		System.out.println("Server Online!");
		sc.close();
		Server s = new Server(port);
		s.connectClient();
		s.continuousConnection();
	}
}
