
package com.xmlws.agent.back;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Ponuda complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ponuda">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="Broj_kreveta" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Od" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="DoDatuma" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Rezervacija" type="{admin.xmlws.com/backend}Rezervacija" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Smestaj" type="{admin.xmlws.com/backend}Smestaj"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ponuda", propOrder = {
    "cena",
    "brojKreveta",
    "od",
    "doDatuma",
    "rezervacija",
    "id",
    "smestaj"
})
public class Ponuda {

    @XmlElement(name = "Cena", required = true)
    protected BigDecimal cena;
    @XmlElement(name = "Broj_kreveta", required = true)
    protected String brojKreveta;
    @XmlElement(name = "Od", required = true)
    protected String od;
    @XmlElement(name = "DoDatuma", required = true)
    protected String doDatuma;
    @XmlElement(name = "Rezervacija")
    protected List<Rezervacija> rezervacija;
    protected long id;
    @XmlElement(name = "Smestaj", required = true)
    protected Smestaj smestaj;

    /**
     * Gets the value of the cena property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCena(BigDecimal value) {
        this.cena = value;
    }

    /**
     * Gets the value of the brojKreveta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojKreveta() {
        return brojKreveta;
    }

    /**
     * Sets the value of the brojKreveta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojKreveta(String value) {
        this.brojKreveta = value;
    }

    /**
     * Gets the value of the od property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOd() {
        return od;
    }

    /**
     * Sets the value of the od property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOd(String value) {
        this.od = value;
    }

    /**
     * Gets the value of the doDatuma property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDoDatuma() {
        return doDatuma;
    }

    /**
     * Sets the value of the doDatuma property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDoDatuma(String value) {
        this.doDatuma = value;
    }

    /**
     * Gets the value of the rezervacija property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rezervacija property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRezervacija().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rezervacija }
     * 
     * 
     */
    public List<Rezervacija> getRezervacija() {
        if (rezervacija == null) {
            rezervacija = new ArrayList<Rezervacija>();
        }
        return this.rezervacija;
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

}
