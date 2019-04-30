package stic3.sn.ui;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.ResourceBundle;

import cours.java.stic3.model.Participant;
import cours.java.stic3.model.Projet;
import cours.java.stic3.model.Tache;
import cours.java.stic3.service.IObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class ParticipationController implements Initializable{

    @FXML
    private TextArea desc;

    @FXML
    private ComboBox<Participant> ComboPar;

    @FXML
    private Button btnAdd;

    @FXML
    private ComboBox<Tache> ComboTache;

    @FXML
    private ComboBox<Projet> ComboProjet2;
    
    private ObservableList<Projet> projets;
    private ObservableList<Tache> taches;
    private ObservableList<Participant> pars;

    @FXML
    void onClick(ActionEvent event) {
    	if(event.getSource()==ComboProjet2) {
    		taches = FXCollections.observableArrayList();
    		Registry registry;
    		try {
    			registry = LocateRegistry.getRegistry("localhost",1004);
    			IObject iobj = (IObject)registry.lookup("OjectDistant");
    			List<Object> objects = iobj.ListObject("Tache");
    			for(Object object: objects) {
    				taches.add((Tache)object);
    			}
			} catch (Exception e) {
				// TODO: handle exception
			}
    		for(Tache t: taches) {
    			if(t.getTacheId() == ComboProjet2.getSelectionModel().getSelectedItem().getProjetId()) {
    				ComboTache.setItems(taches);
    			}
    		}
    		
    	}
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		projets = FXCollections.observableArrayList();
		pars = FXCollections.observableArrayList();
		Registry registry;
		try {
			registry = LocateRegistry.getRegistry("localhost",1004);
			IObject iobj = (IObject)registry.lookup("OjectDistant");
			List<Object> objects = iobj.ListObject("Projet");
			for(Object object: objects) {
				projets.add((Projet)object);
			}
			ComboProjet2.setItems(projets);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			registry = LocateRegistry.getRegistry("localhost",1004);
			IObject iobj = (IObject)registry.lookup("OjectDistant");
			List<Object> objects = iobj.ListObject("Participant");
			for(Object object: objects) {
				pars.add((Participant)object);
			}
			ComboPar.setItems(pars);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*try {
			registry = LocateRegistry.getRegistry("localhost",1004);
			IObject iobj = (IObject)registry.lookup("OjectDistant");
			List<Object> objects = iobj.ListObject("Tache");
			for(Object object: objects) {
				taches.add((Tache)object);
			}
			ComboTache.setItems(taches);
		} catch (Exception e) {
			// TODO: handle exception
		}*/
		
	}

}