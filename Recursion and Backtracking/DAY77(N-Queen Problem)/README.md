# **♛ N-Queens Problem – README 🏰**

## **📜 Problem Statement**

The **N-Queens** puzzle is about placing `n` queens on an `n × n` chessboard such that **no two queens can attack each other**.  
A queen can attack another queen if they share the **same row, column, or diagonal**.

You need to find **all possible solutions** where each solution is represented as a **permutation of `[1, 2, ..., n]`**,  
where the number in the `i-th` position represents the **row position of the queen in the i-th column**.

---

## **📌 Constraints**

✔ `1 ≤ n ≤ 10`

---

## **🛠️ Function Description**

```java
public ArrayList<ArrayList<Integer>> nQueen(int n)
```

- **Input:**
  - `n` → Number of queens (also the board size `n × n`).
- **Output:**
  - A list of **valid board configurations** where each board is represented as `[row_1, row_2, ..., row_n]`.
- **Edge Cases:**
  - If `n = 2 or 3`, return `[]` (since no valid solutions exist).
  - If `n = 1`, return `[[1]]` (since only one possible placement exists).

---

## **📥 Input Format**

A single integer `n` (the size of the chessboard).

## **📤 Output Format**

A list of lists, where each list represents a valid queen placement.

---

## **🔍 Examples & Explanation**

### **Example 1:**

#### **Input:**

```
n = 1
```

#### **Output:**

```
[[1]]
```

✅ **Explanation:** Only **one queen** can be placed in the **only cell available**.

---

### **Example 2:**

#### **Input:**

```
n = 4
```

#### **Output:**

```
[[2, 4, 1, 3], [3, 1, 4, 2]]
```

✅ **Explanation:**  
The **two valid solutions** for `n = 4` are:

```
Solution 1:   Solution 2:
. . Q .       . Q . .
. . . Q       . . . Q
Q . . .       . . Q .
. Q . .       Q . . .
```

Here, `[2, 4, 1, 3]` means:

- Queen is in **row 2** of **column 1**
- Queen is in **row 4** of **column 2**
- Queen is in **row 1** of **column 3**
- Queen is in **row 3** of **column 4**

---

### **Example 3:**

#### **Input:**

```
n = 2
```

#### **Output:**

```
[]
```

✅ **Explanation:** No valid configurations exist for `n = 2`.

---

## **👀 Approach**

### **1️⃣ Brute Force (Generate All Possible Arrangements) – ❌ Inefficient**

- Generate all possible **permutations** of `[1, 2, ..., n]` (Total `n!` possibilities).
- Check if any two queens attack each other.
- **Time Complexity:** `O(n! * n)`
- **Space Complexity:** `O(n!)`

🔴 **Fallbacks:**

- **Too slow** for `n ≥ 10`.
- Checking constraints (`O(n)`) for each permutation is inefficient.

---

### **2️⃣ Optimized Approach: Backtracking + HashSets ✅**

✔ We place queens **column by column**, ensuring each row has only **one queen**.  
✔ We **prune** invalid choices **early**, avoiding unnecessary computation.  
✔ We use **HashSets** to track:

- **Columns already occupied.**
- **Main diagonals** (`row - col`).
- **Anti-diagonals** (`row + col`).

#### **Steps:**

1. Start placing queens **row by row**.
2. For each column:
   - Check if it's **safe** (not in the same column or diagonal).
   - If safe, **place the queen** and move to the next row.
   - If a solution is found, **store it**.
   - **Backtrack:** Remove the queen and try the next column.
3. Repeat until all possibilities are explored.

---

## **⏳ Time & Space Complexity**

| Approach                                    | Time Complexity  | Space Complexity |
| ------------------------------------------- | ---------------- | ---------------- |
| **Brute Force (Generate all permutations)** | `O(n! * n)`      | `O(n!)`          |
| **Optimized Backtracking with HashSets**    | `O(n!)` (Pruned) | `O(n)`           |

🔹 **Why is this optimized?**

- We **avoid placing queens in invalid positions early**.
- HashSets provide **O(1) lookups** to check for conflicts.

---

## **🚀 Java Implementation**

```java
import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        backtrack(n, 0, new ArrayList<>(), results, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return results;
    }

    private void backtrack(int n, int row, List<Integer> current, ArrayList<ArrayList<Integer>> results,
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

            // Backtrack: remove the queen and try next position
            current.remove(current.size() - 1);
            columns.remove(col);
            mainDiagonals.remove(mainDiagonal);
            antiDiagonals.remove(antiDiagonal);
        }
    }
}
```

---

## **🎯 Why This Approach?**

✔ **Avoids unnecessary computations** using HashSets (`O(1) lookups`).  
✔ **Efficient backtracking** prunes invalid placements early.  
✔ **Scalable up to `n = 10`** (total `n!` complexity is manageable).

---

## **🧪 Example Walkthrough (`n = 4`)**

1. Place `Q1` in **row 1, column 2**
2. Place `Q2` in **row 2, column 4**
3. Place `Q3` in **row 3, column 1**
4. Place `Q4` in **row 4, column 3**

✅ **Valid solution `[2, 4, 1, 3]` found!**  
🔄 **Backtrack & find other solutions**

---

## **🔥 Summary**

| Approach                       | Time Complexity | Space Complexity | Strengths                    |
| ------------------------------ | --------------- | ---------------- | ---------------------------- |
| **Brute Force (Permutations)** | `O(n! * n)`     | `O(n!)`          | Very slow for `n ≥ 10` 🚫    |
| **Optimized Backtracking**     | `O(n!)`         | `O(n)`           | Fast pruning, works well! ✅ |

🎯 **Best Approach:** **Optimized Backtracking with HashSets** (`O(n!)`)

---

## **💡 Conclusion**

✔ **Solved N-Queens using backtracking efficiently!** 🏆  
✔ **Handles up to `n = 10` efficiently** 🚀  
✔ **Uses HashSets to optimize lookups** 🔥

💬 **Would you like to see a visualization of the recursion tree?** 😃♛
