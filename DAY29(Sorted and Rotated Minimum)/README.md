# 🎯 Sorted and Rotated Minimum

---

## 💡 Problem Statement

You are given a **sorted and rotated array** `arr[]` (which may contain duplicates). The goal is to find the **minimum element** in the array.

---

## 🔒 Constraints

- \( 1 $\leq \text{arr.size()}$ $\leq 10^6 $\) 🧮
- \( 1 $\leq \text{arr}[i]$ $\leq 10^9$ \) 🔢

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int findMin(int[] arr) {
        // Implementation here
    }
}
```

### Parameters

- **`arr[]`**: A sorted and rotated array of integers, possibly containing duplicates.

### Returns

- An integer representing the minimum element in the array.

---

## 📥 Input Format

- A sorted and rotated array `arr[]` of size \( n \).

---

## 📤 Output Format

- An integer representing the minimum element in `arr[]`.

---

## 🎯 Examples

### Example 1

**Input**:  
`arr = [5, 6, 1, 2, 3, 4]`

**Output**:  
`1`

**Explanation**:  
The minimum element is `1`, which appears after rotation.

---

### Example 2

**Input**:  
`arr = [3, 2, 2, 2]`

**Output**:  
`2`

**Explanation**:  
The minimum element is `2`.

---

### Example 3

**Input**:  
`arr = [4, 4, 4]`

**Output**:  
`4`

**Explanation**:  
All elements are the same, so `4` is the minimum.

---

## 💡 Approach

### Binary Search (Optimized for Rotated Arrays)

1. **Divide and Conquer**:

   - Use binary search to narrow down the search space for the minimum.

2. **Rotation Property**:

   - In a rotated array, the minimum element is the only element for which the previous element is greater.

3. **Handle Duplicates**:
   - If duplicates are encountered, shrink the search space by incrementing the left pointer.

---

### Algorithm

1. Initialize two pointers, `left` and `right`, at the start and end of the array.
2. Use a loop to perform binary search until `left < right`:
   - Find the middle element: \( $\text{mid}$ = $\text{left}$ + ($\text{right}$ - $\text{left})$ / 2 \).
   - Compare `arr[mid]` with `arr[right]`:
     - If \( $\text{arr[mid]}$ < $\text{arr[right]}$ \): The minimum lies in the left half.
     - If \( $\text{arr[mid]}$ > $\text{arr[right]}$ \): The minimum lies in the right half.
     - If \( $\text{arr[mid]}$ == $\text{arr[right]}$ \): Decrement `right` to handle duplicates.
3. Return `arr[left]` as the minimum element.

---

## ⏱️ Time Complexity

- **Time Complexity**: \( $O(\log n) $\) in the average case. \( O(n) \) in the worst case (when duplicates dominate).
- **Space Complexity**: \( O(1) \).

---

## 🔍 Example Walkthrough

### Example 1

**Input**:  
`arr = [5, 6, 1, 2, 3, 4]`

**Steps**:

1. **Initialization**:

   - `left = 0`, `right = 5`.

2. **First Iteration**:

   - `mid = 2`, \( $\text{arr[mid]}$ = 1 \).
   - \( $\text{arr[mid]}$ < $\text{arr[right]}$ \): Update `right = mid = 2`.

3. **Second Iteration**:

   - `mid = 1`, \( $\text{arr[mid]}$ = 6 \).
   - \( $\text{arr[mid]}$ > $\text{arr[right]}$ \): Update `left = mid + 1 = 2`.

4. **Exit Condition**:
   - `left == right = 2`.

**Output**:  
`1`

---

## ✨ Key Takeaways

- Handles duplicates efficiently by shrinking the search space.
- Leverages binary search to minimize time complexity.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me

**Happy Coding!** 💻🚀
