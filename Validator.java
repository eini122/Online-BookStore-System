/*
 * This class will write method to check the input is vailed
 */
package bookstoresystem;
public class Validator implements Acceptable{
    //check the input is not empty
    public boolean isNonEmptyString (String s){
        return !s.trim().isEmpty();
    }
    //check the input is greater than -1
    public boolean isPositiveInput (double d){
        return d >= 0;
    }
}
