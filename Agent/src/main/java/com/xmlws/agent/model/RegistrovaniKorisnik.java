//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.29 at 10:41:48 AM CEST 
//


package com.xmlws.agent.model;

import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RegistrovaniKorisnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RegistrovaniKorisnik">
 *   &lt;complexContent>
 *     &lt;extension base="{admin.xmlws.com/backend}Korisnik">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RegistrovaniKorisnik")
@Entity
public class RegistrovaniKorisnik
    extends Korisnik
{
	
	public RegistrovaniKorisnik() {
    	
    }

    public RegistrovaniKorisnik(Long id, String ime, String prezime, String email, String lozinka) {
    	super(id, ime, prezime, email, lozinka);
	}

}
