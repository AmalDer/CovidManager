package application;

import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UtilisateursTestController implements Initializable{

	@FXML
	private TableView<Utilisateur> tableUtilisateurs;
	
	@FXML
	private TableColumn<Utilisateur,String> idColonne;
	
	@FXML
	private TableColumn<Utilisateur,String> loginColonne;
	
	@FXML
	private TableColumn<Utilisateur,String> mdpColonne;
	
	@FXML
	private TableColumn<Utilisateur,String> fctColonne;
	
	@FXML
	private Button buttonAjouter, buttonActualiser;
	
	String query=null;
	Connection connection=null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet=null;
	Utilisateur utilisateur = null;
	ConnectDB connectNow=new ConnectDB();
	
	ObservableList<Utilisateur> UtilisateurList = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		try {
			loadDate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void refreshTable() throws SQLException {
		UtilisateurList.clear();
		
		query = "select * from user";
		preparedStatement = connection.prepareStatement(query);
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			UtilisateurList.add(new Utilisateur(
					resultSet.getInt("id_user"),
					resultSet.getString("titre"),
                    resultSet.getString("login"),
                    resultSet.getString("passwd")));
					tableUtilisateurs.setItems(UtilisateurList);
			
		}
		
	}
	
	public void getAddView(ActionEvent event) {
		Parent parent = null;
		try {
			parent = FXMLLoader.load(getClass().getResource("Uajout.fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.UTILITY);
        stage.show();
	}
	
	private void loadDate() throws SQLException {
        
        connection = connectNow.getConnection();
        refreshTable();
        
        idColonne.setCellValueFactory(new PropertyValueFactory<>("Identifiant"));
        loginColonne.setCellValueFactory(new PropertyValueFactory<>("Login"));
        mdpColonne.setCellValueFactory(new PropertyValueFactory<>("Mot de passe"));
        fctColonne.setCellValueFactory(new PropertyValueFactory<>("Fonction"));
        
	
	}
}