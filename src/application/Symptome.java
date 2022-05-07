package application;

public class Symptome {
	int id_Symptome;
	String descriptionSymptome;
	
	public int getId_Symptome() {
		return id_Symptome;
	}

	public void setId_Symptome(int id_Symptome) {
		this.id_Symptome = id_Symptome;
	}

	public String getDescriptionSymptome() {
		return descriptionSymptome;
	}

	public void setDescriptionSymptome(String descriptionSymptome) {
		this.descriptionSymptome = descriptionSymptome;
	}

	public Symptome(int id_Symptome, String descriptionSymptome) {
		this.id_Symptome=id_Symptome;
		this.descriptionSymptome=descriptionSymptome;
	}
	
}
