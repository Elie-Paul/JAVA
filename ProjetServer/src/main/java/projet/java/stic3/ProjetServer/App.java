package projet.java.stic3.ProjetServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import cours.java.stic3.service.IObject;
import cours.java.stic3.service.ObjectImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws RemoteException, AlreadyBoundException
    {
    	System.setSecurityManager(new SecurityManager());
		Registry registry = LocateRegistry.createRegistry(1004);
		IObject obj = new ObjectImpl();
		registry.bind("OjectDistant", obj);
		System.out.println("Serveur lance sur le port 1004");   
    }
}
