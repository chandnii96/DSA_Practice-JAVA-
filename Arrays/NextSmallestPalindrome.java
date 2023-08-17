/*
Given a number, in the form of an array Num[] of size N containing digits from 1 to 9(inclusive). The task is to find the next smallest palindrome strictly larger than the given number.

Example 1:

Input:
N = 11
Num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2}
Output: 9 4 1 8 8 0 8 8 1 4 9
Explanation: Next smallest palindrome is
9 4 1 8 8 0 8 8 1 4 9
*/
public class GFG {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }
            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        Vector<Integer> v = new Vector<>();

        int m = n / 2;
        int l = m - 1;
        int r = (n % 2 == 1) ? m + 1 : m;

        while (l >= 0 && num[l] == num[r]) {
            l--;
            r++;
        }

        int carry = 0;

        if (l < 0 || num[l] < num[r]) {
            carry = 1;
        }

        l = m;

        if (n % 2 == 0) {
            l = m - 1;
        }

        r = m;

        while (l >= 0) {
            num[l] = num[l] + carry;
            carry = num[l] / 10;
            num[l] = num[l] % 10;
            num[r] = num[l];
            l--;
            r++;
        }

        if (carry == 1) {
            v.addElement(1);
            for (int i = 0; i < n - 1; i++) {
                v.add(0);
            }
            v.addElement(1);
        } else {
            for (int ele : num) {
                v.add(ele);
            }
        }

        return v;
    }
}
