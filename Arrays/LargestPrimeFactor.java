/*
Given a number N, the task is to find the largest prime factor of that number.
 Example 1:

Input:
N = 5
Output:
5
Explanation:
5 has 1 prime factor i.e 5 only.
*/
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.largestPrimeFactor(N));
        }
    }
}

class Solution {
    static long largestPrimeFactor(int N) {
        // Initialize the largest prime factor to be -1
        long largest_prime = -1;

        // Divide the number by 2 until it becomes odd
        while (N % 2 == 0) {
            largest_prime = 2;
            N /= 2;
        }

        // Now the number is odd, we can start checking for prime factors from 3 to sqrt(N)
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                largest_prime = i;
                N /= i;
            }
        }

        // If N is still greater than 2, it is a prime factor
        if (N > 2) {
            largest_prime = N;
        }
        return largest_prime;
    }
}
