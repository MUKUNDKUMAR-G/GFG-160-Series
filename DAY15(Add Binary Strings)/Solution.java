import java.util.Scanner;

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = s1.length() - 1;
        int j = s2.length() - 1;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? s1.charAt(i--) - '0' : 0;
            int bit2 = (j >= 0) ? s2.charAt(j--) - '0' : 0;
            int sum = bit1 + bit2 + carry;

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString().replaceFirst("^0+(?!$)", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first binary string:");
        String s1 = sc.nextLine();
        System.out.println("Enter second binary string:");
        String s2 = sc.nextLine();

        Solution sol = new Solution();
        String output = sol.addBinary(s1, s2);

        System.out.println("Resultant binary string: " + output);
        sc.close();
    }
}
