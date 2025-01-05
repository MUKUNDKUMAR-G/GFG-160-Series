# 🌟 Count Pairs Whose Sum is Less Than Target

---

## 💡 Problem Statement

Given an array `arr[]` and an integer `target`, count the number of **pairs** \( (i, j) \) such that:

- \( $\text{arr[i]}$ + $\text{arr[j]}$ < $\text{target}$ \), where \( $i < j$ \).

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( 0 $\leq$ $\text{arr[i]}$ $\leq$ $10^4$ \)
- \( 1 $\leq$ $\text{target}$ $\leq$ $10^4$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int countPairs(int[] arr, int target);
}
```

### Parameters

- **`arr[]`**: An integer array.
- **`target`**: An integer representing the upper limit for the pair sum.

### Returns

- An integer representing the number of pairs with sum less than the target.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) integers.
3. An integer \( target \), the target sum.

---

## 📤 Output Format

- An integer representing the count of valid pairs.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [7, 2, 5, 3], target = 8
```

**Output**:

```plaintext
2
```

**Explanation**:  
The valid pairs are:

- \( (2, 5) \): \( 2 + 5 = 7 \)
- \( (2, 3) \): \( 2 + 3 = 5 \)

---

### Example 2

**Input**:

```plaintext
arr = [5, 2, 3, 2, 4, 1], target = 5
```

**Output**:

```plaintext
4
```

**Explanation**:  
The valid pairs are:

- \( (2, 2) \): \( 2 + 2 = 4 \)
- \( (2, 1) \): \( 2 + 1 = 3 \)
- \( (3, 1) \): \( 3 + 1 = 4 \)
- \( (2, 1) \): \( 2 + 1 = 3 \)

---

### Example 3

**Input**:

```plaintext
arr = [2, 1, 8, 3, 4, 7, 6, 5], target = 7
```

**Output**:

```plaintext
6
```

**Explanation**:  
The valid pairs are:

- \( (2, 1) \): \( 2 + 1 = 3 \)
- \( (2, 3) \): \( 2 + 3 = 5 \)
- \( (2, 4) \): \( 2 + 4 = 6 \)
- \( (1, 3) \): \( 1 + 3 = 4 \)
- \( (1, 4) \): \( 1 + 4 = 5 \)
- \( (1, 5) \): \( 1 + 5 = 6 \)

---

## 💡 Approach

### Optimized Two-Pointer Technique

1. **Sort the Array**:

   - Start by sorting the array in non-decreasing order.

2. **Two-Pointer Technique**:

   - Initialize two pointers, one at the start \( i = 0 \) and one at the end \( j = \text{n} - 1 \).
   - Check the sum of the elements at these pointers.

3. **Logic for Pair Counting**:

   - If \( $\text{arr[i]}$ + $\text{arr[j]}$ < $\text{target}$ \):
     - All pairs \( (i, j), (i, j-1), $\dots$, (i, i+1) \) are valid.
     - Increment the count by \( j - i \), and move \( i \) forward.
   - Else, move \( j \) backward to decrease the sum.

4. **Stop Condition**:
   - Repeat until \( i < j \).

---

### Algorithm

1. **Sort the Array**:

   - Sort the array in \( $O(n \log n)$ \).

2. **Two-Pointer Traversal**:
   - Start with \( i = 0 \) and \( j = n - 1 \).
   - Count valid pairs using the above logic.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- Sorting the array: \( $O(n \log n)$ \).
- Two-pointer traversal: \( O(n) \).
- **Overall**: \( $O(n \log n)$ \).

### Space Complexity

- \( O(1) \): No additional space required.

---

## 🖥️ Solution

### Java Implementation

```java

class Solution {
    public int countPairs(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        int i = 0, j = arr.length - 1;

        while (i < j) {
            int sum = arr[i] + arr[j];

            if (sum < target) {
                count += (j - i);
                i++;
            } else {
                j--;
            }
        }

        return count;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
arr = [7, 2, 5, 3], target = 8
```

### Execution Steps:

1. **Sort the Array**:

   ```plaintext
   arr = [2, 3, 5, 7]
   ```

2. **Two-Pointer Traversal**:

   - \( i = 0, j = 3 \):
     - \( 2 + 7 = 9 \), move \( j \) to \( 2 \).
   - \( i = 0, j = 2 \):
     - \( 2 + 5 = 7 < 8 \), add \( 2 \) to count (\( j - i = 2 \)).
     - Move \( i \) to \( 1 \).
   - \( i = 1, j = 2 \):
     - \( 3 + 5 = 8 \), move \( j \) to \( 1 \).

3. **Output**:
   ```plaintext
   Count of pairs: 2
   ```

---

## ✨ Key Takeaways

- **Two-Pointer Technique** optimizes pair counting to \( O(n) \) after sorting.
- Handles large arrays efficiently while maintaining accuracy.

**Happy Coding!** 🚀
