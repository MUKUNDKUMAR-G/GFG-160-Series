# 🌟 Find All Triplets with Zero Sum

---

## 💡 Problem Statement

Given an array `arr[]`, find all **unique triplets** \( (i, j, k) \) such that:

- \( $\text{arr[i]}$ + $\text{arr[j]}$ + $\text{arr[k]}$ = 0 \).
- \( i < j < k \).

The output triplets should be represented by their **indices**, and the indices must satisfy \( i < j < k \).

---

## 🔒 Constraints

- \( 3 $\leq$ $\text{arr.size()}$ $\leq$ $10^3$ \)
- \( $-10^4$ $\leq$ $\text{arr[i]}$ $\leq$ $10^4$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public List<List<Integer>> findTriplets(int[] arr);
}
```

### Parameters

- **`arr[]`**: An array of integers.

### Returns

- A list of lists containing all unique triplets \( (i, j, k) \) where the indices satisfy \( i < j < k \) and \( $\text{arr[i]}$ + $\text{arr[j]}$ + $\text{arr[k]}$ = 0 \).

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. The array \( arr[] \) of \( n \) integers.

---

## 📤 Output Format

- A list of lists containing the indices of all triplets that satisfy the condition.
- If no such triplets exist, return an empty list.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [0, -1, 2, -3, 1]
```

**Output**:

```plaintext
[[0, 1, 4], [2, 3, 4]]
```

**Explanation**:

- Triplets with sum 0 are:
  - \( $\text{arr[0]}$ + $\text{arr[1]}$ + $\text{arr[4]}$ = 0 + (-1) + 1 = 0 \).
  - \( $\text{arr[2]}$ + $\text{arr[3]}$ + $\text{arr[4]}$ = 2 + (-3) + 1 = 0 \).

---

### Example 2

**Input**:

```plaintext
arr = [1, -2, 1, 0, 5]
```

**Output**:

```plaintext
[[0, 1, 2]]
```

**Explanation**:

- Triplet: \( $\text{arr[0]}$ + $\text{arr[1]}$ + $\text{arr[2]}$ = 1 + (-2) + 1 = 0 \).

---

### Example 3

**Input**:

```plaintext
arr = [2, 3, 1, 0, 5]
```

**Output**:

```plaintext
[]
```

**Explanation**:

- No triplets with sum \( 0 \) exist.

---

## 💡 Approach

### Optimized HashMap-Based Approach

Instead of brute-forcing through all triplets (\( $O(n^3)$ \)), a more efficient solution uses a **HashMap** to find valid pairs for each fixed element.

### Steps:

1. **Fix One Element**:

   - Iterate through the array, fixing \( \text{arr[i]} \).
   - For each fixed \( $\text{arr[i]}$ \), find pairs \( $\text{arr[j]}$ \) and \( $\text{arr[k]}$ \) such that their sum equals \( -$\text{arr[i]}$ \).

2. **Use a HashMap for Pair Search**:

   - Use a HashMap to store elements and their indices while iterating through the remaining array.
   - For each \( $\text{arr[k]}$ \), check if \( $\text{target}$ = -($\text{arr[i]}$ + $\text{arr[k]}$) \) exists in the HashMap.

3. **Avoid Duplicate Triplets**:

   - Use indices \( i, j, k \) to ensure \( i < j < k \).

4. **Store the Result**:
   - Add valid triplets to the result list.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- Outer Loop: \( O(n) \).
- Inner Loop with HashMap Operations: \( O(n) \).
- Total: \( $O(n^2)$ \).

### Space Complexity

- \( O(n) \): For storing elements in the HashMap.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();

        // Iterate through the array and fix one element
        for (int i = 0; i < arr.length; i++) {
            // Create a map to store indices of elements
            Map<Integer, List<Integer>> map = new HashMap();

            // Iterate through the remaining elements to find pairs
            for (int k = i + 1; k < arr.length; k++) {
                int target = -(arr[i] + arr[k]);

                // If target exists in the map, add triplet
                if (map.containsKey(target)) {
                    for (int j : map.get(target)) {
                        ans.add(Arrays.asList(i, j, k));
                    }
                }

                // Store the current element and its index in the map
                map.computeIfAbsent(arr[k], key -> new ArrayList<>()).add(k);
            }
        }

        return ans;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the size of the array: 5
Enter the elements of the array:
0 -1 2 -3 1
```

### Execution Steps:

1. **Fix \( $\text{arr[0]}$ = 0 \)**:

   - Target: \( -$\text{arr[0]}$ = 0 \).
   - Pair: \( (1, 4) \).

2. **Fix \( \text{arr[2]} = 2 \)**:

   - Target: \( -$\text{arr[2]}$ = -2 \).
   - Pair: \( (3, 4) \).

3. **Output**:

```plaintext
Triplets with zero sum:
[0, 1, 4]
[2, 3, 4]
```

---

## ✨ Key Takeaways

- **HashMap-Based Pair Search** reduces complexity to \( O(n^2) \).
- **Scalable** for arrays up to \( 10^3 \).
- **Distinct Triplets** are guaranteed by checking indices \( i, j, k \).

**Happy Coding!** 🚀
