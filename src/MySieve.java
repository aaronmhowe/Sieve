import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MySieve implements Sieve {

    /**
     * method to implement the Sieve algorithm up to n integers
     * @param n integer value to list prime numbers up to
     * @return the list of primes
     */
    /*
    Explanation for M:
    M is the square root of the max value N, that is, when currentPrime reaches M, the loop should exit knowing that
    mathematically, all primes have been found.
     */
    public List<Integer> getPrimes(int n) {
        // list of potential prime numbers
        List<Integer> numberList = new ArrayList<>();
        // list of found prime numbers
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            numberList.add(i);
        }
        Iterator<Integer> iterator = numberList.iterator();
        double m = java.lang.Math.sqrt(n);
        while (iterator.hasNext()) {
            Integer currentPrime = iterator.next();
            // Check if the square root of the max value N has been reached
            if (currentPrime >= m) {
                primeList.addAll(numberList);
                break;
            }
            primeList.add(currentPrime);
            // iterate numberList, assign each value to 'p', check if value % currentPrime divides evenly,
            // if true, remove.
            numberList.removeIf(p -> p % currentPrime == 0);
            iterator = numberList.iterator();

        }
        return primeList;
    }
}
