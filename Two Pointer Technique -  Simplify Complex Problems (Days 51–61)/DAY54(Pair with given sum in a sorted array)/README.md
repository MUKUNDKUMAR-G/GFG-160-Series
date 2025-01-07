# 🌟 Pair with Given Sum in a Sorted Array

---

## 💡 Problem Statement

You are given an integer `target` and a **sorted array** `arr[]`. Your task is to find the number of **pairs** \( (i, j) \) such that:

- \( arr[i] + arr[j] = $\text{target}$ \), where \( i < j \).
- Each pair must use elements at distinct indices.

---

## 🔒 Constraints

- \( $-10^5$ $\leq$ $\text{target}$ $\leq$ $10^5$ \)
- \( 2 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( $-10^5$ $\leq$ $\text{arr[i]}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int countPairs(int[] arr, int target);
}
```

### Parameters

- **`arr[]`**: A sorted array of integers.
- **`target`**: An integer representing the desired sum.

### Returns

- An integer representing the total number of valid pairs whose sum is equal to the `target`.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers in sorted order.
3. An integer \( target \), the target sum.

---

## 📤 Output Format

- An integer representing the total number of valid pairs.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [-1, 1, 5, 5, 7], target = 6
```

**Output**:

```plaintext
3
```

**Explanation**:  
The valid pairs are:

1. \( (1, 5) \): Sum = \( 6 \)
2. \( (1, 5) \): Sum = \( 6 \)
3. \( (-1, 7) \): Sum = \( 6 \)

---

### Example 2

**Input**:

```plaintext
arr = [1, 1, 1, 1], target = 2
```

**Output**:

```plaintext
6
```

**Explanation**:  
The valid pairs are:

1. \( (1, 1) \): Sum = \( 2 \)
2. \( (1, 1) \): Sum = \( 2 \)
3. \( (1, 1) \): Sum = \( 2 \)
4. \( (1, 1) \): Sum = \( 2 \)
5. \( (1, 1) \): Sum = \( 2 \)
6. \( (1, 1) \): Sum = \( 2 \)

---

### Example 3

**Input**:

```plaintext
arr = [-1, 10, 10, 12, 15], target = 125
```

**Output**:

```plaintext
0
```

**Explanation**:  
No valid pair sums up to \( 125 \).

---

## 💡 Approach

### Two-Pointer Technique

Since the array is sorted, we can use the **two-pointer approach** to find pairs efficiently:

1. **Initialize Two Pointers**:

   - Start with \( left = 0 \) and \( right = n - 1 \).

2. **Check Pair Sum**:

   - Compute the sum \( $\text{arr[left]}$ + $\text{arr[right]}$ \).
   - If the sum equals the target:
     - Count the pair.
     - Handle duplicates by moving \( left \) and \( right \) appropriately to count all valid pairs.
   - If the sum is less than the target, increment \( left \) to increase the sum.
   - If the sum is greater than the target, decrement \( right \) to reduce the sum.

3. **Continue Until \( left < right \)**:

   - Repeat until \( left \) and \( right \) pointers meet.

4. **Edge Case**:
   - If the array contains fewer than 2 elements, return 0.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- The two-pointer traversal takes \( O(n) \).
- **Overall**: \( O(n) \).

### Space Complexity

- \( O(1) \): No extra space is used apart from variables.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public int countPairs(int[] arr, int target) {
        int count = 0;
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                count++;

                int tempLeft = left + 1;
                while (tempLeft < right && arr[tempLeft] == arr[left]) {
                    count++;
                    tempLeft++;
                }

                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
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
Enter the size of the array: 5
Enter the elements of the array:
-1 1 5 5 7
Enter the target sum: 6
```

### Execution Steps:

1. **Initial Array**:

   ```plaintext
   arr = [-1, 1, 5, 5, 7], target = 6
   ```

2. **Two-Pointer Traversal**:

   - \( left = 0, right = 4 \):
     - Sum = \( -1 + 7 = 6 \), count = 1.
     - Move \( right \) to \( 3 \).
   - \( left = 1, right = 3 \):
     - Sum = \( 1 + 5 = 6 \), count = 2.
     - Move \( right \) to \( 2 \).
   - \( left = 1, right = 2 \):
     - Sum = \( 1 + 5 = 6 \), count = 3.
     - Move \( right \) to \( 1 \).

3. **Output**:
   ```plaintext
   Number of pairs with sum 6: 3
   ```

---

## ✨ Key Takeaways

- **Two-pointer Technique**: Ensures \( O(n) \) time complexity for sorted arrays.
- **Handles Duplicates**: Properly counts all valid pairs without overcounting.
- **Edge Cases**: Works efficiently for arrays with duplicates and large inputs.

**Happy Coding!** 🚀
