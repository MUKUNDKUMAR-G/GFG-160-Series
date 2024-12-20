/*
Input:
Enter the number of rows: 3  
Enter the number of columns: 4  
Enter the matrix elements:  
1 2 3 4  
5 6 7 8  
9 10 11 12      

Output:
Spiral Traversal of the Matrix:  
1 2 3 4 8 12 11 10 9 5 6 7
 */

import java.util.ArrayList;
import java.util.Scanner;

class Solution {

    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        ArrayList<Integer> result = new ArrayList<>();

        // Initialize boundaries
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        // Loop until boundaries overlap
        while (top <= bottom && left <= right) {

            // Traverse top row
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Traverse bottom row (if still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix dimensions
        System.out.print("Enter the number of rows: ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int m = scanner.nextInt();

        // Input matrix elements
        int[][] mat = new int[n][m];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        // Create instance and call function
        Solution solution = new Solution();
        ArrayList<Integer> spiralOrder = solution.spirallyTraverse(mat);

        // Print result
        System.out.println("Spiral Traversal of the Matrix:");
        for (int num : spiralOrder) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
