package model;

import java.util.UUID;

public abstract class Livre extends Document {

	private UUID id;
	protected String auteur;

	public Livre(String titre, String auteur, float tarifjournalier) {
		super(auteur, tarifjournalier);
		this.auteur = auteur;
		id = UUID.randomUUID();
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}	
}