# Count Inversions 🧮

Geek needs to insert a new interval into a sorted list of non-overlapping intervals! Your mission is to help Geek maintain the sorted order while merging overlapping intervals seamlessly. Let’s dive into the world of intervals and make Geek proud! 🚀

## 📝Problem Insight

You are given:

1. A list of non-overlapping intervals sorted by their starting times.
2. A new interval to insert into the list.

The goal is to insert the new interval into the list while ensuring:

- The intervals remain sorted by their starting times.
- There are no overlapping intervals (merge them if necessary).

---

🔒 Constraints:

```
1 ≤ intervals.size() ≤  10^5
0 ≤ start[i], end[i] ≤ 10^9
```

---

## 📜 Function Description

**Method Signature**:

```java
class Solution {
    static ArrayList<int[]> insertInterval(int[][] intervals, int[] newInterval) {
        // Implementation here
    }
}
```

Parameters:

- intervals: A 2D array representing the list of intervals. Each interval is a pair [start, end].
- newInterval: A single interval [start, end] to be inserted into the list.

Returns:

- A list of intervals after inserting and merging the new interval.

---

### **📥 Input Format**

- A 2D array representing sorted non-overlapping intervals.
- A single new interval.

### ** 📤Output Format**

- A 2D array representing the updated list of intervals, merged and sorted.

---

## 🧩 Examples

### Example 1

#### Input:

```
intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]
```

**Output:**

```java
[[1,3], [4,7], [8,10]]
```

### Explanation:

- The newInterval [5,6] overlaps with [4,5] and [6,7].

### Example 2

#### Input:

```
intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,9]
```

**Output:**

```java
[[1,2], [3,10], [12,16]]
```

### Explanation:

The new interval [4,9] overlaps with [3,5],[6,7],[8,10].

---

## 🔧 Approach

To solve this efficiently, follow these steps:

1. Add intervals before the new interval:

   - Add all intervals that end before the new interval starts.

2. Merge overlapping intervals:

   - For intervals that overlap with the new interval, merge them into a single interval by updating the start and end values.

3. Add intervals after the new interval:

   - Add all intervals that start after the new interval ends.

## 🔍 Algorithm Walkthrough

Steps:

1.  Iterate through the intervals:

    - Case 1: If an interval ends before the new interval starts, add it to the result.
    - Case 2: If an interval overlaps with the new interval, merge them.
    - Case 3: If an interval starts after the new interval ends, add the merged newInterval (if not added yet) and the remaining intervals.

2.  Return the updated list of intervals.

### 🚀 Example Walkthrough

#### Example 1 :

```
Input:
intervals = [[1,3], [4,5], [6,7], [8,10]], newInterval = [5,6]

Output:
[[1,3], [4,7], [8,10]]

Steps:

1. Add [1,3] to the result (no overlap).
2. Merge [4,5], [5,6], and [6,7] into [4,7].
3. Add [8,10] to the result.

```

#### Example 2 :

```
Input:
intervals = [[1,2], [3,5], [6,7], [8,10], [12,16]], newInterval = [4,9]

Output:
[[1,2], [3,10], [12,16]]

Steps:

1. Add [1,2] to the result (no overlap).
2. Merge [3,5], [6,7], [8,10], and [4,9] into [3,10].
3. Add [12,16] to the result.

```

---

# 🔍 Complexity Analysis

- Time Complexity:O(n): Each interval is processed once.

- Space Complexity:O(n): For the result list.

---

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me

# Happy Coding! 🚀
