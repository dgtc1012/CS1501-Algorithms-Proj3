/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dgtc1_000
 */
public class Car{
    private String vin;
    private String make;
    private String model;
    private double price;
    private double mileage;
    private String color;
    
    public Car(){
        vin = null;
        make = null;
        model = null;
        price = 0;
        mileage = 0;
        color = null;
    }
    public Car(String myVin, String myMake, String myModel, double myPrice, double myMileage, String myColor){
        vin = myVin;
        make = myMake;
        model = myModel;
        price = myPrice;
        mileage = myMileage;
        color = myColor;
    }
    
    //Set methods
    public void setVIN(String myVIN){
        vin = myVIN;
    }
    public void setMake(String myMake){
        make = myMake;
    }
    public void setModel(String myModel){
        model = myModel;
    }
    public void setPrice(double myPrice){
        price = myPrice;
    }
    public void setMileage(double myMileage){
        mileage = myMileage;
    }
    public void setColor(String myColor){
        color = myColor;
    }
    
    //Get methods
    public String getVIN(){
        return vin;
    }
    public String getMake(){
        return make;
    }
    public String getModel(){
        return model;
    }
    public double getPrice(){
        return price;
    }
    public double getMileage(){
        return mileage;
    }
    public String getColor(){
        return color;
    }
    
    public boolean isEqual(Car c){
        if(!vin.equals(c.vin) || !make.equals(c.make) || !model.equals(c.model) || mileage != c.mileage || !color.equals(c.color) || price != c.price){
            return false;
        }
        return true;
    }
    
    /*Compare methods
    public int compareTo(Car c){
        if(heapType == 1){
            if(price == c.getPrice()){
                return 0;
            }
            else if(price < c.getPrice()){
                return -1;
            }
            return 1;
        }
        else if(heapType == 2){
            if(mileage == c.getMileage()){
                return 0;
            }
            else if(mileage <= c.getMileage()){
                return -1;
            }
            return 1;
        }
        else{
            return -1;
        }
    }
    */
    
    
    public int compareToByPrice(Car c){
        if(price == c.getPrice()){
            return 0;
        }
        else if(price < c.getPrice()){
            return -1;
        }
        return 1;
    }
    
    public int compareToByMileage(Car c){
        if(mileage == c.getMileage()){
            return 0;
        }
        else if(mileage <= c.getMileage()){
            return -1;
        }
        return 1;
    }
}
