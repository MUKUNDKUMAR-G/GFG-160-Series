# Sort 0s, 1s, and 2s 🚦

## 📝Problem Statement

You are given an array arr[] consisting of only 0s, 1s, and 2s. The task is to sort this array in ascending order without using extra space.

The most efficient solution leverages the **Dutch National Flag Algorithm 🏳️** to perform sorting in a single pass.

---

🔒 Constraints:

```
- 1≤arr.size()≤10^6
- 0≤arr[i]≤2
```

---

## 📜 Function Description

**Function**:

```java
public static void sortArray(int[] arr) {
    // Implementation here
}

Parameters:

arr (int[]): An array of integers containing only 0s, 1s, and 2s.
```

---

### **📥 Input Format**

- A single array of integers containing only the elements {0, 1, 2}.

### ** 📤Output Format**

- The same array, sorted in ascending order.

---

## 🧩 Examples

### Example 1

#### Input:

```
arr = [0, 1, 2, 0, 1, 2]
```

**Output:**

```java
[0, 0, 1, 1, 2, 2]
```

### Explanation:

- 0s 1s and 2s are segregated into ascending order.

### Example 2

#### Input:

```
[0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
```

**Output:**

```java
[0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
```

### Explanation:

0s 1s and 2s are segregated into ascending order.

---

## 🧠 Approach

### The solution uses three pointers to sort the array in a single traversal:

    - low: Marks the boundary for 0s.
    - mid: Traverses through the array.
    - high: Marks the boundary for 2s.

### Steps to Solve:

1. Initialize three pointers: low = 0, mid = 0, and high = arr.length - 1.

2. While mid <= high:
   - If the element at mid is 0, swap it with the element at low, and increment both pointers.
   - If the element at mid is 1, move the mid pointer.
   - If the element at mid is 2, swap it with the element at high and decrement high.

---

# Time Complexity

Time Complexity: O(n), where n is the size of the array.
Space Complexity: O(1), as sorting is performed in-place.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
