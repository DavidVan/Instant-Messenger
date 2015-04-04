import java.util.Scanner;


public class StartServer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = sc.nextLine();
		int port = sc.nextInt();
		sc.close();
		Server s = new Server(port);
	}
}
