package model;

import java.util.ArrayList;
import java.util.UUID;

public abstract class Produit {

	 protected String titre;
	 protected float tarifjournalier;
	 private UUID idproduit;
	 static ArrayList<Produit>CollectionProduit;
	 
	 public Produit(String titre, float tarifjournalier) {
		 this.titre=titre;
		 this.tarifjournalier = tarifjournalier;
		 idproduit = UUID.randomUUID();
		 CollectionProduit = new ArrayList<Produit>();
	 }

	 public String getTitre() {
		 return titre;
	 }

	 public void setTitre(String titre) {
		 this.titre = titre;
	 }

	 public float getTarifjournalier() {
		 return tarifjournalier;
	 }

	 public void setTarifjournalier(float tarifjournalier) {
		 this.tarifjournalier = tarifjournalier;
	 }
	
	 public UUID getIdproduit() {
		 return idproduit;
	 }

	 public void setId(UUID idproduit) {
		 this.idproduit = idproduit;
	 }
	 
	 public static void AjouterProduit(int id, Object obj) {
		 CollectionProduit.add(id, (Produit) obj);
	 }	
	 
	 public static void SupprimerProduit(Produit p) {
		 CollectionProduit.remove(p);
	 }
}