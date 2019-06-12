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
import sterling.web.designs.moneymanagement.entities.User;

/**
 *
 * @author Rodney
 */
public class UserDao {
    
    PersistanceUnit pu = PersistanceUnit.getInstance();

    public UserDao(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UserDao() {
    }

    private EntityManagerFactory emf = pu.enFactory;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    //create user from create user form
    public void create(User user) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    //check if user exists in the database
    public User login(String username){
      EntityManager em = getEntityManager();
      try{
        Query q1 = em.createNamedQuery("User.findByUsername");
        q1.setParameter("username", username);
        return (User) q1.getSingleResult();
         
      }catch(Exception ex){
          ex.fillInStackTrace();
          return null;
      }
    }
    
     public List<User> retrieve_user(){
        EntityManager em = getEntityManager();
        try{
            Query trans = em.createNamedQuery("User.findAll");
            return trans.getResultList();
        }catch(Exception ex){
            ex.getLocalizedMessage();
            return null;
        }
    } 

}
