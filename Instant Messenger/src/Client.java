import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {
	public Client(){
		
	}
	public Client(int port, String host){
		try {
			Socket client = new Socket(host,port);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void recieve(Socket client){
			BufferedReader in;
			try {
				in = new BufferedReader(new InputStreamReader(client.getInputStream()));
				System.out.print("String Recieved :");
				while(!in.ready()){
					System.out.println(in.readLine());
					System.out.println();
				}
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
