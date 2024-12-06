import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class day_3_part_2 {
    public static void main(String[] args) throws IOException {
        
        long totalMultipication = 0;

        try {
            String text = Files.readString(Paths.get("inputs/day_3.txt"));
            // String text = Files.readString(Paths.get("inputs/test.txt"));


            // String pattern_mul = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
            // Pattern r_mul = Pattern.compile(pattern_mul);
            // Matcher mul = r_mul.matcher(text);

            // while (mul.find()) {
            //     System.out.println(mul.group(1) + "," + mul.group(2));
            //     totalMultipication += Integer.parseInt(mul.group(1)) * Integer.parseInt(mul.group(2)); 
            //     }

            // mul.reset();
             //   beginning string 
            String beginninString = text.substring(0,text.indexOf("don't()"));
            String pattern_mul = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
            Pattern r_mul = Pattern.compile(pattern_mul);
            Matcher mul = r_mul.matcher(beginninString);
            while (mul.find()) {
                System.out.println(mul.group(1) + "," + mul.group(2));
                totalMultipication += Integer.parseInt(mul.group(1)) * Integer.parseInt(mul.group(2)); 
                }
            mul.reset();


            //   middle os text only count between do() and don't() 
            String pattern_do = "do\\(\\)(.*?)don't\\(\\)";
            Pattern r_do = Pattern.compile(pattern_do);
            Matcher dont = r_do.matcher(text);
            while (dont.find()) {
                System.out.println("    " + dont.group());
                mul = r_mul.matcher(dont.group());
                while (mul.find()) {
                    System.out.println("+" + mul.group(1) + "," + mul.group(2));
                    totalMultipication += Integer.parseInt(mul.group(1)) * Integer.parseInt(mul.group(2)); 
                }
            }
            mul.reset();


            // String pattern_do = "don't\\(\\)(.*?)do\\(\\)";
            // Pattern r_do = Pattern.compile(pattern_do);
            // Matcher dont = r_do.matcher(text);
            // while (dont.find()) {
            //     System.out.println("    " + dont.group());
            //     mul = r_mul.matcher(dont.group());
            //     while (mul.find()) {
            //         System.out.println("-" + mul.group(1) + "," + mul.group(2));
            //         totalMultipication -= Integer.parseInt(mul.group(1)) * Integer.parseInt(mul.group(2)); 
            //     }
            // }
            // mul.reset();
            // int remaing_dont_index = text.lastIndexOf("don't()");
            // System.out.println("index of last don't " + remaing_dont_index + " among the whole lenth " + text.length());
            // String remaining_dont_text = text.substring(remaing_dont_index, text.length());
            // mul = r_mul.matcher(remaining_dont_text);
            // while (mul.find()) {
            //     System.out.println("-" + mul.group(1) + "," + mul.group(2));
            //     totalMultipication -= Integer.parseInt(mul.group(1)) * Integer.parseInt(mul.group(2)); 
            //     }

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

// Your puzzle answer was  :175615763    submit ok  for Day3_part_1

//  the total multipication :99023192    not correct  
//                          :99023192    

//  the total multipication :96702160    not correct 
//  the total multipication :96325960    not correct 
//                           96325960
//   the total multipication :48450967    not correct 