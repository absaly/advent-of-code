import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class B {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        fillHashMap(map);
        String filePath = "day1Java/Resources/CalibrationValues.txt";
        int sum = 0;
        LinkedList<String> linkedList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int num1;
            int num2;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                Pattern p = Pattern.compile("1|2|3|4|5|6|7|8|9|one|two|three|four|five|six|seven|eight|nine");
                Matcher m = p.matcher(line);
                while (m.find()) {
                    linkedList.add(m.group());
                }
                //System.out.println(linkedList.getFirst() + ", " + linkedList.getLast());
                String first = linkedList.getFirst();
                String last = linkedList.getLast();
                if (map.containsKey(first)) {
                    num1 = Integer.parseInt(map.get(first));
                } else {
                    num1 = Integer.parseInt(first);
                }

                if (map.containsKey(last)) {
                    num2 = Integer.parseInt(map.get(last));
                } else {
                    num2 = Integer.parseInt(last);
                }
                int cval = num1 * 10 + num2;
                System.out.println(num1 + ", " + num2 + " CVal: " + cval);
                sum += cval;
                linkedList.clear();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println(sum);
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
