# 🔄 Rotate a Matrix by 90 Degrees (Anti-Clockwise)

---

## 💡 Problem Statement

Given a **square matrix** `mat[][]` of size \( n $\times$ n \), the task is to **rotate it 90 degrees in an anti-clockwise direction** in-place, i.e., without using any extra space.

---

## 🔒 Constraints

- \( 1 $\leq$ n $\leq$ 10^2 \) 🧮
- \( 0 $\leq$ $\text{mat[i][j]}$ $\leq$ $10^3$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    static void rotateby90(int mat[][]);
}
```

### Parameters

- **`mat[][]`**: A square matrix of integers with dimensions \( n $\times$ n \).

### Returns

- The function modifies the input matrix directly to its rotated state.

---

## 📥 Input Format

1. A square matrix `mat[][]` of dimensions \( n $\times$ n \).

---

## 📤 Output Format

- The rotated matrix \( $90^\circ$ \) anti-clockwise is directly modified in `mat[][]`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
mat = [[1, 2, 3],
       [4, 5, 6],
       [7, 8, 9]]
```

**Output**:

```plaintext
Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]
```

---

### Example 2

**Input**:

```plaintext
mat = [[1, 2],
       [3, 4]]
```

**Output**:

```plaintext
Rotated Matrix:
[2, 4]
[1, 3]
```

---

## 💡 Approach

### Step-by-Step Process

1. **Transpose the Matrix**:

   - A transpose operation swaps the element at \( $\text{mat[i][j]}$ \) with \( $\text{mat[j][i]}$ \).

2. **Reverse the colums**:
   - After transposing, reverse the columns of the matrix to achieve a 90-degree anti-clockwise rotation.

### Key Observations

- Rotating a matrix \( $90^\circ$ \) anti-clockwise is equivalent to:
  1. Transposing the matrix.
  2. Reversing the colums.

---

### Algorithm

1. **Transpose the Matrix**:

   - Loop through each element of the upper triangle of the matrix.
   - Swap \( $\text{mat[i][j]}$ \) with \( $\text{mat[j][i]}$ \).

2. **Reverse Each coloum**:
   - Reverse the coloums of the transposed matrix to complete the rotation.

---

## ⏱️ Time Complexity

- **Transpose Operation**: \( $O(n^2)$ \).
- **column Reversal**: \( $O(n^2)$ \).
- **Total Complexity**: \( $O(n^2)$ \).

### Space Complexity

- \( $O(1)$ \): In-place operation without additional space.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    static void rotateby90(int mat[][]) {
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
}
```

---

## 🔍 Example Walkthrough

### Example 1

#### Input:

```plaintext
mat = [[1, 2, 3],
       [4, 5, 6],
       [7, 8, 9]]
```

#### Steps:

1. **Transpose the Matrix**:

   ```plaintext
   Transposed Matrix:
   [1, 4, 7]
   [2, 5, 8]
   [3, 6, 9]
   ```

2. **Reverse the Colums**:
   ```plaintext
   Rotated Matrix:
   [3, 6, 9]
   [2, 5, 8]
   [1, 4, 7]
   ```

#### Output:

```plaintext
Rotated Matrix:
[3, 6, 9]
[2, 5, 8]
[1, 4, 7]
```

---

### Example 2

#### Input:

```plaintext
mat = [[1, 2],
       [3, 4]]
```

#### Steps:

1. **Transpose the Matrix**:

   ```plaintext
   Transposed Matrix:
   [1, 3]
   [2, 4]
   ```

2. **Reverse the Colums**:
   ```plaintext
   Rotated Matrix:
   [2, 4]
   [1, 3]
   ```

#### Output:

```plaintext
Rotated Matrix:
[2, 4]
[1, 3]
```

---

## ✨ Key Takeaways

- **In-Place Operation**: No extra space required.
- **Efficient**: Handles up to \( $10^4$ \) elements comfortably.
- **Intuitive**: Combines simple transpose and reversal for elegant rotation.

**Happy Coding!** 💻🚀
