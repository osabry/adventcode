package etc;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class hackrank {
    public static void main(String[] args) {




        printResult(0,2,10);
        printResult(5,3,5);

    }


        public static void printResult(int a, int b ,int n) {
            for(int i=0; i<n ; i++) {
                double result = 0 ; 
                for ( int j = 0 ; j <= i ; j++) {
                    result += Math.pow(2, j) * b;
                }
                result = a + result;
                System.out.printf("%d ",(int)(result));
            }
            System.out.println("");
    }
}
