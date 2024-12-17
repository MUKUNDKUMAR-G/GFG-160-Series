/*
Input : 

Enter the size of the array: 7
Enter the elements of the array:
1 2 4 5 7 8 3

Output:
Peak found at index: 5, value: 8
 */

import java.util.Scanner;

class Solution {

    public int peakElement(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if the peak is on the right or left
            if (arr[mid] <= arr[mid + 1]) {
                low = mid + 1; // Peak must be to the right
            } else {
                high = mid; // Peak is at mid or to the left
            }
        }

        return low; // Low will point to a peak element
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        Solution solution = new Solution();

        int peakIndex = solution.peakElement(arr);

        System.out.println("Peak found at index: " + peakIndex + ", value: " + arr[peakIndex]);

        scanner.close();
    }
}
