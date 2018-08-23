package com.xmlws.agent.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Smestaj {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smestaj_id")
	private Long id;
	
	@ManyToOne
    private Agent agent;
    
    private int kapacitet;
    
    private String lokacija;
    
    private String kategorija;
    
    private String tip;
    
    private String opis;
    
    private int ocena;
    
    @ManyToOne
    private Ponuda ponuda;    
    
    @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mojeSlike",
				joinColumns = @JoinColumn(name = "smestaj_id", referencedColumnName = "smestaj_id"),
				inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "image_id"))
	private List<Image> mojeSlike = new ArrayList<Image>();
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public int getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(int kapacitet) {
		this.kapacitet = kapacitet;
	}
	public String getLokacija() {
		return lokacija;
	}
	public void setLokacija(String lokacija) {
		this.lokacija = lokacija;
	}
	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	public Ponuda getPonuda() {
		return ponuda;
	}
	public void setPonuda(Ponuda ponuda) {
		this.ponuda = ponuda;
	}
	public List<Image> getMojeSlike() {
		return mojeSlike;
	}
	public void setMojeSlike(List<Image> mojeSlike) {
		this.mojeSlike = mojeSlike;
	}

}
