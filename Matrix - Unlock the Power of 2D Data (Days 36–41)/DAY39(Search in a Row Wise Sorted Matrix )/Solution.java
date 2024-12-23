import java.util.Scanner;

class Solution {

    // Function to search a given number in a row-wise sorted matrix
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns

        // Iterate through each row
        for (int i = 0; i < n; i++) {
            // Apply binary search on the current row
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (mat[i][mid] == x) {
                    return true; // Element found
                } else if (mat[i][mid] < x) {
                    low = mid + 1; // Search in the right half
                } else {
                    high = mid - 1; // Search in the left half
                }
            }
        }

        return false; // Element not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of rows and columns
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = scanner.nextInt();

        // Input the matrix elements
        int[][] mat = new int[n][m];
        System.out.println("Enter the elements of the matrix (row-wise sorted):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        // Input the target value to search
        System.out.print("Enter the number to search: ");
        int x = scanner.nextInt();

        // Create an instance of Solution and search for the element
        Solution solution = new Solution();
        boolean result = solution.searchRowMatrix(mat, x);

        // Print the result
        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        scanner.close();
    }
}
