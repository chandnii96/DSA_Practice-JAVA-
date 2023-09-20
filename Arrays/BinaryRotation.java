/*Given an integer N and an integer D, rotate the binary representation of the integer N by D digits to the left as well as right and return the results in their decimal representation after each of the rotation.
Note: Integer N is stored using 16 bits. i.e. 12 will be stored as 0000000000001100.

Example 1:

Input:
N = 28, D = 2
Output:
112
7
Explanation: 
28 in Binary is: 0000000000011100
Rotating left by 2 positions, it becomes 0000000001110000 = 112 (in decimal).
Rotating right by 2 positions, it becomes 0000000000000111 = 7 (in decimal).
*/

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> res = ob.rotate(n, d);
            System.out.println(res.get(0));
            System.out.println(res.get(1));
        }
    }
}

class Solution {
    ArrayList<Integer> rotate(int N, int D) {
        // Ensure D is between 0 and 15 to handle circular rotations
        D = D % 16;

        // Convert N to binary string and pad it to 16 bits
        String binary_N = Integer.toBinaryString(N);
        while (binary_N.length() < 16) {
            binary_N = "0" + binary_N;
        }

        // Perform left rotation by D positions
        String leftRotated = binary_N.substring(D) + binary_N.substring(0, D);

        // Perform right rotation by (16 - D) positions
        String rightRotated = binary_N.substring(16 - D) + binary_N.substring(0, 16 - D);

        // Convert binary strings back to decimal
        int decimalLeft = Integer.parseInt(leftRotated, 2);
        int decimalRight = Integer.parseInt(rightRotated, 2);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(decimalLeft);
        result.add(decimalRight);

        return result;
    }
}
