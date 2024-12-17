# Max Circular Subarray Sum 🔄

## 📜Problem Statement

Given an array of integers arr[] arranged circularly, determine the maximum subarray sum that can be achieved. Circular arrangement means subarrays can wrap around the end of the array to the beginning.

---

## Function Description

**Function**:

```
Function Name: circularSubarraySum

Parameters:
int[] arr: The input array.

Returns:
int: The maximum circular subarray sum.
```

---

### **Input Format**

- arr[]: An array of integers, where 1≤arr.size()≤10^5.
- Array elements: −10^4≤arr[i]≤10^4.

---

### **Output Format**

- A single integer representing the maximum circular subarray sum.

---

## 📊 Examples

### Example 1

#### Input:

```
arr = [8, -8, 9, -9, 10, -11, 12]

```

**Output:**

```java
22
```

### Explanation:

Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.

---

### Example 2

#### Input:

```
arr[] = [10, -3, -4, 7, 6, 5, -4, -1]

```

**Output:**

```java
23
```

### Explanation:

Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].

---

## 🧠 Approach and Solution

1. Calculate the maximum subarray sum using Kadane’s Algorithm:
   This gives the maximum subarray sum for non-circular cases.

2. Calculate the total sum of the array:
   This will be used to find the circular maximum.

3. Calculate the minimum subarray sum using a modified Kadane’s Algorithm:
   This finds the smallest subarray sum. Subtracting this from the total sum gives the circular sum.

4. Handle edge cases:
   If all elements are negative, the maximum subarray sum will be the largest single element (non-circular).

5. Compare and return:
   The result is the maximum of maxKadane and (totalSum - minKadane).

---

### Constraints:

```
1 ≤ arr.size() ≤ 10^5
-10^5 ≤ arr[i] ≤ 10^5
```

# Time Complexity

- Time Complexity: O(n) Single traversal of the array.
- Space Complexity: O(1), We only use a few variables (No additional data structures are used).

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
