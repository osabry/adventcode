import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class day_1_part_2 {
    public static void main(String[] args) {

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        long totalSimilarity = 0;

        try {
            File myFile = new File("inputs/day_1.txt");
            // File myFile = new File("inputs/test.txt");
            Scanner myReadr = new Scanner(myFile);
            while (myReadr.hasNextLine()) {
                String myLine = myReadr.nextLine();
                String[] a = myLine.split("   ");
                left.add(Integer.parseInt(a[0]));
                right.add(Integer.parseInt(a[1]));
            }
            myReadr.close();

            // System.out.println("The answer is : " + left.size());
            // System.out.println("The answer is : " + right.size());

        } catch (FileNotFoundException e) {
            System.out.println("An erro happened !! ");
            e.printStackTrace();

        }

        // left.sort(null);right.sort(null);

        for (int i = 0; i < left.size(); i++) {
            int item = left.get(i);
            int frequency = 0;
            for (int j = 0; j < right.size(); j++) {
                if (item == right.get(j))
                    frequency++;
            }

            totalSimilarity += item * frequency;
            System.out.println("the " + item + "  appears  " + frequency + " times  , " + totalSimilarity);

        }

        System.out.println(" total similarity score is " + totalSimilarity);

        //
        // total similarity is 26593248

    }

}
