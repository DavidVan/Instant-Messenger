import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class Client {
	public String host;
	public int port;
	public Socket clientSocket;
	public String userName;
	
	public Client() {
		
	}
	
	public Client(String host, int port) {
		this.host = host;
		this.port = port;
		Scanner sc = new Scanner(System.in);
		userName = sc.nextLine();
		sc.close();
		try {
			clientSocket = new Socket(host, port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void initialConnection() {
		try {
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			out.println(userName);
			System.out.println(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
