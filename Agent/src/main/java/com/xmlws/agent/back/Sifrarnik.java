
package com.xmlws.agent.back;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Sifrarnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sifrarnik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="sifra" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vrednost" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sifrarnik", propOrder = {
    "id",
    "sifra",
    "vrednost"
})
public class Sifrarnik {

    protected long id;
    @XmlElement(required = true)
    protected String sifra;
    @XmlElement(required = true)
    protected String vrednost;

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
     * Gets the value of the sifra property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSifra() {
        return sifra;
    }

    /**
     * Sets the value of the sifra property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSifra(String value) {
        this.sifra = value;
    }

    /**
     * Gets the value of the vrednost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVrednost() {
        return vrednost;
    }

    /**
     * Sets the value of the vrednost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVrednost(String value) {
        this.vrednost = value;
    }

}
