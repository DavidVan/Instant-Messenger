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
	public Server() {
		
	}
	
	public Server(int port) {
		clients = new ArrayList<Socket>();
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
		int size = clients.size();
		int count = 0;
		while(size > 0) {
			String message = recieve(count);
			if(message != "") {
				send(message);
			}
			count++;
			if (count >= clients.size()) {
				count = 0;
			}
		}
	}
	
	public void send(String message) {
		try {
			for (int i = 0; i < clients.size(); i++) {
				PrintWriter out = new PrintWriter(clients.get(i).getOutputStream(), true);
				out.println(message);
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String recieve(int count) {
		String message = "";
		try {
			if(count < clients.size()) {
				BufferedReader in = new BufferedReader(new InputStreamReader(clients.get(count).getInputStream()));
				return in.readLine();
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
}
