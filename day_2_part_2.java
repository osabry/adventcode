import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day_2_part_2 {
    public static void main(String[] args) {
        
        long totalSafeReport = 0;

        try {
            // File myFile = new File("inputs/test.txt");
            File myFile = new File("inputs/day_2.txt");
            Scanner myReadr = new Scanner(myFile);

            while (myReadr.hasNextLine()) {
                ArrayList<Integer> myArray = new ArrayList<Integer>();
                String myLine = myReadr.nextLine();
                String[] a = myLine.split(" ");
                for (String item : a) {
                    myArray.add(Integer.parseInt(item));
                }
                Boolean safe = check(myArray);
                if (!safe) {
                    // System.out.println(myArray + "   not safe ");
                    // need to recursive check 
                    for (int i=0; i <myArray.size();i++) {
                        ArrayList<Integer> newArray = new ArrayList<>(myArray);
                        newArray.remove(i);
                        // System.out.print("   " + newArray);
                        if(check(newArray)) {
                            safe = true;
                            // System.out.println("  are safe"); 
                            break;
                        } else {
                            // System.out.println("   not safe");  
                        }                     
                    }
                }
                if (safe)
                    totalSafeReport++;
            }
            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        System.out.println("the safe report are " + totalSafeReport);
        // the safe report are 332 submission is ok
    }

    private static Boolean check(ArrayList<Integer> myList) {
        String sort_direction = "";
        boolean safe = true;
        for (int i = 0; i < myList.size() - 1; i++) {
            int first = myList.get(i);
            int second = myList.get(i + 1);
            if ((Math.abs(first - second) > 3)) {
                return false;
            }

            if (sort_direction == "") {
                if (first > second)
                    sort_direction = "Decrease";
                else
                    sort_direction = "Increased";
            }

            if ((sort_direction == "Increased") && (first >= second)) {
                safe = false;
                break;
            }
            if ((sort_direction == "Decrease") && (first <= second)) {
                safe = false;
                break;
            }
        }
        return safe;
    }
}

// the safe report are 398   submit ok 