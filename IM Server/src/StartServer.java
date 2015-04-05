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
		Socket temp;
		Socket temp2;
		try {
			temp = s.serverSocket.accept();
			s.connectClient(temp);

			while (true) {
				s.continuousConnection();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
