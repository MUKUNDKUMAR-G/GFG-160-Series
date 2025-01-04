# 🌟 Count All Triplets with Given Sum in Sorted Array

---

## 💡 Problem Statement

Given a **sorted array** `arr[]` of integers and a target value `target`, count the number of triplets \( (i, j, k) \) such that:

- \( arr[i] + arr[j] + arr[k] = $\text{target}$ \)
- \( i < j < k \).

The solution must correctly handle duplicate elements in the array, considering all possible combinations for valid triplets.

---

## 🔒 Constraints

- \( 3 $\leq$ $\text{arr.size()}$ $\leq$ $10^4$ \)
- \( $-10^5$ $\leq$ $\text{arr[i]}$, $\text{target}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int countTriplets(int[] arr, int target);
}
```

### Parameters

- **`arr[]`**: A sorted array of integers.
- **`target`**: An integer value for the target sum.

### Returns

- An integer representing the count of triplets satisfying the given conditions.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.
3. An integer \( target \), the target sum.

---

## 📤 Output Format

- An integer representing the count of valid triplets.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [-3, -1, -1, 0, 1, 2], target = -2
```

**Output**:

```plaintext
4
```

**Explanation**:  
The triplets that satisfy the condition are:

1. \( (-3) + (-1) + (2) = -2 \)
2. \( (-3) + (-1) + (2) = -2 \)
3. \( (-3) + (0) + (1) = -2 \)
4. \( (-1) + (-1) + (0) = -2 \)

---

### Example 2

**Input**:

```plaintext
arr = [-2, 0, 1, 1, 5], target = 1
```

**Output**:

```plaintext
0
```

**Explanation**:  
No triplet sums up to \( 1 \).

---

## 💡 Approach

### Optimized Two-Pointer Technique

We solve the problem using the **two-pointer approach** with special handling for duplicate elements to ensure that all valid combinations are included in the count.

1. **Iterate for Each Triplet's First Element**:

   - Fix \( i \) as the first element of the triplet.

2. **Use Two Pointers for Remaining Elements**:

   - Place one pointer at \( j = i + 1 \) and another at \( k = n - 1 \).
   - Compute the sum of \( arr[i] + arr[j] + arr[k] \).

3. **Handle Duplicates Explicitly**:

   - If \( arr[j] == arr[k] \), count all combinations of indices between \( j \) and \( k \).
   - Otherwise, count all valid combinations of duplicates for both \( arr[j] \) and \( arr[k] \).

4. **Adjust Pointers Based on Sum**:
   - If the sum is less than the target, move \( j \) to the right.
   - If the sum is greater than the target, move \( k \) to the left.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- **Outer Loop**: \( O(n) \), iterating over \( i \).
- **Two-Pointer Traversal**: \( O(n) \) for each \( i \).
- **Total**: \( O(n^2) \).

### Space Complexity

- \( O(1) \): No extra space apart from variables.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == target) {
                    if (arr[j] == arr[k]) {
                        int totalPairs = k - j + 1;
                        count += (totalPairs * (totalPairs - 1)) / 2;
                        break;
                    } else {
                        int leftCount = 1, rightCount = 1;

                        while (j + 1 < k && arr[j] == arr[j + 1]) {
                            j++;
                            leftCount++;
                        }

                        while (k - 1 > j && arr[k] == arr[k - 1]) {
                            k--;
                            rightCount++;
                        }

                        count += leftCount * rightCount;
                        j++;
                        k--;
                    }
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
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
 -3 -1 -1 0 1 2
 -2
```

### Execution Steps:

1. **Initial Array**:

   ```plaintext
   arr = [-3, -1, -1, 0, 1, 2], target = -2
   ```

2. **Outer Loop \( i = 0 \)**:

   - \( arr[i] = -3 \), \( j = 1 \), \( k = 5 \).
   - Compute sums:
     - \( (-3) + (-1) + (2) = -2 \): Increment count.
     - \( (-3) + (-1) + (2) = -2 \): Increment count.

3. **Outer Loop \( i = 1 \)**:

   - \( arr[i] = -1 \), \( j = 2 \), \( k = 5 \).
   - Compute sums:
     - \( (-1) + (-1) + (0) = -2 \): Increment count.

4. **Result**:
   ```plaintext
   Number of triplets with sum -2: 4
   ```

---

## ✨ Key Takeaways

- **Explicit Duplicate Handling** ensures no valid combinations are missed.
- **Two-pointer Technique** optimizes the solution to \( O(n^2) \).
- Handles edge cases effectively, including scenarios where all elements are the same.

**Happy Coding!** 🚀
