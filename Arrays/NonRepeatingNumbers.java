/*
Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return in increasing order.

Example 1:

Input: 
N = 2
arr[] = {1, 2, 3, 2, 1, 4}
Output:
3 4 
Explanation:
3 and 4 occur exactly once.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class GFG{
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for (int i = 0; i < 2 * n + 2; i++) {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            System.out.println(Arrays.toString(ans));
        }
    }
}
class Solution
{
    public int[] singleNumber(int[] nums)
    {
        // Code here
        int xorResult = 0;

        // XOR all elements of the array
        for (int num : nums) {
            xorResult ^= num;
        }

        int position = findSetBitPosition(xorResult);

        int num1 = 0;
        int num2 = 0;

        // Separate elements into two groups based on the chosen set bit
        for (int num : nums) {
            if (((num >> position) & 1) == 1) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{Math.min(num1, num2), Math.max(num1, num2)};
    }

    public static int findSetBitPosition(int xorResult) {
        int position = 0;
        while ((xorResult & 1) == 0) {
            xorResult >>= 1;
            position++;
        }
        return position;
    }
    
}
