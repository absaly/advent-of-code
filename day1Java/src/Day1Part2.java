import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Day1Part2 {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        fillHashMap(map);
        String filePath = "day1/Resources/CalibrationValues.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int num1 = -1;
            int num2 = -1;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                for (int i = 0; i < line.length(); i++) {
                    for (int j = i; j < line.length(); j++) {
                        if (map.containsKey(line.substring(i, j)) || map.containsValue(String.valueOf(line.charAt(j)))) {
                            System.out.println(line.substring(i,j) + " " + line.charAt(j));
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

    }

    private static void fillHashMap(HashMap<String, String> map) {
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four" , "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine", "9");
    }
}
