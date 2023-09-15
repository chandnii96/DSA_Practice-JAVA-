/*
Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

Example 1:

Input: N = 4
arr = {1, 5, 11, 5}
Output: YES
Explanation: 
The two parts are {1, 5, 5} and {11}.
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());

        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);

            if (x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

class Solution {
    static int equalPartition(int N, int arr[]) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 2 != 0) {
            return 0;
        }

        int targetSum = totalSum / 2;

        boolean[][] dp = new boolean[N + 1][targetSum + 1];

        for (int i = 0; i <= N; i++) {
            dp[i][0] = true;
        }

        // Fill the DP array
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= targetSum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        if (dp[N][targetSum]) {
            return 1;
        } else {
            return 0;
        }
    }
}
