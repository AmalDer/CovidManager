package application;

public class Room {
	int id_Room;
	String type;
	char etat;
	
	public int getId_Room() {
		return id_Room;
	}

	public void setId_Room(int id_Room) {
		this.id_Room = id_Room;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public char getEtat() {
		return etat;
	}

	public void setEtat(char etat) {
		this.etat = etat;
	}

	public Room(int id_Room, String type, char etat) {
		this.id_Room=id_Room;
		this.type=type;
		this.etat=etat;
	}
	
	
}
