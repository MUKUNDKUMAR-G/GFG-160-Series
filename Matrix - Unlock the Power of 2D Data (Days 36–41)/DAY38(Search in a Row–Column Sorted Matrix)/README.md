# 🔍 Search in a Row-Column Sorted Matrix

---

## 💡 Problem Statement

Given a **2D matrix** `mat[][]` of size \( n \times m \), where each row and each column is sorted in increasing order, and an integer `x`, determine whether `x` is present in the matrix.

---

## 🔒 Constraints

- \( 1 $\leq$ n, m $\leq$ 1000 \)
- \( 1 $\leq$ $\text{mat[i][j]}$ $\leq$ $10^9$ \)
- \( 1 $\leq$ x $\leq$ $10^9$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static boolean matSearch(int mat[][], int x);
}
```

### Parameters

- **`mat[][]`**: A 2D matrix of size \( n \times m \), sorted row-wise and column-wise in increasing order.
- **`x`**: The integer to search for in the matrix.

### Returns

- `true` if `x` is present in the matrix, otherwise `false`.

---

## 📥 Input Format

1. An integer `n`, the number of rows in the matrix.
2. An integer `m`, the number of columns in the matrix.
3. A \( n \times m \) matrix of integers.
4. An integer `x`, the target to find.

---

## 📤 Output Format

- Return `true` if the element is found, else return `false`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
mat = [[3, 30, 38],
       [20, 52, 54],
       [35, 60, 69]], x = 62
```

**Output**:

```plaintext
false
```

**Explanation**:  
62 is not present in the matrix.

---

### Example 2

**Input**:

```plaintext
mat = [[18, 21, 27],
       [38, 55, 67]], x = 55
```

**Output**:

```plaintext
true
```

**Explanation**:  
55 is present in the matrix.

---

## 💡 Approach

### Optimal Approach: Start from Top-Right Corner

Since the matrix is **row-column sorted**, we can leverage the properties of the matrix:

1. **Row-wise Sorted**: Elements increase as we move from left to right.
2. **Column-wise Sorted**: Elements increase as we move from top to bottom.

### Steps:

1. Start from the **top-right corner** of the matrix (`row = 0`, `col = m - 1`).
2. Compare the current element `mat[row][col]` with `x`:
   - If `mat[row][col] == x`, return `true`.
   - If `mat[row][col] > x`, move **left** (decrement `col`).
   - If `mat[row][col] < x`, move **down** (increment `row`).
3. Repeat until we either find `x` or move out of bounds.

---

## ⏱️ Time Complexity

- **Traversal**: At most \( $n + m$ \) steps (one per row or column).
- **Total Complexity**: \( $O(n + m)$ \).

### Space Complexity

- \( O(1) \): No additional space is required.

---

## 🖥️ Solution

### Java Implementation

```java
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
}
```

---

## 🔍 Example Walkthrough

### Example 1

#### Input:

```plaintext
mat = [[3, 30, 38],
       [20, 52, 54],
       [35, 60, 69]], x = 62
```

#### Execution Steps:

1. Start at top-right: \( $\text{mat[0][2]}$ = 38 \).
   - \( 38 < 62 \): Move down to \( $\text{mat[1][2]}$ = 54 \).
2. \( 54 < 62 \): Move down to \( $\text{mat[2][2]}$ = 69 \).
3. \( 69 > 62 \): Move left to \( $\text{mat[2][1]}$ = 60 \).
4. \( 60 < 62 \): Out of bounds.

#### Output:

```plaintext
false
```

---

### Example 2

#### Input:

```plaintext
mat = [[18, 21, 27],
       [38, 55, 67]], x = 55
```

#### Execution Steps:

1. Start at top-right: \( $\text{mat[0][2]}$ = 27 \).
   - \( 27 < 55 \): Move down to \( $\text{mat[1][2]}$ = 67 \).
2. \( 67 > 55 \): Move left to \( $\text{mat[1][1]}$ = 55 \).
3. \( 55 == 55 \): Element found.

#### Output:

```plaintext
true
```

---

### Example 3

#### Input:

```plaintext
mat = [[1, 2, 3],
       [4, 5, 6],
       [7, 8, 9]], x = 3
```

#### Execution Steps:

1. Start at top-right: \( $\text{mat[0][2]}$ = 3 \).
   - \( 3 == 3 \): Element found.

#### Output:

```plaintext
true
```

---

## ✨ Key Takeaways

- **Start from Top-Right**: Exploits row-column sorting for efficient search.
- **Optimized for Large Matrices**: Handles \( n, m \leq 1000 \) within constraints.
- **Space-Efficient**: Operates in constant space.

**Happy Coding!** 🚀
