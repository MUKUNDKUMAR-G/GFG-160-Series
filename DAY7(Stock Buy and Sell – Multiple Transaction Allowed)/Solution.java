import java.util.Scanner;

class Solution {
    public static int maximumProfit(int prices[]) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of days:");
        int n = sc.nextInt();
        int[] prices = new int[n];
        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }
        int profit = maximumProfit(prices);
        System.out.println("Maximum Profit: " + profit);
    }
}
