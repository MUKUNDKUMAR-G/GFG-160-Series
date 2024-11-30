import java.util.HashMap;
import java.util.Scanner;

public class AnagramCheck {

    public static boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s2.toCharArray()) {
            if (!freq.containsKey(ch) || freq.get(ch) == 0) return false;
            freq.put(ch, freq.get(ch) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        // String s1 = scanner.nextLine();
        String s1 = scanner.nextLine().replaceAll("\\s", "").toLowerCase();

        System.out.print("Enter the second string: ");
        // String s2 = scanner.nextLine();
        String s2 = scanner.nextLine().replaceAll("\\s", "").toLowerCase();

        if (areAnagrams(s1, s2)) {
            System.out.println("The strings are anagrams.");
        } else {
            System.out.println("The strings are not anagrams.");
        }

        scanner.close();
    }
}
