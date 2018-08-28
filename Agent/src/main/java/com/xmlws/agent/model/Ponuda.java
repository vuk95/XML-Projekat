package com.xmlws.agent.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Ponuda")
public class Ponuda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ponuda_id")
    private Long id;
	
    private BigDecimal cena;
    
    private BigInteger brojKreveta;
    
    private String od;
    
    private String doDatuma;
    
    @ManyToOne
    private Smestaj smestaj;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getCena() {
		return cena;
	}

	public void setCena(BigDecimal cena) {
		this.cena = cena;
	}

	public BigInteger getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(BigInteger brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public String getOd() {
		return od;
	}

	public void setOd(String od) {
		this.od = od;
	}

	public String getDoDatuma() {
		return doDatuma;
	}

	public void setDoDatuma(String doDatuma) {
		this.doDatuma = doDatuma;
	}

	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}
   
}
