package application;

import java.time.LocalDate;

public class Posologie {
	int id_Posologie;
	LocalDate date_debut;
	LocalDate date_fin;
	int nb_prise_jour;
	
	public int getId_Posologie() {
		return id_Posologie;
	}

	public void setId_Posologie(int id_Posologie) {
		this.id_Posologie = id_Posologie;
	}

	public LocalDate getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(LocalDate date_debut) {
		this.date_debut = date_debut;
	}

	public LocalDate getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(LocalDate date_fin) {
		this.date_fin = date_fin;
	}

	public int getNb_prise_jour() {
		return nb_prise_jour;
	}

	public void setNb_prise_jour(int nb_prise_jour) {
		this.nb_prise_jour = nb_prise_jour;
	}

	public Posologie(int id_Posologie, LocalDate date_debut,LocalDate date_fin,int nb_prise_jour) {
		this.id_Posologie=id_Posologie;
		this.date_debut=date_debut;
		this.date_fin=date_fin;
		this.nb_prise_jour=nb_prise_jour;
	}
	
	
}
