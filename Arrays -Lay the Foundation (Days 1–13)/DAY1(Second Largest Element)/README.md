# Second Largest Element Finder🥈

## Problem Statement

Given an array arr[] of size n, the task is to find the second largest element in the array. If there is no second largest element (all elements are the same or the array has only one element), return -1.

---

## Function Description

**Function Name:**

```
int print2largest(int[] arr)
```

**Parameters:**

`int arr[]` — An array of integers.

**Returns:**

An integer representing the second largest element or `-1` if no such element exists.

---

### **Input Format**

- The first line contains an integer `n`, the size of the array.
- The second line contains `n` space-separated integers representing the elements of the array.

---

### **Output Format**

- Print a single integer — the **second largest element** in the array, or `-1` if it does not exist.

---

## 📊 Examples

### Example 1

#### Input:

```
n = 6
arr[] = {12, 35, 1, 10, 34, 1}

```

**Output:**

```java
34
```

### Explanation:

The largest element is `35`, and the second largest is `34`.

### Example 2

#### Input

```
n = 3
arr[] = {10, 10, 10}

```

**Output:**

```java
-1
```

#### Explanation:

All elements are the same, so there is no second largest element.

---

## 🧠 Approach and Solution

1. Initialize Variables: Use two variables `largest` and `secondLargest` to keep track of the largest and second largest elements.
2. Iterate Through Array:
   - Update `largest` and `secondLargest` if a larger element is found.
   - Update only secondLargest if the current element is greater than it but less than largest.
3. Handle Edge Cases:
   - If the array has fewer than two elements, return `-1`.
   - If no valid second largest is found, return `-1`.
4. Time Complexity: **𝑂(𝑛)**, as we traverse the array once.
5. Auxiliary Space: **𝑂(1)**, as no extra space is used.

---

# Time Complexity

Best, Worst, and Average Case: 𝑂(𝑛), as the algorithm always iterates through the array once.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
