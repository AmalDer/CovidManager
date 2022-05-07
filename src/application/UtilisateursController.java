package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
public class UtilisateursController implements Initializable{
	
	public UtilisateursController() {
		
	}
	
	@FXML
	private Button buttonAjout, buttonModification, buttonSuppression, buttonAffichage;
	
	@FXML
	private Pane mainPane;
	
	public void ajout(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("Uajout.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }
	
	public void modification(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("Umodification.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }
	
	public void suppression(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("Usuppression.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }
	
	public void affichage(ActionEvent event) throws IOException {
        Pane newLoadedPane =  FXMLLoader.load(getClass().getResource("Uaffichage.fxml"));
		mainPane.getChildren().clear();
        mainPane.getChildren().add(newLoadedPane);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
