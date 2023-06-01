public class Basics_pattern {
    public static void hollow_rectangle(int totRows, int totCols){
       //outer loop
        for (int i=1; i<=totRows; i++){
            //inner-columns
            for(int j=1; j<=totCols; j++){
                //cell-(i,j)
                 if(i==1|| i==totRows || j==1 || j== totCols) {
                    System.out.print("*");
                 }
                 else{
                    System.out.print(" ");
                 }
            }
            System.out.println();
        }
    }

    public static void inverted_rotated_half_pyramid(int n){
        for(int i=1; i<=n; i++){

            //inner loop
            //spaces
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");

            }
            //stars
            for(int j=1; j<=i; j++){
                System.out.print("*");

            }
            System.out.println();

        }
    }

    public static void inverted_rotated_half_pyramid_withNumbers(int n){
        for(int i=1; i<=n; i++){
            //inner- numbers
            for(int j=1; j<=n-i+1; j++){
                System.out.print(j);

            }
            System.out.println();
        }
    }

    public static void floyds_triangle(int n){

        int counter=1;
        for(int i=1; i<=n;i++){
            for(int j=1; j<=i;j++){
                System.out.print(counter+" ");
                counter++;
            }
          System.out.println();
        }
    }

    public static void butterfly(int n){
        for(int i=1; i<=n; i++){
            //stars-i
            for(int j=1; j<=i;j++){
                System.out.print("*");
            }
            //spaces
            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            //stars-i
            for(int j=1; j<=i;j++){
              System.out.print("*");
            }
            System.out.println();
        }
        
        //2nd half
        for(int i=n;i>=1;i--){
            //stars-i
            for(int j=1; j<=i;j++){
                System.out.print("*");
            }
            //spaces
            for(int j=1; j<=2*(n-i); j++){
                System.out.print(" ");
            }
            //stars-i
            for(int j=1; j<=i;j++){
            System.out.print("*");
            }
         System.out.println();
        }
       
    }
    public static void solid_rhombus(int n){
        for(int i=1; i<=n; i++){
            for (int j=1; j<=n-i; j++){
                System.out.print(" ");

            }
            for (int j=1; j<=n; j++){
                System.out.print("*");
            }  
            
        System.out.println(" ");
        }
    }
    public static void hollow_rhombus(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n-i;j++){
                System.out.print(" ");
            }
            //rectangle hollow
            for (int j=1; j<=n; j++){
                if (i==1 || i==n || j==1 || j==n){
                    System.out.print("*");
                }
                 else
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void diamond(int n){
        for (int i=1; i<=n; i++){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
          System.out.println();
        }

        for (int i=n; i>=1; i--){
            for(int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=1; j<=(2*i-1); j++){
                System.out.print("*");
            }
          System.out.println();
        }

        

    }

    public static void number_pyramid(int n){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for (int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
        System.out.println();
        }
    }
    public static void palindromic(int n){
        for( int i=1; i<=5; i++){
            for (int j=1; j<=n-i; j++){
                System.out.print(" ");
            }

            for(int j=i; j>=1; j--){
                System.out.print(j);
            }
            for ( int j=2; j<=i; j++){
                System.out.print(j);
            }
         System.out.println();
        }
    }

    public static void butterflyy(int n){
        for (int i=1; i<=n; i++){
            for(int j=1; j<=2*n; j++   ){
                if(j<=i ||  j>2*n-i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
        System.out.println();
        }
        //////////////////////
        for (int i=n; i>=1; i--){
            for(int j=1; j<=2*n; j++   ){
                if(j<=i ||  j>2*n-i){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
        System.out.println();
        }
    }


    public static void main(String args[]){
      //  diamond(4);
        //number_pyramid(5);
       // palindromic(5);
       butterflyy(4);
    }
}
