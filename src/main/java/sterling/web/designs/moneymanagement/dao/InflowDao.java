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
import sterling.web.designs.moneymanagement.entities.Inflow;

/**
 *
 * @author Rodney
 */
public class InflowDao {
    
    PersistanceUnit pu = PersistanceUnit.getInstance();

    public InflowDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public InflowDao() {
    }

    private EntityManagerFactory emf = pu.enFactory;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public void create(Inflow inflow) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(inflow);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Inflow> retrieve_transctions(){
        EntityManager em = getEntityManager();
        try{
            Query trans = em.createNamedQuery("Inflow.findAll");
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
    
    //unconfirmed transactions
     public List<Inflow> unconfirmed_transctions(){
        EntityManager em = getEntityManager();
        String status = "UNCONFIRMED";
        try{
            Query trans = em.createNamedQuery("Inflow.findByStatus");
            trans.setParameter("status", status);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
     
     //unconfirmed transactions
     public List<Inflow> unconfirmedin_transctions(String enteredby){
        EntityManager em = getEntityManager();
        
        try{
            Query trans = em.createNamedQuery("Inflow.findByEnteredby");
            trans.setParameter("enteredby", enteredby);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
     
     //unconfirmed transactions
     public List<Inflow> unconfirmedin_byperson_transctions(String enteredby){
        EntityManager em = getEntityManager();
        String status = "PENDING";
        try{
            Query trans = em.createNamedQuery("Inflow.findByInflow");
            trans.setParameter("enteredby", enteredby);
            trans.setParameter("status", status);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
     
    //confirmed transactions
     public List<Inflow> confirmedin_byperson_transctions(String enteredby){
        EntityManager em = getEntityManager();
        String status = "CONFIRMED";
        try{
            Query trans = em.createNamedQuery("Inflow.findByInflow");
            trans.setParameter("enteredby", enteredby);
            trans.setParameter("status", status);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
     
    
     
     
    //confirmed transactions
     public List<Inflow> confirmed_transctions(){
        EntityManager em = getEntityManager();
        String status = "CONFIRMED";
        try{
            Query trans = em.createNamedQuery("Inflow.findByStatus");
            trans.setParameter("status", status);
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 
    

}
