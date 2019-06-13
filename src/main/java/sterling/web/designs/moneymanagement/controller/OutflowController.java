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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sterling.web.designs.moneymanagement.dao.OutflowDao;
import sterling.web.designs.moneymanagement.entities.Outflow;

/**
 *
 * @author Rodney
 */

@Controller
public class OutflowController {
    
     //retrieve all transactions
    @RequestMapping(value = "/allouttrans", method = RequestMethod.GET)
    public ModelAndView retrieve_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        OutflowDao od = new OutflowDao();
        List outflowtrans = od.retrieve_transctions();
        model.addObject("outflowtrans", outflowtrans);
        model.setViewName("employee_transactions");
        return model;
    } 
    
     //retrieve all transactions
    @RequestMapping(value = "/outbyperson", method = RequestMethod.GET)
    public ModelAndView byperson(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        OutflowDao od = new OutflowDao();
        List outflowtrans = od.retrieve_perperson(username);
        model.addObject("outflowtrans", outflowtrans);
        model.setViewName("employee_outflow");
        return model;
    } 
    
        //enter a transaction
    @RequestMapping(value = "/adminoutflow", method = RequestMethod.GET)
    public ModelAndView send_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        OutflowDao od = new OutflowDao();
        List outflowtrans = od.retrieve_transctions();
        model.addObject("outflowtrans", outflowtrans);
        model.setViewName("admin_outflow_trans");
        return model;
    }

    
    //enter a transaction
    @RequestMapping(value = "/adminconfirmedtrans", method = RequestMethod.GET)
    public ModelAndView send_outflowcon(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        OutflowDao tud = new OutflowDao();
        List<Outflow> contrans = tud.confirmed_outflow();
        model.addObject("contrans", contrans);
        model.setViewName("admin_outflow_confirm");
        return model;
    }
//
//    //edit a transaction
//    @RequestMapping(value = "/editouttrans", method = RequestMethod.GET)
//    public ModelAndView edit_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
//        HttpSession s = request.getSession();
//        HttpSession session = request.getSession();
//        String username = (String) s.getAttribute("username");
//        session.setAttribute("username", username);
//        return model;
//    }
//    
//    //report filter method
//    @RequestMapping(value = "/filterouttrans", method = RequestMethod.GET)
//    public ModelAndView filter_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
//        HttpSession s = request.getSession();
//        HttpSession session = request.getSession();
//        String username = (String) s.getAttribute("username");
//        session.setAttribute("username", username);
//        return model;
//    }
//    
    //create outflow
    @RequestMapping(value = "/showrequestform", method = RequestMethod.GET)
    public ModelAndView open_formtrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        model.setViewName("enter_outflow");
        return model;
    }
//    
}
