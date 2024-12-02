import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    // Function to find all occurrences of pat in txt using KMP algorithm.
    public static List<Integer> searchPattern(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        // Create LPS (Longest Prefix Suffix) array.
        int[] lps = computeLPSArray(pat, m);

        int i = 0, j = 0; // i for txt, j for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j);
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    // Helper function to compute the LPS array.
    private static int[] computeLPSArray(String pat, int m) {
        int[] lps = new int[m];
        int length = 0; 
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the text: ");
        String txt = scanner.nextLine();
        System.out.print("Enter the pattern: ");
        String pat = scanner.nextLine();

        List<Integer> indices = searchPattern(txt, pat);
        if (indices.isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.println(indices);
        }
        scanner.close();
    }
}
