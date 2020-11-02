package fr.mds.langageobjet.niv1.poo.tp14.models;


public abstract class Navire {
	
	private int id;
	private int taille;
	private boolean direction;
	
	public Navire(int id, int taille) {
		this.id = id;
		this.taille = taille;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public boolean isDirection() {
		return direction;
	}

	public void setDirection(boolean direction) {
		this.direction = direction;
	}
	
	
}
