/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.facade.CancionFacade;
import javax.inject.Named;
import  javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;
import com.entities.Cancion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author santi
 */
@Named(value = "cancionController")
@ManagedBean(name="cancionController")
@SessionScoped
public class CancionController implements Serializable {

    private List<Cancion> listCan = new ArrayList<>();
    /**
     * Creates a new instance of CancionController
     */
    @Inject
    CancionFacade cf;

    public CancionController() {
    }

    public void traerCollage() {

        List<Object[]> listIdCanciones;
        this.listCan.clear();
        Cancion can;
//        boolean extreg = false;
        listIdCanciones = cf.findAllShufle();
        for (Object[] id : listIdCanciones) {
            can = cf.find((int) id[0]);
            listCan.add(can);
        }
//        if (this.listCan.size() > 0) {
//            extreg = true;
//        }
    }

    public void traerCollage2() {

        this.listCan.clear();
        this.listCan = cf.findAll();
        Collections.shuffle(listCan);
        while (listCan.size() > 10) {
            listCan.remove(10);
        }
    }

    public List<Cancion> getListCan() {
        return listCan;
    }

    public void setListCan(List<Cancion> listCan) {
        this.listCan = listCan;
    }

}
