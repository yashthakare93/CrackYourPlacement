package Day15;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    public static void printDuplicateCharacters(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + ", count = " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        String S = "geeksforgeeks";
        printDuplicateCharacters(S);
    }
}
