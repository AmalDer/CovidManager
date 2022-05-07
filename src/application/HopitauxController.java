package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HopitauxController implements Initializable{
	
	@FXML
    private TextField txtId; 
    
    @FXML
    private TextField txtNom;
    
    @FXML
    private TextField txtVille;
    
    @FXML
	private TableView<Hopital> table;
	
	@FXML
	private TableColumn<Hopital,Integer> identifiant;
	
	@FXML
	private TableColumn<Hopital,String> nom;
	
	@FXML
	private TableColumn<Hopital,String> ville;
	
	@FXML
	private Button buttonAfficher, buttonAjouter, buttonModifier, buttonSupprimer;
	
	public ObservableList<Hopital> data=FXCollections.observableArrayList();
	
	public void ajouter(ActionEvent event ) throws SQLException{
		int idh =Integer.parseInt(txtId.getText());
    	String nom= txtNom.getText();
    	String ville= txtVille.getText();
    	
    	Hopital  h = new Hopital(idh, nom, ville);
    	
    	Hopital.save(h);
    	
    	afficher();
    	vider(); 
    }
	
	private void vider() {
		   // TODO Auto-generated method stub
			txtId.clear();
			txtNom.clear();
			txtVille.clear();
	
	}
	
	@FXML
	public void afficher() throws SQLException {
		
		data.clear();
		
		ConnectDB connectNow = new ConnectDB();
		Connection con=connectNow.getConnection();
		String sql="select * from hopital;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			data.add(new Hopital(rs.getInt(1),rs.getString(2),rs.getString(3)));
		}
		con.close();	
		
		}
	
	@FXML
	  public void modifier(ActionEvent event) throws SQLException{
			
			Hopital u =table.getSelectionModel().getSelectedItem();
			int id;
			id=u.getId_Hopital();
			txtId.setText(String.valueOf(id));
			String nom= txtNom.getText();
	    	String ville= txtVille.getText();
	    	
	    	Hopital  t = new Hopital(id, nom, ville);
	    	Hopital.delete(id);
	    	data.remove(u);
	    	Hopital.save(t);
	    	afficher();
	    	vider();
			
		}
	
	@FXML
	   public void supprimer(ActionEvent envent) throws SQLException{
		   Hopital u = table.getSelectionModel().getSelectedItem();
		   int id;
		   id=u.getId_Hopital();
		   Hopital.delete(id);
		   data.remove(u);
		   vider();
	   }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		identifiant.setCellValueFactory(new PropertyValueFactory<Hopital,Integer>("id_Hopital"));
		nom.setCellValueFactory(new PropertyValueFactory<Hopital, String>("nomHopital"));
		ville.setCellValueFactory(new PropertyValueFactory<Hopital, String>("ville"));
		
		try {
			afficher();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		table.setItems(data);
		setCellValueFromTabletofierld();
		
	}
	
	private void setCellValueFromTabletofierld() {
    	table.setOnMouseClicked(e->{
    		Hopital u = table.getItems().get(table.getSelectionModel().getSelectedIndex());
    		txtId.setText(String.valueOf((u.getId_Hopital())));
    		txtNom.setText(u.getNomHopital());
    		txtVille.setText(u.getVille());
    	});

  	}

}
