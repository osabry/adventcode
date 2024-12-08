import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day_5_part_2 {
    public static void main(String[] args) {

        int sumMedian = 0;

        int rule[][];
        List<String> update = new ArrayList<>();

        String fileName = "inputs/day_5.txt";
        // fileName = "inputs/test.txt";

        int lineCount = 0;

        try {
            File myFile = new File(fileName);
            Scanner myReadr = new Scanner(myFile);
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                if(myLine.isEmpty()) break;
                lineCount++;
            }
            // System.out.println("first section line count is : " + lineCount);

            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        rule = new int[lineCount][2];
        try {
            File myFile = new File(fileName);
            Scanner myReadr = new Scanner(myFile);
            int line = 0;
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                // System.out.println(myLine);
                if ( line< lineCount && !myLine.isEmpty() ) {
                   
                   String[] a = myLine.split("\\|");
                   for(int i=0;i<a.length;i++) {
                    // System.out.println("   a[] " + a[i]);
                   }
                //    System.out.println(a[0] + " : " + a[1]);
                   rule[line][0] = Integer.parseInt(a[0]);
                   rule[line][1] = Integer.parseInt(a[1]);
                   line++;
                } else {
                    // System.out.println("adding to update list " + myLine + " line = " + line);
                    if(!myLine.isEmpty()) {
                        update.add(myLine);
                    }
                }
            }
            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        // // ==============check search for word A =================
        // for (int i = 0; i < rule.length ; i++) {
        //     System.out.println(" " + rule[i][0] + " | " + rule[i][1]);
        // }
        // System.out.println("=========== after sorted =============");
        // rule = bubbleSortRowWise(rule);

        for ( String str : update) {
            int middleNumber = 0;
            String[] updateList = str.split(",");
            int[] pages = new int[updateList.length];
            
            // Convert string array to int array
            for (int i = 0; i < updateList.length; i++) {
                pages[i] = Integer.parseInt(updateList[i]);
                if(i == ( updateList.length - 1) / 2) middleNumber =  pages[i] ;
            }
            // System.out.println(str + " -> " + (isValid ? "Valid order" + ", middle is : " + middleNumber : "Invalid order") );
            boolean isValid = checkOrder(pages, rule);
            if ( !isValid ) {
                System.out.print(str + " -> is Invalid order corrected to -> ");
                pages = correctOrder(pages, rule);
                if(checkOrder(pages, rule) ) { 
                    String message = "";
                    for (int i = 0; i < pages.length; i++) {
                        message += pages[i] + ",";
                        if(i == ( pages.length - 1) / 2) middleNumber =  pages[i] ;
                    }

                    System.out.println(message + ", middle is : " + middleNumber );
                    
                    // middleNumber =  pages[(pages.length-1)/2] ;
                }
                sumMedian += middleNumber ;
                // System.out.println(str + " -> " + (isValid ? "Valid order" + ", middle is : " + middleNumber : "Invalid order") );
            }
            
        }

        // for (int i = 0; i < rule.length ; i++) {
        //     System.out.println(" " + rule[i][0] + " | " + rule[i][1]);
        // }

        System.out.println("------------completed --------total found " + sumMedian);
        
    }

              
    private static boolean checkOrder(int[] pages, int[][] rules) {
        // Check each pair of pages against the rules
        for (int i = 0; i < pages.length; i++) {
            for (int j = i + 1; j < pages.length; j++) {
                int page1 = pages[i];
                int page2 = pages[j];
                
                // Check if there's a rule requiring the opposite order
                for (int[] rule : rules) {
                    if (rule[0] == page2 && rule[1] == page1) {
                        // Found a rule violation - page2 should come before page1
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private static int[] correctOrder(int[] pages, int[][] rules) {
        // Check each pair of pages against the rules
        for (int i = 0; i < pages.length; i++) {
            for (int j = i + 1; j < pages.length; j++) {
                int page1 = pages[i];
                int page2 = pages[j];
                
                // Check if there's a rule requiring the opposite order
                for (int[] rule : rules) {
                    if (rule[0] == page2 && rule[1] == page1) {
                        pages[i] = page2 ;
                        pages[j] = page1;
                    }
                }
            }
        }
        return pages;
    }


}


//    advent Calende submission : total XMAS found : 2591    answer is correct

//  advent calende day4 part2 submit :  total 1880 X-MAS     answer is correct


//   Day_5 part 1 : Your puzzle answer was 6505.   is correct 
//   day_5 part_2   :   completed --------total found 6897   is correct   