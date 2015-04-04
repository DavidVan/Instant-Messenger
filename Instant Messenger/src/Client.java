import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

	public Socket client;
	private String name;
	private String ip;
	public Client(){
		
	}
	public Client(int port, String host, String name){
		this.name = name;
		try {
			client = new Socket(host,port);
			this.ip = client.getInetAddress().toString();
			send();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void recieve(){
		BufferedReader in;	
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//			System.out.print("String Recieved :");
			System.out.println(in.readLine());
			in.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void send(){
			try {
				PrintWriter out = new PrintWriter(client.getOutputStream(), true);
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String fromUser = in.readLine();
				out.println(name + "(" + ip + "): " + fromUser);				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
	}
	public void changeName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public String getIp(){
		return this.ip;
	}
}
