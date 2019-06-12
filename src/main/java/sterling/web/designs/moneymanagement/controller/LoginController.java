/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sterling.web.designs.moneymanagement.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import sterling.web.designs.moneymanagement.dao.InflowDao;
import sterling.web.designs.moneymanagement.dao.UserDao;
import sterling.web.designs.moneymanagement.entities.Inflow;
import sterling.web.designs.moneymanagement.entities.User;

/**
 *
 * @author Rodney
 */

@Controller
public class LoginController {
    
     @RequestMapping(value = "/")
     public ModelAndView IndexIt(ModelAndView model) throws IOException {
       
       model.setViewName("login");
       return model;
    }
     
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public ModelAndView auth_user(HttpServletRequest request, ModelAndView model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        UserDao usd = new UserDao();
        User uy = usd.login(username);
        String position = uy.getRole();
        if(position.equals("Admin")){
                if(uy.getPassword().equals(password)){
                    session.setAttribute("username", username);
                    UserDao ui = new UserDao();
                    List<User> users = ui.retrieve_user();
                    model.addObject("users", users);
                    model.setViewName("admin_dash");
                    return model;
                }else{
                   // model.addObject("transactions", transactions);
                    model.setViewName("error_login");
                    return model;
                }
        }else if(position.equals("Employee")){      
           
                 if(uy.getPassword().equals(password)){
                    session.setAttribute("username", username);
                    InflowDao sd = new InflowDao();
                    List<Inflow> transactions = sd.retrieve_transctions();
                    model.addObject("transactions", transactions);
                    model.setViewName("employee_transactions");
                    return model;
                }else{
                    model.setViewName("error_login");
                    return model;
                }
        }else if(position.equals("Manager")){
           
                 if(uy.getPassword().equals(password)){
                    session.setAttribute("username", username);
                    InflowDao sd = new InflowDao();
                    List<Inflow> transactions = sd.retrieve_transctions();
                    model.addObject("transactions", transactions);
                    model.setViewName("management_transactions");
                    return model;
                   
                }else{
                    model.setViewName("error_login");
                    return model;
                }
        }    
         return null;
        }
        
    
}
