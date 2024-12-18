import java.util.Scanner;

class Solution {

    // Helper function to check if allocation is feasible
    private static boolean canAllocate(int[] arr, int k, int maxPages) {
        int studentCount = 1; // Start with the first student
        int currentPages = 0;

        for (int pages : arr) {
            if (currentPages + pages > maxPages) {
                studentCount++; // Assign to a new student
                currentPages = pages;

                if (studentCount > k) {
                    return false; // Too many students needed
                }
            } else {
                currentPages += pages;
            }
        }

        return true;
    }

    // Function to find the minimum possible maximum pages
    public static int findPages(int[] arr, int k) {
        if (arr.length < k) {
            return -1; // Not enough books for all students
        }

        int low = 0, high = 0;

        // Calculate the range for binary search
        for (int pages : arr) {
            low = Math.max(low, pages); // Largest book
            high += pages; // Total sum of pages
        }

        int result = -1;

        // Binary search to find the optimal maximum pages
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canAllocate(arr, k, mid)) {
                result = mid; // Update result
                high = mid - 1; // Try for a smaller maximum
            } else {
                low = mid + 1; // Try for a larger maximum
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();

        // Input the array elements
        int[] arr = new int[n];
        System.out.println("Enter the number of pages in each book:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input the number of students
        System.out.print("Enter the number of students: ");
        int k = scanner.nextInt();

        // Find and print the result
        int result = findPages(arr, k);
        System.out.println("The minimum possible maximum pages are: " + result);

        scanner.close();
    }
}
