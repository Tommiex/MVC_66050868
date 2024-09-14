package Controller;

import java.awt.Window;
import java.util.ArrayList;

import Model.Cow;
import Model.CowStock;

public class Manage {
    CowStock cowStock;
    int idInput;
    Cow currentCow = null;
    Window window;
    public Manage(CowStock cowStock) {
        this.cowStock = cowStock;

    }

    public Cow showCowbyID() {
        for (Cow c : cowStock.getStock()) {
            if(c.getId() == idInput){
                currentCow = c;
                return c;
            }
        }
        return null;
    }
    public String getMilkfromCow(){
        if(currentCow == null){
            return "Click Get Cow or GO FIND COW";
        }
        if(currentCow.getColor() == "Blue"){
            return "BSOD";
        }
        
        currentCow.numberOfMilk +=1;
        return this.currentCow.getMilk();
    }
    public void reset(){
        for (Cow  c : cowStock.getStock()) {
            c.numberOfMilk = 0;
            if(c.realColor == "white"){
                c.setColor("white");
            }else{
                c.setColor("brown");
            }
        }
    }
    
    public ArrayList<Cow> getStock(){
        return cowStock.getStock();
    }
    public CowStock getCowStock() {
        return cowStock;
    }

    public void setCowStock(CowStock cowStock) {
        this.cowStock = cowStock;
    }

    public int getIdInput() {
        return idInput;
    }

    public void setIdInput(int idInput) {
        this.idInput = idInput;
    }   
    public Cow getCurrentCow(){
        return currentCow;
    }

}
