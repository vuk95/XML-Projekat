package com.xmlws.agent.model;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresa {
	
	@Id
   	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String drzava;
    
	private String grad;
    
	private String ulica;
    
	private BigInteger broj;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDrzava() {
		return drzava;
	}

	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}

	public String getGrad() {
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public BigInteger getBroj() {
		return broj;
	}

	public void setBroj(BigInteger broj) {
		this.broj = broj;
	}

	public Adresa() {
		
	}
    
}
