import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	
	public Socket client;
	
	public Client(){
		
	}
	public Client(int port, String host){
		try {
			client = new Socket(host,port);
			//send("Hello",client);
			
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
	public void send(String message,Socket client){
		try {
			DataOutputStream mOut = new DataOutputStream(client.getOutputStream());
			mOut.writeByte(1);
			mOut.writeUTF(message);
			mOut.flush();
			
			mOut.writeByte(-1);
			mOut.flush();
			mOut.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
