import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ThreadClient extends Thread {

	Socket client;

	public ThreadClient(Socket client) {
		this.client = client;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String pseudo="";
		try {
			BufferedReader fromClient = new  BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream toClient = new PrintStream(client.getOutputStream());

			
			do {
				pseudo = fromClient.readLine();
				if (Main.clients.keySet().contains(pseudo)) {
					toClient.println("Ce pseudo exite deja");
				}
				else {
					break;
				}
			} while (true);
			Main.clients.put(pseudo, client);
			toClient.println("Bonjour "+pseudo+" ton port d'ecoute est "+client.getPort());
			
			do {
				String message = fromClient.readLine();
				if (message == null)
					break;
				for (Socket c : Main.clients.values()) {
					PrintStream st = new PrintStream(c.getOutputStream());
					st.println("|: "+pseudo + " dit: " + message);
				} 
			} while (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				client.close();
				Main.clients.remove(pseudo);
				Main.clients.keySet().forEach(e->System.out.println());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
