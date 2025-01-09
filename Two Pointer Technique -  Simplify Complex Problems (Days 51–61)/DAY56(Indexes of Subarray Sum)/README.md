# 🌟 Indexes of Subarray Sum

---

## 💡 Problem Statement

Given an array `arr[]` of non-negative integers and a target sum `target`, find a **continuous subarray** (a contiguous sequence of elements) whose sum equals the target.

- Return the **1-based indices** of the leftmost and rightmost elements of this subarray.
- If no such subarray exists, return `[-1]`.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^6$ \)
- \( 0 $\leq$ $\text{arr[i]}$ $\leq$ $10^3$ \)
- \( 0 $\leq$ $\text{target}$ $\leq$ $10^9$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int target);
}
```

### Parameters

- **`arr[]`**: An array of non-negative integers.
- **`target`**: An integer representing the target sum.

### Returns

- An **ArrayList** of integers containing two elements: the 1-based indices of the leftmost and rightmost elements of the subarray, or `[-1]` if no such subarray exists.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) non-negative integers.
3. An integer \( target \), the target sum.

---

## 📤 Output Format

- A list of integers representing the indices of the leftmost and rightmost elements of the subarray, or `[-1]`.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [1, 2, 3, 7, 5], target = 12
```

**Output**:

```plaintext
[2, 4]
```

**Explanation**:  
The sum of elements from the 2nd to the 4th position is \( 2 + 3 + 7 = 12 \).

---

### Example 2

**Input**:

```plaintext
arr = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], target = 15
```

**Output**:

```plaintext
[1, 5]
```

**Explanation**:  
The sum of elements from the 1st to the 5th position is \( 1 + 2 + 3 + 4 + 5 = 15 \).

---

### Example 3

**Input**:

```plaintext
arr = [5, 3, 4], target = 2
```

**Output**:

```plaintext
[-1]
```

**Explanation**:  
There is no subarray with sum equal to \( 2 \).

---

## 💡 Approach

### Optimized Sliding Window Technique

1. **Initialize Two Pointers**:

   - Use \( $\text{start} = 0$ \) and \( $\text{end}$ \) to traverse the array.

2. **Maintain a Window Sum**:

   - Use a variable \( $\text{currentSum}$ \) to keep track of the sum of the current subarray between \( $\text{start}$ \) and \( $\text{end}$ \).

3. **Adjust the Window**:

   - If \( $\text{currentSum}$ < $\text{target}$ \), extend the window by incrementing \( $\text{end}$ \).
   - If \( $\text{currentSum}$ > $\text{target}$ \), shrink the window by incrementing \( $\text{start}$ \).

4. **Check for Match**:

   - If \( $\text{currentSum}$ == $\text{target}$ \), return the 1-based indices \( $[\text{start}$ + 1, $\text{end}$ + 1] \).

5. **Edge Cases**:
   - If no such subarray is found, return `[-1]`.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): The array is traversed once using the sliding window technique.

### Space Complexity

- \( O(1) \): No additional space is required.

---

## 🖥️ Solution

### Java Implementation

```java

class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int currentSum = 0;
        int start = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            if (currentSum == target) {
                result.add(start + 1);
                result.add(end + 1);
                return result;
            }
        }

        result.add(-1);
        return result;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
1 2 3 7 5
 12
```

### Execution Steps:

1. **Initial Array**:

   ```plaintext
   arr = [1, 2, 3, 7, 5], target = 12
   ```

2. **Sliding Window Execution**:

   - \( $\text{end}$ = 0, $\text{currentSum}$ = 1 \).
   - \( $\text{end}$ = 1, $\text{currentSum}$ = 3 \).
   - \( $\text{end}$ = 2, $\text{currentSum}$ = 6 \).
   - \( $\text{end}$ = 3, $\text{currentSum}$ = 13 \): Shrink window (\( $\text{start}$ = 1 \), \( $\text{currentSum}$ = 12 \)).
   - \( $\text{currentSum}$ == $\text{target}$ \): Return \( [2, 4] \).

3. **Output**:
   ```plaintext
   Subarray indices: [2, 4]
   ```

---

## ✨ Key Takeaways

- The **sliding window technique** optimally finds the subarray in \( O(n) \) time.
- Proper handling of edge cases, such as no subarray or large arrays, ensures robustness.

**Happy Coding!** 🚀
