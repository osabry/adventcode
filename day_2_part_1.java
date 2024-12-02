import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day_2_part_1 {
    public static void main(String[] args) {

        long totalSafeReport = 0;

        try {
            File myFile = new File("inputs/day_2.txt");
            // File myFile = new File("inputs/test.txt");
            Scanner myReadr = new Scanner(myFile);
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                String[] a = myLine.split(" ");
                String sort_direction = "";
                Boolean safe = true;
                for(int i = 0; i < a.length -1 ; i++ ) {
                    int first = Integer.parseInt(a[i]);
                    int second = Integer.parseInt(a[i+1]);
                    if( (Math.abs(first-second) > 3) || (first-second ==0 )) {
                        safe = false;
                        break;
                    }
                    if ( sort_direction == "" ) {
                        if ( first > second ) sort_direction = "Decrease";
                        else sort_direction = "Increased";
                    }

                    if ((sort_direction == "Increased") && ( first > second ) ) {
                        safe = false;
                        break;
                    }
                    if ( (sort_direction == "Decrease") && ( first < second ) ) {
                        safe = false;
                        break;
                    }
                              
                }
                System.out.println(myLine + "   " + safe);  
                if (safe) totalSafeReport++;
            }
            myReadr.close();

            // System.out.println("The answer is : " + left.size());
            // System.out.println("The answer is : " + right.size());

        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }

        // left.sort(null);right.sort(null);

        System.out.println("the safe report are " + totalSafeReport);


        // the safe report are 332 submission is ok 

    }

}
