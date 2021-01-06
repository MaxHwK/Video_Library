package model;

import java.util.UUID;

public class ClientFidele extends Client {

	private final double reduction = 0.1;
	
	public ClientFidele(UUID idclient, String nom, String prenom) {
		super(idclient, nom, prenom);
	}

	public double getReduction() {
		return reduction;
	}
}