# Rotate Array by d Elements🔄

## Problem Statement

Given an array and a number d, `rotate the array to the right by d steps`, where n can be less than or equal to the size of the array. The rotation means the elements shift, and the last elements wrap around to the start.

---

## Function Description

**Function Name:**

```
rotateArr(arr, d)

**Input:**

arr – Array of integers.
d – Number of positions to rotate.

**Output:**
The array after rotation.
```

---

### **Input Format**

- An integer array arr of size n.
- An integer d representing the rotation count.

---

### **Output Format**

- An array with elements rotated by d positions to the right.

---

## 📊 Examples

### Example 1

#### Input:

```
arr[] = [1, 2, 3, 4, 5],
d = 2

```

**Output:**

```java
[3, 4, 5, 1, 2]
```

### Explanation:

when rotated by 2 elements, it becomes 3 4 5 1 2.

### Example 2

#### Input

```
arr[] = [7, 3, 9, 1],
d = 9

```

**Output:**

```java
[3, 9, 1, 7]
```

#### Explanation:

The elements of the array are 4 5 2. The reversed array will be 2 5 4.

---

## 🧠 Approach and Solution

1. Modulo Operation: If d >= n, normalize d using d = d % n.
2. Reverse Method:
   - Reverse the first d elements.
   - Reverse the last n - d elements.
   - Reverse the entire array.
3. This ensures the elements are rotated in-place.

---

### Constraints:

```
1<=arr.size(), d <=10^5
0 <= arr[i] <= 10^5
```

# Time Complexity

- Time Complexity: O(n), as the array is traversed multiple times for reversal.
- Space Complexity: O(1), as no extra space is used.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
