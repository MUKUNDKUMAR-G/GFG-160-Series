class Solution {
    // Function to solve Sudoku
    static boolean solveSudoku(int[][] mat) {
        return solve(mat, 0, 0);
    }

    // Recursive function to solve Sudoku using backtracking
    private static boolean solve(int[][] mat, int row, int col) {
        if (row == 9) return true;

        if (col == 9) return solve(mat, row + 1, 0);

        // Skip already filled cells
        if (mat[row][col] != 0) return solve(mat, row, col + 1);

        for (int num = 1; num <= 9; num++) {
            if (isValid(mat, row, col, num)) {
                mat[row][col] = num;
                if (solve(mat, row, col + 1)) return true;
                mat[row][col] = 0;
            }
        }

        return false; // No valid placement found
    }

    // Check if placing a number is valid
    private static boolean isValid(int[][] mat, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (mat[row][i] == num || mat[i][col] == num) return false;
        }

        int subRowStart = (row / 3) * 3;
        int subColStart = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mat[subRowStart + i][subColStart + j] == num) return false;
            }
        }

        return true;
    }

    static void printSudoku(int[][] mat) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int[][] mat = new int[9][9];

        System.out.println("Enter the 9×9 Sudoku grid (use 0 for empty cells):");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        if (solveSudoku(mat)) {
            System.out.println("Solved Sudoku:");
            printSudoku(mat);
        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}