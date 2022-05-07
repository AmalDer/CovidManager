package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Medicament {
	int id_Medoc;
	String descriptionMedoc;
	
	public int getId_Medoc() {
		return id_Medoc;
	}

	public void setId_Medoc(int id_Medoc) {
		this.id_Medoc = id_Medoc;
	}

	public String getDescriptionMedoc() {
		return descriptionMedoc;
	}

	public void setDescriptionMedoc(String descriptionMedoc) {
		this.descriptionMedoc = descriptionMedoc;
	}
	
	public Medicament(int id_Medoc,String descriptionMedoc) {
		this.id_Medoc=id_Medoc;
		this.descriptionMedoc=descriptionMedoc;
	}
	
	public static int save(Medicament u) throws SQLException {
    	int st=0;
    	ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
    	PreparedStatement stat;
    	String sql="INSERT INTO medicament (id_medoc,descriptionmedoc) VALUES (?,?);";
    	stat=con.prepareStatement(sql);
    	stat.setInt(1,u.getId_Medoc());
    	stat.setString(2, u.getDescriptionMedoc());
    	
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
    }
	
	public static int update(Medicament u) throws SQLException {
		int st=0;
		ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
		String sql="update medicament set descriptionmedoc='"+u.getDescriptionMedoc()+"' where id_medoc="+u.getId_Medoc()+";";
		PreparedStatement stat;
		stat=con.prepareStatement(sql);
		
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
	}
	
	public static int delete(int id) throws SQLException {
		int st=0;
		String sql="delete from medicament where id_medoc=?;";
		
		ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
    	PreparedStatement stat;
    	stat=con.prepareStatement(sql);
    	
    	stat.setInt(1,id);
		st=stat.executeUpdate();
		con.close();
		
		return st;
		
	}
	
}
