# Overlapping Intervals 🧮

## 📝Problem Statement

Given an array of intervals arr[][], where each element is an interval [starti, endi], merge all overlapping intervals and return a list of merged intervals.

---

🔒 Constraints:

```
- 1≤arr.size()≤10^5
- 0 ≤ starti ≤ endi ≤ 10^5
```

---

## 📜 Function Signature

**Method Signature**:

```java
class Solution {
    public List<int[]> mergeOverlap(int[][] arr) {
        // Code here // Code here
    }
}
```

---

### **📥 Input Format**

An integer 2D array arr[][] where each element is an interval [starti, endi].

### ** 📤Output Format**

- A 2D array of merged intervals after removing all overlaps.

---

## 🧩 Examples

### Example 1

#### Input:

```
arr: [[1,3],[2,4],[6,8],[9,10]]
```

**Output:**

```java
[[1,4], [6,8], [9,10]]
```

### Explanation:

- In the given intervals we have only two overlapping intervals here, [1,3] and [2,4] which on merging will become [1,4]. Therefore we will return [[1,4], [6,8], [9,10]].

### Example 2

#### Input:

```
arr[][] = [[6,8],[1,9],[2,4],[4,7]]
```

**Output:**

```java
[[1,9]]
```

### Explanation:

In the given intervals all the intervals overlap with the interval [1,9]. Therefore we will return [1,9].

---

## 🔧 Approach

- Sort the intervals by their starting values.
- Merge intervals: Iterate through the sorted intervals and merge those that overlap.

---

# 🔍 Complexity Analysis

Time Complexity:

O(n log n): Sorting the intervals.
O(n): Merging the intervals.

---

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me

# Happy Coding! 🚀
