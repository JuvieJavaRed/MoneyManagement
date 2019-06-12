/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sterling.web.designs.moneymanagement.controller;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sterling.web.designs.moneymanagement.dao.InflowDao;
import sterling.web.designs.moneymanagement.entities.Inflow;

/**
 *
 * @author Rodney
 */

@Controller
public class InflowController {
    
    //retrieve all transactions
    @RequestMapping(value = "/alltrans", method = RequestMethod.GET)
    public ModelAndView retrieve_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        InflowDao od = new InflowDao();
        List inflowtrans = od.retrieve_transctions();
        model.addObject("outflowtrans", inflowtrans);
        model.setViewName("employee_transactions");
        return model;
    } 
    
     //retrieve all transactions
    @RequestMapping(value = "/alladmintrans", method = RequestMethod.GET)
    public ModelAndView admin_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        InflowDao od = new InflowDao();
        List inflowtrans = od.retrieve_transctions();
        model.addObject("inflowtrans", inflowtrans);
        model.setViewName("admin_employee_transac");
        return model;
    } 
    
    
    //enter a transaction
    @RequestMapping(value = "/entertrans", method = RequestMethod.GET)
    public ModelAndView send_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        Random rand = new Random();
        Date date1 = null;
        Inflow rdr = new Inflow();
        InflowDao rdc = new InflowDao();
        String type = request.getParameter("type");
        String currency = request.getParameter("currency");
        int amount = parseInt(request.getParameter("amount"));
        String date = request.getParameter("date");
        String sDate1=date;  
        try {
           date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
        } catch (ParseException ex) {
            Logger.getLogger(InflowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String inflowid = request.getParameter("inflowid");
        String enteredby = username;
        String status = "UNCONFIRMED";
        int transid = rand.nextInt(50);
        String str1 = Integer.toString(transid);
        rdr.setAmount(amount);
        rdr.setCurrency(currency);
        rdr.setEnteredby(enteredby);
        rdr.setDate(date1);
        rdr.setTransid(str1);
        rdr.setInflowid(inflowid);
        rdr.setType(type);
        rdr.setStatus(status);
        rdc.create(rdr);
        List<Inflow> transactions = rdc.unconfirmedin_transctions(username);
        model.addObject("transactions", transactions);
        model.setViewName("employee_transactions");
        return model;
    }

    //edit a transaction
    @RequestMapping(value = "/edittrans", method = RequestMethod.GET)
    public ModelAndView edit_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        return model;
    }
    
         //enter a transaction
    @RequestMapping(value = "/admininflow", method = RequestMethod.GET)
    public ModelAndView send_inflow(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        InflowDao od = new InflowDao();
        List outflowtrans = od.unconfirmed_transctions();
        model.addObject("outflowtrans", outflowtrans);
        model.setViewName("admin_inflow_trans");
        return model;
    }
//    
    //report filter method
    @RequestMapping(value = "/adminreports", method = RequestMethod.GET)
    public ModelAndView filter_alltrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        InflowDao inf = new InflowDao();
        List reportsin = inf.retrieve_transctions();
        model.addObject("reportsin", reportsin);
        model.setViewName("reports_generator_page");
        return model;
    }
    
    //create inflow
    @RequestMapping(value = "/showentry")
    public ModelAndView open_formtrans(ModelAndView model, HttpServletRequest request) throws IOException{
        HttpSession s = request.getSession();
        HttpSession session = request.getSession();
        String username = (String) s.getAttribute("username");
        session.setAttribute("username", username);
        model.setViewName("enter_payment");
        return model;
    }
}
