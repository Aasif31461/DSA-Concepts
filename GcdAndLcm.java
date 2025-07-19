public class GcdAndLcm {
    public static void main(String[] args) {
        // All Concepts: GCD, LCM, Euclidean algorithm, Subtraction method, GCD/LCM of arrays
        /*
         * GCD (Greatest Common Divisor) is the largest positive integer that divides each of the integers without leaving a remainder.
         * LCM (Least Common Multiple) is the smallest positive integer that is divisible by each of the integers.
         * Euclidean algorithm is an efficient method for computing the GCD of two integers.
         * The subtraction method is a simple way to find the GCD by repeatedly subtracting the smaller number from the larger one until both numbers are equal.
         * GCD and LCM can also be extended to arrays of integers, where the GCD is the largest integer that divides all elements
         * and the LCM is the smallest integer that is a multiple of all elements in the array.
         *
         */
        int a = 12, b = 15;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd(a, b));
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm(a, b));
        System.out.println("GCD using Euclidean algorithm of " + a + " and " + b + " is: " + gcdUsingEuclidean(a, b));
        System.out.println("GCD using subtraction of " + a + " and " + b + " is: " + gcdUsingSubtraction(a, b));    
        System.out.println("GCD of array {12, 15, 21} is: " + gcdOfArray(new int[]{12, 15, 21}));
        System.out.println("LCM of array {12, 15, 21} is: " + lcmOfArray(new int[]{12, 15, 21}));
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcdUsingEuclidean(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcdUsingEuclidean(b, a % b);
    }

    static int gcdUsingSubtraction(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    // GCD of more than two numbers
    static int gcdOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    // LCM of more than two numbers
    static int lcmOfArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = lcm(result, arr[i]);
        }
        return result;
    }        
}
