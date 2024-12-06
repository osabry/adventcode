import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.plaf.synth.SynthOptionPaneUI;

public class day_4_part_1 {
    public static void main(String[] args) {

        char array[][];

        List<xmasPoints> xmasPoints = new ArrayList<>();
        String fileName = "inputs/day_4.txt";
        // fileName = "inputs/test.txt";
        String xmas = "XMAS";
        long totalXmas = 0;
        int lineCount = 0;
        int rowCount = 0;

        try {
            File myFile = new File(fileName);
            Scanner myReadr = new Scanner(myFile);
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                lineCount++;
                if (rowCount == 0) {
                    rowCount = myLine.length();
                }
            }
            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        array = new char[lineCount][rowCount];
        try {
            File myFile = new File(fileName);
            Scanner myReadr = new Scanner(myFile);
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                if (rowCount == 0) {
                    rowCount = myLine.length();
                    break;
                }
            }
        myReadr.close();
        int line = 0;
        myReadr = new Scanner(myFile);
        while (myReadr.hasNextLine()) {
            String myLine = myReadr.nextLine();
            for (int i = 0; i < myLine.length(); i++) {
                array[line][i] = myLine.charAt(i);
            }
            line++;
        }
        myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        // ==============check right =================
        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                // System.out.println("   Line " + i + " < " + lineCount); 
                // check right
                if ( (j + 3 < rowCount) && (i < lineCount ) ){
                    String str = "";
                    Point[] points = new Point[4] ;
                    // System.out.print("array"); 
                    for (int n = 0; n < 4; n++) {
                        str += array[i][j + n];
                        points[n] = new Point(i,j+n);
                        // System.out.print("[" + i + "," + ( j + n ) + "] " );            
                    }
                    // System.out.println(" -- > " + str ); 
                    if ( check(str) ) {
                        // System.out.println(" found -- > " + str + "at [" + points[0]+ "],["+ points[1]+ "],["+ points[2]+ "],["+ points[3]+ "]"); 
                        xmasPoints.add(new xmasPoints(points[0],points[1],points[2],points[3]));
                    }
                }
                 
            }
        }

        // =============  check down ===============================
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < lineCount; j++) {
                // System.out.println("   Line " + i + " < " + lineCount); 
                // check right
                if ( (j + 3 < lineCount) && (i < rowCount ) ){
                    String str = "";
                    Point[] points = new Point[4] ;
                    // System.out.print("array"); 
                    for (int n = 0; n < 4; n++) {
                        str += array[j+n][i];
                        points[n] = new Point(j+n,i);
                        // System.out.print("[" + ( j + n ) + "," + i + "]" );            
                    }
                    // System.out.println(" -- > " + str ); 
                    if ( check(str) ) {
                        // System.out.println(" found -- > " + str + "at [" + points[0]+ "],["+ points[1]+ "],["+ points[2]+ "],["+ points[3]+ "]"); 
                        xmasPoints.add(new xmasPoints(points[0],points[1],points[2],points[3]));
                    }
                }
            }
        }

        // ==============  check righ diagnoal  ===============
        for (int i = 0; i < lineCount; i++) {
            for (int j = 0; j < rowCount; j++) {
                // System.out.println("   Line " + i + " < " + lineCount); 
                // check right
                if ( (j + 3 < rowCount) && (i + 3 < lineCount ) ){
                    String str = "";
                    Point[] points = new Point[4] ;
                    // System.out.print("array"); 
                    for (int n = 0; n < 4; n++) {
                        str += array[i + n][j + n];
                        points[n] = new Point(i+n,j+n);
                        // System.out.print("[" + (i + n) + "," + ( j + n ) + "] " );            
                    }
                    // System.out.println(" -- > " + str ); 
                    if ( check(str) ) {
                        // System.out.println(" found -- > " + str + "at [" + points[0]+ "],["+ points[1]+ "],["+ points[2]+ "],["+ points[3]+ "]"); 
                        xmasPoints.add(new xmasPoints(points[0],points[1],points[2],points[3]));
                    }
                }
                 
            }
        }     
        // =============== check left diagonal ===============
        for (int i = 0; i < lineCount - 3; i++) {
            for (int j = 0; j < rowCount; j++) {
                // System.out.println("   Line " + i + " < " + lineCount); 
                // check right
                if ( (j > 2) && (i < lineCount -3 ) ){
                    String str = "";
                    Point[] points = new Point[4] ;
                    System.out.print("array"); 
                    //  // 0,4 1,3 , 2,2, 3,1 
                    for (int n = 0; n < 4; n++) {
                        str += array[i + n][j - n];
                        points[n] = new Point(i+n,j-n);
                        System.out.print("[" + (i + n) + "," + ( j - n ) + "] " );            
                    }
                    System.out.println(" -- > " + str ); 
                    if ( check(str) ) {
                        // System.out.println(" found -- > " + str + "at [" + points[0]+ "],["+ points[1]+ "],["+ points[2]+ "],["+ points[3]+ "]"); 
                        xmasPoints.add(new xmasPoints(points[0],points[1],points[2],points[3]));
                    }
                }
                    
            }
        }   

        System.out.println("------------right down , right diagnoal completed --------total found " + xmasPoints.size() + " XMAS");

        print(array,xmasPoints);
        // =====================================
        }
        private static void print(char[][] array,List<xmasPoints> xmasPoints) {
            int line = array.length;
            int row = array[0].length;
            char printArray[][] = new char[line][row];
            for(int i = 0 ; i < line ; i++ ) {
                for ( int j=0 ; j< row ; j++ ) {
                    printArray[i][j]= '.';
                }
            }
            
                String str = xmasPoints.toString();
                str = str.replace('[', ' ');
                str = str.replace(']', ' ');
                str = str.trim();
                String[] sub_str = str.split(",") ;
                for ( int i = 0 ; i < sub_str.length-1 ;   ) {
                    int target_line = Integer.parseInt(sub_str[i].trim());  
                    int target_row =Integer.parseInt(sub_str[i+1].trim()); 
                    printArray[target_line][target_row] = array[target_line][target_row];
                    i +=2;
                    // System.out.println(sub_str[i].trim());
                }

          


            // System.out.println("total xmas found are : " + xmasPoints.size());
            // System.out.println(xmasPoints);
            // System.out.println(xmasPoints.get(0));
            // System.out.println(xmasPoints.get(0).x1);
            // System.out.println(xmasPoints.get(0).x1.x);

            for(int i = 0 ; i < line ; i++ ) {
                for ( int j=0 ; j< row ; j++ ) {
                    System.out.print(printArray[i][j]);
                }
                System.out.println("");
            }
            System.out.println("the array size is " + line + "," + row);
        }
        
        private static Boolean check(String str) {
            if (str.equals("XMAS") || str.equals("SAMX")) {
                System.out.println("                             found :" + str);
                return true;
            } else
                return false;
        }

        public static class Point {
            private int x;
            private int y;

            @Override
            public String toString() {
                return x + "," + y;
            }

            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
            // Getters and setters
        }

        public static class xmasPoints {
        private Point x1;
        private Point x2;
        private Point x3;
        private Point x4;
    
        @Override
        public String toString() {
            return "[" + x1 + "],[" + x2 + "],[" + x3 + "],[" + x4 + "]";
        }

        public xmasPoints(Point x1, Point x2,Point x3,Point x4) {
            this.x1 = x1;
            this.x2 = x2;
            this.x3 = x3;
            this.x4 = x4;
        }
        // Getters and setters
    }

}


//    advent Calende submission : total XMAS found : 2591    answer is correct