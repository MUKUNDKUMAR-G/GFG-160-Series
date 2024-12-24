import java.util.Scanner;

class Solution {

    // Function to search a number in a strictly sorted matrix
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;    
        int m = mat[0].length; 

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;   
            int row = mid / m;  
            int col = mid % m;

            if (mat[row][col] == x) {
                return true; // Element found
            } else if (mat[row][col] < x) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
            }
        }

        return false; // Element not found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = scanner.nextInt();

        int[][] mat = new int[n][m];
        System.out.println("Enter the elements of the matrix (strictly sorted):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        System.out.print("Enter the number to search: ");
        int x = scanner.nextInt();

        Solution solution = new Solution();
        boolean result = solution.searchMatrix(mat, x);

        if (result) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        scanner.close();
    }
}
