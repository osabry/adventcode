import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class day_1_part_2 {

    static String[] myNumber = {"one", "two", "three","four","five", "six", "seven", "eight", "nine"};
    int[] myNumber_index = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public static void main(String[] args) {
        int current_elve = 0 ;
        try {
            File myFile = new File("inputs\\day_1_p2.txt");
//            File myFile = new File("inputs\\test.txt");
            Scanner myReadr = new Scanner(myFile);
            while(myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
//                System.out.println(myLine + " : " + getValues(myLine));
                System.out.print(myLine);


                    int[] num_index = getIndex(myLine);
                    System.out.print("[");
                    for (int j : num_index )  {
                        System.out.print("<" + j + ">");
                    }
                    System.out.print("]");

                    int first_index = 1000000;
                    int last_index = -1;
                    int needToreplace_first = -1 ,needToreplace_last = -1;
                    for(int i = 0 ; i < num_index.length ; i++ ) {
                        if (num_index[i] >= 0 ) {
                            if (num_index[i] < first_index ) {
                                first_index = num_index[i];
                                needToreplace_first = i;
                            }
                            if (num_index[i] > last_index ) {
                                last_index = num_index[i];
                                needToreplace_last = i;
                            }
                        }
                    }

                    if(needToreplace_last != -1 && needToreplace_first != -1 ) {
                        myLine = myLine.replace(myNumber[needToreplace_first],Integer.toString(needToreplace_first+1));
                        myLine = myLine.replace(myNumber[needToreplace_last],Integer.toString(needToreplace_last+1));
                    }



                 System.out.println("  after replace : " + myLine + " : " + getValues(myLine));
                 current_elve += getValues(myLine);

            }
            myReadr.close();
            System.out.println("The answer is : " + current_elve);

        }
        catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();

        }

    }

    private static boolean myLineHasNumber(String myLine) {

        for ( int i= 0 ; i < myNumber.length ; i++) {
            if(myLine.contains(myNumber[i])) {
                return true;
            }
        }
        return false;

    }

    private static int[] getIndex(String myLine) {
        int[] myNumber_index = {-1,-1,-1,-1,-1,-1,-1,-1,-1};
        for ( int i= 0 ; i < myNumber.length ; i++) {
            if(myLine.contains(myNumber[i])) {
                myNumber_index[i] = myLine.indexOf(myNumber[i]);
            }
        }
        return myNumber_index;
    }

    private static Integer getValues(String myLine) {
        int result = 0;
        for ( int i = 0 ; i < myLine.length(); i++) {
            if( Character.isDigit(myLine.charAt(i))) {
                result = 10 * Character.getNumericValue(myLine.charAt(i));
                break;
            }
        }
        for ( int i = myLine.length()-1 ; i > -1 ; i--) {
            if( Character.isDigit(myLine.charAt(i))) {
                result +=  Character.getNumericValue(myLine.charAt(i));
                break;
            }
        }
        return result;
    }
}
