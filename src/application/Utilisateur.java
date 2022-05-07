package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Utilisateur {
	
	private int id_user;
	private String titre;
	private String login;
	private String passwd;
	
	public Utilisateur(int id_user,  String titre, String login, String passwd) {
		this.setId_user(id_user);
		this.setLogin(passwd);
		this.setPasswd(passwd);
		this.setTitre(titre);
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public static int save(Utilisateur u) throws SQLException {
    	int st=0;
    	ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
    	PreparedStatement stat;
    	String sql="INSERT INTO user (id_user,titre,login,passwd) VALUES (?,?,?,?);";
    	stat=con.prepareStatement(sql);
    	stat.setInt(1,u.getId_user());
    	stat.setString(2, u.getTitre());
    	stat.setString(3, u.getLogin());
    	stat.setString(4, u.getPasswd());
    	
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
    }
	
	public static int update(Utilisateur u) throws SQLException {
		int st=0;
		ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
		String sql="update user set titre='"+u.getTitre()+"', login='"+u.getLogin()+"', passwd='"+u.getPasswd()+"' where id_user="+u.getId_user()+";";
		PreparedStatement stat;
		stat=con.prepareStatement(sql);
		
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
	}
	
	public static int delete(int id) throws SQLException {
		int st=0;
		String sql="delete from user where id_user=?;";
		
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
