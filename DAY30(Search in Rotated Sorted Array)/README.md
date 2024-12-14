# 🎯 Search in Rotated Sorted Array

---

## 💡 Problem Statement

You are given a **sorted and rotated array** `arr[]` containing distinct elements. Your task is to find the **index** of a target key. If the target key is not found, return `-1`.

---

## 🔒 Constraints

- \( $1 \leq \text{arr.size()}$ $ \leq 10^6 $\) 🧮
- \( $0 \leq \text{arr}[i]$ $ \leq 10^6$ \) 🔢
- \( $1 \leq \text{key}$ $\leq 10^6$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int search(int[] arr, int key);
}
```

### Parameters

- **`arr[]`**: A sorted and rotated array of distinct integers.
- **`key`**: An integer representing the target element to search for.

### Returns

- An integer representing the **index** of the target key in the array, or `-1` if the target is not found.

---

## 📥 Input Format

1. A sorted and rotated array `arr[]` of size \( n \).
2. An integer `key`.

---

## 📤 Output Format

- An integer index of the `key` in `arr[]`, or `-1` if the key is not found.

---

## 🎯 Examples

### Example 1

**Input**:  
`arr = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3`

**Output**:  
`8`

**Explanation**:  
The target key `3` is found at index `8`.

---

### Example 2

**Input**:  
`arr = [3, 5, 1, 2], key = 6`

**Output**:  
`-1`

**Explanation**:  
The target key `6` is not present in the array.

---

### Example 3

**Input**:  
`arr = [33, 42, 72, 99], key = 42`

**Output**:  
`1`

**Explanation**:  
The target key `42` is found at index `1`.

---

## 💡 Approach

The task is to search for the target key in a **sorted and rotated array**. Using **binary search** with additional logic for rotation ensures optimal efficiency.

### Key Observations

1. **Array Properties**:

   - A rotated sorted array is divided into two **sorted subarrays**.
   - One of the subarrays (either left or right of the middle element) will always be sorted.

2. **Search Conditions**:
   - Use the sorted subarray to decide where to search for the key:
     - If the **left subarray is sorted**, check if the key lies within it.
     - If the **right subarray is sorted**, check if the key lies within it.

---

### Algorithm

1. Initialize two pointers, `low` and `high`, at the start and end of the array.
2. Perform binary search while \( $\text{low}$ $ \leq \text{high}$ \):
   - Compute the middle index: \( $\text{mid}$ = $\text{low}$ + ($\text{high}$ - $\text{low}$) / 2 \).
   - If \($ \text{arr[mid]}$ == $\text{key}$ \), return `mid`.
   - If the **left subarray is sorted**:
     - Check if \($ \text{key}$ \) lies in the range \( [$\text{arr[low]}$, $\text{arr[mid]})$ \).
   - Otherwise, the **right subarray is sorted**:
     - Check if \( $\text{key}$ \) lies in the range \( ($\text{arr[mid]}$, $\text{arr[high]}] $\).
3. Return `-1` if the key is not found.

---

## ⏱️ Time Complexity

- **Binary Search**: \( O(\log n) \), where \( n \) is the size of the array.

### Space Complexity

- \( O(1) \): No additional space is used.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public int search(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if the middle element is the key
            if (arr[mid] == key) {
                return mid;
            }

            // Check if the left subarray is sorted
            if (arr[low] <= arr[mid]) {
                // Check if the key lies in the sorted left subarray
                if (arr[low] <= key && key < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Otherwise, the right subarray must be sorted
            else {
                // Check if the key lies in the sorted right subarray
                if (arr[mid] < key && key <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        // If the key is not found
        return -1;
    }
```

---

## 🔍 Example Walkthrough

### Example 1

**Input**:  
`arr = [5, 6, 7, 8, 9, 10, 1, 2, 3], key = 3`

**Steps**:

1. **First Iteration**:

   - `low = 0`, `high = 8`, `mid = 4`.
   - \( $\text{arr[mid]}$ = 9 \), key is not in the left subarray.
   - Update `low = 5`.

2. **Second Iteration**:

   - `low = 5`, `high = 8`, `mid = 6`.
   - \( $\text{arr[mid]} = 1 $\), key is in the right subarray.
   - Update `low = 7`.

3. **Third Iteration**:

   - `low = 7`, `high = 8`, `mid = 7`.
   - \( $\text{arr[mid]} = 2 $\), key is in the right subarray.
   - Update `low = 8`.

4. **Fourth Iteration**:
   - \( $\text{arr[mid]} = 3 $\).

**Output**:  
`8`

---

## ✨ Key Takeaways

- **Efficient Search**: Handles rotation using binary search logic.
- **Scalable Solution**: Works for arrays with up to \(10^6\) elements.

**Happy Coding!** 💻🚀
