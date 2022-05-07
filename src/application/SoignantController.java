package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SoignantController {
	
	public SoignantController() {
		
	}
	
	@FXML
	private Button buttonPatients;
	
	@FXML
	private Button buttonSejours;
	
	public void patients(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Patients.fxml");
	}
	
	public void sejours(ActionEvent event) throws IOException {
		Main m = new Main();
		m.changeScene("Sejours.fxml");
	}

}
