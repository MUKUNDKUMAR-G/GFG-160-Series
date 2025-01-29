import java.util.Scanner;

class Solution {
    double power(double b, int e) {
        // Base case: anything raised to power 0 is 1
        if (e == 0) return 1.0;

        // Handle negative exponent
        if (e < 0) {
            b = 1 / b;
            e = -e; // Convert e to positive for easier calculation
        }

        // Recursively calculate half power
        double halfPower = power(b, e / 2);

        // If exponent is even: multiply halfPower by itself
        if (e % 2 == 0) {
            return halfPower * halfPower;
        }
        // If exponent is odd: multiply halfPower by itself and one more b
        else {
            return halfPower * halfPower * b;
        }
    }

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter base (b): ");
            double b = scanner.nextDouble();
            System.out.print("Enter exponent (e): ");
            int e = scanner.nextInt();
    
            Solution sol = new Solution();
            System.out.println("Recursive Power: " + sol.power(b, e));
            System.out.println("Built-in Power: " + sol.powerBuiltIn(b, e));
        }
}