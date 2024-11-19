# Next Permutation🔄

## Problem Statement

Given an array of integers `arr[]` representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).

**Note** - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

---

## Function Description

**Function Name:**

```
nextPermutation(arr)

**Input:**

arr – Array of integers.

**Output:**
Rearranges arr to the next permutation in-place.
```

---

### **Input Format**

- An integer array arr of size n.

---

### **Output Format**

- An array rearranged to the next permutation.

---

## 📊 Examples

### Example 1

#### Input:

```
arr = [1, 2, 3]

```

**Output:**

```java
[1, 3, 2]
```

### Explanation:

The next permutation of [1, 2, 3] is [1, 3, 2].

### Example 2

#### Input

```
arr = [3, 2, 1]
```

**Output:**

```java
[1, 2, 3]
```

#### Explanation:

Since no higher permutation exists, it's rearranged as the lowest permutation.

---

## 🧠 Approach and Solution

1. Find the Pivot: Identify the first index from the right where arr[i] < arr[i+1]. This is the pivot point.
2. Find the Successor: Find the smallest number larger than arr[pivot] from the right of the array.
3. Swap: Swap the pivot element with its successor.
4. Reverse: Reverse the subarray after the pivot to get the next permutation.

---

### Constraints:

```
1<=arr.size(), d <=10^5
0 <= arr[i] <= 10^5
```

# Time Complexity

- Time Complexity: O(n), where 𝑛 is the size of the array.
- Space Complexity: O(1), as no extra space is used.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
