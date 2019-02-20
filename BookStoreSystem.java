/*
 * This program will be the main class for book store system
 * in could allow user to choose option to enter other menu
 * Kaitian Li
 * 11/29/2018
 */
package bookstoresystem;
import java.util.*;
import java.io.*;
public class BookStoreSystem {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        //set variables
        char selection;
        ArrayList<Books> books = new ArrayList<>();
        ArrayList<Dvds> dvds = new ArrayList<>();
        String input;
        //while loop for check the input 
        while(true){
            mainMenu();
            System.out.print("Choose the role: ");
            input = in.nextLine();
            input = input.toUpperCase();
            selection = input.charAt(0);
            switch(selection){
                case 'A':
                    if(checkUser()){
                        managerMenu manager = new managerMenu();
                        manager.managerMenu(books, dvds);
                    }
                    break;
                case 'B':
                    userMenu um = new userMenu();
                    um.userMenu(books, dvds);
                    break;
                case 'C':
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter valid option: ");
                    break;
            }
        }
    }
    //display main menu
    public static void mainMenu(){
        System.out.println("******************************************************************************");
        System.out.println("**Welcome to the Comets Books and DVDs Store**");
        System.out.println("\nPlease select your role:" 
                +"\nA – store manager"+"\nB – customer"+"\nC – exit store");
        System.out.println("******************************************************************************");
    }
    //check username and password is match the IO file
    public static boolean checkUser(){
        String userName;
        String password;
        while(true){
            Validator check = new Validator();
            //get input
            try{
                System.out.print("Please enter your username(enter -1 to back main menu): ");
                userName = in.nextLine();
                if(userName.trim().equals("-1")){
                    break;
                }
                System.out.println();
                System.out.print("Please enter your password:  ");
                password = in.nextLine();
                System.out.println();
                while(!check.isNonEmptyString(userName) || !check.isNonEmptyString(password)){
                    System.out.println("Please enter valid data: ");
                    System.out.print("Please enter your username: ");
                    userName = in.nextLine();
                    System.out.print("Please enter your password:  ");
                    password = in.nextLine();
                }
                //check the input with IO fil, if match return true, else return false 
                File user = new File(BookStoreSystem.class.getResource("managerCheck.txt").getFile());
                if(!user.exists()) throw new FileNotFoundException();
                else{
                    BufferedReader bReader = new BufferedReader(new FileReader(user));
                    String str;
                    String userText;
                    String passwordText;
                    while((str = bReader.readLine()) != null){
                        String[] temp = new String[2];
                        temp = str.split(",");
                        userText = temp[0];
                        passwordText = temp[1];
                        if(userText.equals(userName) && passwordText.endsWith(password)){
                            bReader.close();
                            return true;
                        }
                    }
                    System.out.println("Username or Password not exit, Please enter again"); 
                    bReader.close();
                }
            }
            //catech execptions
            catch(InputMismatchException e){
                System.out.println("Please enter valid data: ");
                in = new Scanner (System.in);
            }
            catch(FileNotFoundException e){
                System.out.println("File Not Found");
                return false;
            }
            catch(IOException e){
                System.out.println("File error");
                return false;
            }
        }
        return false;
    }
    
}
