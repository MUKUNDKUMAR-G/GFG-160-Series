# 🌟 Intersection of Two Arrays with Duplicate Elements

---

## 💡 Problem Statement

You are given two integer arrays \( a[] \) and \( b[] \). Find the **intersection** of the two arrays, defined as the set of elements that are **common to both arrays**.

- Each element in the result should appear **only once**, even if it appears multiple times in both arrays.
- The result can be in any order; the driver code will sort the array before printing.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{a.size(), b.size()}$ $\leq$ $10^5$ \)
- \( 1 $\leq$ $\text{a[i], b[i]}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b);
}
```

### Parameters

- **`a[]`**: An integer array of size \( n \).
- **`b[]`**: An integer array of size \( m \).

### Returns

- An ArrayList containing the intersection of the two arrays, without duplicates.

---

## 📥 Input Format

1. An integer \( n \), the size of array \( a[] \).
2. An array \( a[] \) of \( n \) integers.
3. An integer \( m \), the size of array \( b[] \).
4. An array \( b[] \) of \( m \) integers.

---

## 📤 Output Format

- An ArrayList containing all common elements, without duplicates.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
a = [1, 2, 1, 3, 1], b = [3, 1, 3, 4, 1]
```

**Output**:

```plaintext
[1, 3]
```

**Explanation**:

- Common elements: \( 1 \) and \( 3 \).
- Each element appears only once in the result.

---

### Example 2

**Input**:

```plaintext
a = [1, 1, 1], b = [1, 1, 1, 1, 1]
```

**Output**:

```plaintext
[1]
```

**Explanation**:

- Common element: \( 1 \).
- \( 1 \) appears only once in the result.

---

### Example 3

**Input**:

```plaintext
a = [1, 2, 3], b = [4, 5, 6]
```

**Output**:

```plaintext
[]
```

**Explanation**:

- No common elements between \( a[] \) and \( b[] \).

---

## 💡 Approach

### Optimized HashSet-Based Solution

1. **Use a HashSet for One Array**:

   - Insert all elements of \( a[] \) into a HashSet.

2. **Check Elements in the Second Array**:

   - Iterate through \( b[] \).
   - If an element of \( b[] \) is found in the HashSet, add it to the result and remove it from the HashSet to avoid duplicates in the result.

3. **Avoid Using `contains` on the Result**:
   - Use the HashSet itself to ensure unique elements, eliminating the need for duplicate checks in the result.

---

### Algorithm

1. Initialize a HashSet `setA` and add all elements of \( a[] \) to it.
2. Create a list `result` to store the intersection.
3. Iterate through \( b[] \):
   - If the current element exists in `setA`, add it to the result and remove it from `setA`.
4. Return the result list.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- **Building `setA`**: \( O(n) \).
- **Iterating through \( b[] \)**: \( O(m) \).
- Total: \( O(n + m) \).

### Space Complexity

- \( O(n) \): For storing elements of \( a[] \) in the HashSet.

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        Set<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int num : b) {
            if (setA.contains(num)) {
                result.add(num);
                setA.remove(num);
            }
        }

        return result;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the size of array a: 5
Enter the elements of array a:
1 2 1 3 1
Enter the size of array b: 5
Enter the elements of array b:
3 1 3 4 1
```

### Execution Steps:

1. Add elements of \( a[] \) to `setA`:

   ```plaintext
   setA = {1, 2, 3}
   ```

2. Iterate through \( b[] \):

   - \( 3 \) exists in `setA`: Add to result and remove from `setA`.
   - \( 1 \) exists in `setA`: Add to result and remove from `setA`.

3. Result:

   ```plaintext
   result = [3, 1]
   ```

4. Sort the result before printing:
   ```plaintext
   [1, 3]
   ```

---

## ✨ Key Takeaways

- **HashSet-Based Solution** ensures efficient \( O(n + m) \) complexity.
- Handles duplicate elements seamlessly using set operations.
- Sorting is performed in the driver code after returning the result.

**Happy Coding!** 🚀
