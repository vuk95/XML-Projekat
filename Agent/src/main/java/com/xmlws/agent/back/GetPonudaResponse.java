
package com.xmlws.agent.back;

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
 *         &lt;element name="Ponuda" type="{admin.xmlws.com/backend}Ponuda"/>
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
    "ponuda"
})
@XmlRootElement(name = "getPonudaResponse")
public class GetPonudaResponse {

    @XmlElement(name = "Ponuda", required = true)
    protected Ponuda ponuda;

    /**
     * Gets the value of the ponuda property.
     * 
     * @return
     *     possible object is
     *     {@link Ponuda }
     *     
     */
    public Ponuda getPonuda() {
        return ponuda;
    }

    /**
     * Sets the value of the ponuda property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ponuda }
     *     
     */
    public void setPonuda(Ponuda value) {
        this.ponuda = value;
    }

}
