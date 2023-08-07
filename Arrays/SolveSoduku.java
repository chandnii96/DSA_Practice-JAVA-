/*
Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]), the task is to find a solved Sudoku. For simplicity, you may assume that there will be only one unique solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Zeros in the grid indicates blanks, which are to be filled with some number between 1-9. You can not replace the element in the cell which is not blank

Example 1:

Input:
grid[][] = 
[[3 0 6 5 0 8 4 0 0],
[5 2 0 0 0 0 0 0 0],
[0 8 7 0 0 0 0 3 1 ],
[0 0 3 0 1 0 0 8 0],
[9 0 0 8 6 3 0 0 5],
[0 5 0 0 9 0 6 0 0],
[1 3 0 0 0 0 2 5 0],
[0 0 0 0 0 0 0 7 4],
[0 0 5 2 0 6 3 0 0]]
Output:
True
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9
Explanation: 
There exists a valid Sudoku for the input grid, which is shown in output.
*/

class Driver_class {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int grid[][] = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++)
                    grid[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            if (ob.SolveSudoku(grid)) {
                ob.printGrid(grid);
            } else {
                System.out.print("No solution exists");
            }
            System.out.println();
        }
    }
}

class Solution {
    //Function to find a solved Sudoku.
    static boolean SolveSudoku(int grid[][]) {
        int N = 9;
        int[] emptyCell = findEmptyCell(grid);

        // If no empty cell is found, the Sudoku is solved.
        if (emptyCell == null) {
            return true;
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (int num = 1; num <= 9; num++) {
            if (isSafe(grid, row, col, num)) {
                grid[row][col] = num;

                if (SolveSudoku(grid)) {
                    return true;
                }

                grid[row][col] = 0; // Backtrack and try a different number
            }
        }

        return false;
    }

    static int[] findEmptyCell(int[][] grid) {
        int N = 9;
        int[] emptyCell = new int[2];
        emptyCell[0] = -1;
        emptyCell[1] = -1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0) {
                    emptyCell[0] = i;
                    emptyCell[1] = j;
                    return emptyCell;
                }
            }
        }

        return null; // Return null if no empty cell is found.
    }

    static boolean isSafe(int[][] grid, int row, int col, int num) {
        int N = 9;

        // Check if 'num' can be placed in the given row and column
        // without violating the Sudoku rules.
        for (int i = 0; i < N; i++) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 sub-grid for the presence of 'num'
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    //Function to print grids of the Sudoku.
    static void printGrid(int grid[][]) {
        int N = 9;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(grid[i][j] + " ");
            }
        }
    }
}
