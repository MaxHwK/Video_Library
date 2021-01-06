package model;

import java.util.UUID;

public class CD extends SupportNumerique {

	protected int anneesortie;
	private UUID id;

	public CD(String titre, int anneesortie, float tarifjournalier) {
		super(titre, tarifjournalier);
		this.anneesortie = anneesortie;
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public int getAnneesortie() {
		return anneesortie;
	}

	public void setAnneesortie(int anneesortie) {
		this.anneesortie = anneesortie;
	}
}