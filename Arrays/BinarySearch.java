import java.util.*;

public class BinarySearch{
    public static int binarysearch(int numbers[], int key){
        int start=0, end=numbers.length-1;

        while(start<=end){
            int mid=(start+end)/2;
            if (numbers[mid]==key){
                return mid;
            
            }
            if (numbers[mid]<key){
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
    return -1;nm
    }

    public static void main(String args[]){
        int numbers[]={2,3,5,7,8,22,134,456,765};
        int key=789;


        System.out.println("Index for key is:" + binarysearch(numbers,key));
    }
}
