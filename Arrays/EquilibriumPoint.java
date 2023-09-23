/*
Given an array A of n positive numbers. The task is to find the first equilibrium point in an array. Equilibrium point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

Note: Return equilibrium point in 1-based indexing. Return -1 if no such point exists. 

Example 1:

Input: 
n = 5 
A[] = {1,3,5,2,2} 
Output: 
3 
Explanation:  
equilibrium point is at position 3 as sum of elements before it (1+3) = sum of elements after it (2+2). 
*/

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); 

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long arr[] = new long[n];
            String inputLine[] = br.readLine().trim().split(" ");

            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(inputLine[i]);
            }

            Solution ob = new Solution();
            
            // calling equilibriumPoint() function
            System.out.println(ob.equilibriumPoint(arr, n));
        }
    }
}

class Solution {
    public static int equilibriumPoint(long arr[], int n) {
        if (n == 1) {
            return 1; // There's only one element, so it's the equilibrium point.
        }

        int totalSum = 0;
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }

        for (int i = 0; i < n; i++) {
            totalSum -= arr[i];

            if (leftSum == totalSum) {
                return i + 1; // Return 1-based index
            }

            leftSum += arr[i];
        }

        return -1;
    }
}
