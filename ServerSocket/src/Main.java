import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Main {
	private static ServerSocket srv;
	public static Map<String, Socket> clients = new HashMap<>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			srv = new ServerSocket(5001);
			System.out.println("Server lance sur le port 5001");
			Socket client = null;
			while (true) {
				client = srv.accept();
				new ThreadClient(client).start();
				
			}
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
