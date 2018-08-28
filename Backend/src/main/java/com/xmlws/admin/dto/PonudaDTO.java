package com.xmlws.admin.dto;

import javax.validation.constraints.NotEmpty;

import com.xmlws.admin.backend.Smestaj;

public class PonudaDTO {

	private Long id;
	
	@NotEmpty
	private String od;
	@NotEmpty
	private String doDatuma;
	private double cena;
	private String brojKreveta;
    private String smestajNaziv;
   
    @NotEmpty
    private String smestajLokacija;
    private Smestaj smestaj;
	
    public PonudaDTO() {
    	
    }
    
    public PonudaDTO(Long id, String od, String doDatuma, double cena,String brojLezaja,String smestajNaziv, String smestajLokacija,Smestaj smestaj) {
		this.id = id;
		this.od = od;
		this.doDatuma = doDatuma;
		this.cena = cena;
		this.brojKreveta = brojLezaja;
		this.smestajNaziv = smestajNaziv;
		this.smestajLokacija = smestajLokacija;
		this.smestaj = smestaj;
	}
    
    
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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

	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getBrojKreveta() {
		return brojKreveta;
	}
	public void setBrojKreveta(String brojKreveta) {
		this.brojKreveta = brojKreveta;
	}
	public String getSmestajNaziv() {
		return smestajNaziv;
	}
	public void setSmestajNaziv(String smestajNaziv) {
		this.smestajNaziv = smestajNaziv;
	}
	public String getSmestajLokacija() {
		return smestajLokacija;
	}
	public void setSmestajLokacija(String smestajLokacija) {
		this.smestajLokacija = smestajLokacija;
	}

	public Smestaj getSmestaj() {
		return smestaj;
	}

	public void setSmestaj(Smestaj smestaj) {
		this.smestaj = smestaj;
	}
    
    
    
	
	
}
