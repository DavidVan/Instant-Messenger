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
	public ArrayList<PrintWriter> output;
	public ArrayList<BufferedReader> input;
	
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
			PrintWriter out = new PrintWriter(clients.get(clients.size()-1).getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clients.get(clients.size()-1).getInputStream()));
			String userName = in.readLine();
			System.out.println(userName + " has connected.");
			out.println("Welcome " + userName + "! Connection to server successful!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectClient(Socket temp) {
		try {
			clients.add(temp);
			PrintWriter out = new PrintWriter(clients.get(clients.size()-1).getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clients.get(clients.size()-1).getInputStream()));
			String userName = in.readLine();
			System.out.println(userName + " has connected.");
			out.println("Welcome " + userName + "! Connection to server successful!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void continuousConnection() {
		try {
//			if () {
//				clients.remove();
//			}
			for (int i = 0; i < clients.size(); i++) {
				PrintWriter temp = new PrintWriter(clients.get(i).getOutputStream(), true);
				BufferedReader temp2 = new BufferedReader(new InputStreamReader(clients.get(i).getInputStream()));
				if (!output.contains(temp) && !input.contains(temp2)) {
					output.add(temp);
					input.add(temp2);
				}
			}
			for (int i = 0; i < input.size(); i++) {
				for (int j = 0; j < output.size(); j++) {
					String temp = input.get(i).readLine();
					if (temp != null) {
						output.get(j).println(temp);
						System.out.println(temp);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
