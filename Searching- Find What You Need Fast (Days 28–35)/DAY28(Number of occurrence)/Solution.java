/*
Input:

Enter the size of the array: 7
Enter the elements of the sorted array:
1 1 2 2 2 2 3
Enter the target value: 2

Output:

Occurrences of 2: 4
 */

import java.util.Scanner;

class Solution {

    // Binary search for the first occurrence of the target
    private static int findFirstOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid; // Possible first occurrence
                right = mid - 1; // Move left to find earlier occurrences
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Binary search for the last occurrence of the target
    private static int findLastOccurrence(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                result = mid; // Possible last occurrence
                left = mid + 1; // Move right to find later occurrences
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    // Function to count the frequency of the target in the array
    public int countFreq(int[] arr, int target) {

        /* //Linear Approach(O(n))
            int targetOcc = 0;

            for(int num : arr){
                if(num == target){
                    targetOcc += 1;
                }

                //This statement is necessary to include or else the time complexity will be O(n) neither than O(log n)
                if(num > target){
                    break;
                }
            }
        */
        int first = findFirstOccurrence(arr, target);

        // If target is not found
        if (first == -1) {
            return 0; // Target does not exist
        }

        int last = findLastOccurrence(arr, target);

        // Return the count
        return (last - first) + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Read the sorted array from the user
        int[] arr = new int[n];
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Read the target value from the user
        System.out.print("Enter the target value: ");
        int target = scanner.nextInt();

        // Calculate the number of occurrences of the target
        Solution solution = new Solution();
        int occurrences = solution.countFreq(arr, target);

        // Print the result
        System.out.println("Occurrences of " + target + ": " + occurrences);

        scanner.close();
    }
}
