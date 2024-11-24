# Kadane's Algorithm

## 📜Problem Statement

Given an integer array arr[]. You need to find the maximum sum of a subarray.

---

## Function Description

**Function**:
int maxSubarraySum(int[] arr)

Input: An integer array arr[] of size n.
Output: Returns the maximum sum of any contiguous subarray.

---

### **Input Format**

- contains N space-separated integers denoting the array arr[].

---

### **Output Format**

- Maximum sum of any contiguous subarray

---

## 📊 Examples

### Example 1

#### Input:

```
arr[] = [2, 3, -8, 7, -1, 2, 3]

```

**Output:**

```java
11
```

### Explanation:

The subarray {7, -1, 2, 3} has the largest sum 11.

### Example 2

#### Input:

```
arr[] = [-2, -4]

```

**Output:**

```java
-2
```

### Explanation:

The subarray {-2} has the largest sum -2.

---

## 🧠 Approach and Solution

Kadane's Algorithm:

1. Start by initializing sum as 0 and maxSum as the first element of the array.
2. Traverse the array: - Add the current element to sum. - Update maxSum to the maximum of maxSum and sum.
   -If sum becomes negative, reset sum to 0.
   3.Return maxSum.

---

### Constraints:

```
1 ≤ arr.size() ≤ 10^5
-10^9 ≤ arr[i] ≤ 10^4
```

# Time Complexity

- Time Complexity: O(n) Single traversal of the array.
- Space Complexity: O(1), We only use a few variables (No additional data structures are used).

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
