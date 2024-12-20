# 🌪️ Spirally Traversing a Matrix

---

## 💡 Problem Statement

You are given a **rectangular matrix** `mat[][]` of size \( n \times m \). Your task is to return a list of integers representing the elements of the matrix traversed in **spiral form**.

---

## 🔒 Constraints

- \( 1 $\leq$ n, m $\leq$ 1000 \) 🧮
- \( 0 $\leq$ $\text{mat[i][j]}$ $\leq$ 100 \) 🔢

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat);
}
```

### Parameters

- **`mat[][]`**: A 2D matrix of integers with dimensions \( n $\times$ $ m$ \).

### Returns

- An `ArrayList<Integer>` containing the matrix elements in spiral order.

---

## 📥 Input Format

1. A 2D matrix `mat[][]` of dimensions \( n $\times$ m \).

---

## 📤 Output Format

- A list of integers representing the elements of the matrix in spiral order.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
mat = [[1, 2, 3, 4],
       [5, 6, 7, 8],
       [9, 10, 11, 12],
       [13, 14, 15, 16]]
```

**Output**:

```plaintext
[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]
```

**Explanation**:

- Traverse the top row, then the rightmost column, then the bottom row (in reverse), and finally the leftmost column (in reverse).

---

### Example 2

**Input**:

```plaintext
mat = [[1, 2, 3, 4, 5, 6],
       [7, 8, 9, 10, 11, 12],
       [13, 14, 15, 16, 17, 18]]
```

**Output**:

```plaintext
[1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]
```

---

### Example 3

**Input**:

```plaintext
mat = [[32, 44, 27, 23],
       [54, 28, 50, 62]]
```

**Output**:

```plaintext
[32, 44, 27, 23, 62, 50, 28, 54]
```

---

## 💡 Approach

The spiral traversal involves moving through the matrix layer by layer in the following sequence:

1. **Top Row**: Traverse from the leftmost column to the rightmost column.
2. **Right Column**: Traverse down from the current top row to the bottom row.
3. **Bottom Row**: Traverse from the rightmost column to the leftmost column (if the current top row is below the bottom row).
4. **Left Column**: Traverse up from the current bottom row to the top row (if the current left column is before the right column).

### Algorithm

1. **Initialize Boundaries**:

   - `top = 0`, `bottom = n-1`, `left = 0`, `right = m-1`.

2. **Loop Until Bounds Overlap**:

   - Continue traversing while \( $\text{top}$ $\leq$ $\text{bottom}$ \) and \( $\text{left}$ $\leq$ $\text{right}$ \).

3. **Traverse in Spiral Order**:

   - **Top Row**: Traverse left to right, increment `top`.
   - **Right Column**: Traverse top to bottom, decrement `right`.
   - **Bottom Row** (if valid): Traverse right to left, decrement `bottom`.
   - **Left Column** (if valid): Traverse bottom to top, increment `left`.

4. **End Condition**:
   - When \( $\text{top}$ > $\text{bottom}$ \) or \( $\text{left}$ > $\text{right}$ \), the traversal ends.

---

## ⏱️ Time Complexity

- \( O(n $\times$ m) \): Each element is visited exactly once.

### Space Complexity

- \( $O(1)$ \): No extra space is used, except for the result list.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {

    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        ArrayList<Integer> result = new ArrayList<>();

        // Initialize boundaries
        int top = 0, bottom = rows - 1, left = 0, right = cols - 1;

        // Loop until boundaries overlap
        while (top <= bottom && left <= right) {

            // Traverse top row
            for (int i = left; i <= right; i++) {
                result.add(mat[top][i]);
            }
            top++;

            // Traverse right column
            for (int i = top; i <= bottom; i++) {
                result.add(mat[i][right]);
            }
            right--;

            // Traverse bottom row (if still valid)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(mat[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column (if still valid)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(mat[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
1 2 3 4
5 6 7 8
9 10 11 12
```

### Execution Steps:

1. Traverse top row: `1 2 3 4`.
2. Traverse right column: `8 12`.
3. Traverse bottom row: `11 10 9` (reverse).
4. Traverse left column: `5` (upwards).
5. Traverse remaining row: `6 7`.

### Output:

```plaintext
Spiral Traversal of the Matrix:
1 2 3 4 8 12 11 10 9 5 6 7
```

---

## ✨ Key Takeaways

- **Handles Large Matrices**: Efficiently traverses matrices up to \( 1000 $\times$ 1000 \).
- **Space Efficient**: Uses \( O(1) \) auxiliary space.
- **Flexible**: Handles rectangular matrices of any dimension.

**Happy Coding!** 💻🚀
