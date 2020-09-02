package com.yuhtin.tests.main;

/*

 Eratosthenes' sieve is a simple and practical algorithm and method for finding prime numbers up to a certain limit value.
 According to tradition, it was created by the Greek mathematician Eratosthenes,
 the third chief librarian at the Library of Alexandria

 This code was made entirely by me just based on the theory created by Eratosthenes
*/
public class Crivo {

    public static void main(String[] args) {
        int maxNumber = 100, primesCount = 0;

        long startingOperation = System.currentTimeMillis();
        boolean[] primes = execute(maxNumber);
        long finishedOperation = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) continue;

            builder.append(i).append(", ");
            ++primesCount;
        }
        builder.append("]");

        String primesList = builder.toString().replace(", ]", "]");
        System.out.println(primesCount + " prime numbers were found");
        System.out.println("Estimated in " + (finishedOperation - startingOperation) + "ms");
        System.out.println("List of prime numbers found between 2 and " + maxNumber + ":");
        System.out.println(primesList);
    }

    private static boolean[] execute(int maxNumber) {
        int raiz = (int) Math.floor(Math.sqrt(maxNumber));

        boolean[] primes = new boolean[maxNumber + 1];
        for (int number = 2; number <= raiz; number++) {
            if (primes[number]) continue;

            for (int multiples = number; number * multiples <= maxNumber; multiples++) {
                primes[number * multiples] = true;
            }
        }

        return primes;
    }
}
