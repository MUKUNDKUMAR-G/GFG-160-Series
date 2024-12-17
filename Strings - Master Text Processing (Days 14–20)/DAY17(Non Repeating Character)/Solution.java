import java.util.*;

public class Solution {
    // Function to find the first non-repeating character.
    static char nonRepeatingChar(String s) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        // Count the frequency of each character.
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with a frequency of 1.
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // Return '$' if no non-repeating character is found.
        return '$';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        char result = nonRepeatingChar(input);
        System.out.println(result == '$' ? "-1" : result);
        scanner.close();
    }
}
