//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.11 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2019.08.10 a las 02:47:23 PM BOT 
//


package com.numa.soap.gs_ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="clubInfo" type="{http://www.numapage.com/club-ws}clubInfo"/&gt;
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
    "clubInfo"
})
@XmlRootElement(name = "updateClubRequest")
public class UpdateClubRequest {

    @XmlElement(required = true)
    protected ClubInfo clubInfo;

    /**
     * Obtiene el valor de la propiedad clubInfo.
     * 
     * @return
     *     possible object is
     *     {@link ClubInfo }
     *     
     */
    public ClubInfo getClubInfo() {
        return clubInfo;
    }

    /**
     * Define el valor de la propiedad clubInfo.
     * 
     * @param value
     *     allowed object is
     *     {@link ClubInfo }
     *     
     */
    public void setClubInfo(ClubInfo value) {
        this.clubInfo = value;
    }

}