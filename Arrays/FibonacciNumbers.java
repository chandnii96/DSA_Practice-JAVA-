/*
Given a number N, find the first N Fibonacci numbers. The first two number of the series are 1 and 1.

Example 1:

Input:
N = 5
Output: 1 1 2 3 5
*/
class GFG {
    public static void main(String[] args) {
        // Taking input using Scanner class
        Scanner sc = new Scanner(System.in);

        // Taking total count of test cases
        int t = sc.nextInt();

        while (t-- > 0) {
            // Taking total number of elements
            int n = sc.nextInt();

            // Calling printFibb() method
            long[] res = new Solution().printFibb(n);

            // Printing the elements of the array
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }

            System.out.println();
        }
    }
}

class Solution
{
    //Function to return list containing first n fibonacci numbers.
    public static long[] printFibb(int n) 
    {
        //Your code here
        long[] fibo = new long[n];

        // Special case for N=1
        if (n >= 1) {
            fibo[0] = 1;
        }

        // Special case for N=2
        if (n >= 2) {
            fibo[1] = 1;
        }

        // Calculate and add the remaining Fibonacci numbers
        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i - 1] + fibo[i - 2];
        }

        return fibo;
    }
}
