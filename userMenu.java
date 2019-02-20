 /* This class will display the inventory that store has
 *  and also display the amount after user choose the items that user wants to purchase
 */
package bookstoresystem;
import java.util.*;
public class userMenu {
    userMenu(){}
    Scanner in = new Scanner(System.in);
    public void userMenu(ArrayList<Books> books, ArrayList<Dvds> dvds){
        int get_input=0;
        int bookSize = books.size();
        int dvdSize = dvds.size();
        //set another two variables for shopping carts
	LinkedList<Integer> BooksCart = new LinkedList<>();
	LinkedList<Integer> dvdsCart = new LinkedList<>();
        Collections.sort(books, new SortBooks());
        Collections.sort(dvds, new SortDvds());
        while(get_input != 9){
            try{
                //display the menu for user to choose
                displayMenu();
                //get input
                get_input = in.nextInt();
                switch (get_input) {
                    case 1:
                        displayBooks(books, "Book");//method for display the books menu
                        break;
                    case 2:
                        displayDvds(dvds, "DVD");//method for display the dvds menu
                        break;
                    case 3:
                        getItem(BooksCart, bookSize);//get the input from user and save it into list
                        break;
                    case 4:
                        getItem(dvdsCart, dvdSize);//get the input from user and save it into list
                        break;
                    case 5:
                        deleteItem(BooksCart);//remove item from cart
                        break;
                    case 6:
                        deleteItem(dvdsCart);//remove item from cart
                        break;
                    case 7:
                        displayCarts(BooksCart, dvdsCart, books, dvds);//display cart
                        break;
                    case 8://display and clear cart
                        displayCarts(BooksCart, dvdsCart, books, dvds);
                        BooksCart.clear();
                        dvdsCart.clear();
                        System.out.println("Thanks you for shoppiny");
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Wrong Input, Pleae enter again");
                        break;
                }
            }
            catch(InputMismatchException e){
                System.out.println("This option is not acceptable. please enter again");
                in = new Scanner (System.in);
            }
        }
    }
    //display main menu
    private void displayMenu() {
	System.out.println("**Welcome to the Mustangs Books and DVDs Store**"+"\n\n"+
                "Choose from the following options:"+"\n"+
                "1 - Browse books inventory(price low to high)"+
                "\n"+"2 - Browse DVDs inventory(price low to high"
                +"\n"+"3 - add a book to the cart"+"\n"+"4 - add a DVD to the cart"
                +"\n"+"5 - Delete a book from cart"+"\n"+"6 – Delete a DVD from cart"
                +"\n"+"7 - View cart"+"\n"+"8 - Checkout"+"\n"+"9 - Exit Store");
	System.out.print("Please enter the option:");
    }
    //display books catelog
    private void displayBooks(ArrayList<Books> books, String itemType) {
        int x = 1;
        System.out.println(itemType+" "+"\n-------------------------------------------------------------------------------------------------------------");
        for(Books book: books){
            System.out.println("Item Numer:  " + x +"| "+book.toString());
            x++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
    //display dvd catelog
    private void displayDvds(ArrayList<Dvds> dvds, String itemType) {
        int x = 1;
        System.out.println(itemType+" "+"\n-------------------------------------------------------------------------------------------------------------");
        for(Dvds dvd: dvds){
            System.out.println("Item Numer:  " + x +"| "+ dvd.toString());
            x++;
        }
         System.out.println("-------------------------------------------------------------------------------------------------------------");
    }
    //store item into cart
    private void getItem(LinkedList<Integer> cart, int size) {
	int x;
        while(true){
            try{
                Validator va = new Validator();
                System.out.println("Please enter Item number to add into cart(0 to return): ");
                x =in.nextInt();
                if(!va.isPositiveInput(x)){
                    System.out.println("Please enter positive number.");
                }
                else if(x>size){
                    System.out.println("Do not have this option.");
                }
                else if(x == 0){
                    break;
                }
                else{
                    cart.add(x);
                    System.out.println("Add item successfully");
                }
            }
            catch(InputMismatchException e){
                System.out.println("Input Error");
                in= new Scanner(System.in);
            }
        }   
    }
    //dilete item from cart
    private void deleteItem(LinkedList<Integer> cart){
        int x = -1;
        if(cart.isEmpty()){
            System.out.println("Your Cart is empty");
        }
        else
        {
            while( x!= 0){
                try{
                    System.out.print("Please enter Item number to delete (o to return): ");
                    x = in.nextInt();
                    if(x==0){
                    }
                    else{
                        if(cart.contains(x)){
                            cart.remove((Integer)x); 
                            System.out.println("Remove Item Successfully");
                        }
                        else{
                            System.out.println("Do not have this item in the cart");
                        }
                    }
                    
                }
                catch(InputMismatchException e){
                    System.out.println("Input Error");
                    in= new Scanner(System.in);
                }
            }
        }  
    }
    //display item 
    private void displayCarts(LinkedList<Integer> booksCart, LinkedList<Integer> dvdsCart, ArrayList<Books> books, ArrayList<Dvds> dvds){
        double total = 0;
        System.out.println("------------------------------------------------Shoppint Cart------------------------------------------------");
        if(booksCart.isEmpty() && dvdsCart.isEmpty()){
            System.out.println("\t\tYour Cart is empty");
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
        else if(booksCart.isEmpty() && !dvdsCart.isEmpty()){
            for(int i = 0; i < dvdsCart.size(); i++){
                int x = i+1;
                System.out.println("Item Numer:  " + x +"| "+ dvds.get(i).toString());
                total += dvds.get(i).price;
            }
            total += total * 0.0825;
            System.out.printf("%-25s$%.2f%n","Total+Tax",total);
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
        else if(!booksCart.isEmpty() && dvdsCart.isEmpty()){
            for(int i = 0; i < booksCart.size(); i++){
                int x = i+1;
                System.out.println("Item Numer:  " + x +"| "+ books.get(i).toString());
                total += books.get(i).price;
            }
            total += total * 0.0825;
            System.out.printf("%-25s$%.2f%n","Total+Tax",total);
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
        else{
            for(int i = 0; i < booksCart.size(); i++){
                int x = i+1;
                System.out.println("Item Numer:  " + x +"| "+ books.get(i).toString());
                total += books.get(i).price;
            }
            for(int i = 0; i < dvdsCart.size(); i++){
                int x = i+1;
                System.out.println("Item Numer:  " + x +"| "+ dvds.get(i).toString());
                total += dvds.get(i).price;
            }
            total += total * 0.0825;
            System.out.printf("%-25s$%.2f%n","Total+Tax",total);
            System.out.println("-------------------------------------------------------------------------------------------------------------");
        }
    }
}
//sort function
class SortBooks implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        Books b1 = (Books) o1;
        Books b2 = (Books) o2;
        if(b1.price>b2.price){
            return 1;
        }
        else return -1;
    }
}
class SortDvds implements Comparator{
    @Override
    public int compare(Object o1, Object o2){
        Dvds d1 = (Dvds) o1;
        Dvds d2 = (Dvds) o2;
        if(d1.price>d2.price){
            return 1;
        }
        else return -1;
    }
}