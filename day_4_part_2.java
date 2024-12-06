import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day_4_part_2 {
    public static void main(String[] args) {

        char array[][];

        List<xmasPoints> xmasPoints = new ArrayList<>();
        String fileName = "inputs/day_4.txt";
        // fileName = "inputs/test.txt";
        String xmas = "MAS";
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
        // ==============check search for word A =================
        for (int i = 1; i < lineCount -1 ; i++) {
            for (int j = 1; j < rowCount -1 ; j++) {
                // System.out.println("   Line " + i + " < " + lineCount); 
                // check right
                if(array[i][j] == 'A') {
                    Point[] points = new Point[5] ;

                    points[0] = new Point(i-1, j-1);
                    points[1] = new Point(i-1, j+1);
                    points[2] = new Point(i, j);
                    points[3] = new Point(i+1, j-1);
                    points[4] = new Point(i+1, j+1);

                    String str1 = array[i-1][j-1] + "A" + array[i+1][j+1];
                    String str2 = array[i-1][j+1] + "A" + array[i+1][j-1];
                    if(check(str1) && check(str2)) {
                        // System.out.println(" found -- > " + str1 + str2 + "at [" + points[0]+ "],["+ points[1]+ "],["+ points[2]+ "],["+ points[3]+ "],["+ points[4] + "]"); 
                        xmasPoints.add(new xmasPoints(points[0],points[1],points[2],points[3],points[4]));
                    }
                }
            }
        }

        System.out.println("------------completed --------total found " + xmasPoints.size() + " X-MAS");

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
            if (str.equals("MAS") || str.equals("SAM")) {
                // System.out.println("                             found :" + str);
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
        private Point x5;
    
        @Override
        public String toString() {
            return "[" + x1 + "],[" + x2 + "],[" + x3 + "],[" + x4 + "],[" + x5 + "]";
        }

        public xmasPoints(Point x1, Point x2,Point x3,Point x4,Point x5) {
            this.x1 = x1;
            this.x2 = x2;
            this.x3 = x3;
            this.x4 = x4;
            this.x5 = x5;
        }
        // Getters and setters
    }

}


//    advent Calende submission : total XMAS found : 2591    answer is correct

//  advent calende day4 part2 submit :  total 1880 X-MAS     answer is correct