package com.xmlws.agent.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ponuda")
public class Ponuda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private BigDecimal cena;
    
    private BigInteger brojKreveta;
    
    private Date od;
    
    private Date _do;
    
    /*
    @ManyToOne
    protected Rezervacija rezervacija;
    */

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

	public Date getOd() {
		return od;
	}

	public void setOd(Date od) {
		this.od = od;
	}

	public Date get_do() {
		return _do;
	}

	public void set_do(Date _do) {
		this._do = _do;
	}
    
    
}
