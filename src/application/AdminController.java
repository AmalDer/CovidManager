package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminController {
	
	public AdminController() {
		
	}
	
	@FXML
	private Button buttonUtilisateurs;
	
	@FXML
	private Button buttonHopitaux;
	
	@FXML
	private Button buttonTraitements;
	
	public void utilisateurs(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Test.fxml");
	}
	
	public void hopitaux(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Hopitaux.fxml");
	}
	
	public void traitements(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Traitements.fxml");
	}
}
