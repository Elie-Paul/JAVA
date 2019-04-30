package cours.java.stic3.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IObject extends Remote{

    Boolean InsertOrUpdateObject(Object obj) throws RemoteException;
    
    List<Object> ListObject(String model) throws RemoteException;

}
