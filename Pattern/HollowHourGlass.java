import java.util.*;
  
public class Patterns{
    public static void HollowHourGlass(int n)
    {
        int i, j;
        //printing the upper part
        for (i = 1; i <= n; i++) {
            for (j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (j = i; j <= n; j++) {
                if(j==i||j==n||i==1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
  
        // Printing the lower part
        for (i = n - 1; i >= 1; i--) {
            for (j = 1; j < i; j++) {
                System.out.print(" ");
            }
            for (j = i; j <= n; j++) {
                if(j==i||j==n||i==1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            
            System.out.println();
        }
    }
  
    // Driver Function
    public static void main(String args[])
    {
        int n = 6;
       HollowHourGlass(n);
    }
}
