package model;

import java.util.UUID;

public class DVD extends SupportNumerique {

	protected String realisateur;
	private UUID id;

	public DVD(String titre, String realisateur, float tarifjournalier) {
		super(titre, tarifjournalier);
		this.realisateur = realisateur;
		id = UUID.randomUUID();
	}

    public UUID getId() {
        return id;
    }

	public String getRealisateur() {
		return realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}	
}