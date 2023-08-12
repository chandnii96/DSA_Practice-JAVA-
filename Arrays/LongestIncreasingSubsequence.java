/*
Given an array of integers, find the length of the longest (strictly) increasing subsequence from the given array.

Example 1:

Input:
N = 16
A = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15}
Output: 
6
Explanation:
There are more than one LIS in this array. One such Longest increasing subsequence is {0,2,6,9,13,15}.
*/
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        // Taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        // Taking total testcases
        int t = sc.nextInt();
        while (t > 0) {
            // Taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            // Inserting elements in the array
            for (int i = 0; i < n; ++i) {
                array[i] = sc.nextInt();
            }
            // Creating an object of class Solution
            Solution ob = new Solution();
            // Calling longestSubsequence() method of class Solution
            System.out.println(ob.longestSubsequence(n, array));
            t--;
        }
    }
}

class Solution {
    // Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[]) {
        int[] piles = new int[size];
        int len = 0;

        for (int num : a) {
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (piles[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            piles[left] = num;
            if (left == len) {
                len++;
            }
        }

        return len;
    }
}
