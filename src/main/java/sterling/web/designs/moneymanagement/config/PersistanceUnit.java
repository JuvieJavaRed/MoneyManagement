/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sterling.web.designs.moneymanagement.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Rodney 
 */
public class PersistanceUnit {
     private static PersistanceUnit pu;
    public static PersistanceUnit getInstance(){
        if(pu==null){
            return new PersistanceUnit();
        }
        return pu;
    }
    
    public EntityManagerFactory enFactory = Persistence.createEntityManagerFactory("sterling.web.designs_MoneyManagement_war_1.0PU");
}
