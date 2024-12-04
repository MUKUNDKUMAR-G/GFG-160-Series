import java.util.Scanner;

class Solution {
    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String concatenated = s1 + s1;
        return kmpSearch(concatenated, s2);
    }

    private static boolean kmpSearch(String text, String pattern) {
        int[] lps = buildLPS(pattern);
        int i = 0, j = 0;

        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++; j++;
                if (j == pattern.length()) return true;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                i++;
            }
        }
        return false;
    }

    private static int[] buildLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int j = 0, i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[i++] = ++j;
            } else if (j > 0) {
                j = lps[j - 1];
            } else {
                lps[i++] = 0;
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        boolean result = areRotations(s1, s2);
        System.out.println("Are the strings rotations of each other? " + result);
    }
}
