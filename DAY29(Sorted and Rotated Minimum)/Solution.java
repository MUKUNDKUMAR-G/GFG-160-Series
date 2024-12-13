/*
Input : 

Enter the size of the array:
6
Enter the array elements:
5 6 1 2 3 4

Output:
The minimum element in the array is: 1
 */

import java.util.Scanner;

class Solution {
    // Function to find the minimum element in a sorted and rotated array
    public int findMin(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // If mid element is less than the last element, the minimum is in the left part
            if (arr[mid] < arr[end]) {
                end = mid;
            }
            // If mid element is greater than the last element, the minimum is in the right part
            else if (arr[mid] > arr[end]) {
                start = mid + 1;
            }
            // When elements are equal, reduce the search space
            else {
                end--;
            }
        }

        return arr[start];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Scanner sc = new Scanner(System.in);

        // Input the size of the array
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid array size.");
            return;
        }

        // Input the array elements
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call the function and display the result
        int minElement = solution.findMin(arr);
        System.out.println("The minimum element in the array is: " + minElement);

        sc.close();
    }
}
