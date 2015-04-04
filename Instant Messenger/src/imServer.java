import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class imServer {

	public int port;
	public String host;
	
	public imServer() {
	}
	/**
	 * Constructor for 
	 * @param port
	 * @param host
	 */
	public imServer(int port, String host) {
		this.port = port;
		this.host = host;
		try {
			ServerSocket serverSocket = new ServerSocket(this.port, 0, InetAddress.getByName(this.host));;
			Socket clientSocket = serverSocket.accept();
			PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);
			System.out.println(output);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
