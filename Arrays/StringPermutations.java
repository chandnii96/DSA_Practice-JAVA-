/*
Given a string S. The task is to find all permutations (need not be different) of a given string.

Example 1:

Input:
S = AAA
Output: AAA AAA AAA AAA AAA AAA
Explanation: There are total 6 permutations, as given in the output.
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        while (T-- > 0) {
            Solution ob = new Solution();
            String S = sc.nextLine();
            ArrayList<String> arr = ob.permutation(S);

            for (String s : arr) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}

class Solution
{
    ArrayList<String> res;
    public ArrayList<String> permutation(String S) {
        //Your code here
      
      res=new ArrayList<>();
        fun(S.toCharArray(),new char[S.length()],0);
        Collections.sort(res);
        return res;
    }
    
    public void fun(char[] s, char[] temp, int x){
        if(x>=s.length){
            res.add(new String(temp));
            return;
        }
        for(int i=0;i<s.length;i++){
            if(s[i]!='-'){
                temp[x]=s[i];
                char prev=s[i];
                s[i]='-';
                fun(s,temp,x+1);
                s[i]=prev;
            }
        }
    }  
}

