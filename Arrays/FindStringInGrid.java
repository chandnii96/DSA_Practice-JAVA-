/*
Given a 2D grid of n*m of characters and a word, find all occurrences of given word in grid. A word can be matched in all 8 directions at any point. Word is said to be found in a direction if all characters match in this direction (not in zig-zag form). The 8 directions are, horizontally left, horizontally right, vertically up, vertically down, and 4 diagonal directions.

Note: The returning list should be lexicographically smallest. If the word can be found in multiple directions starting from the same coordinates, the list should contain the coordinates only once. 

Example 1:

Input: 
grid = {{a,b,c},{d,r,f},{g,h,i}},
word = "abc"
Output: 
{{0,0}}
Explanation: 
From (0,0) we can find "abc" in horizontally right direction.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        while (T-- > 0) {
            String[] s1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);

            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String line = br.readLine().trim();
                for (int j = 0; j < m; j++) {
                    grid[i][j] = line.charAt(j);
                }
            }

            String word = br.readLine().trim();
            Solution obj = new Solution();
            int[][] ans = obj.searchWord(grid, word);

            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }

            if (ans.length == 0) {
                System.out.println("-1");
            }
        }
    }
}
class Solution {
    public int[][] searchWord(char[][] grid, String word) {
        int p = grid.length;
        int q = grid[0].length;
        int w = word.length();

        List<int[]> result = new ArrayList<>();

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < p; i++) {
            for (int j = 0; j < q; j++) {
                if (grid[i][j] == word.charAt(0)) {
                    for (int dir = 0; dir < 8; dir++) {
                        int x = i;
                        int y = j;
                        int index = 0;
                        while (index < w && x >= 0 && x < p && y >= 0 && y < q && grid[x][y] == word.charAt(index)) {
                            x += dx[dir];
                            y += dy[dir];
                            index++;
                        }
                        if (index == w) {
                            result.add(new int[]{i, j});
                            break;
                        }
                    }
                }
            }
        }

        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}
