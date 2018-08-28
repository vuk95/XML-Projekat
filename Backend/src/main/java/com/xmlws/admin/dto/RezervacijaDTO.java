package com.xmlws.admin.dto;

public class RezervacijaDTO {

	private Long id;
	private boolean potvrdjeno;
	private String datumRealizacije;
	private PonudaDTO ponudaDTO;
	
	public RezervacijaDTO() {
		
	}
	
	public RezervacijaDTO(Long id, boolean potvrdjeno, String datumRealizacije,PonudaDTO ponudaDTO) {
		super();
		this.id = id;
		this.potvrdjeno = potvrdjeno;
		this.datumRealizacije = datumRealizacije;
		this.ponudaDTO = ponudaDTO;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public boolean isPotvrdjeno() {
		return potvrdjeno;
	}
	public void setPotvrdjeno(boolean potvrdjeno) {
		this.potvrdjeno = potvrdjeno;
	}
	public String getDatumRealizacije() {
		return datumRealizacije;
	}
	public void setDatumRealizacije(String datumRealizacije) {
		this.datumRealizacije = datumRealizacije;
	}
	public PonudaDTO getPonudaDTO() {
		return ponudaDTO;
	}
	public void setPonudaDTO(PonudaDTO ponudaDTO) {
		this.ponudaDTO = ponudaDTO;
	}
	
	
	
}
