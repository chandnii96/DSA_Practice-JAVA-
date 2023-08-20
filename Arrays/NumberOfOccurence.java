/*
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int firstOccurrence = firstOccurrence(arr, n, x);
        
        // If x is not present, return 0
        if (firstOccurrence == -1) {
            return 0;
        }
        
        // Function to find the index of the last occurrence of x in arr
        int lastOccurrence = lastOccurrence(arr, n, x);
        
        // Count of occurrences is the difference between last and first occurrences plus 1
        return lastOccurrence - firstOccurrence + 1;
    }
    
    // Function to find the index of the first occurrence of x in arr
    private int firstOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                high = mid - 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    // Function to find the index of the last occurrence of x in arr
    private int lastOccurrence(int[] arr, int n, int x) {
        int low = 0, high = n - 1;
        int result = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                result = mid;
                low = mid + 1;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
}
