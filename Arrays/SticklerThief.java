/*
Stickler the thief wants to loot money from a society having n houses in a single line. He is a weird person and follows a certain rule when looting the houses. According to the rule, he will never loot two consecutive houses. At the same time, he wants to maximize the amount he loots. The thief knows which house has what amount of money but is unable to come up with an optimal looting strategy. He asks for your help to find the maximum money he can get if he strictly follows the rule. ith house has a[i] amount of money present in it.

Example 1:

Input:
n = 5
a[] = {6,5,5,7,4}
Output: 
15
Explanation: 
Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6+5+4=15.
*/
import java.util.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        // Taking input using Scanner class 
        Scanner sc = new Scanner(System.in);

        // Taking count of test cases 
        int t = sc.nextInt();

        while (t-- > 0) {
            // Taking count of houses
            int n = sc.nextInt();
            int arr[] = new int[n];

            // Inserting money present in each house in the array 
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt();

            // Calling method FindMaxSum() of class Solution 
            System.out.println(new Solution().FindMaxSum(arr, n));
        }
    }
}

class Solution {
    // Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n) {
        // Your code here
        if (n == 0) {
            return 0;
        }

        // Initialize variables to track the maximum amount with or without the current house
        int include = arr[0];
        int exclude = 0;

        // Iterate through the houses
        for (int i = 1; i < n; i++) {
            // Calculate the new maximum amount including the current house
            int newInclude = exclude + arr[i];

            // Update exclude with the maximum of the previous include and exclude
            exclude = Math.max(include, exclude);

            // Update include with the new maximum
            include = newInclude;
        }

        // Return the maximum of include and exclude
        return Math.max(include, exclude);
    }
}
