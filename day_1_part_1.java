import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day_1_part_1 {
    public static void main(String[] args) {
        int current_elve = 0 ;

        try {
            File myFile = new File("inputs\\day_1.txt");
            Scanner myReadr = new Scanner(myFile);
            while(myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
//                System.out.println(myLine + " : " + getValues(myLine));
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
