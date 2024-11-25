# 🌟Maximum Product Subarray

## 📜Problem Statement

Given an array arr[] containing both positive and negative integers (may include 0), find the maximum product of any subarray in arr. It is guaranteed that the result fits in a 32-bit integer.

---

## Function Description

**Function**:
The function maxProduct(int[] arr) returns the maximum product of any subarray.

---

### **Input Format**

- arr[]: An array of integers, where 1≤arr.size()≤10^6.
- Array elements: −10≤arr[i]≤10.

---

### **Output Format**

- A single integer representing the maximum product of a subarray.

---

## 📊 Examples

### Example 1

#### Input:

```
arr[] = [-2, 6, -3, -10, 0, 2]

```

**Output:**

```java
180
```

### Explanation:

Subarray {6, -3, -10} gives the maximum product 6×(−3)×(−10)=180.

---

### Example 2

#### Input:

```
arr[] = [-1, -3, -10, 0, 6]

```

**Output:**

```java
30
```

### Explanation:

Subarray {-3, -10} gives the maximum product (−3)×(−10)=30.

---

## 🧠 Approach and Solution

1. Initialization:

   - Maintain three variables:
     - maxProduct to store the global maximum product.
     - currMax to store the current maximum product at each index.
     - currMin to store the current minimum product (important for handling negatives).

2. Iterate Through Array:

   - For each element, calculate:
     - tempMax = currMax (to preserve the previous value of currMax).
     - currMax = max(arr[i], tempMax _ arr[i], currMin _ arr[i]).
     - currMin = min(arr[i], tempMax _ arr[i], currMin _ arr[i]).
     - Update maxProduct to be the maximum of itself and currMax.

3. Return the value of maxProduct.

---

### Constraints:

```
1 ≤ arr.size() ≤ 10^6
-10 ≤ arr[i] ≤ 10
```

# Time Complexity

- Time Complexity: O(n) Single traversal of the array.
- Space Complexity: O(1), We only use a few variables (No additional data structures are used).

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
