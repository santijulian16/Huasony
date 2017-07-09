/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "cancion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancion.findAll", query = "SELECT c FROM Cancion c")
    , @NamedQuery(name = "Cancion.findByIdCancion", query = "SELECT c FROM Cancion c WHERE c.idCancion = :idCancion")
    , @NamedQuery(name = "Cancion.findByNombre", query = "SELECT c FROM Cancion c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Cancion.findByDuracion", query = "SELECT c FROM Cancion c WHERE c.duracion = :duracion")
    , @NamedQuery(name = "Cancion.findByCalidad", query = "SELECT c FROM Cancion c WHERE c.calidad = :calidad")
    , @NamedQuery(name = "Cancion.findByPosicion", query = "SELECT c FROM Cancion c WHERE c.posicion = :posicion")
    , @NamedQuery(name = "Cancion.findByUrl", query = "SELECT c FROM Cancion c WHERE c.url = :url")
    , @NamedQuery(name = "Cancion.findByNumReproducciones", query = "SELECT c FROM Cancion c WHERE c.numReproducciones = :numReproducciones")})
public class Cancion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCancion")
    private Integer idCancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "duracion")
    @Temporal(TemporalType.TIME)
    private Date duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "calidad")
    private int calidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "posicion")
    private short posicion;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "letra")
    private String letra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "url")
    private String url;
    @Column(name = "numReproducciones")
    private BigInteger numReproducciones;
    @JoinColumn(name = "idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario idUsuario;
    @JoinColumn(name = "idGenero", referencedColumnName = "idGenero")
    @ManyToOne(optional = false)
    private Genero idGenero;
    @JoinColumn(name = "idAlbum", referencedColumnName = "idAlbum")
    @ManyToOne(optional = false)
    private Album idAlbum;

    public Cancion() {
    }

    public Cancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public Cancion(Integer idCancion, String nombre, int calidad, short posicion, String letra, String url) {
        this.idCancion = idCancion;
        this.nombre = nombre;
        this.calidad = calidad;
        this.posicion = posicion;
        this.letra = letra;
        this.url = url;
    }

    public Integer getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(Integer idCancion) {
        this.idCancion = idCancion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getDuracion() {
        return duracion;
    }

    public void setDuracion(Date duracion) {
        this.duracion = duracion;
    }

    public int getCalidad() {
        return calidad;
    }

    public void setCalidad(int calidad) {
        this.calidad = calidad;
    }

    public short getPosicion() {
        return posicion;
    }

    public void setPosicion(short posicion) {
        this.posicion = posicion;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public BigInteger getNumReproducciones() {
        return numReproducciones;
    }

    public void setNumReproducciones(BigInteger numReproducciones) {
        this.numReproducciones = numReproducciones;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Genero getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Genero idGenero) {
        this.idGenero = idGenero;
    }

    public Album getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(Album idAlbum) {
        this.idAlbum = idAlbum;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCancion != null ? idCancion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.idCancion == null && other.idCancion != null) || (this.idCancion != null && !this.idCancion.equals(other.idCancion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Cancion[ idCancion=" + idCancion + " ]";
    }
    
}
