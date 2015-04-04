import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class imServer {

	public int port;
	public ServerSocket serverSocket;

	public imServer() {
	}
	/**
	 * Constructor for socket.
	 * @param port
	 */
	public imServer(int port) {
		this.port = port;
		try {
			serverSocket = new ServerSocket(this.port);
			System.out.println("1");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void accept() {
		try {
			Socket clientSocket = serverSocket.accept();
			PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			output.println("Sent Data");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
