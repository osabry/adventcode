import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day_7_part_1 {

    static long totla_sum = 0 ; 
        public static void main(String[] args) {
    
            // System.out.println(Long.MAX_VALUE);
    
            
    
            String fileName = "inputs/day_7.txt";
            // fileName = "inputs/day_7_part_1_test.txt";
    
            long current_result = 0;
            int count = 1 ;
          
            try {
                File myFile = new File(fileName);
                Scanner myReadr = new Scanner(myFile);
                
                while (myReadr.hasNextLine()) {
                    String myLine = myReadr.nextLine();
                    String[] myNums_str;
                    System.out.println("reading line : " + myLine  + " at : " + count++);
    
                    current_result = Long.parseLong(myLine.substring(0, myLine.indexOf(":")));
                    if ( Long.MAX_VALUE < current_result ) System.out.println("wow ......................");
                    String sss =  myLine.substring(myLine.indexOf(":") + 1 , myLine.length());
                    myNums_str = sss.trim().split(" ") ; 
                    myPrint(myNums_str.length);
                    totla_sum +=check(current_result, myNums_str) ;
                // System.out.println(myLine);
            }
            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }


        System.out.println("------------total sum of calibrated : " + totla_sum);
        
    }

             
    private static long check(long result, String[] myNums) {
        // Check each pair of pages against the rules
        int n = myNums.length;
        Long[] numbers = new Long[n];
        long size_of_operation = (long)Math.pow(2, n-1);
        System.out.println("check in proggress for " + result + ", array length " + n  + ", total operation to check  " + size_of_operation);
        for (int i = 0; i < n; i++) {
            numbers[i] = Long.parseLong(myNums[i]);
            // System.out.print(numbers[i]+" ") ;
        }
        // System.out.println("----------------") ;
        
        for (int i = 0; i < size_of_operation; i++) {
                String operations  = String.format("%"+ (n-1) + "s", Long.toBinaryString(i)).replace(" ","0");
                // long tmp = calculate(numbers,operations);
                // String tttt = operations.replaceAll("0", "+").replaceAll("1", "*");
                // String equeation = "" + numbers[0];
                // for ( int k = 1 ; k < numbers.length ; k++ ) {
                //     equeation +=  " " + tttt.charAt(k-1) + " " + numbers[k];
                // }
                // System.out.println(equeation + ((tmp==result)?" = ":" != ") + tmp + "    current sum = " + totla_sum) ;

                if( result == calculate(numbers,operations)) { 
                    // String tttt = operations.replaceAll("0", "+").replaceAll("1", "*");
                    // String equeation = "" + numbers[0];
                    // for ( int k = 1 ; k < numbers.length ; k++ ) {
                    //     equeation +=  " " + tttt.charAt(k-1) + " " + numbers[k];
                    // }
                    // System.out.println(equeation + " = " + result + "    current sum = " + totla_sum) ;
                    return result; }
                }
        return 0;
        }
                
    private static long calculate(Long[] numbers, String operations) {
                            long result = numbers[0] ; 
                            for ( int i = 1 ; i < numbers.length ; i ++ ) {
                                if(operations.charAt(i-1) == '0') { 
                                    result += numbers[i]; 
                                }
                                else {
                                    result *= numbers[i]; 
                            }
                        }
                        return result;
                    }
    private static void myPrint(int n) {

        int row = n-1;
        int line = (int)Math.pow(2, n-1);
        System.out.println("created matrix " + row + " x " + line);

        String[] operationMatrix = new String[line];
        for (int i = 0; i < line; i++) {
                operationMatrix[i]  = String.format("%"+ row + "s", Integer.toBinaryString(i)).replace(" ","0");  
                System.out.println(operationMatrix[i] +" "); 
            }
    }
}





///
/// 
///         String[][] operationMatrix = new String[n-1][n-1];
// for (int i = 0; i < n-1; i++) {
//     for ( int j = 0 ; j < n-1 ; j ++ ) {
//         operationMatrix[i][j]  = String.format("%"+ (n-1) + "s", Integer.toBinaryString(i+j)).replace(" ","0");  
//         System.out.print(operationMatrix[i][j] +" "); 

//         for(int h=0 ; h < )




//     }
//     System.out.println() ;
// }

//    advent Calende submission : total XMAS found : 2591    answer is correct

//  advent calende day4 part2 submit :  total 1880 X-MAS     answer is correct

//   Day_5 part 1 : Your puzzle answer was 6505.   is correct 
// total visited distance  5239 submission is correct 



// day 7 part_1  ------------total sum of calibrated : 58657412504    answer not correct 
// day 7 part_1  ------------total sum of calibrated : 7885693428401   that is the right answer !!