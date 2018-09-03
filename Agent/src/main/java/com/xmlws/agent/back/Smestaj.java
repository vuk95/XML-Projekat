
package com.xmlws.agent.back;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Smestaj complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Smestaj">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Agent" type="{admin.xmlws.com/backend}Agent"/>
 *         &lt;element name="Kategorija" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Tip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Opis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Ocena" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="lokacija" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Image" type="{admin.xmlws.com/backend}Image" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Ponuda" type="{admin.xmlws.com/backend}Ponuda" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Parking" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Wifi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Dorucak" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Polupansion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Pansion" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="TV" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Kuhinja" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Kupatilo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Sifrarnik" type="{admin.xmlws.com/backend}Sifrarnik"/>
 *         &lt;element name="zauzet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Smestaj", propOrder = {
    "agent",
    "kategorija",
    "tip",
    "opis",
    "ocena",
    "id",
    "lokacija",
    "naziv",
    "image",
    "ponuda",
    "parking",
    "wifi",
    "dorucak",
    "polupansion",
    "pansion",
    "tv",
    "kuhinja",
    "kupatilo",
    "sifrarnik",
    "zauzet"
})
public class Smestaj {

    @XmlElement(name = "Agent", required = true)
    protected Agent agent;
    @XmlElement(name = "Kategorija", required = true)
    protected String kategorija;
    @XmlElement(name = "Tip", required = true)
    protected String tip;
    @XmlElement(name = "Opis", required = true)
    protected String opis;
    @XmlElement(name = "Ocena")
    protected int ocena;
    protected long id;
    @XmlElement(required = true)
    protected String lokacija;
    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(name = "Image")
    protected List<Image> image;
    @XmlElement(name = "Ponuda")
    protected List<Ponuda> ponuda;
    @XmlElement(name = "Parking")
    protected boolean parking;
    @XmlElement(name = "Wifi")
    protected boolean wifi;
    @XmlElement(name = "Dorucak")
    protected boolean dorucak;
    @XmlElement(name = "Polupansion")
    protected boolean polupansion;
    @XmlElement(name = "Pansion")
    protected boolean pansion;
    @XmlElement(name = "TV")
    protected boolean tv;
    @XmlElement(name = "Kuhinja")
    protected boolean kuhinja;
    @XmlElement(name = "Kupatilo")
    protected boolean kupatilo;
    @XmlElement(name = "Sifrarnik", required = true)
    protected Sifrarnik sifrarnik;
    protected boolean zauzet;

    /**
     * Gets the value of the agent property.
     * 
     * @return
     *     possible object is
     *     {@link Agent }
     *     
     */
    public Agent getAgent() {
        return agent;
    }

    /**
     * Sets the value of the agent property.
     * 
     * @param value
     *     allowed object is
     *     {@link Agent }
     *     
     */
    public void setAgent(Agent value) {
        this.agent = value;
    }

    /**
     * Gets the value of the kategorija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKategorija() {
        return kategorija;
    }

    /**
     * Sets the value of the kategorija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKategorija(String value) {
        this.kategorija = value;
    }

    /**
     * Gets the value of the tip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTip() {
        return tip;
    }

    /**
     * Sets the value of the tip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTip(String value) {
        this.tip = value;
    }

    /**
     * Gets the value of the opis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Sets the value of the opis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpis(String value) {
        this.opis = value;
    }

    /**
     * Gets the value of the ocena property.
     * 
     */
    public int getOcena() {
        return ocena;
    }

    /**
     * Sets the value of the ocena property.
     * 
     */
    public void setOcena(int value) {
        this.ocena = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the lokacija property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLokacija() {
        return lokacija;
    }

    /**
     * Sets the value of the lokacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLokacija(String value) {
        this.lokacija = value;
    }

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the image property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the image property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Image }
     * 
     * 
     */
    public List<Image> getImage() {
        if (image == null) {
            image = new ArrayList<Image>();
        }
        return this.image;
    }

    /**
     * Gets the value of the ponuda property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ponuda property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPonuda().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ponuda }
     * 
     * 
     */
    public List<Ponuda> getPonuda() {
        if (ponuda == null) {
            ponuda = new ArrayList<Ponuda>();
        }
        return this.ponuda;
    }

    /**
     * Gets the value of the parking property.
     * 
     */
    public boolean isParking() {
        return parking;
    }

    /**
     * Sets the value of the parking property.
     * 
     */
    public void setParking(boolean value) {
        this.parking = value;
    }

    /**
     * Gets the value of the wifi property.
     * 
     */
    public boolean isWifi() {
        return wifi;
    }

    /**
     * Sets the value of the wifi property.
     * 
     */
    public void setWifi(boolean value) {
        this.wifi = value;
    }

    /**
     * Gets the value of the dorucak property.
     * 
     */
    public boolean isDorucak() {
        return dorucak;
    }

    /**
     * Sets the value of the dorucak property.
     * 
     */
    public void setDorucak(boolean value) {
        this.dorucak = value;
    }

    /**
     * Gets the value of the polupansion property.
     * 
     */
    public boolean isPolupansion() {
        return polupansion;
    }

    /**
     * Sets the value of the polupansion property.
     * 
     */
    public void setPolupansion(boolean value) {
        this.polupansion = value;
    }

    /**
     * Gets the value of the pansion property.
     * 
     */
    public boolean isPansion() {
        return pansion;
    }

    /**
     * Sets the value of the pansion property.
     * 
     */
    public void setPansion(boolean value) {
        this.pansion = value;
    }

    /**
     * Gets the value of the tv property.
     * 
     */
    public boolean isTV() {
        return tv;
    }

    /**
     * Sets the value of the tv property.
     * 
     */
    public void setTV(boolean value) {
        this.tv = value;
    }

    /**
     * Gets the value of the kuhinja property.
     * 
     */
    public boolean isKuhinja() {
        return kuhinja;
    }

    /**
     * Sets the value of the kuhinja property.
     * 
     */
    public void setKuhinja(boolean value) {
        this.kuhinja = value;
    }

    /**
     * Gets the value of the kupatilo property.
     * 
     */
    public boolean isKupatilo() {
        return kupatilo;
    }

    /**
     * Sets the value of the kupatilo property.
     * 
     */
    public void setKupatilo(boolean value) {
        this.kupatilo = value;
    }

    /**
     * Gets the value of the sifrarnik property.
     * 
     * @return
     *     possible object is
     *     {@link Sifrarnik }
     *     
     */
    public Sifrarnik getSifrarnik() {
        return sifrarnik;
    }

    /**
     * Sets the value of the sifrarnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Sifrarnik }
     *     
     */
    public void setSifrarnik(Sifrarnik value) {
        this.sifrarnik = value;
    }

    /**
     * Gets the value of the zauzet property.
     * 
     */
    public boolean isZauzet() {
        return zauzet;
    }

    /**
     * Sets the value of the zauzet property.
     * 
     */
    public void setZauzet(boolean value) {
        this.zauzet = value;
    }

}
