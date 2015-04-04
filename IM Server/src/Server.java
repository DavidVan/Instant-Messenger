import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;

public class Server {
	public int port;
	public ServerSocket serverSocket;
	public ArrayList<Socket> clients;
	ArrayList<PrintWriter> output;
	ArrayList<BufferedReader> input;
	
	public Server() {
		
	}
	
	public Server(int port) {
		clients = new ArrayList<Socket>();
		output = new ArrayList<PrintWriter>();
		input = new ArrayList<BufferedReader>();
		this.port = port;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectClient() {
		try {
			clients.add(serverSocket.accept());
			output.add(new PrintWriter(clients.get(clients.size()-1).getOutputStream(), true));
			input.add(new BufferedReader(new InputStreamReader(clients.get(clients.size()-1).getInputStream())));
			String userName = input.get(input.size()-1).readLine();
			output.get(output.size()-1).println("Welcome " + userName + "! Connection to server successful!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void continuousConnection() {
//		try {
//			if () {
//				clients.remove();
//			}
//			for (int i = 0; i < clients.size(); i++) {
//				output.add(new PrintWriter(clients.get(i).getOutputStream(), true));
//				input.add(new BufferedReader(new InputStreamReader(clients.get(i).getInputStream())));
//			}
			while(clients.size() != 0) {
				for (int i = 0; i < input.size(); i++) {
					for (int j = 0; j < output.size(); j++) {
						if (input.get(i) != null) {
							output.get(j).println(input.get(i));
						}
					}
				}
			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
