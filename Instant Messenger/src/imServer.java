import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class imServer {
	public imServer() {
	}
	/**
	 * Constructor for 
	 * @param port
	 * @param host
	 */
	public imServer(int port, String host) {
		try {
			ServerSocket serverSocket = new ServerSocket(port, 0, InetAddress.getByName(host));;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}