class Solution {
    // Directions: [Right, Left, Down, Up]
    private static final int[] dX = {0, 0, 1, -1};
    private static final int[] dY = {1, -1, 0, 0};

    static public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    if (dfs(mat, word, 0, i, j, n, m)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] mat, String word, int index, int x, int y, int n, int m) {
        if (index == word.length()) return true;

        if (x < 0 || x >= n || y < 0 || y >= m || mat[x][y] != word.charAt(index)) {
            return false;
        }

        char temp = mat[x][y];
        mat[x][y] = '#'; 

        for (int d = 0; d < 4; d++) {
            int newX = x + dX[d];
            int newY = y + dY[d];
            if (dfs(mat, word, index + 1, newX, newY, n, m)) {
                return true;
            }
        }

        mat[x][y] = temp;
        return false;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        System.out.println("Enter grid size (n, m):");
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] mat = new char[n][m];

        System.out.println("Enter the matrix:");
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                mat[i][j] = row.charAt(j);
            }
        }

        System.out.println("Enter the target word:");
        String word = sc.next();

        System.out.println("Word exists in matrix? " + isWordExist(mat, word));

        sc.close();
    }
}