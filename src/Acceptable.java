/*
 * This is an interface that check the data is valid
 */
package bookstoresystem;
public interface Acceptable {
    boolean isNonEmptyString (String s);
    boolean isPositiveInput (double d);
}
