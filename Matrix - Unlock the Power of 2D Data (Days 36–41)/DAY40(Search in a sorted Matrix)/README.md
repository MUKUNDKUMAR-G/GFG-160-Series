# 🔍 Search in a Strictly Sorted Matrix

---

## 💡 Problem Statement

You are given a **strictly sorted 2D matrix** `mat[][]` of size \( n \times m \), where:

- Each row is sorted in **strictly increasing order**.
- The first element of the \( $i$ \)-th row (\( i > 0 \)) is greater than the last element of the \( (i - 1) \)-th row.

Your task is to determine whether a given number `x` is present in the matrix.

---

## 🔒 Constraints

- \( 1 $\leq n$, m $\leq$ 1000 \)
- \( 1 $\leq$ $\text{mat[i][j]}$ $\leq$ $10^9$ \)
- \( 1 $\leq x$ $\leq$ $10^9$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public boolean searchMatrix(int[][] mat, int x);
}
```

### Parameters

- **`mat[][]`**: A \( n $\times$ m \) matrix of integers, sorted in strictly increasing order.
- **`x`**: An integer to search for in the matrix.

### Returns

- A `boolean` value:
  - `true` if `x` is found in the matrix.
  - `false` otherwise.

---

## 📥 Input Format

1. An integer \( n \), the number of rows in the matrix.
2. An integer \( m \), the number of columns in the matrix.
3. A \( n \times m \) matrix, where each row is strictly sorted, and each row’s first element is greater than the previous row's last element.
4. An integer `x`, the target value to search for.

---

## 📤 Output Format

- Return `true` if `x` is found in the matrix, otherwise `false`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
mat = [[1, 5, 9],
       [14, 20, 21],
       [30, 34, 43]], x = 14
```

**Output**:

```plaintext
true
```

---

### Example 2

**Input**:

```plaintext
mat = [[1, 5, 9, 11],
       [14, 20, 21, 26],
       [30, 34, 43, 50]], x = 42
```

**Output**:

```plaintext
false
```

---

### Example 3

**Input**:

```plaintext
mat = [[87, 96, 99],
       [101, 103, 111]], x = 101
```

**Output**:

```plaintext
true
```

---

## 💡 Approach

Since the matrix is **strictly sorted**:

- The entire matrix can be treated as a **flattened 1D array**.
- The element at position \( {mat[row][col]} \) in the matrix can be mapped to the index \({index = row \* m + col} \) in the virtual 1D array.
- Conversely, a virtual 1D array index can be mapped back to matrix coordinates:  
  \[
  $\text{row = index / m}$, $\quad$ col = index % m \]

### Steps:

1. Treat the matrix as a 1D array and perform **binary search**.
2. Use the index mapping formula to access the matrix elements.
3. Compare the middle element in the binary search with `x`:
   - If equal, return `true`.
   - If less, move to the right half.
   - If greater, move to the left half.
4. Return `false` if the search completes without finding `x`.

---

## ⏱️ Time Complexity

- **Binary Search**: \( O(\log(n $\cdot$ m)) \).

### Space Complexity

- \( O(1) \): No additional space required.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;

        int low = 0, high = n * m - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int row = mid / m;
            int col = mid % m;

            if (mat[row][col] == x) {
                return true; // Element found
            } else if (mat[row][col] < x) {
                low = mid + 1; // Search right half
            } else {
                high = mid - 1; // Search left half
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
mat = [[1, 5, 9],
       [14, 20, 21],
       [30, 34, 43]], x = 14
```

#### Steps:

1. Flattened array:  
   \[
   [1, 5, 9, 14, 20, 21, 30, 34, 43]
   \]
   Indices range: \( 0 \) to \( 8 \).

2. Perform Binary Search:
   - Midpoint index = \( 4 \): \( $\text{mat[1][1]}$ = 20 \). \( 20 > 14 \): Search left.
   - Midpoint index = \( 3 \): \( $\text{mat[1][0]}$ = 14 \). \( 14 == 14 \): Found.

#### Output:

```plaintext
true
```

---

### Example 2

#### Input:

```plaintext
mat = [[1, 5, 9, 11],
       [14, 20, 21, 26],
       [30, 34, 43, 50]], x = 42
```

#### Steps:

1. Flattened array:  
   \[
   [1, 5, 9, 11, 14, 20, 21, 26, 30, 34, 43, 50]
   \]
   Indices range: \( 0 \) to \( 11 \).

2. Perform Binary Search:

   - Midpoint index = \( 5 \): \( $\text{mat[1][1]}$ = 20 \). \( 20 < 42 \): Search right.
   - Midpoint index = \( 8 \): \( $\text{mat[2][0]}$ = 30 \). \( 30 < 42 \): Search right.
   - Midpoint index = \( 10 \): \( $\text{mat[2][2]}$ = 43 \). \( 43 > 42 \): Search left.
   - Midpoint index = \( 9 \): \( $\text{mat[2][1]}$ = 34 \). \( 34 < 42 \): Search right.

3. Search completes without finding \( 42 \).

#### Output:

```plaintext
false
```

---

## ✨ Key Takeaways

- **Matrix as 1D Array**: Simplifies the search problem.
- **Binary Search**: Efficiently narrows down to the target.
- Handles \( n, m \leq 1000 \) comfortably.

**Happy Coding!** 🚀
