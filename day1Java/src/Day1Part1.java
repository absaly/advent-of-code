import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day1Part1 {
    public static void main(String[] args) {
        int sum = 0;
        String filePath = "day1/Resources/CalibrationValues.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int num1 = 0;
            int num2 = 0;
            while ((line = reader.readLine()) != null) {
                char[] lineChar = line.toCharArray();
                //System.out.println(line);
                for (char c : lineChar) {
                    if (Character.isDigit(c)) {
                        num1 = c - 48;
                        break;
                    }
                }

                for (int j = lineChar.length - 1; j >= 0; j--) {
                    if (Character.isDigit(lineChar[j])) {
                        num2 = lineChar[j] - 48;
                        break;
                    }
                }

                sum += num1 * 10 + num2;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(sum);
    }
}