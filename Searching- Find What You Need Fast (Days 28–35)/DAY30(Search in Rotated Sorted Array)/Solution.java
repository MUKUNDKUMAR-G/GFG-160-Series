import java.util.Scanner;

class Solution {
    // Function to search for the key in a rotated sorted array
    public int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the middle element is the key
            if (arr[mid] == key) {
                return mid;
            }

            // Check if the left subarray is sorted
            if (arr[low] <= arr[mid]) {
                // Check if the key lies in the sorted left subarray
                if (arr[low] <= key && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } 
            // Otherwise, the right subarray must be sorted
            else {
                // Check if the key lies in the sorted right subarray
                if (arr[mid] < key && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // If the key is not found
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Read the array elements from the user
        int[] arr = new int[n];
        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Prompt the user for the key
        System.out.print("Enter the key to search for: ");
        int key = scanner.nextInt();

        // Create an instance of the solution class and search for the key
        Solution solution = new Solution();
        int index = solution.search(arr, key);

        // Output the result
        if (index != -1) {
            System.out.println("The key " + key + " is found at index " + index + ".");
        } else {
            System.out.println("The key " + key + " is not found in the array.");
        }

        scanner.close();
    }
}
