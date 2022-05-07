package application;

import java.time.LocalDate;

public class Diagnostic {
	int id_Diagnostic;
	LocalDate date_Contamination;
	LocalDate date_Diagnostic;
	LocalDate date_Cloture;
	boolean etat_final;
	
	public int getId_Diagnostic() {
		return id_Diagnostic;
	}

	public void setId_Diagnostic(int id_Diagnostic) {
		this.id_Diagnostic = id_Diagnostic;
	}

	public LocalDate getDate_Contamination() {
		return date_Contamination;
	}

	public void setDate_Contamination(LocalDate date_Contamination) {
		this.date_Contamination = date_Contamination;
	}

	public LocalDate getDate_Diagnostic() {
		return date_Diagnostic;
	}

	public void setDate_Diagnostic(LocalDate date_Diagnostic) {
		this.date_Diagnostic = date_Diagnostic;
	}

	public LocalDate getDate_Cloture() {
		return date_Cloture;
	}

	public void setDate_Cloture(LocalDate date_Cloture) {
		this.date_Cloture = date_Cloture;
	}

	public boolean isEtat_final() {
		return etat_final;
	}

	public void setEtat_final(boolean etat_final) {
		this.etat_final = etat_final;
	}
	
	public Diagnostic(int id_Diagnostic,LocalDate date_Contamination,LocalDate date_Diagnostic,LocalDate date_Cloture,boolean etat_final) {
		this.id_Diagnostic=id_Diagnostic;
		this.date_Contamination=date_Contamination;
		this.date_Diagnostic=date_Diagnostic;
		this.date_Cloture=date_Cloture;
		this.etat_final=etat_final;
	}
	
	
}
