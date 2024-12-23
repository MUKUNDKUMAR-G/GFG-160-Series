# 🔍 Search in a Row-Wise Sorted Matrix

---

## 💡 Problem Statement

You are given a **row-wise sorted 2D matrix** `mat[][]` of size \( n \times m \), where each row is sorted in non-decreasing order. Your task is to determine whether a given integer `x` is present in the matrix.

---

## 🔒 Constraints

- \( 1 $\leq$ n, m $\leq$ 1000 \)
- \( 1 $\leq$ $\text{mat[i][j]}$ $\leq$ $10^5$ \)
- \( 1 $\leq$ x $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public boolean searchRowMatrix(int[][] mat, int x);
}
```

### Parameters

- **`mat[][]`**: A \( n $\times$ m \) matrix of integers, where each row is sorted in non-decreasing order.
- **`x`**: An integer to search for in the matrix.

### Returns

- A `boolean` value:
  - `true` if `x` is found in the matrix.
  - `false` otherwise.

---

## 📥 Input Format

1. An integer \( n \) representing the number of rows in the matrix.
2. An integer \( m \) representing the number of columns in the matrix.
3. A \( n \times m \) matrix, where each row is sorted.
4. An integer `x`, the target value to search for.

---

## 📤 Output Format

- Return `true` if `x` is found in the matrix, otherwise `false`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
mat = [[3, 4, 9],
       [2, 5, 6],
       [9, 25, 27]], x = 9
```

**Output**:

```plaintext
true
```

---

### Example 2

**Input**:

```plaintext
mat = [[19, 22, 27, 38, 55, 67]], x = 56
```

**Output**:

```plaintext
false
```

---

### Example 3

**Input**:

```plaintext
mat = [[1, 2, 9],
       [65, 69, 75]], x = 91
```

**Output**:

```plaintext
false
```

---

## 💡 Approach

### 1️⃣ **Binary Search on Each Row**

Since each row in the matrix is sorted, we can apply **binary search** on each row to determine whether `x` exists in that row.

#### Steps:

1. Iterate through all the rows in the matrix.
2. For each row, perform a binary search to determine whether `x` exists in that row.
3. If `x` is found in any row, return `true`.
4. If the loop completes without finding `x`, return `false`.

---

## ⏱️ Time Complexity

- **Binary Search per Row**: \( $O(\log m)$ \), where \( m \) is the number of columns.
- **For All Rows**: \( O(n $\cdot$ $\log$ m) \), where \( n \) is the number of rows.

### Space Complexity

- \( O(1) \): No additional space required.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length; // Number of rows
        int m = mat[0].length; // Number of columns

        // Iterate through each row
        for (int i = 0; i < n; i++) {
            // Apply binary search on the current row
            int low = 0, high = m - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;

                if (mat[i][mid] == x) {
                    return true; // Element found
                } else if (mat[i][mid] < x) {
                    low = mid + 1; // Search in the right half
                } else {
                    high = mid - 1; // Search in the left half
                }
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
mat = [[3, 4, 9],
       [2, 5, 6],
       [9, 25, 27]], x = 9
```

#### Execution Steps:

1. **Row 0**: Apply binary search:
   - Middle element \( $\text{mat[0][1]}$ = 4 \). \( 4 < 9 \): Search right.
   - Middle element \( $\text{mat[0][2]}$ = 9 \). \( 9 == 9 \): Found.

#### Output:

```plaintext
true
```

---

### Example 2

#### Input:

```plaintext
mat = [[19, 22, 27, 38, 55, 67]], x = 56
```

#### Execution Steps:

1. **Row 0**: Apply binary search:
   - Middle element \( $\text{mat[0][2]}$ = 27 \). \( 27 < 56 \): Search right.
   - Middle element \( $\text{mat[0][4]}$ = 55 \). \( 55 < 56 \): Search right.
   - Middle element \( $\text{mat[0][5]}$ = 67 \). \( 67 > 56 \): Search left.

#### Output:

```plaintext
false
```

---

## ✨ Key Takeaways

- **Binary Search per Row** is efficient for row-wise sorted matrices.
- Handles \( n, m $\leq$ 1000 \) efficiently within constraints.
- Provides consistent performance even for large matrices.

**Happy Coding!** 🚀
