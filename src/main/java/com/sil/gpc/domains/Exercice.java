package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Exercice implements Serializable{

	@Id
	private String codeExercice;
	private String libExercice;
	private Date dateDebut;
	private Date dateFin;
	private String etatExo;
	private boolean exoSelectionner;


	// Liaison à Point vente
	@OneToMany(cascade = CascadeType.ALL,targetEntity = PointVente.class, fetch =FetchType.LAZY,mappedBy = "exercice" )
	public List<PointVente> ventesCorrespondantDeLannee;

	// Liaison à operation de caisse
	@OneToMany(cascade = CascadeType.ALL,targetEntity = OpCaisse.class, fetch =FetchType.LAZY,mappedBy = "exercice" )
	public List<PointVente> opCaisseDeLannee;

	// Liaison à la demande d'approvisionnement
	@OneToMany(cascade = CascadeType.ALL,targetEntity = DemandeApprovisionnement.class, fetch =FetchType.LAZY,mappedBy = "exercice" )
	public List<DemandeApprovisionnement> demadeApproDeLannee;
	
	//Liaison à l'approvisionnement
	@OneToMany(cascade = CascadeType.DETACH,fetch = FetchType.EAGER, targetEntity = Approvisionnement.class,mappedBy = "exercice")
	public List<Approvisionnement> approsParExercice;

	//Liaison à la commande
	@OneToMany(cascade = CascadeType.DETACH,targetEntity = Commande.class,mappedBy = "exercice")
	public List<Commande> commandesParExercice;

	//Liaison au Placement
	@OneToMany(cascade = CascadeType.DETACH,targetEntity = Placement.class,mappedBy = "exercice")
	public List<Placement> placementsParExercice;

	//Liaison au point de vente
	@OneToMany(cascade = CascadeType.DETACH,targetEntity = PointVente.class,mappedBy = "exercice")
	public List<PointVente> PointsParExercice;

	//Liaison au reversement
	@OneToMany(cascade = CascadeType.DETACH,targetEntity = Reversement.class,mappedBy = "exercice")
	public List<Reversement> ReversementsParExercice;

	//Liaison au recollement
	@OneToMany(cascade = CascadeType.DETACH,targetEntity = Recollement.class,mappedBy = "exercice")
	public List<Recollement> recollementsParExercice;
	
	public Exercice() {
		super();
	}

	public Exercice(String codeExercice, String libExercice, Date dateDebut, Date dateFin, String etatExo,
			boolean exoSelectionner) {
		super();
		this.codeExercice = codeExercice;
		this.libExercice = libExercice;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatExo = etatExo;
		this.exoSelectionner = exoSelectionner;
	}

	public String getCodeExercice() {
		return codeExercice;
	}

	public void setCodeExercice(String codeExercice) {
		this.codeExercice = codeExercice;
	}

	public String getLibExercice() {
		return libExercice;
	}

	public void setLibExercice(String libExercice) {
		this.libExercice = libExercice;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getEtatExo() {
		return etatExo;
	}

	public void setEtatExo(String etatExo) {
		this.etatExo = etatExo;
	}

	public boolean isExoSelectionner() {
		return exoSelectionner;
	}

	public void setExoSelectionner(boolean exoSelectionner) {
		this.exoSelectionner = exoSelectionner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codeExercice == null) ? 0 : codeExercice.hashCode());
		result = prime * result + ((dateDebut == null) ? 0 : dateDebut.hashCode());
		result = prime * result + ((dateFin == null) ? 0 : dateFin.hashCode());
		result = prime * result + ((etatExo == null) ? 0 : etatExo.hashCode());
		result = prime * result + (exoSelectionner ? 1231 : 1237);
		result = prime * result + ((libExercice == null) ? 0 : libExercice.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}

	@Override
	public String toString() {
		return "Exercice [codeExercice=" + codeExercice + ", libExercice=" + libExercice + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", etatExo=" + etatExo + ", exoSelectionner=" + exoSelectionner + "]";
	}
	
	
}
