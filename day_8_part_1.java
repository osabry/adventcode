import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class day_8_part_1 {

    public static void main(String[] args) {


        String fileName = "inputs/day_8.txt";
        fileName = "inputs/day_8_part_1_test.txt";

        String mapData = readMapFromFile(fileName);
        if (mapData != null) {
            int result = findAntinodePositions(mapData);
            System.out.println("The number of unique locations containing an antinode is " + result + ".");
        } else {
            System.out.println("Failed to read the map data from the file.");
        }
    }

    public static String readMapFromFile(String filename) {
        StringBuilder mapData = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                mapData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return mapData.toString().trim();
    }

    public static int findAntinodePositions(String mapData) {
        String[] rows = mapData.split("\n");
        Set<String> antinodes = new HashSet<>();
        int numRows = rows.length;
        int numCols = rows[0].length();

        // Collect positions of all antennas
        for (int r1 = 0; r1 < numRows; r1++) {
            for (int c1 = 0; c1 < numCols; c1++) {
                char freq1 = rows[r1].charAt(c1);
                if (freq1 != '.') {
                    for (int r2 = r1; r2 < numRows; r2++) {
                        for (int c2 = (r2 == r1 ? c1 + 1 : 0); c2 < numCols; c2++) {
                            char freq2 = rows[r2].charAt(c2);
                            if (freq1 == freq2) {
                                if ((r2 - r1) % 2 == 0 && (c2 - c1) % 2 == 0) {
                                    int midR = (r1 + r2) / 2;
                                    int midC = (c1 + c2) / 2;
                                    antinodes.add(midR + "," + midC);

                                    int antinodeR1 = r1 - (r2 - r1) / 2;
                                    int antinodeC1 = c1 - (c2 - c1) / 2;
                                    int antinodeR2 = r2 + (r2 - r1) / 2;
                                    int antinodeC2 = c2 + (c2 - c1) / 2;

                                    if (0 <= antinodeR1 && antinodeR1 < numRows && 0 <= antinodeC1 && antinodeC1 < numCols) {
                                        antinodes.add(antinodeR1 + "," + antinodeC1);
                                    }
                                    if (0 <= antinodeR2 && antinodeR2 < numRows && 0 <= antinodeC2 && antinodeC2 < numCols) {
                                        antinodes.add(antinodeR2 + "," + antinodeC2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return antinodes.size();
    }
}