import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day_3_part_1 {
    public static void main(String[] args) {
        
        long totalMultipication = 0;

        try {
            // File myFile = new File("inputs/test.txt");
            File myFile = new File("inputs/day_3.txt");
            Scanner myReadr = new Scanner(myFile);

            while (myReadr.hasNextLine()) {

                StringBuffer sb = new StringBuffer(myReadr.nextLine());
                // System.out.println("=====> " + sb.indexOf("mul("));
                 while( sb.indexOf("mul(") > 0 ) {
                    String sub_str="";
                    int display_length = ( sb.length() < 40 ) ? sb.length() : 40 ;
                    System.out.println("======before delete =========== " + sb.substring(0,display_length));
                    String deleted_message = sb.substring(0,sb.indexOf("mul(") + 4 );
                    sb.delete(0,sb.indexOf("mul(")+4);

                    
                    if ( sb.indexOf(")") < 8 ) {
                        sub_str = sb.substring(0,sb.indexOf(")"));
                        if(sub_str.contains(",")) {
                            System.out.print("  send for check  " + sub_str + "     :  ");
                            totalMultipication += check(sub_str);
                        }
                    } else {
                        System.out.println("----->length " + sb.indexOf(")"));
                        // sb.delete(0,sb.indexOf(")")+1);
                    }
                    if(!sub_str.isEmpty()) System.out.println("    " + sub_str);
                    display_length = ( sb.length() < 40 ) ? sb.length() : 40 ;
                    System.out.println("======after delete  =========== " + sb.substring(0,display_length) + ", the ')' position found at " + sb.indexOf(")"));
                    // System.out.println("======after delete ===========" + sb.length() + "==== deleted " + deleted_message + "===length" + deleted_message.length() );
                    
                    
                //     String sub_str = sb.substring(0,7);
                //     System.out.println("======after substring===========" + sb.length() + "===substring " + sub_str);
                //     // System.out.println("----->" + sub_str +"length " + sub_str.length() + " has ',' " + sub_str.contains(","));
                // //     System.out.println("======================" + sb);
                // //     sb = sb.delete(0,sb.indexOf("mul("));
                // //     sub_str = sb.substring(0,sb.indexOf(")"));
                //     if(sub_str.length()<=7 && sub_str.contains(",")) {
                // //         System.out.println("need to evaluate " + sub_str);
                //         totalMultipication += check(sub_str);
                //     } else {
                //         System.out.println("----->" + sub_str +"length " + sub_str.length() + " has ',' " + sub_str.contains(","));
                //         // sb.delete(0,sb.indexOf(")")+1);
                //     }
                // //     if ( sb.indexOf("mul(") < 0) break; 
                }
            }
            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        System.out.println("the total multipication :" + totalMultipication);
        // the safe report are 332 submission is ok
    }

    private static long check(String str) {
        String[] a = str.split(",");
        int b=0; int c=0;
        try {
             b = Integer.parseInt(a[0]);
             c = Integer.parseInt(a[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("==error catched " + str);
            return 0;
        }
        System.out.print("       check completed for " + b + "," + c);
        return  b * c;
    }
}

// thethe safe report are 2676537    not submit
//  the safe report are 401473    not submit
// the total multipication :124007256   not correct 

// the total multipication :148774354   not correct 
//                          149150554    not correct

// the total multipication :148774354
// 