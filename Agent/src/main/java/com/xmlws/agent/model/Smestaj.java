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
import javax.xml.bind.annotation.XmlElement;

@Entity
public class Smestaj {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smestaj_id")
	private Long id;
	
	@ManyToOne
    private Agent agent;
    
    private String lokacija;
    
    private String kategorija;
    
    private String tip;
    
    private String opis;
    
    private int ocena;
    
    private boolean parking;

    private boolean wifi;
    
    private boolean dorucak;
    
    private boolean polupansion;
    
    private boolean pansion;
    
    private boolean tv;
    
    private boolean kuhinja;    
    
    private boolean kupatilo;
    
    private String naziv;
     
    @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mojeSlike",
				joinColumns = @JoinColumn(name = "smestaj_id", referencedColumnName = "smestaj_id"),
				inverseJoinColumns = @JoinColumn(name = "image_id", referencedColumnName = "image_id"))
	private List<Image> mojeSlike = new ArrayList<Image>();
	
    @OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "mojePonude",
				joinColumns = @JoinColumn(name = "smestaj_id", referencedColumnName = "smestaj_id"),
				inverseJoinColumns = @JoinColumn(name = "ponuda_id", referencedColumnName = "ponuda_id"))
	private List<Ponuda> mojePonude = new ArrayList<Ponuda>();
    
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
	public List<Image> getMojeSlike() {
		return mojeSlike;
	}
	public void setMojeSlike(List<Image> mojeSlike) {
		this.mojeSlike = mojeSlike;
	}
	public boolean isParking() {
		return parking;
	}
	public void setParking(boolean parking) {
		this.parking = parking;
	}
	public boolean isWifi() {
		return wifi;
	}
	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}
	public boolean isDorucak() {
		return dorucak;
	}
	public void setDorucak(boolean dorucak) {
		this.dorucak = dorucak;
	}
	public boolean isPolupansion() {
		return polupansion;
	}
	public void setPolupansion(boolean polupansion) {
		this.polupansion = polupansion;
	}
	public boolean isPansion() {
		return pansion;
	}
	public void setPansion(boolean pansion) {
		this.pansion = pansion;
	}
	public boolean isTv() {
		return tv;
	}
	public void setTv(boolean tv) {
		this.tv = tv;
	}
	public boolean isKuhinja() {
		return kuhinja;
	}
	public void setKuhinja(boolean kuhinja) {
		this.kuhinja = kuhinja;
	}
	public boolean isKupatilo() {
		return kupatilo;
	}
	public void setKupatilo(boolean kupatilo) {
		this.kupatilo = kupatilo;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public List<Ponuda> getMojePonude() {
		return mojePonude;
	}
	public void setMojePonude(List<Ponuda> mojePonude) {
		this.mojePonude = mojePonude;
	}
	
	

}
