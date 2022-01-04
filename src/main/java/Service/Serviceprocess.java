/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author muhammad dzaki
 */
public class Serviceprocess {
    public String vegNama(HttpServletRequest data){
        String inputName = data.getParameter("vegName");
        return inputName;
    }
    public String vegPrice(HttpServletRequest data){
        String inputPrice = data.getParameter("vegPrice");
        return inputPrice;
    }
    public String vegQty(HttpServletRequest data){
        String inputQty = data.getParameter("vegQty");
        return inputQty;
    }
    public String vegMoney(HttpServletRequest data){
        String inputMoney = data.getParameter("vegMoney");
        return inputMoney;
    }
    public Double vegprice(String inputPrice){
        Double Price = Double.valueOf(inputPrice);
        return Price;
    }
    public Double vegqty(String inputQty){
        Double Qty = Double.valueOf(inputQty);
        return Qty;
    }
    public Double custMoney(String inputMoney){
        Double Money = Double.valueOf(inputMoney);
        return Money;
    }
    public Double priceperQty(Double Price, Double Qty){
        Double pricePerQty = Price * Qty;
        return pricePerQty;
    }
    public Double totprice(Double pricePerQty){
        Double totPrice = null;
        if(pricePerQty < 16000){
            totPrice = pricePerQty - (pricePerQty * 0/100);
            
        }
        else if(pricePerQty >= 16000 && pricePerQty < 25000){
            totPrice = pricePerQty - (pricePerQty * 10/100);
            
        }
        else if(pricePerQty >= 25000){
            totPrice = pricePerQty - (pricePerQty * 15/100);
            
        }
        return totPrice;
    }
    public String vegDisc(Double pricePerQty){
        String Disc = "";
        if(pricePerQty < 16000){
            Disc = "0%";
            
        }
        else if(pricePerQty >= 16000 && pricePerQty < 25000){
            Disc = "10%";
            
        }
        else if(pricePerQty >= 25000){
            Disc = "15%";
            
        }
        return Disc;
    }
    public Double change(Double Money, Double totPrice){
        Double Change = Money - totPrice;
        return Change;
    
    
    }
}