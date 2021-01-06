package model;

import java.util.UUID;
import java.util.ArrayList;

public class Client {
	
	private static UUID idclient;	
	protected String nom;	
	protected String prenom;
	static ArrayList<Client>CollectionClient;
		
	public Client(UUID id, String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		idclient = UUID.randomUUID();
		CollectionClient = new ArrayList<Client>();
	}

	public static UUID getIdclient() {
		return idclient;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public static void AjouterClient(UUID id, String nom, String prenom) {
		Client c = new Client(id, nom, prenom);
		CollectionClient.add(c);
	}
	
	public static void SupprimerClient(Client c) {
		try {
			CollectionClient.remove(c);
		}
		catch(NullPointerException e) {
		}
	}
}