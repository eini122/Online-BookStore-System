/*
 * This class include the sub class of dvds from Abstract class Catelogltem
 * The dvds class allow main menu to create an object of dvds
 */
package bookstoresystem;
import java.math.BigDecimal;
public class Dvds extends Catelogltem {
    //set variables
    private String director;
    private int year;
    private int dvdCode;
    //constructor
    public Dvds(String title, double price, String director, int year, int dvdCode){
        super(title, price);
        this.price = price*0.8;
        this.director=director;
        this.year=year;
        this.dvdCode=dvdCode;
        BigDecimal bg = new BigDecimal(this.price);
        this.price = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    //return directore name
    public String getDirector(){
        return director;
    }
    //return Year
    public int getYear(){
        return year;
    }
    //return dvd code
    public int getDvdCode(){
        return dvdCode;
    }
    @Override
    public String toString(){
        String str = "Title:\t" + title + "\t|" + "Director:\t"+director+"\t|"
                +"Price:\t$"+price+"\t|"+" Year: "+year + "\t|"+ "DvdCode:" + dvdCode;
        return str;
    }
}
