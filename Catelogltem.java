/*
 * This class will help main program pass information and store it 
 * into correct position
 * Kaitian Li
 * 11/28/2018
 */
package bookstoresystem;
//Create the class for main catelogltem
public abstract class Catelogltem {
    protected String title;
    protected double price;
    //constructor 
    public Catelogltem(String title, double price){
        this.title = title;
        this.price = price;    
    }
    //return the tile
    public String getTitle(){
        return title;
    }
    //return the price
    public double getPrice(){
        return price;
    }  
}
