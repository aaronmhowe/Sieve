/**
 * Aaron Howe
 * HW5: Sieve of Eratosthenes
 * Standard
 */

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class SieveDriver {

    private java.util.Scanner scan;
    private Sieve theSieve;

    /**
     * parameterless constructor to instantiate member fields
     */
    public SieveDriver() {
        scan = new Scanner(System.in);
        theSieve = new MySieve();
    }

    /**
     * void method to get user input (getNumber), print prime numbers up to n
     */
    public void go() {

        // assume that the user will give input greater than 0
        boolean isZero = false;
        do {
            java.util.List<Integer> primes;
            int n = getNumber();
            if (n == 0) {
                isZero = true;
                System.out.println("Bye");
            } else {
                primes = theSieve.getPrimes(n);
                printPrimes(n, primes);
            }
        }
        while (!isZero);
    }

    /**
     * method to take in user input for the value of n
     * @return input n
     */
    public int getNumber() {
        int n = 0;
        // assume that the user will give bad input, keep going
        boolean continueInput = true;
        // get input from the user until try and catch blocks are satisfied
        do {
            try {
                System.out.print("Enter the upper bound (0 to exit): ");
                n = scan.nextInt();
                if (n >= 0) {
                    // the user has given satisfactory input, stop iterating
                    continueInput = false;
                } else {
                    System.out.println("Cannot enter a number less than 0");
                }
            // catch scanner exception for garbage input such as char, re-enter the try block
            } catch (InputMismatchException e) {
                System.out.println("Integers are required");
                scan.nextLine();
            }
        }
        while (continueInput);
        return n;
    }

    /**
     * void method to print the list of prime numbers to console
     * @param bound print value from user input
     * @param list of primes
     */
    public void printPrimes(int bound, java.util.List<Integer> list) {
        System.out.println("Here are the primes between 2 and " + bound);
        Iterator<Integer> it = list.iterator();
        for(int i = 0; i < list.size(); i ++) {
            if (i % 12 == 0 && i != 0) {
                System.out.println();
            }
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // calculate the percentage of primes given a bound and round it
        float percentage = Math.round(100 * (float)list.size() / bound);
        System.out.printf("%.0f%% of the numbers between 1 and " + bound + " are prime", percentage);
        System.out.println();
        System.out.println();
    }

    /**
     * main method to run SieveDriver
     * @param args
     */
    public static void main(String[] args) {

        new SieveDriver().go();

    }

}