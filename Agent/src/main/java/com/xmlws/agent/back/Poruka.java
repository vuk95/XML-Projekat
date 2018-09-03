
package com.xmlws.agent.back;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Poruka complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Poruka">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="RegistrovaniKorisnik" type="{admin.xmlws.com/backend}RegistrovaniKorisnik"/>
 *         &lt;element name="Agent" type="{admin.xmlws.com/backend}Agent"/>
 *         &lt;element name="procitana" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="idPrimljene" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="datum" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Poruka", propOrder = {
    "id",
    "registrovaniKorisnik",
    "agent",
    "procitana",
    "sadrzaj",
    "idPrimljene",
    "datum"
})
public class Poruka {

    protected long id;
    @XmlElement(name = "RegistrovaniKorisnik", required = true)
    protected RegistrovaniKorisnik registrovaniKorisnik;
    @XmlElement(name = "Agent", required = true)
    protected Agent agent;
    protected boolean procitana;
    @XmlElement(required = true)
    protected String sadrzaj;
    protected Long idPrimljene;
    @XmlElement(required = true)
    protected String datum;

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
     * Gets the value of the registrovaniKorisnik property.
     * 
     * @return
     *     possible object is
     *     {@link RegistrovaniKorisnik }
     *     
     */
    public RegistrovaniKorisnik getRegistrovaniKorisnik() {
        return registrovaniKorisnik;
    }

    /**
     * Sets the value of the registrovaniKorisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistrovaniKorisnik }
     *     
     */
    public void setRegistrovaniKorisnik(RegistrovaniKorisnik value) {
        this.registrovaniKorisnik = value;
    }

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
     * Gets the value of the procitana property.
     * 
     */
    public boolean isProcitana() {
        return procitana;
    }

    /**
     * Sets the value of the procitana property.
     * 
     */
    public void setProcitana(boolean value) {
        this.procitana = value;
    }

    /**
     * Gets the value of the sadrzaj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Sets the value of the sadrzaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSadrzaj(String value) {
        this.sadrzaj = value;
    }

    /**
     * Gets the value of the idPrimljene property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdPrimljene() {
        return idPrimljene;
    }

    /**
     * Sets the value of the idPrimljene property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdPrimljene(Long value) {
        this.idPrimljene = value;
    }

    /**
     * Gets the value of the datum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatum() {
        return datum;
    }

    /**
     * Sets the value of the datum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatum(String value) {
        this.datum = value;
    }

}
