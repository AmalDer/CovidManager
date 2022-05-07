package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PatientsController implements Initializable{
	
	@FXML
    private TextField txtId, txtCin, txtNom, txtPrenom, txtTelephone;
	
	@FXML
	private TextArea txtAdresse;
	
	@FXML
	private DatePicker dateNaissance;
	
	@FXML
	private ComboBox<String> comboSexe;
	
	@FXML
	private TableView<Patient> table;
	
	@FXML
	private TableColumn<Patient,Integer> idColonne;
	
	@FXML
	private TableColumn<Patient,String> cinColonne;
	
	@FXML
	private TableColumn<Patient,String> nomColonne;
	
	@FXML
	private TableColumn<Patient,String> prenomColonne;
	
	@FXML
	private TableColumn<Patient,String> telephoneColonne;
	
	@FXML
	private TableColumn<Patient,String> adresseColonne;
	
	@FXML
	private TableColumn<Patient,String> sexeColonne;
	
	@FXML
	private TableColumn<Patient,LocalDate> dateColonne;
	
	@FXML
	private Button buttonAfficher, buttonAjouter, buttonModifier, buttonSupprimer;
	
	public ObservableList<Patient> data=FXCollections.observableArrayList();
	public ObservableList<String> list=FXCollections.observableArrayList("F","S");

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		comboSexe.setItems(list);
		idColonne.setCellValueFactory(new PropertyValueFactory<Patient,Integer>("id_Patient"));
		cinColonne.setCellValueFactory(new PropertyValueFactory<Patient, String>("cin"));
		nomColonne.setCellValueFactory(new PropertyValueFactory<Patient, String>("nom"));
		prenomColonne.setCellValueFactory(new PropertyValueFactory<Patient, String>("prenom"));
		telephoneColonne.setCellValueFactory(new PropertyValueFactory<Patient, String>("tel"));
		adresseColonne.setCellValueFactory(new PropertyValueFactory<Patient, String>("adresse"));
		sexeColonne.setCellValueFactory(new PropertyValueFactory<Patient, String>("sexe"));
		dateColonne.setCellValueFactory(new PropertyValueFactory<Patient, LocalDate>("dateNaissance"));
		
		try {
			afficher();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setItems(data);
		setCellValueFromTabletofierld();
		
	}
	
	public void ajouter(ActionEvent event ) throws SQLException{
		int idp =Integer.parseInt(txtId.getText());
		String cin=txtCin.getText();
    	String nom= txtNom.getText();
    	String prenom= txtPrenom.getText();
    	String telephone=txtTelephone.getText();
    	String adresse=txtAdresse.getText();
    	String sexe=comboSexe.getValue();
    	LocalDate date=dateNaissance.getValue();
    	
    	Patient  p = new Patient(idp, cin, nom, prenom, sexe, date, telephone, adresse);
    	
    	Patient.save(p);
    	
    	afficher();
    	vider(); 
    }
	
	private void vider() {
		   // TODO Auto-generated method stub
			txtId.clear();
			txtCin.clear();
			txtNom.clear();
			txtPrenom.clear();
			txtTelephone.clear();
			txtAdresse.clear();
	}
	
	@FXML
	public void afficher() throws SQLException {
		
		data.clear();
		
		ConnectDB connectNow = new ConnectDB();
		Connection con=connectNow.getConnection();
		String sql="select * from patient;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			data.add(new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getDate(6).toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),rs.getString(7),rs.getString(8)));
		}
		
		con.close();	
		
		}
	
	@FXML
	  public void modifier(ActionEvent event) throws SQLException{
			
			Patient u =table.getSelectionModel().getSelectedItem();
			int id;
			id=u.getId_Patient();
			txtId.setText(String.valueOf(id));
			String cin=txtCin.getText();
	    	String nom= txtNom.getText();
	    	String prenom= txtPrenom.getText();
	    	String telephone=txtTelephone.getText();
	    	String adresse=txtAdresse.getText();
	    	String sexe=comboSexe.getValue();
	    	LocalDate date=dateNaissance.getValue();
	    	
	    	Patient  p = new Patient(id, cin, nom, prenom, sexe, date, telephone, adresse);
	    	Patient.delete(id);
	    	data.remove(u);
	    	Patient.save(p);
	    	afficher();
	    	vider();
			
		}
	
	private void setCellValueFromTabletofierld() {
    	table.setOnMouseClicked(e->{
    		Patient u = table.getItems().get(table.getSelectionModel().getSelectedIndex());
    		txtId.setText(String.valueOf((u.getId_Patient())));
    		txtCin.setText(u.getCin());
    		txtNom.setText(u.getNom());
    		txtPrenom.setText(u.getPrenom());
    		txtTelephone.setText(u.getTel());
    		txtAdresse.setText(u.getAdresse());
    		comboSexe.setValue(u.getSexe());
    		dateNaissance.setValue(u.getDateNaissance());
    		
    	});

  	}
	
	
	
	
	
	
	
	

}
