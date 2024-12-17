public class Solution {
    public static int minChar(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reverse;
        int[] lps = computeLPSArray(combined);

        return s.length() - lps[combined.length() - 1];
    }

    private static int[] computeLPSArray(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int length = 0, i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(length)) {
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
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        System.out.println("Minimum characters to add: " + minChar(input));
        scanner.close();
    }
}
