/*
 * The AudioBooks is inheritance of Books
 * The Audio book class allow main menu to create an object of audio books
 */
package bookstoresystem;
import java.math.BigDecimal;
public class AudioBooks extends Books{
    //set variable
    private double runningTime;
    //constructor 
    public AudioBooks(String title, double price, String author, int ISBN, double runningTime){
        super(title, price, author, ISBN);
        this.runningTime = runningTime;
        this.price=price*0.5;
        BigDecimal bg = new BigDecimal(this.price);
        this.price = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }  
    //return running time
    public double getRuningTime(){
        return runningTime;
    }
    //return price with 10% discount
    public double getPrice(){
        return super.price;
    }
    public String toString(){
        String str = super.toString()+"\t|"+ "Running Time:"+runningTime;
        return str;
    } 
}
