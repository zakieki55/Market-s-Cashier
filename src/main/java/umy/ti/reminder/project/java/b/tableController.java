/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package umy.ti.reminder.project.java.b;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import Service.Serviceprocess;

/**
 *
 * @author muhammad dzaki
 */
@Controller
public class tableController {
    
    @RequestMapping("/inputData")
    public String getData(HttpServletRequest data, Model vegetables){
        
          Serviceprocess Serv = new Serviceprocess();
          String inpName = Serv.vegNama(data);
          String inpPrice = Serv.vegPrice(data);
          String inpQty = Serv.vegQty(data);
          String inpMoney = Serv.vegMoney(data);
          
          Double Price = Serv.vegprice(inpPrice);
          Double Qty = Serv.vegqty(inpQty);
          Double Money = Serv.custMoney(inpMoney);
          Double priceperQty = Serv.priceperQty(Price, Qty);
          Double totPrice = Serv.totprice(priceperQty);
          String Discount = Serv.vegDisc(priceperQty);
          Double Kembalian = Serv.change(Money, totPrice);

          
        vegetables.addAttribute("veg_Name", inpName);
        vegetables.addAttribute("veg_Price", inpPrice);
        vegetables.addAttribute("veg_Qty", inpQty);
        vegetables.addAttribute("veg_Pqty", priceperQty);
        vegetables.addAttribute("veg_TotPrice", totPrice);
        vegetables.addAttribute("veg_Disc", Discount);
        vegetables.addAttribute("veg_Money", inpMoney);
        vegetables.addAttribute("veg_Change", Kembalian);
        
        return "viewtableData";
    }
}













































//        String inputName = data.getParameter("vegName");
//        String inputPrice = data.getParameter("vegPrice");
//        String inputQty = data.getParameter("vegQty");
//        String inputMoney = data.getParameter("vegMoney");
//        String Disc = "";
//        
//        
//        Double Price = Double.valueOf(inputPrice);
//        Double Qty = Double.valueOf(inputQty);
//        Double Money = Double.valueOf(inputMoney);
//        
//        Double pricePerQty = Price * Qty;
//        Double totPrice = null;
//        
//        if(pricePerQty < 16000){
//            totPrice = pricePerQty - (pricePerQty * 0/100);
//            
//            Disc = "0%";
//        }
//        else if(pricePerQty >= 16000 && pricePerQty < 25000){
//            totPrice = pricePerQty - (pricePerQty * 10/100);
//            
//            Disc = "10%";
//        }
//        else if(pricePerQty >= 25000){
//            totPrice = pricePerQty - (pricePerQty * 15/100);
//            
//            Disc = "15%";
//        }
//        
//        Double Change = Money - totPrice;
//        