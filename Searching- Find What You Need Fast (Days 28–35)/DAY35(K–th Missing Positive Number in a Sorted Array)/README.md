# 🔍 K-th Missing Positive Number in a Sorted Array

---

## 💡 Problem Statement

Given a **sorted array** `arr[]` of distinct positive integers and an integer \( k \), find the \( k \)-th positive number that is **missing** from the array.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \) 🧮
- \( 1 $\leq$ $k$ $\leq$ $10^5$ \) 🔢
- \( 1 $\leq$ $\text{arr}[i]$ $\leq$ $10^6$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int kthMissing(int[] arr, int k);
}
```

### Parameters

- **`arr[]`**: A sorted array of distinct positive integers.
- **`k`**: The index (1-based) of the missing positive number to find.

### Returns

- The \( k \)-th missing positive integer.

---

## 📥 Input Format

1. A sorted array `arr[]` of size \( n \).
2. An integer `k`.

---

## 📤 Output Format

- The \( k \)-th missing positive integer.

---

## 🎯 Examples

### Example 1

**Input**:  
`arr = [2, 3, 4, 7, 11], k = 5`

**Output**:  
`9`

**Explanation**:  
Missing numbers are \([1, 5, 6, 8, 9, 10, ...]\).  
The \( $5^{th}$ \) missing number is `9`.

---

### Example 2

**Input**:  
`arr = [1, 2, 3], k = 2`

**Output**:  
`5`

**Explanation**:  
Missing numbers are \([4, 5, 6, ...]\).  
The \( $2^{nd}$ \) missing number is `5`.

---

### Example 3

**Input**:  
`arr = [3, 5, 9, 10, 11, 12], k = 2`

**Output**:  
`2`

**Explanation**:  
Missing numbers are \([1, 2, 4, 6, 7, 8, ...]\).  
The \( $2^{nd}$ \) missing number is `2`.

---

Here’s an enhanced explanation that includes **your approach** alongside the optimized binary search approach. It also details the time complexity of both methods.

---

## 💡 Approach

### 1️⃣ **Iterative Counting**

#### Steps:

1. Iterate through the array using a loop and count the number of missing numbers sequentially.
2. For each number `j` starting from `1`, compare it with the current array element:
   - If the number exists in the array (e.g., `arr[i] == j`), move to the next element in the array.
   - Otherwise, increment the count of missing numbers.
3. Continue this process until the \( k \)-th missing number is found or all array elements are processed.
4. If \( k \) is not yet reached, compute the missing number as \( $\text{arr[n-1]}$ + $(k$ - $\text{count}$) \).

#### Time Complexity:

- **Outer Loop**: Iterates through all missing numbers up to the largest number in the array (\( $\text{O}$($\text{max(arr[n-1]}$, k)) \)).
- **Worst Case**: Linear iteration for large values of \( k \), resulting in \( $\text{O(n + k)}$ \).

---

### 2️⃣ **Optimized Approach (Binary Search)**

Instead of iterating over every number, use **binary search** to directly locate the \( k \)-th missing positive number efficiently.

#### Key Idea:

- **Missing Numbers Count**: For any index `i`, calculate how many positive integers are missing before \( $\text{arr[i]}$ \):
  \[
  $\text{missingCount(i)}$ = $\text{arr[i]}$ - (i + 1)
  \]

#### Steps:

1. Initialize two pointers: `low = 0` and `high = n-1`.
2. Perform binary search:
   - Calculate `mid = (low + high) / 2`.
   - Compute `missingCount(mid)`.
   - If the missing count at `mid` is less than \( k \), the \( k \)-th missing number lies to the right. Update \( \text{low = mid + 1} \).
   - Otherwise, it lies to the left. Update \( \text{high = mid - 1} \).
3. When the search ends, compute the \( k \)-th missing number as:
   \[
   \text{k-th missing number} = k + \text{high} + 1
   \]

#### Time Complexity:

- **Binary Search**: \( $\text{O}(\log n)$ \) for finding the range of the missing number.
- **Overall Complexity**: \( $\text{O}(\log n)$ \), significantly faster than the iterative approach.

---

## 🛠️ Comparison of Approaches

| Feature                    | Iterative Approach         | Optimized Binary Search Approach  |
| -------------------------- | -------------------------- | --------------------------------- |
| **Time Complexity**        | \( O(n + k) \)             | \( O($\log n$) \)                 |
| **Space Complexity**       | \( O(1) \)                 | \( O(1) \)                        |
| **Iterative Nature**       | Linear Iteration           | Logarithmic Search                |
| **Performance on Large k** | Degrades for large \( k \) | Handles large \( k \) efficiently |

---

## 🖥️ Solution Code

### Your Approach

Here’s your code with a refined explanation:

```java
class Solution {
    public int kthMissing(int[] arr, int k) {
        int n = arr.length;
        int i = 0; // Pointer for array traversal
        int count = 0; // Count of missing numbers

        // Iterate through numbers starting from 1
        for (int j = 1; j <= arr[n - 1]; j++) {
            if (i < n && arr[i] == j) {
                i++; // Move to the next array element
            } else {
                count++; // Increment missing count
                if (count == k) {
                    return j; // Found the k-th missing number
                }
            }
        }

        // If k-th missing number is beyond the largest number in the array
        return arr[n - 1] + (k - count);
    }
}
```

### Optimized Binary Search Approach

```java
class Solution {
    public int kthMissing(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        // Perform binary search to find the range of the k-th missing number
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int missingCount = arr[mid] - (mid + 1);

            if (missingCount < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Compute the k-th missing number
        return k + high + 1;
    }
}
```

### Example Execution Walkthrough

#### Input:

```plaintext
arr = [2, 3, 4, 7, 11], k = 5
```

#### Execution with Your Approach:

1. Iterate through numbers starting from `1`.
2. Missing numbers: `1, 5, 6, 8, 9`.
3. Stop at \( 5^{th} \) missing number: `9`.

#### Execution with Optimized Approach:

1. Perform binary search:
   - Midpoint `mid = 2`, \( $\text{missingCount(2)}$ = 1 \) (search right).
   - Midpoint `mid = 3`, \( $\text{missingCount(3)}$ = 3 \) (search right).
   - Midpoint `mid = 4`, \( $\text{missingCount(4)}$ = 6 \) (search left).
2. Result: \( k + \text{high} + 1 = 5 + 3 + 1 = 9 \).

#### Output:

```plaintext
The 5-th missing positive number is: 9
```

---

## ✨ Key Takeaways

- **Binary Search** ensures efficient computation of missing numbers.
- Handles edge cases gracefully, such as when \( k \) exceeds the total missing numbers in the array.

**Happy Coding!** 💻🚀
