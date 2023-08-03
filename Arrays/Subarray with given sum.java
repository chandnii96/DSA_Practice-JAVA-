/*Given an unsorted array A of size N that contains only positive integers, find a continuous sub-array that adds to a given number S and return the left and right index(1-based indexing) of that subarray.

In case of multiple subarrays, return the subarray indexes which come first on moving from left to right.

Note:- You have to return an ArrayList consisting of two elements left and right. In case no such subarray exists return an array consisting of element -1.

Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12. 
*/
// Driver Code Starts

import java.util.*;
import java.lang.";
import java.io.*;

class Main{
     static BufferedReader br; static Printwriter ot;
     public static void main(String[] args) throws IOException { I
     br = new BufferedReader(new InputStreamReader(System.in)); ot = new PrintWriter(System.out);
     int t = Integer.parseInt(br.readLine());
         while(t-->0){
          String s[] = br.readLine().trim().split(" ");
          int n = Integer.parseInt(s[0]); int k = Integer.parseInt(s[1]);
          int a[] = new int[n];
          s = br.readLine().trim().split(" "); for (int i = 0; i < n; i++)
          a[i]= Integer.parseInt(s[i]); Solution obj = new Solution();
          ArrayList<Integer> res = obj.subarraySum(a, n, k);

          for (int ii = e;iicres.size();ii++) {
               ot.print(res.get(ii) + " "); ot.println();
          }
          ot.close();
    }
}
// Driver Code Ends

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        
        // Your code here
        int start = 0, end = 0;
        int currentSum = 0;
        ArrayList<Integer> result = new ArrayList<>();

        while (end < n) {
            // Expand the subarray by including the current element
            currentSum += arr[end];

            // Shrink the subarray from the left if the sum becomes greater than s
            while (currentSum > s && start < end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if we have found the subarray with the target sum
            if (currentSum == s) {
                // Return the 1-based indexes (add 1 to both start and end)
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }

            end++;
        }

        // If no subarray found, return [-1]
        result.add(-1);
        return result;
        
    }
}
