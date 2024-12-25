# 🌟 Set Matrix Zeroes

---

## 💡 Problem Statement

You are given a 2D matrix `mat[][]` of size \( n $\times$ m \). The task is to modify the matrix in place such that if any element \( $\text{mat[i][j]}$ = 0 \):

1. All elements in the \( i \)-th row are set to `0`.
2. All elements in the \( j \)-th column are set to `0`.

The solution **must use constant space complexity**, i.e., no extra data structures can be used for row or column marking.

---

## 🔒 Constraints

- \( 1 $\leq$ n, m $\leq$ 500 \)
- \( $-2^{31}$ $\leq$ $\text{mat[i][j]}$ $\leq$ $2^{31}$ - 1 \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public void setMatrixZeroes(int[][] mat);
}
```

### Parameters

- **`mat[][]`**: A 2D integer matrix of size \( n $\times$ m \).

### Returns

- The function modifies the matrix **in place**, setting rows and columns to zero based on the conditions.

---

## 📥 Input Format

1. An integer \( n \), the number of rows in the matrix.
2. An integer \( m \), the number of columns in the matrix.
3. A \( n $\times$ m \) matrix of integers.

---

## 📤 Output Format

- The matrix is modified directly and printed in its updated state.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
mat = [[1, -1, 1],
       [-1, 0, 1],
       [1, -1, 1]]
```

**Output**:

```plaintext
[[1, 0, 1],
 [0, 0, 0],
 [1, 0, 1]]
```

**Explanation**:

- \( $\text{mat[1][1]}$ = 0 \), so the entire row 1 and column 1 are set to 0.

---

### Example 2

**Input**:

```plaintext
mat = [[0, 1, 2, 0],
       [3, 4, 5, 2],
       [1, 3, 1, 5]]
```

**Output**:

```plaintext
[[0, 0, 0, 0],
 [0, 4, 5, 0],
 [0, 3, 1, 0]]
```

**Explanation**:

- \( $\text{mat[0][0]}$ = 0 \) and \( $\text{mat[0][3]}$ = 0 \).
- Entire row 0, column 0, and column 3 are set to 0.

---

## 💡 Approach

### Observations

1. **Marker-Based Solution**:

   - Use the **first row** and **first column** of the matrix to act as markers to indicate which rows and columns need to be set to zero.

2. **Steps**:

   - **Step 1**: Identify all rows and columns that need to be set to zero using the first row and column as markers.
   - **Step 2**: Update the rest of the matrix based on these markers.
   - **Step 3**: Handle the first row and column separately, as they are used for marking.

3. **Why Separate Handling for First Row and Column?**
   - They serve as markers, so modifying them early can overwrite the information needed to update other parts of the matrix.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- **Matrix Traversal**: \( O(n $\times$ m) \).

### Space Complexity

- \( O(1) \): No additional space is used beyond the input matrix.

---

## 🖥️ Solution

### Java Implementation

Here’s the full solution with **user input** for better interactivity:

```java

class Solution {

    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        boolean firstRowZero = false, firstColZero = false;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    if (i == 0) firstRowZero = true;
                    if (j == 0) firstColZero = true;
                    mat[i][0] = 0;
                    mat[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
0 1 2 0
3 4 5 2
1 3 1 5
```

### Execution Steps:

1. **Step 1: Mark Zeros**

   - First row marker: \( [0, 1, 2, 0] \).
   - First column marker: \( [0, 3, 1] \).

2. **Step 2: Update Matrix Using Markers**

   ```plaintext
   [0, 0, 0, 0]
   [0, 4, 5, 0]
   [0, 3, 1, 0]
   ```

3. **Step 3 & Step 4: Handle First Row and Column**
   ```plaintext
   [0, 0, 0, 0]
   [0, 0, 0, 0]
   [0, 0, 0, 0]
   ```

### Output:

```plaintext
Modified Matrix:
0 0 0 0
0 4 5 0
0 3 1 0
```

---

## ✨ Key Takeaways

- **Marker-Based Solution**: Efficiently handles matrix modification without additional space.
- **Separation of Concerns**: Treats the first row and column differently to preserve markers.
- **Interactive**: User-friendly input/output for real-time testing.

**Happy Coding!** 💻🚀
