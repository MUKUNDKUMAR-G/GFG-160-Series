import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int getMinDiff(int[] arr, int k) {
        int n = arr.length;
        if (n == 1) return 0;

        // Sort the array
        Arrays.sort(arr);

        // Initialize the result as the difference between max and min heights
        int result = arr[n - 1] - arr[0];

        // Traverse and calculate the minimized difference
        for (int i = 1; i < n; i++) {
            if (arr[i] - k < 0) continue;

            // Calculate new max and min heights after adjustments
            int max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
            int min = Math.min(arr[0] + k, arr[i] - k);

            // Update result if a smaller difference is found
            result = Math.min(result, max - min);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution sol = new Solution();

        // Take input for the array
        System.out.println("Enter the size of the array:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Take input for k
        System.out.println("Enter the value of k:");
        int k = scanner.nextInt();

        // Calculate and print the result
        int result = sol.getMinDiff(arr, k);
        System.out.println("Minimum difference: " + result);
    }
}
