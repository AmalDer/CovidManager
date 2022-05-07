package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	private static Stage stg;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		stg = primaryStage;
		primaryStage.setResizable(false);
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
		primaryStage.setTitle("Gestion de patients");
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public void changeScene(String fxml) throws IOException{
		// TODO Auto-generated method stub
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}

}
