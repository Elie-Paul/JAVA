package application;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FormulaireController implements Initializable {

    @FXML
    private TextField ip;

    @FXML
    private TextField port;
    
    @FXML
    private Button env;

    @FXML
    private TextField pseudo;
    
    @FXML
    private Button con;

    @FXML
    private ListView<?> user;

    @FXML
    private TextField msg;

    @FXML
    private TextArea msgs;
    
    Socket server;
    PrintStream st;
    BufferedReader in;

    @FXML
    void connexionClick(ActionEvent event) {
    	try {
			if (con.getText().equals("Connexion")) {
				server = new Socket(ip.getText(), Integer.parseInt(port.getText()));
				in = new BufferedReader(new InputStreamReader(server.getInputStream()));
				st = new PrintStream(server.getOutputStream());
				st.println(pseudo.getText());
				ip.setEditable(false);
				port.setEditable(false);
				pseudo.setEditable(false);
				env.setDisable(true);
				con.setText("Deconnexion");
			}
			else
			{
				ip.setEditable(true);
				port.setEditable(true);
				pseudo.setEditable(true);
				con.setDisable(false);
				con.setText("Connexion");
				st.close();
				in.close();
				server.close();
				server = null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Utilitaires.showMessage("Chat", "error message", e.getMessage());
		}
    }

    @FXML
    void envoyerClick(ActionEvent event) {

    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//con.setDisable(true);
	}

}


