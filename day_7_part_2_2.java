import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day_7_part_2_2 {

    static long totla_sum = 0 ; 

    public static void main(String[] args) {


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

                    int[] numbers = new int[myNums_str.length];
                    for (int i = 0; i < myNums_str.length; i++) {
                        numbers[i] = Integer.parseInt(myNums_str[i]);
                    }
                    // myPrint(myNums_str.length);

                    if (isValidEquation(current_result, numbers)) {
                        totla_sum += current_result;
                    }
            }
            myReadr.close();
        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();
        }


        System.out.println("------------total sum of calibrated : " + totla_sum);

    }

    public static boolean isValidEquation(long target, int[] numbers) {
        String[] operators = {"+", "*","||"};
        return checkCombinations(target, numbers, operators, 0, numbers[0]);
    }

    public static boolean checkCombinations(long target, int[] numbers, String[] operators, int index, long nextValue2) {
            long nextValue = 0 ; 
            if (index == numbers.length - 1) {
                return nextValue2 == target;
            }
            for (String operator : operators) {
                if(operator.equals("+") ) {
                    nextValue = nextValue2 + numbers[index + 1] ;
                } else if (operator.equals("*")) {
                    nextValue = nextValue2 * numbers[index + 1] ;
                } else {
                    // System.out.print("                 found | operation , " + result );
                    String ss = "" + nextValue2 + "" + numbers[index + 1];
                nextValue = Long.parseLong(ss);
            }

            if (checkCombinations(target, numbers, operators, index + 1, nextValue)) {
                return true;
            }
        }
        return false;
    }
}

// day 7 part_1  ------------total sum of calibrated : 58657412504    answer not correct 
// day 7 part_1  ------------total sum of calibrated : 7885693428401   that is the right answer !!

// Day 7  part_2 , ------------total sum of calibrated : 8791878552204    not correct !
// day 7 part 2 ------------total sum of calibrated : 348360680516005   answer is correct ! used the day_7_part_2_2 
