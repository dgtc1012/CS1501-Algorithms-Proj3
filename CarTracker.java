/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dgtc1_000
 */
import java.util.Scanner;

public class CarTracker {
    public static void main(String[] args) {
        System.out.println("Welcome to the car sorting program." +
          "\nThis program will allow you to add cars to a queue and then find the cars"+
            "with either the lowest mileage or the lowest price.\nLets get started.\n");
        
        Scanner s = new Scanner(System.in); 
        boolean done = false;
        char option; 
        int updateOption;
        String make;
        String model;
        String vin;
        boolean valid = true;
        String color;
        double price;
        double mileage;
        int numCars = 0;
        CarHeap cbp = new CarHeap(100, 1);
        CarHeap cbm = new CarHeap(100, 2);
        /*
        //for testing
        Car temp1 = new Car("123456", "Honda", "Civic", 17000, 8000, "red");
        Car temp2 = new Car("123456", "Honda", "Civic", 17000, 8000, "red");
        cbp.insert(temp1);
        cbm.insert(temp2);
        
        temp1 = new Car("234567", "Hyundai", "Elantra", 15000, 10000, "black");
        temp2 = new Car("234567", "Hyundai", "Elantra", 15000, 10000, "black");
        cbp.insert(temp1);
        cbm.insert(temp2);
        
        temp1 = new Car("345678", "Hyundai", "Genesis", 27000, 1000, "black");
        temp2 = new Car("345678", "Hyundai", "Genesis", 27000, 1000, "black");
        cbp.insert(temp1);
        cbm.insert(temp2);
        */
        Car min;
        
        while(!done){
            System.out.println("\n\nChoose an option: ");
                System.out.println("\t1) Add a car");
                System.out.println("\t2) Delete a car");
                System.out.println("\t3) Update a car by VIN");
                System.out.println("\t4) View lowest price car");
                System.out.println("\t5) View lowest mileage car");
                System.out.println("\t6) View lowest price car by make and model");
                System.out.println("\t7) View lowest mileage car by make and model");
                System.out.println("\t8) Quit");
                System.out.print("\nSelection:\t");
            
            option = s.next().charAt(0);
            
            if(option == '1'){
                System.out.print("\nWhat is the MAKE of the car you want to add?\t");
                make = s.next();
                System.out.print("\nWhat is the MODEL of the car you want to add?\t");
                model = s.next();
                System.out.print("\nWhat is the VIN number of the car you want to add?\t");
                vin = s.next();
                if(vin.length() != 17){
                    valid = false;
                }
                else{
                    for(int i = 0; i < vin.length(); i++){
                        if(!((vin.charAt(i) >= '0' && vin.charAt(i) <= '9') || (vin.charAt(i) >= 'A' && vin.charAt(i) <= 'Z'))){
                            valid = false;
                        }
                        else if(vin.charAt(i) == 'Q' || vin.charAt(i) == 'O' || vin.charAt(i) == 'I'){
                            valid = false;
                        }
                    }
                }
                while(!valid){
                    System.out.print("The VIN number you entered is not valid. The requirements for this identifier are as follows:"+
                            "\n\t- Must be 17 characters long (can be letters and numbers)"+
                            "\n\t- All characters must be uppercase"+
                            "\n\t- Cannot contain the letters \'Q\', \'O\', or \'I\'"+
                            "Please try again with a new VIN:\t");
                    vin = s.next();
                    
                    if(vin.length() != 17){
                        valid = false;
                    }
                    else{
                        for(int i = 0; i < vin.length(); i++){
                            if(!((vin.charAt(i) >= '0' && vin.charAt(i) <= '9') || (vin.charAt(i) >= 'A' && vin.charAt(i) <= 'Z'))){
                                valid = false;
                            }
                            else if(vin.charAt(i) == 'Q' || vin.charAt(i) == 'O' || vin.charAt(i) == 'I'){
                                valid = false;
                            }
                        }
                    }
                }
                
                System.out.print("\nWhat is the COLOR of the car you want to add?\t");
                color = s.next();
                System.out.print("\nWhat is the PRICE of the car you want to add?\t");
                price = s.nextDouble();
                System.out.print("\nWhat is the MILEAGE on the car you want to add?\t");
                mileage = s.nextDouble();
                
                Car newC_P = new Car(vin, make, model, price, mileage, color);
                Car newC_M = new Car(vin, make, model, price, mileage, color);
                
                cbp.insert(newC_P);
                cbm.insert(newC_M);
                
                numCars++;
                done = false;
            }
            else if(option == '2'){
                System.out.print("\nWhat is the VIN number of the car you want to remove?\t");
                vin = s.next();
                if(vin.length() != 17){
                    valid = false;
                }
                else{
                    for(int i = 0; i < vin.length(); i++){
                        if(!((vin.charAt(i) >= '0' && vin.charAt(i) <= '9') || (vin.charAt(i) >= 'A' && vin.charAt(i) <= 'Z'))){
                            valid = false;
                        }
                        else if(vin.charAt(i) == 'Q' || vin.charAt(i) == 'O' || vin.charAt(i) == 'I'){
                            valid = false;
                        }
                    }
                }
                while(!valid){
                    System.out.print("The VIN number you entered is not valid. The requirements for this identifier are as follows:"+
                            "\n\t- Must be 17 characters long (can be letters and numbers)"+
                            "\n\t- All characters must be uppercase"+
                            "\n\t- Cannot contain the letters \'Q\', \'O\', or \'I\'"+
                            "Please try again with a new VIN:\t");
                    vin = s.next();
                    
                    if(vin.length() != 17){
                        valid = false;
                    }
                    else{
                        for(int i = 0; i < vin.length(); i++){
                            if(!((vin.charAt(i) >= '0' && vin.charAt(i) <= '9') || (vin.charAt(i) >= 'A' && vin.charAt(i) <= 'Z'))){
                                valid = false;
                            }
                            else if(vin.charAt(i) == 'Q' || vin.charAt(i) == 'O' || vin.charAt(i) == 'I'){
                                valid = false;
                            }
                        }
                    }
                }
                cbp.deleteCar(vin);
                cbm.deleteCar(vin);
                
                done = false;
            }
            else if(option == '3'){
                System.out.print("\nWhat is the VIN number of the car you want to update?\t");
                vin = s.next();
                if(vin.length() != 17){
                    valid = false;
                }
                else{
                    for(int i = 0; i < vin.length(); i++){
                        if(!((vin.charAt(i) >= '0' && vin.charAt(i) <= '9') || (vin.charAt(i) >= 'A' && vin.charAt(i) <= 'Z'))){
                            valid = false;
                        }
                        else if(vin.charAt(i) == 'Q' || vin.charAt(i) == 'O' || vin.charAt(i) == 'I'){
                            valid = false;
                        }
                    }
                }
                while(!valid){
                    System.out.print("The VIN number you entered is not valid. The requirements for this identifier are as follows:"+
                            "\n\t- Must be 17 characters long (can be letters and numbers)"+
                            "\n\t- All characters must be uppercase"+
                            "\n\t- Cannot contain the letters \'Q\', \'O\', or \'I\'"+
                            "Please try again with a new VIN:\t");
                    vin = s.next();
                    
                    if(vin.length() != 17){
                        valid = false;
                    }
                    else{
                        for(int i = 0; i < vin.length(); i++){
                            if(!((vin.charAt(i) >= '0' && vin.charAt(i) <= '9') || (vin.charAt(i) >= 'A' && vin.charAt(i) <= 'Z'))){
                                valid = false;
                            }
                            else if(vin.charAt(i) == 'Q' || vin.charAt(i) == 'O' || vin.charAt(i) == 'I'){
                                valid = false;
                            }
                        }
                    }
                }
                
                if(cbp.getIndex(vin) == -1){
                    System.out.println("\nNo car was found with the given VIN number.");
                }
                else{
                    System.out.println("\nChoose the field you would like to update:"+
                            "\n\t1) Price"+
                            "\n\t2) Mileage"+
                            "\n\t3) Color");
                    updateOption = s.nextInt();
                    
                    
                    if(updateOption == 1){
                        System.out.print("Enter the new price:\t");
                        double newP = s.nextDouble();
                        cbp.updatePrice(vin, newP);
                        cbm.updatePrice(vin, newP);
                    }
                    else if(updateOption == 2){
                        System.out.print("Enter the new mileage:\t");
                        double newM = s.nextDouble();
                        cbp.updateMileage(vin, newM);
                        cbm.updateMileage(vin, newM);
                    }
                    else if(updateOption == 3){
                        System.out.print("Enter the new color:\t");
                        String newC = s.next();
                        cbp.updateColor(vin, newC);
                        cbm.updateColor(vin, newC);
                    }
                }
                
                done = false;
            }
            else if(option == '4'){
                min = cbp.getMinCar();
                if(min != null){
                    System.out.println("\nThe car with the lowest price is:"+
                            "\n\tMake:\t"+min.getMake()+
                            "\n\tModel:\t"+min.getModel()+
                            "\n\tVIN:\t"+ min.getVIN()+
                            "\n\tPrice:\t"+ min.getPrice()+
                            "\n\tMilage:\t"+ min.getMileage()+
                            "\n\tColor:\t"+ min.getColor());
                }
                else{
                    System.out.println("There are no cars in the heap yet.");
                }
                done = false;
            }
            else if(option == '5'){
                min = cbm.getMinCar();
                if(min != null){
                    System.out.println("\nThe car with the lowest mileage is:"+
                            "\n\tMake:\t"+min.getMake()+
                            "\n\tModel:\t"+min.getModel()+
                            "\n\tVIN:\t"+ min.getVIN()+
                            "\n\tPrice:\t"+ min.getPrice()+
                            "\n\tMilage:\t"+ min.getMileage()+
                            "\n\tColor:\t"+ min.getColor());
                }
                else{
                    System.out.println("There are no cars in the heap yet.");
                }
                done = false;
            }
            else if(option == '6'){
                System.out.print("\nWhat is the make of the type of car?\t");
                make = s.next();
                System.out.print("What is the model of the type of car?\t");
                model = s.next();
                
                min = cbp.minByMakeModel(make, model);
                if(min == null){
                    System.out.println("\nNo car of the specified make and model were found.");
                }
                else{
                    System.out.println("\nThe lowest price "+make+" "+model+" costs $"+min.getPrice()+" and has "+min.getMileage()+" miles on it.");
                }
                done = false;
            }
            else if(option == '7'){
                System.out.print("\nWhat is the make of the type of car?\t");
                make = s.next();
                System.out.print("What is the model of the type of car?\t");
                model = s.next();
                
                min = cbm.minByMakeModel(make, model);
                if(min == null){
                    System.out.println("\nNo car of the specified make and model were found.");
                }
                else{
                    System.out.println("\nThe lowest mileage "+make+" "+model+" costs $"+min.getPrice()+" and has "+min.getMileage()+" miles on it.");
                }
                done = false;
            }
            else if(option == '8'){
                done = true;
            }
            else{
                System.out.println("\nThat was an invalid entry, try again");
                done = false;
            }
        }
    
    }
}
