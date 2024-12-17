# Reverse an Array🔄

## Problem Statement

You are given an array of size **N**. The task is to reverse the array so that the first element becomes the last, the second becomes the second last, and so on.

---

## Function Description

**Function Name:**

```
void reverseArray(arr)
```

- Input: An array arr of integers.
- Output: The same array, reversed in-place.

---

### **Input Format**

- An array of N integers.

---

### **Output Format**

- The reversed array.

---

## 📊 Examples

### Example 1

#### Input:

```
N = 6,
arr = [1, 4, 3, 2, 6, 5]

```

**Output:**

```java
[5, 6, 2, 3, 4, 1]
```

### Explanation:

The elements of the array are 1 4 3 2 6 5. After reversing the array, the first element goes to the last position, the second element goes to the second last position and so on. Hence, the answer is 5 6 2 3 4 1.

### Example 2

#### Input

```
N = 3,
arr = [4, 5, 2]

```

**Output:**

```java
[2, 5, 4]
```

#### Explanation:

The elements of the array are 4 5 2. The reversed array will be 2 5 4.

---

## 🧠 Approach and Solution

1. Two-Pointer Technique:
   - Initialize two pointers: start at the beginning and end at the last element of the array.
   - Swap the elements at start and end.
   - Increment start and decrement end until the pointers meet.

---

### Constraints:

1<=arr.size()<=10^5
0<=arr[i]<=10^5

# Time Complexity

Best, Worst, and Average Case: 𝑂(𝑛), as the algorithm always iterates through the array once.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
