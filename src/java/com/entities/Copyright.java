/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author santi
 */
@Entity
@Table(name = "copyright")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Copyright.findAll", query = "SELECT c FROM Copyright c")
    , @NamedQuery(name = "Copyright.findByIdCopyright", query = "SELECT c FROM Copyright c WHERE c.idCopyright = :idCopyright")
    , @NamedQuery(name = "Copyright.findByNombre", query = "SELECT c FROM Copyright c WHERE c.nombre = :nombre")})
public class Copyright implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCopyright")
    private Integer idCopyright;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCopyright")
    private List<Album> albumList;

    public Copyright() {
    }

    public Copyright(Integer idCopyright) {
        this.idCopyright = idCopyright;
    }

    public Integer getIdCopyright() {
        return idCopyright;
    }

    public void setIdCopyright(Integer idCopyright) {
        this.idCopyright = idCopyright;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Album> getAlbumList() {
        return albumList;
    }

    public void setAlbumList(List<Album> albumList) {
        this.albumList = albumList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCopyright != null ? idCopyright.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Copyright)) {
            return false;
        }
        Copyright other = (Copyright) object;
        if ((this.idCopyright == null && other.idCopyright != null) || (this.idCopyright != null && !this.idCopyright.equals(other.idCopyright))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entities.Copyright[ idCopyright=" + idCopyright + " ]";
    }
    
}
