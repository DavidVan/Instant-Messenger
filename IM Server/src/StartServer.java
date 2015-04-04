import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class StartServer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String host = "localhost";
		int port = 4444;
		System.out.println("Server Online!");
		Server s = new Server(port);
		ArrayList<Socket> list = new ArrayList<Socket>();
		try {
			int count = 0;
			while (true) {
				list.add(s.serverSocket.accept());
				if (!s.clients.contains(list.get(count))) {
					s.connectClient(list.get(count));
				}
				count++;
				s.continuousConnection();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
