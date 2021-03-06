//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.15 at 09:35:24 AM CEST 
//


package com.xmlws.ws.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
    "dodatnaUsluga"
})

@XmlRootElement(name = "Sifrarnik")
public class Sifrarnik {

    @XmlElement(name = "Dodatna_usluga")
    protected List<Sifrarnik.DodatnaUsluga> dodatnaUsluga;

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
     * {@link Sifrarnik.DodatnaUsluga }
     * 
     * 
     */
    public List<Sifrarnik.DodatnaUsluga> getDodatnaUsluga() {
        if (dodatnaUsluga == null) {
            dodatnaUsluga = new ArrayList<Sifrarnik.DodatnaUsluga>();
        }
        return this.dodatnaUsluga;
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
