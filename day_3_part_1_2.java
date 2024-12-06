import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day_3_part_1_2 {
    public static void main(String[] args) {
        
        long totalMultipication = 0;


        try {
            File myFile = new File("inputs/test.txt");
            // File myFile = new File("inputs/day_3.txt");
            Scanner myReadr = new Scanner(myFile);
            String pattern_mul = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
            Pattern r_mul = Pattern.compile(pattern_mul);
            

            while (myReadr.hasNextLine()) {

                StringBuffer sb = new StringBuffer(myReadr.nextLine());
                Matcher m = r_mul.matcher(sb);

                while (m.find()) {
                    totalMultipication += Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2)); 
                }
            }
            myReadr.close();

            // myReadr = new Scanner(myFile);
            // String pattern_do = "don't\\(\\)(.*?)do\\(\\)";
            // Pattern r_do = Pattern.compile(pattern_do);
            // while (myReadr.hasNextLine()) {

            //     StringBuffer sb = new StringBuffer(myReadr.nextLine());
            //     Matcher m = r_do.matcher(sb);

            //     while (m.find()) {
            //         totalMultipication += Integer.parseInt(m.group(1)) * Integer.parseInt(m.group(2)); 
            //     }
            // }
            // myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        System.out.println("the total multipication :" + totalMultipication);
        // the safe report are 332 submission is ok
    }

}

// thethe safe report are 2676537    not submit
//  the safe report are 401473    not submit
// the total multipication :124007256   not correct 

// the total multipication :148774354   not correct 
//                          149150554    not correct

// Your puzzle answer was  :175615763    submit ok 
// 