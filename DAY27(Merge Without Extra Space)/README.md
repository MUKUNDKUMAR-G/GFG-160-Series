# Merge Without Extra Space

This problem involves merging two sorted arrays a[] and b[] in-place, without using any extra space. After merging:

- a[] should contain the first 𝑛 smallest elements in sorted order.
- b[] should contain the remaining 𝑚 largest elements in sorted order.

## 📝Problem Insight

Given two sorted arrays
a[] of size 𝑛 and b[] of size 𝑚, modify them so that they form a single sorted sequence across the two arrays, while preserving the constraints:

- No extra space is allowed.
- a[] contains the first 𝑛smallest elements.
- b[] contains the last 𝑚largest elements.

---

🔒 Constraints:

```
1 <= a.size(), b.size() <= 10^5
0 <= a[i], b[i] <= 10^7
```

---

## 📜 Function Description

**Method Signature**:

```java
class Solution {
    public void mergeArrays(int a[], int b[]) {
        // Implementation here
    }
}
```

Parameters:

- a[]: An array of size n, sorted in non-decreasing order.
- b[]: An array of size m, sorted in non-decreasing order.

Returns:

- a[]: Contains the first 𝑛smallest elements in sorted order after merging.
- b[]: Contains the remaining 𝑚 largest elements in sorted order after merging.

---

### **📥 Input Format**

- Two sorted arrays a[] and b[].

### ** 📤Output Format**

- Two sorted arrays a[] and b[] after merging.

---

## 🧩 Examples

### Example 1

#### Input:

```
a[] = [2, 4, 7, 10], b[] = [2, 3]
```

**Output:**

```java
a[] = [2, 2, 3, 4]
b[] = [7, 10]
```

### Explanation:

- After merging the two non-decreasing arrays, we get, 2 2 3 4 7 10.

### Example 2

#### Input:

```
a[] = [0, 1], b[] = [2, 3]
```

**Output:**

```java
a[] = [0 1]
b[] = [2 3]
```

### Explanation:

After merging two sorted arrays we get 0 1 2 3.

---

## 🔧 Approach

The solution avoids using extra space by swapping elements between a[] and b[].

1.Swap Elements Between Arrays:

- Compare the largest element in a[] with the smallest element in b[].
- If the largest element in a[] is greater than the smallest element in b[], swap them.

2. Sort Each Array:

- After the swaps, a[] and b[] might not be fully sorted.
- Sort both arrays individually.

3. Result:

- a[] will contain the first 𝑛 smallest elements.
- b[] will contain the remaining 𝑚 largest elements.

### 🚀 Example Walkthrough

#### Example 1 :

```
Input:
a[] = [2, 4, 7, 10], b[] = [2, 3]

Steps:

1. Swapping:
 - Compare a[3]=10 and b[0]=2.Swap 10 and 2.
 - Comparea[2]=7 andb[1]=3. Swap 7 and3.

2. Result after swaps:
    - a[]=[2,4,3,2],
    - b[]=[7,10].

3. Sorting:
    - a[]=[2,2,3,4].
    - b[]=[7,10].

4. Output:
    - a[]=[2,2,3,4],
    - b[]=[7,10].

```

---

# 🔍 Complexity Analysis

### Time Complexity :

- Swapping Loop: O(min(n,m))
- Sorting Arrays: O(nlogn + mlogm)
- Total: **O(nlogn + mlogm)**

### Space Complexity

**Space: O(1)**, No additional space used.

---

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me

# Happy Coding! 🚀
