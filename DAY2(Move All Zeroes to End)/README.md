# Move All Zeroes to End of Array🌟

## Problem Statement

Given an array arr[]. Push all the zeros of the given array to the right end of the array while maintaining the order of non-zero elements. **Do the mentioned change in the array in place**.

---

## Function Description

**Function Name:**

```
void pushZerosToEnd(int arr)
```

**The function takes:**

`arr[]`: an array of integers.

**Returns:**

No Return : It rearranges the array such that all zeros are moved to the end.

---

### **Input Format**

- An integer n, the size of the array.

---

### **Output Format**

- The input array modified with all zeros shifted to the end.

---

## 📊 Examples

### Example 1

#### Input:

```
n = 5
arr[] = {3, 5, 0, 0, 4}

```

**Output:**

```java
3 5 4 0 0
```

### Explanation:

There are two 0s that are moved to the end.

### Example 2

#### Input

```
n = 4
arr[] = {0, 0, 0, 4}

```

**Output:**

```java
4 0 0 0
```

#### Explanation:

There are three 0s that are moved to the end.

---

## 🧠 Approach and Solution

1. Use a pointer `count` to track the position for the next non-zero element.
2. Traverse the array.
3. On encountering a `non-zero element`:
   - Swap it with the element at arr[count].
   - Increment count.
4. This ensures non-zero elements are placed in the correct order and zeros are pushed to the end.

---

# Time Complexity

Best, Worst, and Average Case: 𝑂(𝑛), as the algorithm always iterates through the array once.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
