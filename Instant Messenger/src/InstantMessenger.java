
public class InstantMessenger {
	public static void main(String[] args) {
<<<<<<< Updated upstream
		imServer myServer = new imServer(45005);
		System.out.println("Test");
		Client myClient = new Client(45005, "localhost");
		myServer.accept();
=======
		imServer myServer = new imServer(45001);
		Client myClient = new Client(45001, "localhost");
>>>>>>> Stashed changes
		System.out.println("Yay.");
		myClient.recieve();
	}
}
