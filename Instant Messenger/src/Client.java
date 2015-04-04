import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
<<<<<<< Updated upstream
	
	public Socket client;
	
=======
	private Socket client;
>>>>>>> Stashed changes
	public Client(){
		
	}
	public Client(int port, String host){
		try {
			client = new Socket(host,port);
<<<<<<< Updated upstream
			//send("Hello",client);
			
=======
			send();
			client.close();
>>>>>>> Stashed changes
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
			System.out.print("String Recieved :");
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
				out.println(fromUser);
//				while(fromUser != null){
//					System.out.println("Client: " + fromUser);
//					out.println(fromUser);
//				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
}
