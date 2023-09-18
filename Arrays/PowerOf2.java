/*
Given a non-negative integer N. The task is to check if N is a power of 2. More formally, check if N can be expressed as 2x for some integer x.

Example 1:

Input: 
N = 8
Output: 
YES
Explanation:
8 is equal to 2 raised to 3 (23 = 8).
*/
import java.util.*;
import java.io.*;
import java.lang.*;

class Driver_class {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine()); // Number of test cases

        while (t-- > 0) {
            // Input a number n
            long n = Long.parseLong(read.readLine());

            // Check if n is a power of 2 using the isPowerofTwo method
            if (new Solution().isPowerofTwo(n) == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
class Solution{
    
    // Function to check if given number n is a power of two.
    public static boolean isPowerofTwo(long n){
        
        // Your code here
        
        if(n<=0){
            return false;
        }
        if(n==1 || n==2){
            return true;
        }
        while(n>1){
            if(n%2 != 0){
                return false;
            }
            n=n/2;
        }
    return true;
        
    }
    
}
