//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.09.01 at 11:39:39 AM CEST 
//


package com.xmlws.admin.backend;

import java.util.ArrayList;
import java.util.List;
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
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Smestaj" type="{admin.xmlws.com/backend}Smestaj" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "smestaj"
})
@XmlRootElement(name = "getAllSmestajResponse")
public class GetAllSmestajResponse {

    @XmlElement(name = "Smestaj")
    protected List<Smestaj> smestaj;

    /**
     * Gets the value of the smestaj property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the smestaj property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSmestaj().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Smestaj }
     * 
     * 
     */
    public List<Smestaj> getSmestaj() {
        if (smestaj == null) {
            smestaj = new ArrayList<Smestaj>();
        }
        return this.smestaj;
    }

	public void setSmestaj(List<Smestaj> smestaj) {
		this.smestaj = smestaj;
	}
    
    

}
