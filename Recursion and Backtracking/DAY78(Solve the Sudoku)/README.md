## 🧩 Solve the Sudoku - Backtracking Approach 🎯

Sudoku is a **constraint satisfaction problem** that can be efficiently solved using **backtracking**. Given a **9×9 Sudoku grid**, our task is to fill the empty cells (denoted by `0`) such that:  
✅ Each row contains digits `1-9` exactly once.  
✅ Each column contains digits `1-9` exactly once.  
✅ Each **3×3 sub-box** contains digits `1-9` exactly once.

---

## 📌 **Constraints**

- **Grid size:** `9 x 9`
- **Input values:** `0 ≤ mat[i][j] ≤ 9` (0 represents empty cells to be filled)
- **Guaranteed:** **Only one valid solution exists**

---

## 📥 **Input Format**

A **9×9 matrix** where:  
🔹 `mat[i][j] = 0` → Empty cell to be filled.  
🔹 `mat[i][j] ≠ 0` → Pre-filled and **cannot be changed**.

### **Example Input**

![Example Input](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/701375/Web/Other/blobid0_1738306620.png)

---

## 📤 **Output Format**

A **fully solved Sudoku grid** satisfying the constraints.

### **Example Output**

![Example Output](https://media.geeksforgeeks.org/img-practice/prod/addEditProblem/701375/Web/Other/blobid0_1738306722.png)

---

## 🚀 **Approach: Backtracking**

The **Backtracking Algorithm** is used to solve Sudoku efficiently by **placing digits recursively** and undoing invalid placements.

### **🔹 Steps to Solve**

1. **Find an Empty Cell** (`0` in matrix).
2. **Try Numbers from 1 to 9**:
   - Check if placing the number violates **row, column, or sub-grid constraints**.
3. **If valid, place the number** and recursively **solve the next empty cell**.
4. **If no valid number exists, backtrack**:
   - Reset the cell to `0` and try a different number.
5. **Repeat until the entire Sudoku is filled**.

---

## ⏳ **Time & Space Complexity**

| Complexity                     | Value                                               |
| ------------------------------ | --------------------------------------------------- |
| **Worst Case Time Complexity** | **O(9ⁿ)** (Exponential, but pruned by backtracking) |
| **Average Case Complexity**    | **O(9^k)** (where `k` is the number of empty cells) |
| **Space Complexity**           | **O(1)** (modifies grid in-place)                   |

---

## ✅ **Optimized Backtracking Solution**

### **Java Implementation**

```java
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
}
```

---

## 🎯 **Example Walkthrough**

Let's visualize how **Backtracking** solves the problem step-by-step:

```
Step 1: Find the first empty cell.
Step 2: Try placing '1', check row/column/sub-grid constraints.
Step 3: If valid, move to the next empty cell.
Step 4: Repeat until the board is full or backtrack if stuck.
Step 5: Print the solved Sudoku grid.
```

---

## 🎉 **Key Takeaways**

✅ **Backtracking** allows efficient constraint-based filling.  
✅ **Pruning invalid choices** reduces the search space.  
✅ **Time Complexity** is reduced by constraint checking.  
✅ **Guaranteed unique solution** ensures correctness.

---

## 🔥 **Want to Try?**

💻 Run the program, enter an unsolved **9×9 Sudoku**, and watch **Backtracking** solve it like a pro! 🚀🎯
