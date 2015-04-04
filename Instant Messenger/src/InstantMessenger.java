
public class InstantMessenger {
	public static void main(String[] args) {
		imServer myServer = new imServer(45000, "localhost");
		Client myClient = new Client(45000, "localhost");
		System.out.println("Yay.");
	}
}
