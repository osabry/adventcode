import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class day_3_part_2_2 {
    public static void main(String[] args) throws IOException {

        long totalMultipication = 0;
        String file = "inputs/day_3.txt";
        // file = "inputs/test.txt";
        file = "inputs/day_3_cleanup";

        StringBuilder text = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(file), StandardCharsets.UTF_8)) {
            stream.forEach(s -> text.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }



        // // StringBuilder sb = new StringBuilder("Hello World!");
        // // int start = sb.indexOf("World");
        // // int end = start + "World".length();
        // // sb.delete(start, end);

        // // mul.reset();
        // // beginning string
        // System.out.println("======before delete  =========== text.length()=" + text.length() + ",   " + text.substring(0,40));
        // String beginninString = text.substring(0, text.indexOf("don't()"));
        // totalMultipication += add(beginninString);
        // text.delete(0, beginninString.length());
        // System.out.println("======after delete  =========== text.length()=" + text.length() + ",   " + text.substring(0,40));

        // // middle os text only count between do() and don't()
        // String pattern_do = "do\\(\\)(.*?)don't\\(\\)";
        // Pattern r_do = Pattern.compile(pattern_do);
        // Matcher dont = r_do.matcher(text);
        // while (dont.find()) {
        //     String current = dont.group();
        //     System.out.println("    " + current);
        //     totalMultipication += add(current);
        // }
        // System.out.println("======befroe delete  =========== text.length()=" + text.length() + ",   " + text.substring(0,40));
        // text.delete(0,text.lastIndexOf("don't()"));
        // System.out.println("======after delete  =========== text.length()=" + text.length() + ",   " + text.substring(0,40));
        
        
        // System.out.println("======remaining ===========" + text);

        // if ( text.indexOf("do()") > 0 ) {
        //     String reminingString = text.substring(text.indexOf("do()"),text.length()-1);
        //     totalMultipication += add(reminingString);
        // }
        String asas = text.toString();
        System.out.println("the total multipication :" + add(asas));
    }
    
    private static long add(String str) {
        long result = 0;
        String pattern_mul = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern r_mul = Pattern.compile(pattern_mul);
        Matcher mul = r_mul.matcher(str);
        while (mul.find()) {
            System.out.println(mul.group(1) + "," + mul.group(2));
            result += Integer.parseInt(mul.group(1)) * Integer.parseInt(mul.group(2));
        }
        mul.reset();
        return result;
    }

}


// thethe safe report are 2676537 not submit
// the safe report are 401473 not submit
// the total multipication :124007256 not correct

// the total multipication :148774354 not correct
// 149150554 not correct

// Your puzzle answer was :175615763 submit ok for Day3_part_1

// the total multipication :99023192 not correct
// :99023192

// the total multipication :96702160 not correct
// the total multipication :96325960 not correct
// 96325960
// the total multipication :48450967 not correct

// the total multipication :48450967

// the total multipication :74361272 