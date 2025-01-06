# 🌟 Sum Pair Closest to Target

---

## 💡 Problem Statement

Given an array `arr[]` and a number `target`, find a **pair of elements (a, b)** in `arr[]` such that:

1. The **sum** \( a + b \) is closest to the `target`.
2. If multiple pairs have the same closest sum, choose the pair with the **maximum absolute difference** \( |b - a| \).
3. Return the pair in **sorted order** \( [a, b] \).
4. If no valid pair exists, return an **empty array**.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ 2 $\times$ $10^5$ \)
- \( 0 $\leq$ $\text{target}$ $\leq 2$ $\times$ $10^5$ \)
- \( 0 $\leq$ $\text{arr[i]}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public List<Integer> sumClosest(int[] arr, int target);
}
```

### Parameters

- **`arr[]`**: An integer array.
- **`target`**: An integer representing the target sum.

### Returns

- A list of two integers \( [a, b] \) representing the pair with the closest sum to the target, or an **empty list** if no such pair exists.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.
3. An integer \( target \), the target sum.

---

## 📤 Output Format

- A list of integers representing the pair \( [a, b] \) closest to the target.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [10, 30, 20, 5], target = 25
```

**Output**:

```plaintext
[5, 20]
```

**Explanation**:  
The pair \( (5, 20) \) has a sum \( 5 + 20 = 25 \), which is exactly equal to the target.

---

### Example 2

**Input**:

```plaintext
arr = [5, 2, 7, 1, 4], target = 10
```

**Output**:

```plaintext
[2, 7]
```

**Explanation**:  
The pairs \( (4, 7) \) and \( (2, 7) \) both have a sum \( 11 \), which is closest to the target. However, \( (2, 7) \) has a larger absolute difference \( |7 - 2| = 5 \), compared to \( |7 - 4| = 3 \).

---

### Example 3

**Input**:

```plaintext
arr = [10], target = 10
```

**Output**:

```plaintext
[]
```

**Explanation**:  
Since there is only one element, no valid pair exists.

---

## 💡 Approach

### Optimized Two-Pointer Technique

1. **Edge Case**:

   - If the size of the array is less than 2, return an empty array.

2. **Sort the Array**:

   - Sort the array in ascending order. This allows us to efficiently use the two-pointer technique.

3. **Two-Pointer Traversal**:

   - Initialize two pointers: \( i = 0 \) (left) and \( j = n - 1 \) (right).
   - Maintain variables to track:
     - The closest sum to the target.
     - The pair with the largest absolute difference for ties.

4. **Check the Sum**:

   - Compute the sum \( $\text{arr[i]}$ + $\text{arr[j]}$ \).
   - Update the closest sum and pair if the current sum is closer to the target.
   - For ties, prefer the pair with the maximum absolute difference.
   - Adjust pointers based on whether the sum is less than or greater than the target.

5. **Return the Pair**:
   - Return the closest pair in sorted order, or an empty list if no pair exists.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- Sorting the array: \( $O(n \log n)$ \).
- Two-pointer traversal: \($ O(n)$ \).
- **Overall**: \( $O(n \log n)$ \).

### Space Complexity

- \( O(1) \): No additional space apart from variables.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        if (arr.length < 2) {
            return new ArrayList<>();
        }

        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;
        int closestDiff = Integer.MAX_VALUE;
        int maxAbsDiff = Integer.MIN_VALUE;
        int a = -1, b = -1;

        while (left < right) {
            int sum = arr[left] + arr[right];
            int diff = Math.abs(target - sum);

            if (diff < closestDiff || (diff == closestDiff && (arr[right] - arr[left] > maxAbsDiff))) {
                closestDiff = diff;
                maxAbsDiff = arr[right] - arr[left];
                a = arr[left];
                b = arr[right];
            }

            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return a == -1 ? new ArrayList<>() : Arrays.asList(a, b);
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
arr = [5, 2, 7, 1, 4], target = 10
```

### Execution Steps:

1. **Sort the Array**:

   ```plaintext
   arr = [1, 2, 4, 5, 7]
   ```

2. **Two-Pointer Traversal**:

   - \( i = 0, j = 4 \):
     - \( 1 + 7 = 8 \), closest so far.
     - Move \( i \) to \( 1 \).
   - \( i = 1, j = 4 \):
     - \( 2 + 7 = 9 \), update closest pair.
     - Move \( i \) to \( 2 \).
   - \( i = 2, j = 4 \):
     - \( 4 + 7 = 11 \), exceeds target, move \( j \) to \( 3 \).
   - \( i = 2, j = 3 \):
     - \( 4 + 5 = 9 \), same sum but smaller difference.

3. **Result**:
   ```plaintext
   Closest pair: [2, 7]
   ```

---

## ✨ Key Takeaways

- **Two-pointer Technique**: Efficiently finds the closest pair in \( $O(n \log n)$ \).
- **Handles Edge Cases**: Correctly handles ties using maximum absolute difference.

**Happy Coding!** 🚀
