import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class day_5_part_1 {
    public static void main(String[] args) {

        int rule[][];
        List<String> update = new ArrayList<>();

        String fileName = "inputs/day_5.txt";
        fileName = "inputs/test.txt";

        int lineCount = 0;
        int rowCount = 0;

        try {
            File myFile = new File(fileName);
            Scanner myReadr = new Scanner(myFile);
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                if(myLine.isEmpty()) break;
                lineCount++;
            }
            System.out.println("first section line count is : " + lineCount);

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
                System.out.println(myLine);
                if ( line< lineCount && !myLine.isEmpty() ) {
                   
                   String[] a = myLine.split("\\|");
                   for(int i=0;i<a.length;i++) {
                    System.out.println("   a[] " + a[i]);
                   }
                   System.out.println(a[0] + " : " + a[1]);
                   rule[line][0] = Integer.parseInt(a[0]);
                   rule[line][1] = Integer.parseInt(a[1]);
                   line++;
                } else {
                    System.out.println("adding to update list " + myLine + " line = " + line);
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
        // ==============check search for word A =================
        for (int i = 0; i < rule.length ; i++) {
            System.out.println(" " + rule[i][0] + " | " + rule[i][1]);
        }
        System.out.println("=========== after sorted =============");
        rule = bubbleSortRowWise(rule);

        for (int i = 0; i < rule.length ; i++) {
            System.out.println(" " + rule[i][0] + " | " + rule[i][1]);
        }



        for ( String str : update) {
            System.out.println(str);
        }

        System.out.println("------------completed --------total found ");
        
    }

        private static Boolean check(String str) {
            if (str.equals("MAS") || str.equals("SAM")) {
                // System.out.println("                             found :" + str);
                return true;
            } else
                return false;
        }

        public static int[][] bubbleSortRowWise(int[][] array) {
            int[] col = new int[array.length];
            for (int i = 0; i < array.length; i++) {
                col[i] = array[i][0];
            }
            Arrays.sort(col);
            int[][] newArray = new int[array.length][2];
            for (int i = 0; i < array.length; i++) {
                newArray[i][0] = col[i];
                newArray[i][1] = find(col[i],array);
            }
            return newArray;
        }
              
        private static int find(int item,int[][] array) {
            for (int i = 0; i < array.length; i++) {
                if ( array[i][0] == item) {
                    return array[i][1];
                } 
        }
        return item;
    }

}


//    advent Calende submission : total XMAS found : 2591    answer is correct

//  advent calende day4 part2 submit :  total 1880 X-MAS     answer is correct