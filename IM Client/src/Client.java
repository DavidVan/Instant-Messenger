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
	PrintWriter out;
	BufferedReader in;
	
	
	public Client() {
		
	}
	
	public Client(String host, int port,String userName) {
		this.host = host;
		this.port = port;
		this.userName = userName;
		try {
			clientSocket = new Socket(host, port);
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
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
			out.println(userName);
			System.out.println(in.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void recieve(){
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			String message = in.readLine();
			while(message != null){
				System.out.println(message);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String send(){
		String response = "";
		Scanner sc = new Scanner(System.in);
		String fromUser = sc.nextLine();
		response = fromUser;
		out.println(userName + "(" + clientSocket.getInetAddress() + "): " + fromUser);
		return response;
	}
}
