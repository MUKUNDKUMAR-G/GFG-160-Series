# 🌟 Largest Subarray with Equal 0's and 1's

---

## 💡 Problem Statement

You are given a binary array `arr[]` containing only `0`s and `1`s. Find the **length of the longest subarray** where the number of `0`s is equal to the number of `1`s.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( 0 $\leq$ $\text{arr[i]}$ $\leq$ 1 \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int maxLen(int[] arr);
}
```

### Parameters

- **`arr[]`**: An array of integers containing only `0`s and `1`s.

### Returns

- An integer representing the length of the longest subarray with equal `0`s and `1`s.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers containing only `0`s and `1`s.

---

## 📤 Output Format

- A single integer representing the length of the longest subarray with equal `0`s and `1`s.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [1, 0, 1, 1, 1, 0, 0]
```

**Output**:

```plaintext
6
```

**Explanation**:

- The longest subarray with equal `0`s and `1`s is \( $\text{arr[1...6]}$ \), with a length of \( 6 \).

---

### Example 2

**Input**:

```plaintext
arr = [0, 0, 1, 1, 0]
```

**Output**:

```plaintext
4
```

**Explanation**:

- The longest subarrays with equal `0`s and `1`s are \( $\text{arr[0...3]}$ \) or \( $\text{arr[1...4]}$ \), both with a length of \( 4 \).

---

### Example 3

**Input**:

```plaintext
arr = [0]
```

**Output**:

```plaintext
0
```

**Explanation**:

- No subarray exists with equal `0`s and `1`s.

---

## 💡 Approach

### Optimized Approach Using HashMap

1. **Transform the Array**:

   - Replace all `0`s in the array with `-1`.
   - This transformation allows us to find subarrays with a sum of `0`, which corresponds to equal counts of `1`s and `0`s in the original array.

2. **Prefix Sum with HashMap**:

   - Use a running sum (`prefixSum`) to calculate the cumulative sum of the array.
   - Use a `HashMap` to store the first occurrence of each `prefixSum`.

3. **Check for Subarray with Sum `0`**:

   - If `prefixSum` is `0`, the subarray from the start to the current index has an equal count of `0`s and `1`s.
   - If `prefixSum` is already in the `HashMap`, calculate the length of the subarray from the first occurrence to the current index and update the maximum length.

4. **Edge Cases**:
   - An array with no subarray having equal `0`s and `1`s.
   - Single-element arrays.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): The array is traversed once.

### Space Complexity

- \( O(n) \): The `HashMap` stores at most \( n \) entries.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public int maxLen(int[] arr) {
        int n = arr.length;

        // Step 1: Replace 0s with -1
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            }
        }

        // Step 2: Use HashMap for prefix sum
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            // If prefixSum is 0, subarray from 0 to i has equal 0s and 1s
            if (prefixSum == 0) {
                maxLength = i + 1;
            }

            // If prefixSum is seen before, calculate the length of subarray
            if (prefixSumMap.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(prefixSum));
            } else {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the size of the array: 7
Enter the elements of the array (0s and 1s only):
1 0 1 1 1 0 0
```

### Execution Steps:

1. **Transform Array**:

   ```plaintext
   arr = [1, -1, 1, 1, 1, -1, -1]
   ```

2. **Prefix Sum Calculation**:

   - \( i = 0, $\text{prefixSum}$ = 1, $\text{maxLength}$ = 0 \).
   - \( i = 1, $\text{prefixSum}$ = 0, $\text{maxLength}$ = 2 \).
   - \( i = 2, $\text{prefixSum}$ = 1 \) → `prefixSumMap` contains \( 1 \), update \( $\text{maxLength}$ = 2 \).
   - Continue for all indices...

3. **Final Result**:
   ```plaintext
   Length of the longest subarray with equal 0s and 1s: 6
   ```

---

## ✨ Key Takeaways

- **HashMap + Prefix Sum** efficiently solves the problem in \( O(n) \).
- Transforming `0`s to `-1`s simplifies the logic to finding subarrays with a sum of `0`.

**Happy Coding!** 🚀
