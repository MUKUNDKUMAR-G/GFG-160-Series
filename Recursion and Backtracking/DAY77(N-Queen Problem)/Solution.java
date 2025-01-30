import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter the number of queens (n): ");
        int n = scanner.nextInt();

        // Solve the N-Queens problem
        ArrayList<ArrayList<Integer>> solutions = nQueen(n);

        // Print results
        if (solutions.isEmpty()) {
            System.out.println("No solutions exist for n = " + n);
        } else {
            System.out.println("Total solutions: " + solutions.size());
            for (ArrayList<Integer> solution : solutions) {
                System.out.println(solution);
            }
        }

        scanner.close();
    }

    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        backtrack(n, 0, new ArrayList<>(), results, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return results;
    }

    private static void backtrack(int n, int row, List<Integer> current, ArrayList<ArrayList<Integer>> results,
                                  Set<Integer> columns, Set<Integer> mainDiagonals, Set<Integer> antiDiagonals) {
        if (row == n) {
            results.add(new ArrayList<>(current));
            return;
        }

        for (int col = 0; col < n; col++) {
            int mainDiagonal = row - col;
            int antiDiagonal = row + col;

            // Check if the column or diagonals are already occupied
            if (columns.contains(col) || mainDiagonals.contains(mainDiagonal) || antiDiagonals.contains(antiDiagonal)) {
                continue;
            }

            // Place the queen
            current.add(col + 1); // Convert to 1-based index
            columns.add(col);
            mainDiagonals.add(mainDiagonal);
            antiDiagonals.add(antiDiagonal);

            // Recur to place the next queen
            backtrack(n, row + 1, current, results, columns, mainDiagonals, antiDiagonals);

            // Backtrack: remove the queen and try the next position
            current.remove(current.size() - 1);
            columns.remove(col);
            mainDiagonals.remove(mainDiagonal);
            antiDiagonals.remove(antiDiagonal);
        }
    }
}
