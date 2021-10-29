package com.sil.gpc.domains;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Avance implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAvance;
    private Date datAvance;
    private double montant;
    private double nouvelleAvance;
    private boolean epuisee;
    @ManyToOne(targetEntity = Contrat.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "numcontrat", name = "numcontrat", nullable = false)
    private  Contrat contrat;
    @ManyToOne(targetEntity = OpCaisse.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(referencedColumnName = "numOpCaisse", name = "numOpCaisse")
    private  OpCaisse opcaisse;

}
