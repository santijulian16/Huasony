/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.facade;

import com.entities.Cancion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author santi
 */
@Stateless
public class CancionFacade extends AbstractFacade<Cancion> {

    @PersistenceContext(unitName = "HuasonyPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CancionFacade() {
        super(Cancion.class);
    }

    public List<Object[]> findAllShufle() {
        Query q = em.createNativeQuery("select c.`idCancion`, c.`idAlbum` from cancion as c order by Rand() limit 10");
        List<Object[]> can = q.getResultList();
        return can;
    }

}
