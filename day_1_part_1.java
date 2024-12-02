import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day_1_part_1 {
    public static void main(String[] args) {

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        long totalDistance = 0 ;

        try {
            File myFile = new File("inputs/day_1.txt");
            Scanner myReadr = new Scanner(myFile);
            while(myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                String[] a = myLine.split("   "); 
                left.add(Integer.parseInt(a[0]));
                right.add(Integer.parseInt(a[1]));
            }
            myReadr.close();
            
            System.out.println("The answer is : " + left.size());
            System.out.println("The answer is : " + right.size());

        }
        catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();

        }

        left.sort(null);right.sort(null);

        for ( int i=0 ; i < left.size(); i++) {
            totalDistance += Math.abs(left.get(i) - right.get(i));
            System.out.println("" + left.get(i) + "   " + right.get(i) + "   " + totalDistance);

        }

        System.out.println(" total distance is " + totalDistance );

        //
        //   total distance is 3508942    submit ok ... 



       
    }

    
}
