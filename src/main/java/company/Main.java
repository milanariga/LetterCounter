package company;

import org.apache.commons.math3.util.Precision;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class Main {
    private static int totalCount = 0;

    public static void main(String[] args) {
        String path;
        if (args.length < 1) {
            System.out.println("No arg found, using file in resource folder");
            path = "src/main/resources/sample.txt";
        } else path = args[0];
        HashMap<Character, Integer> characters = new HashMap<>();
        try {
            characters = readFile(path);
        } catch (IOException e) {
            System.out.println("File : " + path + " not found");
            System.exit(1);
        }
        printResult(characters, totalCount);
    }

    public static HashMap<Character, Integer> readFile(String path) throws IOException {
        HashMap<Character, Integer> characters = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(path));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            } else {
                char[] chars = line.toLowerCase().toCharArray();
                for (char c : chars) {
                    if (Character.isLetter(c)) {
                        totalCount++;
                        if (characters.containsKey(c)) {
                            Integer count = characters.get(c) + 1;
                            characters.put(c, count);
                        } else {
                            characters.put(c, 1);
                        }
                    }
                }
            }
        }
        return characters;
    }

    public static void printResult(HashMap<Character, Integer> set, Integer totalCount) {
        set.forEach((x, y) -> {
            Double aDouble = Double.valueOf(y);
            double ratio = (aDouble / totalCount) * 100;
            double roundedRatio = Precision.round(ratio, 2);
            System.out.println("Character " + x + ": " + y +
                    " - " + roundedRatio + "% of all text");
        });
    }

}
