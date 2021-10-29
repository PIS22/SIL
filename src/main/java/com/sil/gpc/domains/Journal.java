package com.sil.gpc.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Journal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idJrn;
    private String codJrn;
    private String libJrn;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="CompteAutorises")
    private List<Compte> compteAutorises;
    
    @ManyToOne(targetEntity = Compte.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "autoContrepart", referencedColumnName = "idCpte", nullable = true)
    private Compte autoContrepart;
    
    @ManyToOne(targetEntity = NatureJournal.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "idNat", referencedColumnName = "idNat", nullable = false)
    public NatureJournal natJrn;

    public Journal(NatureJournal natJrn) {
    }

    public Journal() {
    }

    public Journal(Long idJrn, String codJrn, String libJrn, List<Compte> compteAutorises, Compte autoContrepart,
                   NatureJournal natJrn) {
		super();
		this.idJrn = idJrn;
		this.codJrn = codJrn;
		this.libJrn = libJrn;
		this.compteAutorises = compteAutorises;
		this.autoContrepart = autoContrepart;
		this.natJrn = natJrn;
	}



	public Long getIdJrn() {
        return idJrn;
    }

    public void setIdJrn(Long idJrn) {
        this.idJrn = idJrn;
    }

    public String getCodJrn() {
        return codJrn;
    }

    public void setCodJrn(String codJrn) {
        this.codJrn = codJrn;
    }

    public String getLibJrn() {
        return libJrn;
    }

    public void setLibJrn(String libJrn) {
        this.libJrn = libJrn;
    }


	public List<Compte> getCompteAutorises() {
		return compteAutorises;
	}


	public void setCompteAutorises(List<Compte> compteAutorises) {
		this.compteAutorises = compteAutorises;
	}


	public Compte getAutoContrepart() {
		return autoContrepart;
	}


	public void setAutoContrepart(Compte autoContrepart) {
		this.autoContrepart = autoContrepart;
	}


	public NatureJournal getNatJrn() {
		return natJrn;
	}


	public void setNatJrn(NatureJournal natJrn) {
		this.natJrn = natJrn;
	}


	@Override
	public String toString() {
		return "Journal [idJrn=" + idJrn + ", codJrn=" + codJrn + ", libJrn=" + libJrn + ", compteAutorises="
				+ compteAutorises + ", autoContrepart=" + autoContrepart + ", natJrn=" + natJrn + "]";
	}

   
}
