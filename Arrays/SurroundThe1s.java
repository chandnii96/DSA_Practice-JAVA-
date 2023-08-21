/*
Given a matrix of order nxm, composed of only 0's and 1's, find the number of 1's in the matrix that are surrounded by an even number (>0) of 0's. The surrounding of a cell in the matrix is defined as the elements above, below, on left, on right as well as the 4 diagonal elements around the cell of the matrix. Hence, the surrounding of any matrix elements is composed of 8 elements. Find the number of such 1's.

Example 1:

Input: 
matrix = {{1, 0, 0}, 
          {1, 1, 0}, 
          {0, 1, 0}}
Output: 
1
Explanation: 
1 that occurs in the 1st row and 1st column, has 3 surrounding elements 0,1 and 1. The occurrence of zero is odd. 
1 that occurs in 2nd row and 1st column has 5 surrounding elements 1,0,1,1 and 0. The occurrence of zero is even. 
1 that occurs in 2nd row and 2nd column has 8 surrounding elements. The occurrence of 0 is odd. 
Similarly, for the 1 that occurs in 3rd row and 2nd column, the occurrence of zero in it's 5 surrounding elements is odd. 
Hence, the output is 1.
*/
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        
        while (T-- > 0) {
            String[] inputSize = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputSize[0]);
            int m = Integer.parseInt(inputSize[1]);
            
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] rowValues = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(rowValues[j]);
                }
            }
            
            Solution ob = new Solution();
            int ans = ob.Count(matrix);
            System.out.println(ans);
        }
    }
}
class Solution {
    public int Count(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int count = 0;
        
        int[][] directions = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0},
            {1, 1}, {-1, -1}, {1, -1}, {-1, 1}
        };
        
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    int zeroCount = 0;
                    for (int[] dir : directions) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];
                        
                        if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols &&
                            matrix[newRow][newCol] == 0) {
                            zeroCount++;
                        }
                    }
                    
                    if (zeroCount % 2 == 0 && zeroCount > 0) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
