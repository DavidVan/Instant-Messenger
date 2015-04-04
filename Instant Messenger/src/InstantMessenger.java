
public class InstantMessenger {
	public static void main(String[] args) {
		String host = args[0];
		int port = Integer.parseInt(args[1]);
		imServer myServer = new imServer(port, host);
	}
}
