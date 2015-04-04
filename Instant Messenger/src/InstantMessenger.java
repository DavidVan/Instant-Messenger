
public class InstantMessenger {
	public static void main(String[] args) {
		imServer myServer = new imServer(45005);
		Client myClient = new Client(45005, "localhost", "Kenneth");
		myServer.accept();
		myClient.recieve();
		myServer.receive();
	}
}
