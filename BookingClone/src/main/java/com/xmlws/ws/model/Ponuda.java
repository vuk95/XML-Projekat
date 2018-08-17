//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.15 at 09:35:24 AM CEST 
//


package com.xmlws.ws.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
 *         &lt;element name="Cena" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="Broj_kreveta" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&gt;
 *         &lt;element name="Od" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element name="Do" type="{http://www.w3.org/2001/XMLSchema}date"/&gt;
 *         &lt;element ref="{}Rezervacija"/&gt;
 *         &lt;element name="Dodatna_usluga" maxOccurs="unbounded" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                   &lt;element name="Sifra"&gt;
 *                     &lt;simpleType&gt;
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
 *                         &lt;pattern value="[0-9][0-9][0-9]"/&gt;
 *                       &lt;/restriction&gt;
 *                     &lt;/simpleType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Opis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
    "cena",
    "brojKreveta",
    "od",
    "_do",
    "rezervacija",
    "dodatnaUsluga",
    "id"
})
@Entity
@XmlRootElement(name = "Ponuda")
@Table(name = "Ponuda")
public class Ponuda {

    @XmlElement(name = "Cena", required = true)
    protected BigDecimal cena;
    @XmlElement(name = "Broj_kreveta", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojKreveta;
    @XmlElement(name = "Od", required = true)
    @XmlSchemaType(name = "date")
    protected Date od;
    @XmlElement(name = "Do", required = true)
    @XmlSchemaType(name = "date")
    protected Date _do;
    @XmlElement(name = "Rezervacija", required = true)
    @ManyToOne
    protected Rezervacija rezervacija;
   
    /*
    @XmlElement(name = "Dodatna_usluga")
    @OneToMany
    @JoinTable(name = "ponuda_dodatne_usluge", joinColumns = {@JoinColumn(name="ponuda_id")},
               inverseJoinColumns = {@JoinColumn(name="dodatna_id")} ) 
    protected List<DodatnaUsluga> dodatnaUsluga;
    */
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ponuda_id")
    protected long id;

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
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojKreveta() {
        return brojKreveta;
    }

    /**
     * Sets the value of the brojKreveta property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojKreveta(BigInteger value) {
        this.brojKreveta = value;
    }

    /**
     * Gets the value of the od property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getOd() {
        return od;
    }

    /**
     * Sets the value of the od property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOd(Date value) {
        this.od = value;
    }

    /**
     * Gets the value of the do property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDo() {
        return _do;
    }

    /**
     * Sets the value of the do property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDo(Date value) {
        this._do = value;
    }

    /**
     * Gets the value of the rezervacija property.
     * 
     * @return
     *     possible object is
     *     {@link Rezervacija }
     *     
     */
    public Rezervacija getRezervacija() {
        return rezervacija;
    }

    /**
     * Sets the value of the rezervacija property.
     * 
     * @param value
     *     allowed object is
     *     {@link Rezervacija }
     *     
     */
    public void setRezervacija(Rezervacija value) {
        this.rezervacija = value;
    }

    /**
     * Gets the value of the dodatnaUsluga property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dodatnaUsluga property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDodatnaUsluga().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ponuda.DodatnaUsluga }
     * 
     * 
     */
    /*public List<Ponuda.DodatnaUsluga> getDodatnaUsluga() {
        if (dodatnaUsluga == null) {
            dodatnaUsluga = new ArrayList<Ponuda.DodatnaUsluga>();
        }
        return this.dodatnaUsluga;
    }
     */
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
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="Naziv" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *         &lt;element name="Sifra"&gt;
     *           &lt;simpleType&gt;
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int"&gt;
     *               &lt;pattern value="[0-9][0-9][0-9]"/&gt;
     *             &lt;/restriction&gt;
     *           &lt;/simpleType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Opis" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
        "naziv",
        "sifra",
        "opis"
    })
    public static class DodatnaUsluga {

        @XmlElement(name = "Naziv", required = true)
        protected String naziv;
        @XmlElement(name = "Sifra")
        protected int sifra;
        @XmlElement(name = "Opis", required = true)
        protected String opis;

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

}