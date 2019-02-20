/*
 * This class include the sub class of Books from Abstract class Catelogltem
 * The book class allow main menu to create an object of books
 */
package bookstoresystem;

//subclass of Catelogltem

import java.math.BigDecimal;

public class Books extends Catelogltem{
    //set variables
    private String booksAuthor;
    private int booksISBN;
    //constructor
    public Books(String title, double price, String author, int ISBN){
        super(title, price);
        booksAuthor = author;
        booksISBN = ISBN;
        this.price=price*0.9;
        BigDecimal bg = new BigDecimal(this.price);
        this.price = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
    //return author name
    public String getAuthor(){
        return booksAuthor;
    }
    //return the ISBN number
    public int getISBN(){
        return booksISBN;
    }
    //over ride the string 
    @Override
    public String toString(){
        String str = "Title:\t" + title + "\t|" + "Author:\t"+booksAuthor+"\t|"+"Price: $"+price+"\t|"+" ISBN:"+booksISBN;
        return str;
    } 
}
