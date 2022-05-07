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

public class TestController implements Initializable{
	
	@FXML
    private TextField txtId; 
    
    @FXML
    private TextField txtTitre;
    
    @FXML
    private TextField txtLogin;
    
    @FXML
    private TextField txtMdp;
	
	@FXML
	private TableView<Utilisateur> table;
	
	@FXML
	private TableColumn<Utilisateur,Integer> identifiant;
	
	@FXML
	private TableColumn<Utilisateur,String> fonction;
	
	@FXML
	private TableColumn<Utilisateur,String> login;
	
	@FXML
	private TableColumn<Utilisateur,String> mdp;
	
	@FXML
	private Button buttonAfficher, buttonAjouter, buttonModifier, buttonSupprimer;
	
	public ObservableList<Utilisateur> data=FXCollections.observableArrayList();
	
	public void ajouter(ActionEvent event ) throws SQLException{
		int idu =Integer.parseInt(txtId.getText());
    	String titre= txtTitre.getText();
    	String log= txtLogin.getText();
    	String pass=txtMdp.getText();
    	
    	Utilisateur  u = new Utilisateur(idu, titre, log, pass);
    	
    	Utilisateur.save(u);
    	
    	afficher();
    	vider(); 
    }
	
	private void vider() {
		   // TODO Auto-generated method stub
			txtId.clear();
			txtTitre.clear();
			txtLogin.clear();
			txtMdp.clear();
	
	}
	/*private void setCellValueFromTabletofierld() {
		table.setOnMouseClicked(e->{
	    		Utilisateur u = table.getItems().get(table.getSelectionModel().getSelectedIndex());
	    		txtId.setText(Integer.toString(u.getId_user()));
	    		txtTitre.setText(u.getTitre());
	    		txtLogin.setText(u.getLogin());
	    		txtMdp.setText(u.getPasswd());
	    	});

	  	}*/
	
	@FXML
	public void afficher() throws SQLException {
		
		data.clear();
		
		ConnectDB connectNow = new ConnectDB();
		Connection con=connectNow.getConnection();
		String sql="select * from user;";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			data.add(new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		}
		con.close();	
		
		}
	
	 @FXML
	  public void modifier(ActionEvent event) throws SQLException{
			
			Utilisateur u =table.getSelectionModel().getSelectedItem();
			int id;
			id=u.getId_user();
			txtId.setText(String.valueOf(id));
			String titre= txtTitre.getText();
	    	String log= txtLogin.getText();
	    	String pass=txtMdp.getText();
	    	
	    	Utilisateur  t = new Utilisateur(id, titre, log, pass);
	    	Utilisateur.delete(id);
	    	data.remove(u);
	    	Utilisateur.save(t);
	    	afficher();
	    	vider();
			
		}
	 
	 @FXML
	   public void supprimer(ActionEvent envent) throws SQLException{
		   Utilisateur u = table.getSelectionModel().getSelectedItem();
		   int id;
		   id=u.getId_user();
		   Utilisateur.delete(id);
		   data.remove(u);
		   vider();
	   }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		identifiant.setCellValueFactory(new PropertyValueFactory<Utilisateur,Integer>("id_user"));
		fonction.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("titre"));
		login.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("login"));
		mdp.setCellValueFactory(new PropertyValueFactory<Utilisateur, String>("passwd"));
		
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
    		Utilisateur u = table.getItems().get(table.getSelectionModel().getSelectedIndex());
    		txtId.setText(String.valueOf((u.getId_user())));
    		txtTitre.setText(u.getTitre());
    		txtLogin.setText(u.getLogin());
    		txtMdp.setText(u.getPasswd());
    	});

  	}
	

}
