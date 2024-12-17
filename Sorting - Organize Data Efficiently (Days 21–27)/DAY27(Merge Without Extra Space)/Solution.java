/*
Input:

Enter the size of array a: 4
Enter elements of array a (sorted): 
2 4 7 10
Enter the size of array b: 2
Enter elements of array b (sorted): 
2 3

Output:

Array a after merge: [2, 2, 3, 4]
Array b after merge: [7, 10]
*/


import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public void mergeArrays(int a[], int b[]) {
        int n = a.length;
        int m = b.length;

        // Step 1: Swap elements between a[] and b[]
        for (int i = n - 1, j = 0; i >= 0 && j < m; i--, j++) {
            if (a[i] > b[j]) {
                // Swap elements
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
            }
        }

        // Step 2: Sort both arrays
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for size of arrays
        System.out.print("Enter the size of array a: ");
        int n = scanner.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements of array a (sorted): ");
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.print("Enter the size of array b: ");
        int m = scanner.nextInt();
        int[] b = new int[m];
        System.out.println("Enter elements of array b (sorted): ");
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        // Merge the arrays without extra space
        Solution solution = new Solution();
        solution.mergeArrays(a, b);

        // Print the result
        System.out.println("Array a after merge: " + Arrays.toString(a));
        System.out.println("Array b after merge: " + Arrays.toString(b));

        scanner.close();
    }
}
