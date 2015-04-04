
public class InstantMessenger {
	public static void main(String[] args) {
		imServer myServer = new imServer(45005);
		System.out.println("Test");
		Client myClient = new Client(45005, "localhost");
		myServer.accept();
		System.out.println("Yay.");
		myClient.recieve();
		myServer.receive();
	}
}
