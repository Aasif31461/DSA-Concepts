import java.util.Arrays;

/**
 * Prime Number Algorithms and Concepts for DSA in Java
 *
 * This file contains all important methods and optimized solutions for working with prime numbers.
 * Topics covered:
 * 1. Basic Prime Check
 * 2. Optimized Prime Check
 * 3. Sieve of Eratosthenes
 * 4. Count of Primes
 * 5. Generating All Primes up to n
 * 6. Space-optimized Sieve (if needed)
 * 7. Prime Factorization (optional)
 */

public class Prime {

    public static void main(String[] args) {
        int n = 50;
        System.out.println("Primes up to " + n + ": " + Arrays.toString(sieveOfEratosthenes(n)));
        System.out.println("Is 29 prime? " + isPrime(29));
        System.out.println("Is 97 prime (optimized)? " + isPrimeOptimized(97));
        System.out.println("Count of primes up to " + n + ": " + countPrimes(n));
        System.out.println("Prime factors of 84: " + Arrays.toString(primeFactors(84)));
        System.out.println("Primes in range 10 to 50: " + Arrays.toString(segmentedSieve(10, 50)));
    }

    /**
     * 1. Basic Prime Check (O(sqrt(n)))
     */
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * 2. Optimized Prime Check (6k +/- 1 rule)
     */
    public static boolean isPrimeOptimized(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    /**
     * 3. Sieve of Eratosthenes (O(n log log n))
     * Returns all primes up to n (inclusive)
     */
    public static int[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        if (n >= 0) isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        int count = 0;
        for (boolean b : isPrime) if (b) count++;
        int[] primes = new int[count];
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes[idx++] = i;
        }
        return primes;
    }

    /**
     * 4. Count of Primes up to n
     */
    public static int countPrimes(int n) {
        return sieveOfEratosthenes(n).length;
    }

    /**
     * 5. Prime Factorization (returns all prime factors, including duplicates)
     */
    public static int[] primeFactors(int num) {
        if (num <= 1) return new int[0];
        int[] factors = new int[32]; // Enough for int range
        int idx = 0;
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors[idx++] = i;
                num /= i;
            }
        }
        if (num > 1) factors[idx++] = num;
        return Arrays.copyOf(factors, idx);
    }

    //advanced/space-optimized sieve or segmented sieve as needed
    public static int[] segmentedSieve(int low, int high) {
        boolean[] isPrime = new boolean[high - low + 1];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i <= high; i++) {
            for (int j = Math.max(i * i, (low + i - 1) / i * i); j <= high; j += i) {
                isPrime[j - low] = false;
            }
        }
        int count = 0;
        for (boolean b : isPrime) if (b) count++;
        int[] primes = new int[count];
        int idx = 0;
        for (int i = low; i <= high; i++) {
            if (isPrime[i - low]) primes[idx++] = i;
        }
        return primes;
    }
}
