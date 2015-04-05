import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

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
		String message = recieve(clients.get(0));
			if(message != ""){
				System.out.println(message);
				send(message);
			}
			else {
				serverSpeak();
			}

	}
	public String serverSpeak(){
		String response = "";
		try {
			PrintWriter out = new PrintWriter(clients.get(0).getOutputStream(), true);
			Scanner sc = new Scanner(System.in);
			String fromServer = sc.nextLine();
			response += fromServer;
			System.out.println("Admin(localhost): " + response);
			out.println("Admin(localhost): " + response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}

	public void send(String message) {
			try {
				PrintWriter out = new PrintWriter(clients.get(0).getOutputStream(), true);
				out.println(message);
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
	}
	
	public String recieve(Socket socket) {
		String message = "";
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			message = in.readLine();
			return message;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return message;
	}
	
}
