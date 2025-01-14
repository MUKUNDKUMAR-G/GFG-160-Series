import java.util.Scanner;

class Solution {
    public static int findEquilibrium(int[] arr) {
        int n = arr.length;

        if (n < 3) return -1;

        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Initialize leftSum to 0
        int leftSum = 0;

        // Step 3: Traverse the array and check for equilibrium
        for (int i = 0; i < n; i++) {
            // Right sum is total sum minus current element minus left sum
            totalSum -= arr[i];

            // Check if left sum equals right sum
            if (leftSum == totalSum) {
                return i;
            }

            // Update left sum
            leftSum += arr[i];
        }

        // Step 4: Return -1 if no equilibrium point found
        return -1;
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

        int result = findEquilibrium(arr);
        System.out.println("Equilibrium Point Index: " + result);

        scanner.close();
    }
}