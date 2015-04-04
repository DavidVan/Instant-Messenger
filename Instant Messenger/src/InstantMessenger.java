
public class InstantMessenger {
	public static void main(String[] args) {
		imServer myServer = new imServer(45001);
		Client myClient = new Client(45001, "localhost");
		System.out.println("Yay.");
	}
}
