package petriNet.semantics;

import java.util.*;

/**
 * Created by Mihai on 3/9/2017.
 */
public class Util {

    private static final int MAX = 100;

    /**
     * Generates a random* unique* int by adding a random prime number from the fist MAX to the
     * current time in milliseconds
     *
     * @return int
     */
    public static int uniqueID()
    {
        // Holds the first MAX primes
        List<Integer> result = new LinkedList<>();

        // Overestimate by 40%
        int n = (int) (1.4 * MAX * Math.log(MAX));

        boolean[] isPrimeArray = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrimeArray[i] = true;
        }

        for (int i = 2, primesLeft = MAX; i * i <= n && primesLeft > 0; i++) {
            if (isPrimeArray[i]) {
                result.add(i);
                primesLeft--;
                for (int j = i; i * j <= n; j++) {
                    isPrimeArray[i * j] = false;
                }
            }
        }

        // Shuffle the result array
        Collections.shuffle(result);

        // Pick a random index
        int rnd = new Random().nextInt(result.size());

        // Add the random prime to current time in ms and return
        return result.get(rnd) + Math.toIntExact(System.currentTimeMillis());
    }

}
