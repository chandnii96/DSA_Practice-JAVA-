/*
A beautiful matrix is a matrix in which the sum of elements in each row and column is equal. Given a square matrix of size NxN. Find the minimum number of operation(s) that are required to make the matrix beautiful. In one operation you can increment the value of any one cell by 1.
Example 1:

Input:
N = 2
matrix[][] = {{1, 2},
              {3, 4}}
Output: 
4
Explanation:
Updated matrix:
4 3
3 4
1. Increment value of cell(0, 0) by 3
2. Increment value of cell(0, 1) by 1
Hence total 4 operation are required.
*/
import java.io.*;
import java.util.*;

class IntMatrix {
    public static int[][] input(BufferedReader br, int n, int m) throws IOException {
        int[][] mat = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for (int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        return mat;
    }

    public static void print(int[][] m) {
        for (int[] a : m) {
            for (int e : a) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = IntMatrix.input(br, N, N);
            int res = Solution.findMinOperation(N, matrix);
            System.out.println(res);
        }
    }
}

class Solution {
    public static int findMinOperation(int N, int[][] matrix) {
        int a[] = new int[N];
        int m = Integer.MIN_VALUE;
        
        // Compute row and column sums, find the maximum sum
        for (int i = 0; i < N; i++) {
            int s = 0;
            int s1 = 0;
            for (int j = 0; j < N; j++) {
                s += matrix[i][j];
                s1 += matrix[j][i];
            }
            m = Math.max(m, Math.max(s, s1));
            a[i] = s;
        }
        
        int ans = 0;
        
        // Determine the operations count required
        for (int i = 0; i < N; i++) {
            ans += Math.abs(a[i] - m);
        }
        
        return ans;
    }
}





