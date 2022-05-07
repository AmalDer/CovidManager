package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hopital {
	int id_Hopital;
	String nomHopital;
	String ville;
	
	public int getId_Hopital() {
		return id_Hopital;
	}

	public void setId_Hopital(int id_Hopital) {
		this.id_Hopital = id_Hopital;
	}

	public String getNomHopital() {
		return nomHopital;
	}

	public void setNomHopital(String nomHopital) {
		this.nomHopital = nomHopital;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public Hopital(int id_Hopital, String nomHopital, String ville) {
		this.id_Hopital=id_Hopital;
		this.nomHopital=nomHopital;
		this.ville=ville;
	}
	
	public static int save(Hopital u) throws SQLException {
    	int st=0;
    	ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
    	PreparedStatement stat;
    	String sql="INSERT INTO hopital (id_hopital,nomhopital,ville) VALUES (?,?,?);";
    	stat=con.prepareStatement(sql);
    	stat.setInt(1,u.getId_Hopital());
    	stat.setString(2, u.getNomHopital());
    	stat.setString(3, u.getVille());
    	
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
    }
	
	public static int update(Hopital u) throws SQLException {
		int st=0;
		ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
		String sql="update hopital set nomhopital='"+u.getNomHopital()+"', ville='"+u.getVille()+"' where id_hopital="+u.getId_Hopital()+";";
		PreparedStatement stat;
		stat=con.prepareStatement(sql);
		
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
	}
	
	public static int delete(int id) throws SQLException {
		int st=0;
		String sql="delete from hopital where id_hopital=?;";
		
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
