/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sterling.web.designs.moneymanagement.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import sterling.web.designs.moneymanagement.config.PersistanceUnit;
import sterling.web.designs.moneymanagement.entities.Outflow;

/**
 *
 * @author Rodney
 */
public class OutflowDao {
    
    PersistanceUnit pu = PersistanceUnit.getInstance();

    public OutflowDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public OutflowDao() {
    }

    private EntityManagerFactory emf = pu.enFactory;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Outflow outflow) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(outflow);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
     public List<Outflow> retrieve_transctions(){
        EntityManager em = getEntityManager();
        try{
            Query trans = em.createNamedQuery("Outflow.findAll");
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
     
    
    public List<Outflow> retrieve_perperson(String username){
        EntityManager em = getEntityManager();
        try{
            Query trans = em.createNamedQuery("Outflow.findByRequestedby");
            trans.setParameter("requestedby", username);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
    
     //unconfirmed transactions
     public List<Outflow> unconfirmed_outflow(){
        EntityManager em = getEntityManager();
        String status = "";
        try{
            Query trans = em.createNamedQuery("Outflow.findByStatus");
            trans.setParameter("status", status);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
     
    //confirmed transactions
     public List<Outflow> confirmed_outflow(){
        EntityManager em = getEntityManager();
        String status = "CONFIRMED";
        try{
            Query trans = em.createNamedQuery("Outflow.findByStatus");
            trans.setParameter("status", status);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
    

}
