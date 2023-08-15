/*
Given an array A[] consisting of 0’s and 1’s. A flip operation is one in which you turn 1 into 0 and a 0 into 1. You have to do at most one “Flip” operation of any subarray. Formally, select a range (l, r) in the array A[], such that (0 ≤ l ≤ r < n) holds and flip the elements in this range to get the maximum ones in the final array. You can possibly make zero operations to get the answer.

Example 1:

Input:
N = 5
A[] = {1, 0, 0, 1, 0} 
Output:
4
Explanation:
We can perform a flip operation in the range [1,2]
After flip operation array is : [ 1 1 1 1 0 ]
Count of one after fliping is : 4
*/
class GFG{
  public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Inputting the number of test cases
        while (t-- > 0) {
            int n = scanner.nextInt(); // Inputting the size of the array
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(maxOnes(a, n));
        }
    }
}
class Solution {

    public static int maxOnes(int a[], int n) {
        // Your code goes here
        int maxCount=0;
        int count = 0;
        int countOne = 0;
        for(int i=0;i<n;i++){
            if(a[i]==1){
                countOne++; //count number of 1's
            }
            if(a[i]==0){ 
                count++; //count of flips required
            }else{
                count--; //if element is 1 then it should be zero and not to be counted in the flip's count or in the result
            }
            if(count>0 && count > maxCount){
                maxCount = count;//update if count is maximum
            }else if(count<0){
                count = 0;// if negative count then discard
            }
        }
        return maxCount + countOne;
    }
}






