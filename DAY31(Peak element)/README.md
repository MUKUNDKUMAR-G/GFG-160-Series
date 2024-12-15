# 🎯 Peak Element

---

## 💡 Problem Statement

You are given an array `arr[]` where no two adjacent elements are the same. Your task is to find the **index of a peak element**. A **peak element** is defined as an element that is greater than its adjacent elements (if they exist).

### Notes:

- Consider elements outside the bounds of the array as **negative infinity**.
- If there are multiple peak elements, return the index of any one of them.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq 10^6 $\) 🧮
- \( $-2^{31}$ $\leq$ $\text{arr[i]}$ $\leq$ $2^{31} - 1$\) 🔢

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int peakElement(int[] arr);
}
```

### Parameters

- **`arr[]`**: An array of integers where no two adjacent elements are the same.

### Returns

- An integer representing the **index** of any peak element in the array.

---

## 📥 Input Format

1. An array `arr[]` of size \( n \).

---

## 📤 Output Format

- An integer index of any peak element in the array.

---

## 🎯 Examples

### Example 1

**Input**:  
`arr = [1, 2, 4, 5, 7, 8, 3]`

**Output**:  
`true`

**Explanation**:  
`arr[5] = 8` is a peak element because \( $\text{arr[4]}$ < $\text{arr[5]}$ > $\text{arr[6]}$ \).

---

### Example 2

**Input**:  
`arr = [10, 20, 15, 2, 23, 90, 80]`

**Output**:  
`true`

**Explanation**:

- `arr[1] = 20` is a peak element because \( $\text{arr[0]}$ < $\text{arr[1]}$ > $\text{arr[2]}$ \).
- `arr[5] = 90` is also a peak element because \( $\text{arr[4]}$ < $\text{arr[5]}$ > $\text{arr[6]}$ \).

---

### Example 3

**Input**:  
`arr = [1, 2, 3]`

**Output**:  
`true`

**Explanation**:  
`arr[2]` is a peak element because \( $\text{arr[1]}$ < $\text{arr[2]}$ \) and \( $\text{arr[2]}$ \) has negative infinity to its right.

---

## 💡 Approach

### Binary Search (Optimized for Large Arrays)

We can use **binary search** to efficiently find a peak element in \( $O(\log n) $\).

### Key Idea:

1. If `arr[mid]` is less than `arr[mid + 1]`, a peak element exists to the **right of mid**.
2. Otherwise, a peak element exists to the **left of mid** or at `mid` itself.

---

### Algorithm

1. Initialize two pointers, `low` and `high`, to represent the search space.
2. Use a loop to perform binary search while \( $\text{low}$ < $\text{high}$ \):
   - Compute the middle index: \( $\text{mid}$ = $\text{low}$ + ($\text{high}$ - $\text{low}) / 2 $\).
   - If \( $\text{arr[mid]}$ $\leq$ $\text{arr[mid + 1]}$ \):
     - Move the search space to the right (\( $\text{low}$ = $\text{mid} + 1$ \)).
   - Else:
     - Move the search space to the left (\( $\text{high}$ = $\text{mid}$ \)).
3. Return `low` as the index of a peak element.

---

## ⏱️ Time Complexity

- **Binary Search**: \($ O(\log n)$ \)
- **Space Complexity**: \($ O(1)$ \)

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {

    public int peakElement(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            // Check if the peak is on the right or left
            if (arr[mid] <= arr[mid + 1]) {
                low = mid + 1; // Peak must be to the right
            } else {
                high = mid; // Peak is at mid or to the left
            }
        }

        return low; // Low will point to a peak element
    }
```

---

## 🔍 Example Walkthrough

### Example 1

**Input**:  
`arr = [1, 2, 4, 5, 7, 8, 3]`

**Steps**:

1. **First Iteration**:

   - `low = 0`, `high = 6`, `mid = 3`.
   - \( $\text{arr[mid]} = 5 $\), \( $\text{arr[mid + 1]}$ = 7 \).
   - Move to the right: \( $\text{low} = 4 $\).

2. **Second Iteration**:

   - `low = 4`, `high = 6`, `mid = 5`.
   - \( $\text{arr[mid]}$ = 8 \), \( $\text{arr[mid + 1]}$ = 3 \).
   - Move to the left: \( $\text{high} = 5$\).

3. **Exit Condition**:
   - \( $\text{low}$ = $\text{high} = 5$ \).

**Output**:  
`5`

---

### Example 2

**Input**:  
`arr = [10, 20, 15, 2, 23, 90, 80]`

**Steps**:

1. **First Iteration**:

   - `low = 0`, `high = 6`, `mid = 3`.
   - \( $\text{arr[mid]} = 2$ \), \( $\text{arr[mid + 1]}$ = 23 \).
   - Move to the right: \( $\text{low} = 4$ \).

2. **Second Iteration**:

   - `low = 4`, `high = 6`, `mid = 5`.
   - \( $\text{arr[mid]}$ = 90 \), \( $\text{arr[mid + 1]}$ = 80 \).
   - Move to the left: \( $\text{high} = 5 $\).

3. **Exit Condition**:
   - \( $\text{low}$ = $\text{high} = 5$\).

**Output**:  
`5`

---

## ✨ Key Takeaways

- Binary search ensures \( $O(\log n)$ \) time complexity.
- The solution is robust and works even for large arrays.

**Happy Coding!** 💻🚀
