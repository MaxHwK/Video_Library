package model;

import java.util.UUID;

public class BD extends Livre {

	private UUID id;

	public BD( String auteur, String titre, float tarifjournalier) {
        super (auteur, titre, tarifjournalier);
        id = UUID.randomUUID();
    }

	public UUID getId() {
		return id;
	}
}