package model;

import java.util.Date;

public class Emprunt {

	private Date DateDebut;
	private Date DateFin;
	private float montant;

	public Emprunt(Date dateDebut, Date dateFin, float montant) {
		this.DateDebut = dateDebut;
		this.DateFin = dateFin;
		this.montant= montant;
	}

	public Date getDateDebut() {
		return DateDebut;
	}
	
	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}
	
	public float getMontant() {
		return montant;
	}
}