import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class day_6_part_1 {
    public static void main(String[] args) {

        int distance = 0;
        int start_x=0, start_y =0;
        String move_direction = "";

        char matrix[][];
        List<String> update = new ArrayList<>();

        String fileName = "inputs/day_6.txt";
        // fileName = "inputs/day_6_test.txt";

        long lineCount = 0;
        long rowcount = 0;

        try {
            File myFile = new File(fileName);
            Scanner myReadr = new Scanner(myFile);
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                if( rowcount == 0 ) rowcount = myFile.length();
                if(myLine.isEmpty()) break;
                lineCount++;
            }
            // System.out.println("first section line count is : " + lineCount);

            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }
        matrix = new char[((int)lineCount)][(int)rowcount];
        
        try {
            File myFile = new File(fileName);
            Scanner myReadr = new Scanner(myFile);
            int line = 0;
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                // System.out.println(myLine);
                if ( line< lineCount && !myLine.isEmpty() ) {
                   char[] a = myLine.toCharArray();
                   matrix[line] = a;
                   if(myLine.indexOf("^") >= 0 ) {
                    start_y = myLine.indexOf("^") ; start_x = line; move_direction = "up";
                   }
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

        System.err.println( "found ^ at " + start_x + "," + start_y );

        while (start_x < lineCount || start_y < rowcount ) {

            System.err.println( "start operation " + start_x + "," + start_y + move_direction);

            if( move_direction == "up" ) {
                matrix[start_x][start_y] = 'X';
                if(start_x == 0 ) break;  
                if(matrix[start_x-1][start_y] == '#') {
                    move_direction = "right";
                } else start_x--;
            } 
            if(move_direction == "right") {
                matrix[start_x][start_y] = 'X';
                if ( start_y == rowcount - 1) break;
                if(matrix[start_x][start_y+1] == '#') {
                    move_direction = "down";
                } else start_y++;
            } 
            if(move_direction == "down") {
                matrix[start_x][start_y] = 'X';
                if( start_x == lineCount - 1 ) break;
                if(matrix[start_x+1][start_y] == '#') {
                    move_direction = "left";
                } else start_x++;
            } 

            if(move_direction == "left") {
                matrix[start_x][start_y] = 'X';
                if( start_y == 0 ) break;
                if(matrix[start_x][start_y-1] == '#') {
                    move_direction = "up";
                } else start_y--;
            } 
        }


        for (int i = 0; i < matrix.length ; i++) {
            for ( int j = 0 ; j < matrix[i].length ; j++){
                if( matrix[i][j] == 'X' ) {
                    distance++;
                }
                System.out.print(matrix[i][j]);
            }
            System.out.println("");
        }

        System.out.println("------------total visited distance  " + distance);
        
    }

             
    // private static boolean checkOrder(int[] pages, int[][] rules) {
    //     // Check each pair of pages against the rules
    //     for (int i = 0; i < pages.length; i++) {
    //         for (int j = i + 1; j < pages.length; j++) {
    //             int page1 = pages[i];
    //             int page2 = pages[j];
                
    //             // Check if there's a rule requiring the opposite order
    //             for (int[] rule : rules) {
    //                 if (rule[0] == page2 && rule[1] == page1) {
    //                     // Found a rule violation - page2 should come before page1
    //                     return false;
    //                 }
    //             }
    //         }
    //     }
    //     return true;
    // }

}


//    advent Calende submission : total XMAS found : 2591    answer is correct

//  advent calende day4 part2 submit :  total 1880 X-MAS     answer is correct

//   Day_5 part 1 : Your puzzle answer was 6505.   is correct 

// total visited distance  5239 submission is correct 