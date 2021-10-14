package com.sil.gpc.domains;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Immo implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long idImmo;
	@Column(unique = true)
	private String element;
	private String intitule;
	private Date datEntree;
	private double valBrute;
	private double valResid;
	private double valAmortissable;
	private int nbAnne;
	private int nbMois;
	private int nbJrs;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Localisation.class)
	@JoinColumn(name = "localisation", nullable = false, referencedColumnName = "idLoc")
	private Localisation localisation;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Service.class)
	@JoinColumn(name = "service", nullable = false, referencedColumnName = "codeService")
	private Service service;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = Activite.class)
	@JoinColumn(name = "activite", nullable = false, referencedColumnName = "idAct")
	private Activite activite;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = EtatImmo.class)
	@JoinColumn(name = "etatImmo", nullable = false, referencedColumnName = "idEtatImmo")
	private EtatImmo etatImmo;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity = TypeAmort.class)
	@JoinColumn(name = "typeAmort", nullable = false, referencedColumnName = "idTypAmo")
	private TypeAmort typeAmort;
	
	public Immo() {
		// TODO Auto-generated constructor stub
	}

	public Immo(Long idImmo, String element, String intitule, Date datEntree, double valBrute, double valResid,
			double valAmortissable, int nbAnne, int nbMois, int nbJrs, Localisation localisation, Service service,
			Activite activite, EtatImmo etatImmo, TypeAmort typeAmort) {
		super();
		this.idImmo = idImmo;
		this.element = element;
		this.intitule = intitule;
		this.datEntree = datEntree;
		this.valBrute = valBrute;
		this.valResid = valResid;
		this.valAmortissable = valAmortissable;
		this.nbAnne = nbAnne;
		this.nbMois = nbMois;
		this.nbJrs = nbJrs;
		this.localisation = localisation;
		this.service = service;
		this.activite = activite;
		this.etatImmo = etatImmo;
		this.typeAmort = typeAmort;
	}

	public Long getIdImmo() {
		return idImmo;
	}

	public void setIdImmo(Long idImmo) {
		this.idImmo = idImmo;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public Date getDatEntree() {
		return datEntree;
	}

	public void setDatEntree(Date datEntree) {
		this.datEntree = datEntree;
	}

	public double getValBrute() {
		return valBrute;
	}

	public void setValBrute(double valBrute) {
		this.valBrute = valBrute;
	}

	public double getValResid() {
		return valResid;
	}

	public void setValResid(double valResid) {
		this.valResid = valResid;
	}

	public double getValAmortissable() {
		return valAmortissable;
	}

	public void setValAmortissable(double valAmortissable) {
		this.valAmortissable = valAmortissable;
	}

	public int getNbAnne() {
		return nbAnne;
	}

	public void setNbAnne(int nbAnne) {
		this.nbAnne = nbAnne;
	}

	public int getNbMois() {
		return nbMois;
	}

	public void setNbMois(int nbMois) {
		this.nbMois = nbMois;
	}

	public int getNbJrs() {
		return nbJrs;
	}

	public void setNbJrs(int nbJrs) {
		this.nbJrs = nbJrs;
	}

	public Localisation getLocalisation() {
		return localisation;
	}

	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Activite getActivite() {
		return activite;
	}

	public void setActivite(Activite activite) {
		this.activite = activite;
	}

	public EtatImmo getEtatImmo() {
		return etatImmo;
	}

	public void setEtatImmo(EtatImmo etatImmo) {
		this.etatImmo = etatImmo;
	}

	public TypeAmort getTypeAmort() {
		return typeAmort;
	}

	public void setTypeAmort(TypeAmort typeAmort) {
		this.typeAmort = typeAmort;
	}

	@Override
	public String toString() {
		return "Immo [idImmo=" + idImmo + ", element=" + element + ", intitule=" + intitule + ", datEntree=" + datEntree
				+ ", valBrute=" + valBrute + ", valResid=" + valResid + ", valAmortissable=" + valAmortissable
				+ ", nbAnne=" + nbAnne + ", nbMois=" + nbMois + ", nbJrs=" + nbJrs + ", localisation=" + localisation
				+ ", service=" + service + ", activite=" + activite + ", etatImmo=" + etatImmo + ", typeAmort="
				+ typeAmort + "]";
	}
	
	

}
