package application;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDB {
    static Connection databaseLink;
    
    public Connection getConnection() {
    	String databaseName = "projet_amal";
    	String databaseUser = "root";
    	String databasePassword = "DERakkour2006*.";
    	String url = "jdbc:mysql://localhost/" + databaseName;
    	
    	try
    	{
    		Class.forName("com.mysql.cj.jdbc.Driver");
    		databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
    		
    	} catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    	
    	
    	return databaseLink;
    }
}