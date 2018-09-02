
package com.xmlws.agent.back;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Rezervacija complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Rezervacija">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RegistrovaniKorisnik" type="{admin.xmlws.com/backend}RegistrovaniKorisnik"/>
 *         &lt;element name="Potvrdjeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Datum_realizacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Ponuda" type="{admin.xmlws.com/backend}Ponuda"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rezervacija", propOrder = {
    "registrovaniKorisnik",
    "potvrdjeno",
    "datumRealizacije",
    "id",
    "ponuda"
})
public class Rezervacija {

    @XmlElement(name = "RegistrovaniKorisnik", required = true)
    protected RegistrovaniKorisnik registrovaniKorisnik;
    @XmlElement(name = "Potvrdjeno")
    protected boolean potvrdjeno;
    @XmlElement(name = "Datum_realizacije", required = true)
    protected String datumRealizacije;
    protected long id;
    @XmlElement(name = "Ponuda", required = true)
    protected Ponuda ponuda;

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
     * Gets the value of the potvrdjeno property.
     * 
     */
    public boolean isPotvrdjeno() {
        return potvrdjeno;
    }

    /**
     * Sets the value of the potvrdjeno property.
     * 
     */
    public void setPotvrdjeno(boolean value) {
        this.potvrdjeno = value;
    }

    /**
     * Gets the value of the datumRealizacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumRealizacije() {
        return datumRealizacije;
    }

    /**
     * Sets the value of the datumRealizacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumRealizacije(String value) {
        this.datumRealizacije = value;
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
     * Gets the value of the ponuda property.
     * 
     * @return
     *     possible object is
     *     {@link Ponuda }
     *     
     */
    public Ponuda getPonuda() {
        return ponuda;
    }

    /**
     * Sets the value of the ponuda property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ponuda }
     *     
     */
    public void setPonuda(Ponuda value) {
        this.ponuda = value;
    }

}
