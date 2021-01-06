package model;

import java.util.UUID;

public class Dictionnaire extends Document {

	protected String langue;
	private UUID id;

	public Dictionnaire(String langue,  String titre, float tarifjournalier) {
		super(titre, tarifjournalier);
		this.langue = langue;
		id = UUID.randomUUID();
	}

	public String getLangue() {
		return langue;
	}

	public void setLangue(String langue) {
		this.langue = langue;
	}

	public UUID getId() {
		return id;
	}
}