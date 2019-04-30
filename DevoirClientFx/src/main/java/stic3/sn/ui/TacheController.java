package stic3.sn.ui;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.scene.control.TextField;
import stic3.sn.LoadView;
import stic3.sn.Utilitaires;

public class TacheController implements Initializable{

    @FXML
    private TextField nom;

    @FXML
    private TextField daDeb;

    @FXML
    private TextField daFin;

    @FXML
    private TextArea desc;

    @FXML
    private ComboBox<Projet> ComboProjet;

    @FXML
    private Button btnAdd;
    
    private ObservableList<Projet> projets;

    @FXML
    void onClick(ActionEvent event) {
    	Registry registry;
    	try {
    		registry = LocateRegistry.getRegistry("localhost",1004);
			IObject iobj = (IObject)registry.lookup("OjectDistant");
			Tache t = new Tache();
			int tacheId = 1;
			t.setTacheId(tacheId);
			t.setNom(nom.getText());
			t.setDescription(desc.getText());
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
			t.setDatedebut(formatter.parse(daDeb.getText()));
			t.setDatefin(formatter.parse(daFin.getText()));
			t.setProjetId(ComboProjet.getSelectionModel().getSelectedItem());
			
			if(iobj.InsertOrUpdateObject(t)) {
				Utilitaires.showMessage("Examen java", "Information", "Tache ajouter");
				LoadView.showView("Examen", "AddParticipation.fxml", 1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		Registry registry;
		projets = FXCollections.observableArrayList();
		try {
			registry = LocateRegistry.getRegistry("localhost",1004);
			IObject iobj = (IObject)registry.lookup("OjectDistant");
			List<Object> objects = iobj.ListObject("Projet");
			for(Object object: objects) {
				projets.add((Projet)object);
			}
			ComboProjet.setItems(projets);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
