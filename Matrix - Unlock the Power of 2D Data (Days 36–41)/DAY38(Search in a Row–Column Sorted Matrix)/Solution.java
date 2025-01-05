import java.util.Arrays;
import java.util.Scanner;
class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns

        // Start from the top-right corner
        int row = 0, col = m - 1;

        while (row < n && col >= 0) {
            if (mat[row][col] == x) {
                return true; // Element found
            } else if (mat[row][col] > x) {
                col--; // Move left
            } else {
                row++; // Move down
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