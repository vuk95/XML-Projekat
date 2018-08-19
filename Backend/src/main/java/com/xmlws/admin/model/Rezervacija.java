//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.15 at 09:35:24 AM CEST 
//


package com.xmlws.admin.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{}Korisnik"/&gt;
 *         &lt;element name="Potvrdjeno" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="Datum_realizacije" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "korisnik",
    "potvrdjeno",
    "datumRealizacije",
    "id"
})
@Entity
@XmlRootElement(name = "Rezervacija")
public class Rezervacija {
	
    @XmlElement(name = "Korisnik", required = true)
    @ManyToOne
    protected Korisnik korisnik;
    @XmlElement(name = "Potvrdjeno")
    protected boolean potvrdjeno;
    @XmlElement(name = "Datum_realizacije", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date datumRealizacije;
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    /**
     * Gets the value of the korisnik property.
     * 
     * @return
     *     possible object is
     *     {@link Korisnik }
     *     
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Sets the value of the korisnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korisnik }
     *     
     */
    public void setKorisnik(Korisnik value) {
        this.korisnik = value;
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
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDatumRealizacije() {
        return datumRealizacije;
    }

    /**
     * Sets the value of the datumRealizacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumRealizacije(Date value) {
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

}
