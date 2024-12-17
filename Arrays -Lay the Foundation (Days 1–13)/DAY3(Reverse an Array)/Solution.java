import java.util.Scanner;

class Solution {
    // Function to reverse an array in-place
    private static void reverseArray(int[] arr) {
        int n = arr.length;
        int start = 0, end = n - 1;
        while (start < end) {
            // Swap elements at start and end
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Main function to demonstrate
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input size of the array
        System.out.print("Enter the size of the array: ");
        int n = input.nextInt();

        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        // Call reverseArray function
        reverseArray(arr);

        // Output the reversed array
        System.out.println("Reversed array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
