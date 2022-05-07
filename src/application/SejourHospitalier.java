package application;

import java.time.LocalDate;

public class SejourHospitalier {
	int id_Sejour;
	LocalDate debutSejour;
	LocalDate finSejour;
	
	public int getId_Sejour() {
		return id_Sejour;
	}

	public void setId_Sejour(int id_Sejour) {
		this.id_Sejour = id_Sejour;
	}

	public LocalDate getDebutSejour() {
		return debutSejour;
	}

	public void setDebutSejour(LocalDate debutSejour) {
		this.debutSejour = debutSejour;
	}

	public LocalDate getFinSejour() {
		return finSejour;
	}

	public void setFinSejour(LocalDate finSejour) {
		this.finSejour = finSejour;
	}

	public SejourHospitalier(int id_Sejour,LocalDate debutSejour,LocalDate finSejour) {
		this.id_Sejour=id_Sejour;
		this.debutSejour=debutSejour;
		this.finSejour=finSejour;
	}
	
}
