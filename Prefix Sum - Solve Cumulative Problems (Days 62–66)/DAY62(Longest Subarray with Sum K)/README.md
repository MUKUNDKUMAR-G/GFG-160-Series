# 🌟 Longest Subarray with Sum \( k \)

---

## 💡 Problem Statement

Given an array `arr[]` of integers and a target sum `k`, your task is to find the **length of the longest subarray** where the sum of its elements equals \( k \). If no such subarray exists, return \( 0 \).

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( $-10^4$ $\leq$ $\text{arr[i]}$ $\leq$ $10^4$ \)
- \( $-10^9$ $\leq$ k $\leq$ $10^9$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int longestSubarray(int[] arr, int k);
}
```

### Parameters

- **`arr[]`**: An array of integers.
- **`k`**: The target sum to achieve.

### Returns

- An integer representing the length of the longest subarray where the sum equals \( k \).

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.
3. An integer \( k \), the target sum.

---

## 📤 Output Format

- A single integer representing the length of the longest subarray with sum equal to \( k \).

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [10, 5, 2, 7, 1, -10], k = 15
```

**Output**:

```plaintext
6
```

**Explanation**:

- Subarrays with sum = \( 15 \) are:
  - \( [10, 5] \) (length = 2)
  - \( [5, 2, 7, 1] \) (length = 4)
  - \( [10, 5, 2, 7, 1, -10] \) (length = 6).
- The longest subarray is of length \( 6 \).

---

### Example 2

**Input**:

```plaintext
arr = [-5, 8, -14, 2, 4, 12], k = -5
```

**Output**:

```plaintext
5
```

**Explanation**:

- Subarray with sum = \( -5 \) is:
  - \( [-5, 8, -14, 2, 4] \) (length = 5).

---

### Example 3

**Input**:

```plaintext
arr = [10, -10, 20, 30], k = 5
```

**Output**:

```plaintext
0
```

**Explanation**:

- No subarray with sum = \( 5 \) exists.

---

## 💡 Approach

### Optimized Approach with HashMap

1. **Prefix Sum**:

   - Use a running `sum` to keep track of the cumulative sum as we iterate through the array.

2. **HashMap for Lookup**:

   - Maintain a `HashMap` to store the first occurrence of each prefix sum and its index.
   - The difference between the current `sum` and \( k \) gives the prefix sum that, when removed, leaves a subarray with sum \( k \).

3. **Key Idea**:

   - If \( $\text{sum}$ - k \) exists in the `HashMap`, compute the length of the subarray.
   - Update the maximum length whenever a longer subarray is found.

4. **Edge Case**:
   - If \( $\text{sum}$ == k \), the subarray from the beginning to the current index has a sum \( k \).

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): The array is traversed once.

### Space Complexity

- \( O(n) \): The `HashMap` stores at most \( n \) prefix sums.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;
        int maxLength = 0;

        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLength = i + 1;
            }
            if (prefixSumMap.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum - k));
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
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
Enter the size of the array: 6
Enter the elements of the array:
10 5 2 7 1 -10
Enter the target sum (k): 15
```

### Execution Steps:

1. **Initial Variables**:

   ```plaintext
   sum = 0, maxLength = 0, prefixSumMap = {}
   ```

2. **Processing Each Element**:

   - \( i = 0 \), \( arr[0] = 10 \):

     - \( $\text{sum}$ = 10 \), \( $\text{maxLength}$ = 0 \).
     - Add \( $\text{sum}$ \) to `prefixSumMap`: \( {10: 0} \).

   - \( i = 1 \), \( arr[1] = 5 \):

     - \( $\text{sum}$ = 15 \), \( $\text{maxLength}$ = 2 \).
     - Add \( $\text{sum}$ \) to `prefixSumMap`: \( {10: 0, 15: 1} \).

   - \( i = 2 \), \( arr[2] = 2 \):

     - \( $\text{sum}$ = 17 \), \( $\text{maxLength}$ = 2 \).
     - Add \( $\text{sum}$ \) to `prefixSumMap`: \( {10: 0, 15: 1, 17: 2} \).

   - Continue until \( i = 5 \).

3. **Final Result**:
   ```plaintext
   Length of the longest subarray with sum k: 6
   ```

---

## ✨ Key Takeaways

- The **prefix sum + HashMap** approach is efficient, handling large arrays within constraints.
- Handles negative numbers gracefully by tracking cumulative sums.

**Happy Coding!** 🚀
