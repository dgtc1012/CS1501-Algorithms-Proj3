/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dgtc1_000
 */
import java.util.HashMap;

public class CarHeap {
    private int type;
    private Car[] c;
    private HashMap<String, Integer> vin_in;
    private int size;
    private int maxSize;
    
    public CarHeap(int myType){
        type = myType;
        maxSize = 100;
        c = new Car[maxSize];
        vin_in = new HashMap();
        size = 0;       
    }
    public CarHeap(int mySize, int myType){
        type = myType;
        maxSize = mySize;
        c = new Car[maxSize];
        vin_in = new HashMap();
        size = 0;       
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
    /**
     * Type 1 refers to sorting by price
     * Type 2 refers to sorting by mileage
     **/
    public void insert(Car newC){
        if(!vin_in.containsKey(newC.getVIN())){
            c[size] = newC;
            vin_in.put(newC.getVIN(), size);
            swim(size);
            size++;
        }
    }
    
    private void swim(int k){
        while(k > 0 && greater(k/2, k)){
            exch(k, k/2);
            k = k/2;
        }
    }
    
    private void sink(int k){
        int j = 2*k;
        while(j < size){
            if (j < (size-1) && greater(j, j+1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    
    private boolean greater(int i, int j){
        int compare;
        if(type == 1){
            compare = c[i].compareToByPrice(c[j]);
        }
        else{
            compare = c[i].compareToByMileage(c[j]);
        }
        if(compare == 1){
            return true;
        }
        else{
            return false;
        }
    }
    
    private void exch(int i, int j){
        vin_in.put(c[i].getVIN(), j);
        vin_in.put(c[j].getVIN(), i);
        Car swap = c[i];
        c[i] = c[j];
        c[j] = swap;
    }
    
    public int getIndex(String myVIN){
        if(vin_in.containsKey(myVIN)){
            int index = vin_in.get(myVIN);
            return index;
        }
        else{
            return -1;
        }
    }
    
    public Car getMinCar(){
        if(size == 0){
            return null;
        }
        else{
            return c[0];
        }
    }
    
    public int deleteCar(String myVIN){
        int i = this.getIndex(myVIN);
        if(i != -1){
            exch(i, size-1);
            size--;
            swim(i);
            sink(i);
            c[vin_in.get(myVIN)] = null;
            vin_in.remove(myVIN);
            return 1;
        }
        else{
            System.out.println("Could not find a car with VIN # "+myVIN);
            return -1;
        }
    }
    
    public int updateColor(String myVIN, String myColor){
        int i = vin_in.get(myVIN);
        if(i == -1){
            System.out.println("Could not find a car with VIN # "+myVIN);
        }
        else{
            c[i].setColor(myColor);
        }
        return i;
    }
    
    public int updatePrice(String myVIN, double myPrice){
        int i = vin_in.get(myVIN);
        if(i == -1){
            System.out.println("Could not find a car with VIN # "+myVIN);
            return -1;
        }
        else{
            c[i].setPrice(myPrice);
            swim(i);
            sink(i);
            return vin_in.get(myVIN);
        }
        
    }
    
    public int updateMileage(String myVIN, double myMileage){
        int i = vin_in.get(myVIN);
        if(i == -1){
            System.out.println("Could not find a car with VIN # "+myVIN);
            return -1;
        }
        else{
            c[i].setMileage(myMileage);
            swim(i);
            i = vin_in.get(myVIN);
            sink(i);
            return vin_in.get(myVIN);
        }
    }
    
    public Car minByMakeModel(String myMake, String myModel){
        Car lowest = null;
        for(int i = 0; i < size; i++){
            if(c[i].getMake().equalsIgnoreCase(myMake) && c[i].getModel().equalsIgnoreCase(myModel)){
                if(lowest == null){
                    lowest = c[i];
                }
                else{
                    if(type == 1){
                        if(c[i].getPrice() < lowest.getPrice()){
                            lowest = c[i];
                        }
                    }
                    else{
                        if(c[i].getMileage() < lowest.getMileage()){
                            lowest = c[i];
                        }
                    }
                }
            }
        }
        return lowest;
    }
}
