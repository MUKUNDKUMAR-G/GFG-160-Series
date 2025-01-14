# 🌟 Equilibrium Point

---

## 💡 Problem Statement

Given an array `arr[]` of non-negative integers, find the **first equilibrium point** in the array.

### Equilibrium Point:

An index \( i \) (0-based indexing) such that the sum of all elements to the **left** of \( i \) is equal to the sum of all elements to the **right** of \( i \).

Return `-1` if no such equilibrium point exists.

---

## 🔒 Constraints

- \( 3 $\leq$ $\text{arr.size()}$ $\leq$ $10^6$ \)
- \( 0 $\leq$ $\text{arr[i]}$ $\leq$ $10^9$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static int findEquilibrium(int[] arr);
}
```

### Parameters

- **`arr[]`**: An array of non-negative integers.

### Returns

- An integer representing the index of the first equilibrium point or `-1` if no such point exists.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.

---

## 📤 Output Format

- A single integer representing the index of the equilibrium point or `-1`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [1, 2, 0, 3]
```

**Output**:

```plaintext
2
```

**Explanation**:

- The sum of elements to the left of index \( 2 \) is \( 1 + 2 = 3 \).
- The sum of elements to the right of index \( 2 \) is \( 0 + 3 = 3 \).

---

### Example 2

**Input**:

```plaintext
arr = [1, 1, 1, 1]
```

**Output**:

```plaintext
-1
```

**Explanation**:

- No index satisfies the equilibrium condition.

---

### Example 3

**Input**:

```plaintext
arr = [-7, 1, 5, 2, -4, 3, 0]
```

**Output**:

```plaintext
3
```

**Explanation**:

- The sum of elements to the left of index \( 3 \) is \( -7 + 1 + 5 = -1 \).
- The sum of elements to the right of index \( 3 \) is \( -4 + 3 + 0 = -1 \).

---

## 💡 Approach

### Efficient Solution

To find the equilibrium point efficiently:

1. **Calculate Total Sum**:

   - Compute the total sum of the array elements.

2. **Iterate Through the Array**:

   - Maintain a `leftSum` initialized to 0.
   - For each element \( i \), subtract \( $\text{arr[i]}$ \) from the total sum to get the sum of the right side.
   - Compare `leftSum` with the sum of the right side.

3. **Return Index**:

   - If `leftSum` equals the sum of the right side, return the index \( i \).
   - Update `leftSum` by adding \( $\text{arr[i]}$ \).

4. **Return -1**:
   - If no equilibrium point is found, return `-1`.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): The array is traversed twice (once for calculating the total sum and once for checking equilibrium).

### Space Complexity

- \( O(1) \): No additional space is used.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public static int findEquilibrium(int[] arr) {
        int n = arr.length;

        if (n < 3) return -1;

        // Step 1: Calculate total sum
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // Step 2: Initialize leftSum to 0
        int leftSum = 0;

        // Step 3: Traverse the array and check for equilibrium
        for (int i = 0; i < n; i++) {
            // Right sum is total sum minus current element minus left sum
            totalSum -= arr[i];

            // Check if left sum equals right sum
            if (leftSum == totalSum) {
                return i;
            }

            // Update left sum
            leftSum += arr[i];
        }

        // Step 4: Return -1 if no equilibrium point found
        return -1;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
1 2 0 3
```

### Execution Steps:

1. **Initial Variables**:

   ```plaintext
   totalSum = 6, leftSum = 0
   ```

2. **First Iteration (i = 0)**:

   - \( $\text{totalSum}$ = 6 - 1 = 5 \)
   - \( $\text{leftSum}$ = 0 \)
   - \( $\text{leftSum}$ $\neq$ $\text{totalSum}$ \).

3. **Second Iteration (i = 1)**:

   - \( $\text{totalSum}$ = 5 - 2 = 3 \)
   - \( $\text{leftSum}$ = 1 \)
   - \( $\text{leftSum}$ $\neq$ $\text{totalSum}$ \).

4. **Third Iteration (i = 2)**:

   - \( $\text{totalSum}$ = 3 - 0 = 3 \)
   - \( $\text{leftSum}$ = 3 \)
   - \( $\text{leftSum}$ == $\text{totalSum}$ \).

5. **Output**:
   ```plaintext
   Equilibrium Point Index: 2
   ```

---

## ✨ Key Takeaways

- Efficient \( O(n) \) approach using a single traversal with constant space.
- Handles edge cases like arrays with no equilibrium points or arrays with fewer than 3 elements.

**Happy Coding!** 🚀
