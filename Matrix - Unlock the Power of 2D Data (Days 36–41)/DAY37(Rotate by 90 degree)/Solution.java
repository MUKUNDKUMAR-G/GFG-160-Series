// import java.io.IOException;
// import java.util.Scanner;

// public class Solution{

//     private static void rotateby90(int mat[][]) {
//         int n = mat.length;
        
//         //transpose the matrix
//         for(int i = 0; i < n; i++){
//             for(int j = i + 1; j < n; j++){
//                 int temp = mat[i][j];
//                 mat[i][j] = mat[j][i];
//                 mat[j][i] = temp;
//             }
//         }
        
//         int new_n = (n % 2 == 0) ? n - 1 : n - 2;
//         n = mat.length;
//         //Reverse
//         for(int i = 0; i < new_n; i++){
//             for(int j = 0;  j < n; j++){
//                 int temp = mat[i][j];
//                 mat[i][j] = mat[(n - i) - 1][j];
//                 mat[(n - i) - 1][j] = temp;
//             }
//         }
//     }

//     public static void main(String[] args) throws IOException{
//         Scanner input = new Scanner(System.in);
//         int n = input.nextInt();

//         int[][] matrix = new int[n][n];

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 matrix[i][j] = input.nextInt();
//             }
//         }

//         Solution obj = new Solution();
//         obj.rotateby90(matrix);

//         for(int i = 0; i < n; i++){
//             for(int j = 0; j < n; j++){
//                 System.out.printf("%-5d", matrix[i][j]);
//             }

//             System.out.println();
//         }
//     }
// }



import java.io.IOException;
import java.util.Scanner;

public class Solution {

    private static void rotateby90(int mat[][]) {
        int n = mat.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        // Step 2: Reverse each column for anti-clockwise rotation
        for (int j = 0; j < n; j++) {
            int top = 0, bottom = n - 1;
            while (top < bottom) {
                int temp = mat[top][j];
                mat[top][j] = mat[bottom][j];
                mat[bottom][j] = temp;
                top++;
                bottom--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the size of the matrix (n):");
        int n = input.nextInt();

        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = input.nextInt();
            }
        }

        // Rotate the matrix
        rotateby90(matrix);

        // Print the rotated matrix
        System.out.println("Rotated Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%-5d", matrix[i][j]);
            }
            System.out.println();
        }

        input.close();
    }
}
