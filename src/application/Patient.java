package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class Patient {
	int id_Patient;
	String cin;
	LocalDate dateNaissance;
	String nom;
	String prenom;
	String tel;
	String adresse;
	String sexe;
	
	public int getId_Patient() {
		return id_Patient;
	}

	public void setId_Patient(int id_Patient) {
		this.id_Patient = id_Patient;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	
	public Patient(int id_Patient,String cin,String nom,String prenom,String sexe,LocalDate dateNaissance,String tel,String adresse) {
		this.id_Patient=id_Patient;
		this.cin=cin;
		this.dateNaissance=dateNaissance;
		this.nom=nom;
		this.prenom=prenom;
		this.tel=tel;
		this.adresse=adresse;
		this.sexe=sexe;
	}
	

	public static int save(Patient u) throws SQLException {
    	int st=0;
    	ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
    	PreparedStatement stat;
    	String sql="INSERT INTO patient (id_patient,cin,nom,prenom,sexe,datenaissance,tel,adresse) VALUES (?,?,?,?,?,?,?,?);";
    	stat=con.prepareStatement(sql);
    	stat.setInt(1,u.getId_Patient());
    	stat.setString(2, u.getCin());
    	stat.setString(3, u.getNom());
    	stat.setString(4, u.getPrenom());
    	stat.setString(4, u.getSexe());
    	stat.setDate(6, java.sql.Date.valueOf(u.getDateNaissance()));
    	stat.setString(7, u.getTel());
    	stat.setString(8, u.getAdresse());
    	
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
    }
	
	public static int update(Patient u) throws SQLException {
		int st=0;
		ConnectDB cx=new ConnectDB();
    	Connection con=cx.getConnection();
		String sql="update patient set cin='"+u.getCin()+"', nom='"+u.getNom()+"', prenom='"+u.getPrenom()+"', sexe='"+u.getSexe()+"', datenaissance='"+u.getDateNaissance()+"', tel='"+u.getTel()+"', adresse='"+u.getAdresse()+"' where id_patient="+u.getId_Patient()+";";
		PreparedStatement stat;
		stat=con.prepareStatement(sql);
		
    	st=stat.executeUpdate();
    	con.close();
    	
    	return st;
	}
	
	public static int delete(int id) throws SQLException {
		int st=0;
		String sql="delete from patient where id_patient=?;";
		
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
