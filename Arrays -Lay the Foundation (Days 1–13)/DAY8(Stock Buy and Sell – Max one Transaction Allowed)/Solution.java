import java.util.Scanner;

class Solution {
    public int maximumProfit(int[] prices) {
        // Initialize variables
        int lowPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        // Traverse the array
        for (int i = 0; i < prices.length; i++) {
            // Update the lowest price so far
            lowPrice = Math.min(lowPrice, prices[i]);

            // Calculate profit for current price
            int profit = prices[i] - lowPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        // Return the maximum profit
        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of prices array
        System.out.println("Enter the size of the prices array:");
        int n = scanner.nextInt();

        // Input prices array
        System.out.println("Enter the prices:");
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextInt();
        }

        // Output the maximum profit
        System.out.println("Maximum Profit: " + maxProfit(prices));
    }
}
