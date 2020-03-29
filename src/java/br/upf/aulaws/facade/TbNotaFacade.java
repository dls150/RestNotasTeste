/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.aulaws.facade;

import br.upf.aulaws.entity.TbNota;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author notebook
 */
@Stateless
public class TbNotaFacade extends AbstractFacade<TbNota> {

    @PersistenceContext(unitName = "RestNotasPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TbNotaFacade() {
        super(TbNota.class);
    }
    
}
