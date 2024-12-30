# 🌟 Union of Arrays with Duplicates

---

## 💡 Problem Statement

You are given two arrays `a[]` and `b[]`. The task is to calculate the **number of distinct elements** in the **union** of the two arrays.

- The union of two arrays is a set containing all distinct elements from both arrays.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{a.size()}$, $\text{b.size()}$ $\leq$ $10^6$ \)
- \( 0 $\leq$ $\text{a[i]}$, $\text{b[i]}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static int findUnion(int a[], int b[]);
}
```

### Parameters

- **`a[]`**: An integer array of size \( n \).
- **`b[]`**: An integer array of size \( m \).

### Returns

- An integer representing the count of distinct elements in the union of the two arrays.

---

## 📥 Input Format

1. An integer \( n \), the size of array \( a[] \).
2. An array \( a[] \) of \( n \) integers.
3. An integer \( m \), the size of array \( b[] \).
4. An array \( b[] \) of \( m \) integers.

---

## 📤 Output Format

- An integer representing the count of distinct elements in the union of the arrays.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
a = [1, 2, 3, 4, 5], b = [1, 2, 3]
```

**Output**:

```plaintext
5
```

**Explanation**:

- The union of \( a[] \) and \( b[] \): \( \{1, 2, 3, 4, 5\} \).
- Count: \( 5 \).

---

### Example 2

**Input**:

```plaintext
a = [85, 25, 1, 32, 54, 6], b = [85, 2]
```

**Output**:

```plaintext
7
```

**Explanation**:

- The union of \( a[] \) and \( b[] \): \( \{85, 25, 1, 32, 54, 6, 2\} \).
- Count: \( 7 \).

---

### Example 3

**Input**:

```plaintext
a = [1, 2, 1, 1, 2], b = [2, 2, 1, 2, 1]
```

**Output**:

```plaintext
2
```

**Explanation**:

- The union of \( a[] \) and \( b[] \): \( \{1, 2\} \).
- Count: \( 2 \).

---

## 💡 Approach

### Optimized HashSet-Based Approach

1. **Use a HashSet for Union**:

   - Insert all elements from \( a[] \) into the HashSet.
   - Insert all elements from \( b[] \) into the same HashSet.

2. **Distinct Elements**:

   - Since a HashSet allows only unique elements, all duplicates will be automatically removed.

3. **Count the Union**:
   - Return the size of the HashSet as the count of distinct elements in the union.

---

### Algorithm

1. Initialize an empty HashSet.
2. Add all elements from \( a[] \) to the HashSet.
3. Add all elements from \( b[] \) to the HashSet.
4. Return the size of the HashSet.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- **Adding Elements to HashSet**: \( O(n + m) \), where \( n \) and \( m \) are the sizes of \( a[] \) and \( b[] \), respectively.

### Space Complexity

- \( O(n + m) \): For storing elements in the HashSet.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public static int findUnion(int[] a, int[] b) {
        // Create a HashSet to store unique elements
        Set<Integer> unionSet = new HashSet<>();

        // Add all elements of array a to the HashSet
        for (int num : a) {
            unionSet.add(num);
        }

        // Add all elements of array b to the HashSet
        for (int num : b) {
            unionSet.add(num);
        }

        // Return the size of the HashSet
        return unionSet.size();
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
85 25 1 32 54 6
85 2
```

### Execution Steps:

1. Initialize `unionSet`:

   ```plaintext
   {}
   ```

2. Add elements of \( a[] \):

   ```plaintext
   {85, 25, 1, 32, 54, 6}
   ```

3. Add elements of \( b[] \):

   ```plaintext
   {85, 25, 1, 32, 54, 6, 2}
   ```

4. Count of elements in the union:
   ```plaintext
   7
   ```

### Output:

```plaintext
Number of elements in the union: 7
```

---

## ✨ Key Takeaways

- **HashSet** is an efficient data structure for finding unions while avoiding duplicates.
- Handles large inputs (\( n, m $\leq$ $10^6$ \)) efficiently with \( O(n + m) \) complexity.

**Happy Coding!** 🚀
