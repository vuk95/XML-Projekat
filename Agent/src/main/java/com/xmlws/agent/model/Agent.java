//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.29 at 10:41:48 AM CEST 
//


package com.xmlws.agent.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Agent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Agent">
 *   &lt;complexContent>
 *     &lt;extension base="{admin.xmlws.com/backend}Korisnik">
 *       &lt;attribute name="Poslovni_maticni_broj" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Agent")
@Entity
public class Agent
    extends Korisnik
{	

    @XmlAttribute(name = "Poslovni_maticni_broj")
    protected String poslovniMaticniBroj;
    
    public Agent() {
    	
    }

    public Agent(Long id, String ime, String prezime, String email, String lozinka,String poslovniMaticniBroj) {
    	super(id, ime, prezime, email, lozinka);
		this.poslovniMaticniBroj = poslovniMaticniBroj;
	}
    
    
    /**
     * Gets the value of the poslovniMaticniBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoslovniMaticniBroj() {
        return poslovniMaticniBroj;
    }

    /**
     * Sets the value of the poslovniMaticniBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoslovniMaticniBroj(String value) {
        this.poslovniMaticniBroj = value;
    }
}
