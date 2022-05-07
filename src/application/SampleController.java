package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SampleController {
	public SampleController() {
		
	}
	
	@FXML
	private Button buttonConnexion;
	
	@FXML
	private Label wronglogin;
	
	@FXML
	private TextField login;
	
	@FXML
	private PasswordField mdp;
	
	public void userLogIn(ActionEvent event) throws ClassNotFoundException, SQLException {
		
		String username=login.getText();
		String password=mdp.getText();
		
		if(username.equals("") && password.equals("")) {
			
			JOptionPane.showMessageDialog(null, "Veuillez entrer un login et un mot de passe!");
		}
		else {
			
			validateLogIn();
		}
	}
	
	public void validateLogIn() {
		
		Main m = new Main();
		
		ConnectDB connectNow = new ConnectDB();
		Connection con = connectNow.getConnection();
		
		String verifyLogin = "select count(1) from user where login = '" + login.getText() + "' and passwd = '" + mdp.getText() + "'";
		
		String fonction = "select titre from user where login = '" + login.getText() + "' and passwd = '" + mdp.getText() + "'";
		
		try {
			
			Statement statement = con.createStatement();
			ResultSet queryResult = statement.executeQuery(verifyLogin);
			
			while(queryResult.next()) {
				if(queryResult.getInt(1)==1) {
					JOptionPane.showMessageDialog(null, "Bienvenue!");
					if(fonction == "'soignant'") {
						m.changeScene("Soignant.fxml");
					}
					else {
						m.changeScene("Admin.fxml");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Login ou mot de passe éroné!");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}
}
