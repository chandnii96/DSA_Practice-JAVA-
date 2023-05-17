import java.util.*;

public class BasicsArray{
    public static void printpairs(int numbers[]){
        for(int i=0; i<numbers.length; i++){

            int curr= numbers[i];
            for (int j=i+1; j<numbers.length; j++){
                System.out.print(" ("+ curr + "," +numbers[j] +")");
            }
        System.out.println();
        }
    }


    public static void subarray(int numbers[]){
        int ts=0;
    
        
        for(int i=0; i<numbers.length;i++){
    
           int start=i;
           for(int j=i; j<numbers.length; j++){
            
               int end=j;
               for(int k=start; k<=end; k++){
        
                System.out.print(numbers[k]+ " ");

            
                
                
               }
        
                 System.out.println();
                 ts++;
                 
            }
           System.out.println();
        }
        System.out.println("Total pairs :"+ ts);

        System.out.println("smallest sum =");
        
    }

    public static void max_subarray_sum(int aray[]){
        int currsum=0;
        int maxsum=Integer.MIN_VALUE;
        for(int i=0; i<aray.length; i++){
            for(int j=i; j<aray.length; j++){
                currsum=0;
                for(int k=i; k<=j; k++){

                    currsum=currsum + aray[k];

                }
                System.out.println(currsum);
                if(maxsum<currsum){
                    maxsum=currsum;
                }
            }
        }
        System.out.println("max sum=" +maxsum);
    }


    public static void prefix(int aray[]){

        int currSum=0;
        int maxSum= Integer.MIN_VALUE;
        int prefix[]= new int[aray.length];

        // calculate prefix array

        for(int i=1; i<prefix.length;i++){

            prefix[i]=prefix[i-1]+aray[i];
        }
        for(int i=0; i<aray.length; i++){
            for(int j=i; j<aray.length; j++){
                currSum= i==0 ? prefix[j]:prefix[j]- prefix[i-1];

                if(maxSum <currSum){
                    maxSum= currSum;
                }
            }
        }
        System.out.println("Max sum="+maxSum);
    }

    public static void kadanes(int numbers[]){
        int ms= Integer.MIN_VALUE;
        int cs=0;

        for(int i=0; i<numbers.length; i++){
            cs=cs+numbers[i];
            if(cs<0){
                cs=0;
            }
            ms= Math.max(cs,ms);
        }
        System.out.println("Our max subarray sum is:"+ms);
    }


    public static int trappedRainwater(int height[]){
      
        //calculate left max boundary- auxiliary/helper array

        int leftMax[]=new int[height.length];
        leftMax[0]=height[0];
        for(int i=1; i<height.length; i++){
            leftMax[i]= Math.max(height[i],leftMax[i-1]);

        }
        //calculate right max boudary
        int rightMax[]=new int[height.length];
        rightMax[height.length-1]=height[height.length-1];
        for(int i=height.length-2; i>0; i--){
            rightMax[i]= Math.max(height[i], rightMax[i+1]);
            
        }
            int trappedwater=0;  
        //loop
        
         for(int i=0; i<height.length; i++){
             //waterlevel
            int waterlevel=Math.min(leftMax[i],rightMax[i]);
             //trapped
            trappedwater=trappedwater+(waterlevel-height[i]);
         }
        return trappedwater;
    }

    public static int buy_sell_stock(int prices[]){
        int maxprofit=0;
        int buyprice=Integer.MAX_VALUE;
        for(int i=0; i<prices.length;i++){
            if(buyprice<prices[i]){
                int profit=prices[i]-buyprice;
                maxprofit=Math.max(maxprofit,profit);
            }
            else{
                buyprice = prices[i];

            }
            
        }
        return maxprofit;
    }
    public static boolean twice_num(int prices[]){
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[i]==prices[j]){
                    return true;
                }
            }
        }
        return false;
    }

    

    public static int Search(int[] nums, int target) {
        
        if(nums.length == 1){
            return nums[0] == target ? 0 : -1;    
        }
        int i=0;
        int j = nums.length-1;
        while(i<j){
            if(nums[i] == target){
                return i;
            }
            else if(nums[j] == target){
                return j;
            }
            else if(target > nums[i]){
                i++;
            }
            else{
                j--;
            }
        }
        return -1;
    }
     


    public static void main(String args[]){
       int nums[]={4,5,6,7,0,1,2};
       int target=0;
       System.out.println(Search(nums, target));
    }

}
