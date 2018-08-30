
package com.xmlws.agent.back;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Komentar complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Komentar">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Sadrzaj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Odobren" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Smestaj" type="{admin.xmlws.com/backend}Smestaj"/>
 *         &lt;element name="RegistrovaniKorisnik" type="{admin.xmlws.com/backend}RegistrovaniKorisnik"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Komentar", propOrder = {
    "sadrzaj",
    "odobren",
    "id",
    "smestaj",
    "registrovaniKorisnik"
})
public class Komentar {

    @XmlElement(name = "Sadrzaj", required = true)
    protected String sadrzaj;
    @XmlElement(name = "Odobren")
    protected boolean odobren;
    protected long id;
    @XmlElement(name = "Smestaj", required = true)
    protected Smestaj smestaj;
    @XmlElement(name = "RegistrovaniKorisnik", required = true)
    protected RegistrovaniKorisnik registrovaniKorisnik;

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
     * Gets the value of the odobren property.
     * 
     */
    public boolean isOdobren() {
        return odobren;
    }

    /**
     * Sets the value of the odobren property.
     * 
     */
    public void setOdobren(boolean value) {
        this.odobren = value;
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
     * Gets the value of the smestaj property.
     * 
     * @return
     *     possible object is
     *     {@link Smestaj }
     *     
     */
    public Smestaj getSmestaj() {
        return smestaj;
    }

    /**
     * Sets the value of the smestaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Smestaj }
     *     
     */
    public void setSmestaj(Smestaj value) {
        this.smestaj = value;
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

}
