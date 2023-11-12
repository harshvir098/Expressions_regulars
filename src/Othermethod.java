import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Othermethod {
    public static void main(String[] args) {
        String filePath = "santako.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                int santaCount = countOccurrences(line, "*<]:-DOo");
                int reindeerCount = countOccurrences(line, ">:o)");
                int elfCount = countOccurrences(line, "<]:-D");

                if (santaCount > 0 || reindeerCount > 0 || elfCount > 0) {
                    if (santaCount > 0) {
                        System.out.print("Santa Claus(" + santaCount + ") ");
                    }

                    if (reindeerCount > 0) {
                        System.out.print("Reindeer(" + reindeerCount + ") ");
                    }

                    if (elfCount > 0) {
                        System.out.print("Elves(" + elfCount + ")");
                    }

                    System.out.println();
                } else {
                    System.out.println();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countOccurrences(String line, String patternStr) {
        int count = 0;
        int index = line.indexOf(patternStr);

        while (index != -1) {
            count++;
            index = line.indexOf(patternStr, index + 1);
        }

        return count;
    }
}
