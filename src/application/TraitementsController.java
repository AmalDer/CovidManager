package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TraitementsController implements Initializable{
	
	@FXML
    private TextField txtId; 
    
    @FXML
    private TextArea txtDesc;
    
    @FXML
	private TableView<Medicament> table;
	
	@FXML
	private TableColumn<Medicament,Integer> idColonne;
	
	@FXML
	private TableColumn<Medicament,String> descColonne;
	
	@FXML
	private Button buttonAfficher, buttonAjouter, buttonModifier, buttonSupprimer;
	
	public ObservableList<Hopital> data=FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
