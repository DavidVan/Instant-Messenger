import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class imServer {

	public int port;

	public imServer() {
	}
	/**
	 * Constructor for socket.
	 * @param port
	 */
	public imServer(int port) {
		this.port = port;
		try {
			ServerSocket serverSocket = new ServerSocket(this.port);
			Socket clientSocket = serverSocket.accept();
			PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
