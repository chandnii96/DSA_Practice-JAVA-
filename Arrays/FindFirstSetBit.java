/*
Given an integer N. The task is to return the position of first set bit found from the right side in the binary representation of the number.
Note: If there is no set bit in the integer N, then return 0 from the function.  

Example 1:

Input: 
N = 18
Output: 
2
Explanation: 
Binary representation of 18 is 010010,the first set bit from the right side is at position 2.
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Taking test cases
        
        while (t-- > 0) {
            Solution ob = new Solution();
            int n = sc.nextInt(); // Input n
            System.out.println(ob.getFirstSetBit(n)); // Calling the method and printing the result
        }
    }
}

class Solution {
    // Function to find the position of the first set bit in the given number.
    public static int getFirstSetBit(int n) {
        if (n == 0) {
            return 0;
        }
    
        int position = 1;
        while ((n & 1) == 0) {
            n = n >> 1;
            position++;
        }
    
        return position;
    }
}
