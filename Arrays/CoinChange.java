/*
Given an integer array coins[ ] of size N representing different denominations of currency and an integer sum, find the number of ways you can make sum by using different combinations from coins[ ].  
Note: Assume that you have an infinite supply of each type of coin. And you can use any coin as many times as you want.

Example 1:

Input:
N = 3, sum = 4
coins = {1,2,3}
Output: 4
Explanation: Four Possible ways are: {1,1,1,1},{1,1,2},{2,2},{1,3}.
*/
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int sum = sc.nextInt();
            int N = sc.nextInt(); // Fix: Added missing '='
            int coins[] = new int[N];
            for (int i = 0; i < N; i++) coins[i] = sc.nextInt(); // Fix: Corrected syntax
            Solution ob = new Solution();
            System.out.println(ob.count(coins, N, sum));
        }
    }
}
class Solution {
    public long count(int coins[], int N, int sum) {
        // code here.
        long[] count = new long[sum + 1];
        count[0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                count[j] += count[j - coins[i]];
            }
        }

        return count[sum];
    }
}
