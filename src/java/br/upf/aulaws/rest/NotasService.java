/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.upf.aulaws.rest;

import br.upf.aulaws.entity.TbNota;
import br.upf.aulaws.facade.AbstractFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author notebook
 */

@Stateless
@Path("notas")
public class NotasService extends AbstractFacade<TbNota> {
 
    //JPA: mapeando a unidade de persistência
    @PersistenceContext(unitName = "RestNOtasPU")       
    private EntityManager em;
    
    //JPA: criando objeto ejb para persistência
    @EJB
    private br.upf.aulaws.facade.TbNotaFacade ejbFacade;
    
    //JPA: sobrescrevendo o metodo abstrato de getEntityManager
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
          
    public NotasService(){
        super(TbNota.class);
    }
  
    /**
     * Serviço responsável por listar todos os registros
     * @return
     */
    @GET
    @Override
    @Path("/listAll") // adicionando o caminho na URL
    @Produces(MediaType.APPLICATION_JSON)
    public List<TbNota> findAll(){
     return super.findAll();
    }

    /**
     * Serviço responsável por contar a quantidade de registros
     * @return
     */
    @GET
    @Path("/count") //recebendo parâmetro
    @Produces(MediaType.TEXT_PLAIN)
    public String countRest(){
        return String.valueOf(super.count());
    }
    
    /**
     * Serviço responsável por buscar um registro, recebendo como par^âmetro o ID
     * @param id
     * @return
     */
     
    @GET
    @Path("/finByID/{id}") //recebendo o parâmetro
    @Produces(MediaType.APPLICATION_JSON)
    public TbNota findById(@PathParam("id") Integer id){
        return super.find(id);
    }
}