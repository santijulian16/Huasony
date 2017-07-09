/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "auditoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")
    , @NamedQuery(name = "Auditoria.findByIdAuditoria", query = "SELECT a FROM Auditoria a WHERE a.idAuditoria = :idAuditoria")
    , @NamedQuery(name = "Auditoria.findByIdentidadDigital", query = "SELECT a FROM Auditoria a WHERE a.identidadDigital = :identidadDigital")
    , @NamedQuery(name = "Auditoria.findByTiempo", query = "SELECT a FROM Auditoria a WHERE a.tiempo = :tiempo")
    , @NamedQuery(name = "Auditoria.findByFecha", query = "SELECT a FROM Auditoria a WHERE a.fecha = :fecha")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAuditoria")
    private Integer idAuditoria;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "identidad digital")
    private String identidadDigital;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tiempo")
    @Temporal(TemporalType.TIME)
    private Date tiempo;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Auditoria() {
    }

    public Auditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public Auditoria(Integer idAuditoria, String identidadDigital) {
        this.idAuditoria = idAuditoria;
        this.identidadDigital = identidadDigital;
    }

    public Integer getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(Integer idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getIdentidadDigital() {
        return identidadDigital;
    }

    public void setIdentidadDigital(String identidadDigital) {
        this.identidadDigital = identidadDigital;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getTiempo() {
        return tiempo;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAuditoria != null ? idAuditoria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.idAuditoria == null && other.idAuditoria != null) || (this.idAuditoria != null && !this.idAuditoria.equals(other.idAuditoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Auditoria[ idAuditoria=" + idAuditoria + " ]";
    }
    
}
