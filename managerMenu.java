/*
 * This class will include the manager menu and its methods
 */
package bookstoresystem;
import java.util.*;
import java.io.*;
import java.text.*;
public class managerMenu {
    Scanner in = new Scanner(System.in);
    managerMenu(){}
    public void managerMenu(ArrayList<Books> booksArray, ArrayList<Dvds> dvdsArray){
        int option = 0;//set variable for the selction
        //while loop until user enter 9
        while(option != 9){
            //check the input is match the data type
            try{
                printMenu();
                option = in.nextInt();
                switch (option){
                case 1:
                    addBooks(booksArray);
                    break;
                case 2:
                    addAudioBook(booksArray);
                    break;
                case 3:
                    addDvd(dvdsArray);
                    break;
                case 4:
                    removeBook(booksArray);
                    break;
                case 5:
                    removeDvd(dvdsArray);
                    break;
                case 6:
                    displayCart(booksArray, dvdsArray);
                    break;
                case 7:
                    backFile(booksArray, dvdsArray);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("This option is not acceptable");
                }
            }
            catch(InputMismatchException e){
                System.out.println("This option is not acceptable");
                in = new Scanner (System.in);
            }
        }
    }
    //mothod for print out the selction menu
    private void printMenu(){
        System.out.println("****Welcome to the Comets Books and DVDs Store (Catalog Selction)****"
        +"\nChoose from the following options:"+"\n1 - Add Book"+"\n2 - Add AudioBook"
        +"\n3 - Add DVD"+"\n4 - Remove Book"+"\n5 - Remove DVD"+"\n6 - Display Catalog"
        +"\n7 – Create backup file"+"\n9 - Exit Catalog section"+"\nEnter your option:");
    }
    //method for add Book
    private void addBooks(ArrayList<Books> booksArray){
        //set variable
        String title = null;
        double price = 0;
        String author = null;
        int ISBN = 0;
        boolean found = false;
        //get input and check it is correct
        while(true){
            try{
                System.out.println("Enter the ISBN number: ");
                ISBN = in.nextInt();
                ////check the audio book is not in the list
                if(booksArray.size() != 0){
                    for(int i = 0; i<booksArray.size(); i++){
                        if(booksArray.get(i).getISBN() == ISBN){
                            System.out.println("Error, it already had the Book");
                            found = true;
                            break;
                        }
                    }
                    if(found == true){
                        break;
                    }
                }
                //get input
                System.out.println("Enter book title: ");
                in.nextLine();
                title = in.nextLine();
                title = checkString(title);
                System.out.println("Enter book price: ");
                price = in.nextDouble();
                price = checkDouble(price);
                System.out.println("Enether the name of author: ");
                in.nextLine();
                author = in.nextLine();
                author = checkString(author);
                 //create object
                Books book = new Books(title, price, author, ISBN);
                booksArray.add(book);
                System.out.println("Add Book Successfully");
                break;
            }
            catch(InputMismatchException e){
                System.out.println("This option is not acceptable, Pleae enter again.");
                in = new Scanner (System.in);
            }
        }
    }
    private void addAudioBook(ArrayList<Books> booksArray){
        //set variable
        String title = null;
        double price = 0;
        String author = null;
        int ISBN = 0;
        double runningTime = 0;
        boolean found = false;
        //chech the input is correct
        while(true){
            try{
                System.out.println("Enter the ISBN number: ");
                ISBN = in.nextInt();
                ////check the audio book is not in the list
                if(booksArray.size() != 0){
                    for(int i = 0; i<booksArray.size(); i++){
                        if(booksArray.get(i).getISBN() == ISBN){
                            System.out.println("Error, it already had the ISBN number");
                            found = true;
                            break;
                        }
                    }
                    if(found == true){
                        break;
                    }
                }
                //get input
                System.out.println("Enter Audio Book title: ");
                in.nextLine();
                title = in.nextLine();
                title = checkString(title);
                System.out.println("Enter Audio Book price: ");
                price = in.nextDouble();
                price = checkDouble(price);
                System.out.println("Enether the name of author: ");
                in.nextLine();
                author = in.nextLine();
                author = checkString(author);
                System.out.println("Enter the running time: ");
                runningTime = in.nextDouble();
                runningTime = checkDouble(runningTime);
                AudioBooks audioBook = new AudioBooks(title, price, author, ISBN, runningTime);
                booksArray.add(audioBook);
                System.out.println("Add Audio Book Successfully");  
                break;
            }
            catch (InputMismatchException e){
                System.out.println("This option is not acceptable, Pleae enter again.");
                in = new Scanner (System.in);
            }
        }      
    }
    //method of add DVD
    private void addDvd(ArrayList<Dvds> dvdsArray){
        //set variable
        String title = null;
        double price = 0;
        String director = null;
        int year = 0;
        int dvdCode = 0;
        boolean found = false;
        //loop start
        while(true){
            try{
                System.out.println("Enter the dvd code: ");
                dvdCode = in.nextInt();
                //chech the dvd code do not have same one 
                if(dvdsArray.size() != 0){
                    for(int i = 0; i<dvdsArray.size(); i++){
                        if(dvdsArray.get(i).getDvdCode() == dvdCode){
                            System.out.println("Error, it already had the DVD");
                            found = true;
                            break;
                        }
                    }
                    if(found == true){
                        break;
                    }
                }
                //get input
                System.out.println("Enter DVD title: ");
                in.nextLine();
                title = in.nextLine();
                title = checkString(title);
                System.out.println("Enter DVD price: ");
                price = in.nextDouble();
                price = checkDouble(price);
                System.out.println("Enether the name of director: ");
                in.nextLine();
                director = in.nextLine();
                director = checkString(director);
                System.out.println("Enter the Year of DVds: ");
                year = in.nextInt();
                //create new object and check the dvd is not in the list
                Dvds dvd = new Dvds(title, price, director, year, dvdCode);
                dvdsArray.add(dvd);
                System.out.println("Add DVD Successfully");    
                break;
            }
            catch (InputMismatchException e){
                System.out.println("This option is not acceptable, Pleae enter again.");
                in = new Scanner (System.in);
            }
        }  
    }
    //method that ask user enter the ISBN and remove it
    private void removeBook(ArrayList<Books> booksArray){
        //set variables
        boolean bookFound = false;
        int removeISBN = 0;
        System.out.println("Enter the ISBN number: ");
        removeISBN = in.nextInt();
        //loop to check the input ISBN
        for(int i = 0; i <booksArray.size(); i++){
           if(booksArray.get(i).getISBN() == removeISBN){
               booksArray.remove(i);
               System.out.println("Remove Book's ISBN: "+ removeISBN + " Successfully." );
               bookFound = true;
           }  
        }
        //if not found, display information
        if(bookFound == false){
            System.out.println("The Book doesn’t exist in the Catalog");
        }    
    }
    //method that remove the DVD
    private void removeDvd(ArrayList<Dvds> dvdsArray){
        //set variables
        boolean dvdFound = false;
        int removeCode= 0;
        System.out.println("Enter the DVD code: ");
        removeCode = in.nextInt();
        //loop to check the input dvd code
        for(int i = 0; i<dvdsArray.size(); i++){
           if(dvdsArray.get(i).getDvdCode() == removeCode){
               dvdsArray.remove(i);
               System.out.println("Remove DVD's code: "+ removeCode + " Successfully." );
               dvdFound = true;
           }  
        }
        //if not found, display information
        if(dvdFound == false){
            System.out.println("The Book doesn’t exist in the Catalog");
        }    
    }
    //method to print the cart
    private void displayCart(ArrayList<Books> booksArray, ArrayList<Dvds> dvdsArray){
        System.out.println("Book: "+"\n****************************************************************************************************************");
        for(Books book: booksArray){
            if(book instanceof AudioBooks == false){
                System.out.println(book.toString());
            }
        }
        System.out.println("****************************************************************************************************************");
        System.out.println("Audio Books: "+"\n****************************************************************************************************************");
        for(Books audioBook: booksArray){
            if(audioBook instanceof AudioBooks){
                System.out.println(audioBook.toString());
            }
        }
        System.out.println("****************************************************************************************************************");
        System.out.println("DVDS: "+"\n****************************************************************************************************************");
        for(Dvds dvd: dvdsArray){
            System.out.println(dvd.toString());  
        }
        System.out.println("****************************************************************************************************************");
    }
    //back up file
    private void backFile(ArrayList<Books> booksArray, ArrayList<Dvds> dvdsArray){
        Date Now = new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy_MM_dd_hh_mm_ss");
        File file = new File("catalog_backup_"+ft.format(Now));
        try{//check file exits, if not, create a new one
            if(!file.exists()){
                file.createNewFile();
                FileWriter fw = new FileWriter(file.getAbsolutePath());
                BufferedWriter bfw = new BufferedWriter(fw);
                bfw.write("Books:");
                bfw.newLine();
                for(Books book: booksArray){
                    if(book instanceof AudioBooks == false){
                    bfw.write(book.toString());
                    }
                }
                bfw.newLine();
                bfw.write("AudioBooks");
                bfw.newLine();
                for(Books audioBook: booksArray){
                    if(audioBook instanceof AudioBooks){
                        bfw.write(audioBook.toString());
                    }
                }
                bfw.newLine();;
                bfw.write("Dvds:");
                bfw.newLine();
                for(Dvds dvd: dvdsArray){
                    bfw.write(dvd.toString());  
                }
                System.out.println("Creat Back File successfully.");
                bfw.close();
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }        
    }
    //method that check the string is not empty or space.
    //if is empty, ask user enter again
    private String checkString(String str){
        Validator check = new Validator();
        while(!check.isNonEmptyString(str)){
            System.out.println("Invalid input, Please enter again: ");
            str =in.nextLine();
        }
        return str;
    }
    //check the number is not less than 0
    //if is less than 0, ask user enter again
    private double checkDouble(double num){
        Validator check = new Validator();
        while(!check.isPositiveInput(num)){
            System.out.println("Invalid input, Please enter again: ");
            num =in.nextDouble();
        }
        return num;
    }
}
