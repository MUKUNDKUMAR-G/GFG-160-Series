import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static int hIndex(int[] citations) {
        // Step 1: Sort the citations array in descending order
        Arrays.sort(citations);
        int n = citations.length;

        // Step 2: Iterate through the sorted array
        for (int i = 0; i < n; i++) {
            int h = n - i; // Calculate the current H value
            if (citations[i] >= h) {
                return h; // Found the maximum H-index
            }
        }

        // Step 3: If no valid H-index is found, return 0
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the number of papers: ");
        int n = scanner.nextInt();
        int[] citations = new int[n];

        System.out.println("Enter the citations for each paper:");
        for (int i = 0; i < n; i++) {
            citations[i] = scanner.nextInt();
        }

        // Calculate and display the H-index
        int hIndex = hIndex(citations);
        System.out.println("The H-index is: " + hIndex);
    }
}
