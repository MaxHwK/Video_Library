package model;

import java.util.UUID;

public class ClientOccasionnel extends Client {

	private final double reduction = 0;
	
	public ClientOccasionnel(UUID idclient, String nom, String prenom) {
		super(idclient, nom, prenom);
	}
	
	public double getReduction() {
		return reduction;
	}
}