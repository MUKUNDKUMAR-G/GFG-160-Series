# 🎯 K-th Element of Two Sorted Arrays

---

## 💡 Problem Statement

Given two **sorted arrays** `a[]` and `b[]`, find the element that would be at the **k-th position** of the combined sorted array of `a[]` and `b[]`. The arrays remain unchanged, and the goal is to compute this without explicitly merging them.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{size of } a, b$ $\leq 10^6$ \) 🧮
- \( 1 $\leq k$ $\leq$ $\text{size of }$ $a$ + $\text{size of } b$ \) 🔢
- \( 0 $\leq$ $a[i]$, $b[i]$ < $10^8$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int kthElement(int[] a, int[] b, int k);
}
```

### Parameters

- **`a[]`**: A sorted array of integers.
- **`b[]`**: Another sorted array of integers.
- **`k`**: The position (1-based) of the desired element in the combined sorted array.

### Returns

- The integer at the **k-th position** in the combined sorted array of `a[]` and `b[]`.

---

## 📥 Input Format

1. Two sorted arrays `a[]` and `b[]`.
2. An integer `k`.

---

## 📤 Output Format

- An integer representing the **k-th element** in the combined sorted array.

---

## 🎯 Examples

### Example 1

**Input**:  
`a[] = [2, 3, 6, 7, 9]`  
`b[] = [1, 4, 8, 10]`  
`k = 5`

**Output**:  
`6`

**Explanation**:  
Combined sorted array: \([1, 2, 3, 4, 6, 7, 8, 9, 10]\).  
The \($5^{th}$\) element is `6`.

---

### Example 2

**Input**:  
`a[] = [100, 112, 256, 349, 770]`  
`b[] = [72, 86, 113, 119, 265, 445, 892]`  
`k = 7`

**Output**:  
`256`

**Explanation**:  
Combined sorted array: \([72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892]\).  
The \($7^{th}$\) element is `256`.

---

## 💡 Approach

### Efficient Two-Pointer Technique

Instead of merging the arrays explicitly, we use two pointers to iterate through both arrays in sorted order:

1. **Pointers Initialization**:

   - `low1` starts at the beginning of `a[]`.
   - `low2` starts at the beginning of `b[]`.

2. **K-th Element Search**:

   - Compare the elements pointed to by `low1` and `low2`.
   - Increment the pointer for the smaller element while maintaining a count `kCount` to track the combined position.
   - Stop when \( $\text{kCount}$ = $k$ \).

3. **Edge Cases**:
   - If one array is fully traversed before reaching `k`, the remaining elements in the other array are considered.

---

## ⏱️ Time Complexity

- **Time Complexity**: \( O(k) \): We iterate at most \( k \) elements across both arrays.
- **Space Complexity**: \( O(1) \): No extra space is used.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {

    public int kthElement(int[] a, int[] b, int k) {
        int low1 = 0, low2 = 0;
        int n1 = a.length, n2 = b.length;

        int kCount = 0;

        // Use two pointers to traverse both arrays
        while (low1 < n1 && low2 < n2) {
            if (a[low1] < b[low2]) {
                kCount++;
                if (kCount == k) {
                    return a[low1];
                }
                low1++;
            } else {
                kCount++;
                if (kCount == k) {
                    return b[low2];
                }
                low2++;
            }
        }

        // Traverse remaining elements in a[]
        while (low1 < n1) {
            kCount++;
            if (kCount == k) {
                return a[low1];
            }
            low1++;
        }

        // Traverse remaining elements in b[]
        while (low2 < n2) {
            kCount++;
            if (kCount == k) {
                return b[low2];
            }
            low2++;
        }

        return -1; // Should never reach here
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the size of array a: 5
Enter the size of array b: 4
Enter elements of array a (sorted):
2 3 6 7 9
Enter elements of array b (sorted):
1 4 8 10
Enter the value of k: 5
```

### Steps:

1. Initialize pointers: `low1 = 0`, `low2 = 0`.
2. Compare elements of `a` and `b` sequentially:

   - \( a[0] = 2 \), \( b[0] = 1 \): Increment `kCount = 1`, pointer `low2`.
   - \( a[0] = 2 \), \( b[1] = 4 \): Increment `kCount = 2`, pointer `low1`.
   - \( a[1] = 3 \), \( b[1] = 4 \): Increment `kCount = 3`, pointer `low1`.
   - \( a[2] = 6 \), \( b[1] = 4 \): Increment `kCount = 4`, pointer `low2`.
   - \( a[2] = 6 \), \( b[2] = 8 \): Increment `kCount = 5`.

3. Stop when \( kCount = 5 \): The result is `a[2] = 6`.

### Output:

```plaintext
The 5-th element in the combined sorted array is: 6
```

---

**Happy Coding!** 💻🚀
