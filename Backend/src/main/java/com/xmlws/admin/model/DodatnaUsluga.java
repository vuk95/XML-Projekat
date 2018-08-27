package com.xmlws.admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlElement;


public class DodatnaUsluga {

    @XmlElement(name = "Naziv", required = true)
    protected String naziv;
    @XmlElement(name = "Sifra")
    protected int sifra;
    @XmlElement(name = "Opis", required = true)
    protected String opis;
    protected long id;
    
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
     * Gets the value of the sifra property.
     * 
     */
    public int getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     * 
     */
    public void setSifra(int value) {
        this.sifra = value;
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

}
