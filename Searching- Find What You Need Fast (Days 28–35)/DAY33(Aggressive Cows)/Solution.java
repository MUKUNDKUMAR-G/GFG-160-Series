import java.util.Arrays;
import java.util.Scanner;

class Solution {

    // Helper function to check if we can place cows with minimum distance 'dist'
    private static boolean canPlaceCows(int[] stalls, int k, int dist) {
        int cowsPlaced = 1; // Place the first cow in the first stall
        int lastPosition = stalls[0]; // Last placed cow position

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPosition >= dist) {
                cowsPlaced++;
                lastPosition = stalls[i]; // Update last position
            }

            if (cowsPlaced >= k) { // All cows placed successfully
                return true;
            }
        }

        return false;
    }

    // Function to find the maximum minimum distance
    public static int aggressiveCows(int[] stalls, int k) {
        Arrays.sort(stalls); // Step 1: Sort the stalls

        int low = 1; // Minimum possible distance
        int high = stalls[stalls.length - 1] - stalls[0]; // Maximum possible distance
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, k, mid)) {
                result = mid; // Update the result
                low = mid + 1; // Try for a larger distance
            } else {
                high = mid - 1; // Try for a smaller distance
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of stalls
        System.out.print("Enter the number of stalls: ");
        int n = scanner.nextInt();

        // Input stall positions
        int[] stalls = new int[n];
        System.out.println("Enter the positions of the stalls:");
        for (int i = 0; i < n; i++) {
            stalls[i] = scanner.nextInt();
        }

        // Input number of cows
        System.out.print("Enter the number of cows: ");
        int k = scanner.nextInt();

        // Call the function and display result
        int result = aggressiveCows(stalls, k);
        System.out.println("The largest minimum distance is: " + result);

        scanner.close();
    }
}
