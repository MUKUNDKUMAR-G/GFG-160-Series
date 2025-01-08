# 🌟 Count the Number of Possible Triangles

---

## 💡 Problem Statement

Given an integer array `arr[]`, determine the number of **triangles** that can be formed using three distinct elements as the lengths of the triangle sides.

### Triangle Formation Rule

A triangle is valid if the sum of any two sides is **greater** than the third side.

---

## 🔒 Constraints

- \( 3 $\leq$ $\text{arr.size()}$ $\leq$ $10^3$ \)
- \($ 0 \leq \text{arr[i]} \leq 10^5 $\)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static int countTriangles(int[] arr);
}
```

### Parameters

- **`arr[]`**: An array of integers representing possible triangle sides.

### Returns

- An integer representing the count of valid triangles that can be formed.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.

---

## 📤 Output Format

- An integer representing the count of valid triangles.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [4, 6, 3, 7]
```

**Output**:

```plaintext
3
```

**Explanation**:  
The valid triangles are:

1. \( [3, 4, 6] \)
2. \( [4, 6, 7] \)
3. \( [3, 6, 7] \)

---

### Example 2

**Input**:

```plaintext
arr = [10, 21, 22, 100, 101, 200, 300]
```

**Output**:

```plaintext
6
```

**Explanation**:  
The valid triangles are:

1. \( [10, 21, 22] \)
2. \( [21, 100, 101] \)
3. \( [22, 100, 101] \)
4. \( [10, 100, 101] \)
5. \( [100, 101, 200] \)
6. \( [101, 200, 300] \)

---

### Example 3

**Input**:

```plaintext
arr = [1, 2, 3]
```

**Output**:

```plaintext
0
```

**Explanation**:  
No valid triangles can be formed.

---

## 💡 Approach

### Optimized Approach: Sorting and Two Pointers

1. **Sort the Array**:

   - Sorting ensures that the triangle inequality \($ \text{arr[i]} + \text{arr[j]} > \text{arr[k]} $\) is easier to check.

2. **Fix the Largest Side**:

   - Iterate over the array backward and fix \( \text{arr[k]} \) as the largest side of the triangle.

3. **Use Two Pointers**:

   - For the fixed \($ \text{arr[k]} $\), use two pointers \( i \) and \( j \) to find valid pairs:
     - \( i = 0 \), \( j = k - 1 \).
     - If \( \text{arr[i]} + \text{arr[j]} > \text{arr[k]} \):
       - All pairs \( (i, j), (i + 1, j), \dots, (j - 1, j) \) are valid.
       - Increment the count by \( j - i \).
       - Decrement \( j \).
     - Otherwise, increment \( i \) to increase the sum.

4. **Stop Condition**:

   - Stop when \( i \geq j \).

5. **Edge Cases**:
   - Arrays with fewer than 3 elements.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- **Sorting**: \($ O(n \log n) $\)
- **Two-pointer traversal**: \($ O(n^2) $\)
- **Overall**: \($ O(n^2) $\)

### Space Complexity

- \( O(1) \): No additional space is required.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public static int countTriangles(int[] arr) {
        int n = arr.length;
        if (n < 3) return 0;

        Arrays.sort(arr);
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {
            int i = 0, j = k - 1;

            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else {
                    i++;
                }
            }
        }

        return count;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the size of the array: 4
Enter the elements of the array:
4 6 3 7
```

### Execution Steps:

1. **Initial Array**:

   ```plaintext
   arr = [4, 6, 3, 7]
   ```

2. **Sort the Array**:

   ```plaintext
   arr = [3, 4, 6, 7]
   ```

3. **Fix the Largest Side**:

- \($ k = 3, \text{arr[k]} = 7 $\):

  - \($ i = 0, j = 2 $\):
    - \($ arr[i] + arr[j] = 3 + 6 = 9 > 7 $\), count = 2.
    - \( j = 1 \):
      - \($ arr[i] + arr[j] = 3 + 4 = 7 $\), no increment.

- \($ k = 2, \text{arr[k]} = 6 $\):
  - \( i = 0, j = 1 \):
    - \($ arr[i] + arr[j] = 3 + 4 = 7 > 6 $\), count = 3.

4. **Output**:
   ```plaintext
   Number of possible triangles: 3
   ```

---

## ✨ Key Takeaways

- Sorting simplifies the triangle inequality condition.
- The two-pointer approach ensures \($ O(n^2) $\) time complexity.
- This solution handles large arrays efficiently while maintaining accuracy.

**Happy Coding!** 🚀
