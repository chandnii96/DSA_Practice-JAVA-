/*
Given an array A[ ] of positive integers of size N, where each value represents the number of chocolates in a packet. Each packet can have a variable number of chocolates. There are M students, the task is to distribute chocolate packets among M students such that :
1. Each student gets exactly one packet.
2. The difference between maximum number of chocolates given to a student and minimum number of chocolates given to a student is minimum.

Example 1:

Input:
N = 8, M = 5
A = {3, 4, 1, 9, 56, 7, 9, 12}
Output: 6
Explanation: The minimum difference between maximum chocolates and minimum chocolates is 9 - 3 = 6 by choosing following M packets :{3, 4, 9, 7, 9}.
*/

import java.io.*;
import java.util.*;

class GfG {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in); int t = sc.nextInt();
      while(t--> 0) {
         int n = sc.nextInt();
         ArrayList<Integer> arr = new ArrayList<>(); 
         for(int i = 0;i<n;i++){
            int x = sc.nextInt(); 
            arr.add(x);
         }
         int msc.nextInt();
         Solution ob = new Solution();
         System.out.println(ob.findMinDiff(arr,n,m));
     }
   }
}

class Solution
{
    public long findMinDiff (ArrayList<Integer> a, int n, int m)
    {
        // your code here
        Collections.sort(a);  // Sort the array in ascending order
        int minDifference = Integer.MAX_VALUE;  // Initialize minDifference to a large value

        // Find the minimum difference between chocolates given to M students
        for (int i = 0; i <= n - m; i++) {
            int currentDifference = a.get(i + m - 1) - a.get(i);
            minDifference = Math.min(minDifference, currentDifference);
        }

        return minDifference;
    }
}
