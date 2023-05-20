import java.util.*;

public class LinearSearch{
    public static int linearsearch(int numbers[], int key){
        for( int i=0; i<numbers.length; i++){
            if(numbers[i]==key){
                return i;
            }
    
        }
        return -1;
    }


    public static void main(String args[]){
        int numbers[]={2,3,46,742,2573,23,56,43,4};
        int key=56;

        int index=linearsearch(numbers,key);
        if(index==-1){
            System.out.println("KEy is not present");
        }
        else{
            System.out.println("key is at index " + index);
        }
    }


}
