import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class StartServer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int port = 4444;
		System.out.println("Server Online!");
		Server s = new Server(port);
		s.connectClient();
		Socket temp;
		try {
			while (true) {	
				temp = s.serverSocket.accept();
				if (!s.clients.contains(temp)) {
					s.connectClient(temp);
				}
				s.continuousConnection();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
