# Non-overlapping Intervals

This task involves finding the minimum number of intervals to remove from a list of intervals such that the remaining intervals are non-overlapping.🚀

## 📝Problem Insight

You are given a list of intervals `intervals[][],` where each interval is represented as [start 𝑖,end 𝑖]. Your goal is to determine the minimum number of intervals to remove in order to make the rest of the intervals non-overlapping.

---

🔒 Constraints:

```
1 ≤ intervals.size() ≤  10^5
Each interval has exactly two integers: |intervals[i]| == 2
0 ≤ starti < endi <=5*10^4
```

---

## 📜 Function Description

**Method Signature**:

```java
class Solution {
    static int minRemoval(int intervals[][]) {
        // Implementation here
    }
}
```

Parameters:

- intervals[][]: A 2D array where each element represents an interval [start 𝑖,end 𝑖]

Returns:

- An integer representing the minimum number of intervals to remove.

---

### **📥 Input Format**

- A 2D array of intervals [start 𝑖,end 𝑖]

### ** 📤Output Format**

- An integer indicating the minimum number of intervals that need to be removed.

---

## 🧩 Examples

### Example 1

#### Input:

```
intervals = [[1, 2], [2, 3], [3, 4], [1, 3]]
```

**Output:**

```java
1
```

### Explanation:

- Removing [1,3] makes the rest of the intervals non-overlapping.

### Example 2

#### Input:

```
intervals = [[1, 2], [5, 10], [18, 35], [40, 45]]
```

**Output:**

```java
0
```

### Explanation:

All intervals are already non-overlapping.

---

## 🔧 Approach

The `Greedy Approach` ensures the minimum number of removals by always prioritizing intervals that finish the earliest.

### Steps:

1.  Sort by End Time:

    - Sort the intervals by their ending times (end 𝑖) to minimize overlap.

2.  Iterate Through Intervals:

    - Maintain a variable lastEnd to track the end of the last non-overlapping interval.
    - For each interval:

      - If the current interval’s start time is greater than or equal to lastEnd, update lastEnd and include the interval.

      - Otherwise, increment a counter for removals.

3.  Return the Count:

    - The counter tracks the number of overlapping intervals removed.

### 🚀 Example Walkthrough

#### Example 1 :

```
Input:
intervals = [[1, 2], [2, 3], [3, 4], [1, 3]]

Steps:

1. Sort Intervals by End Time:

                        Sorted=[[1,2],[2,3],[1,3],[3,4]]

2. Iterate Through Intervals:

    - Interval [1,2]: No overlap, set lastEnd = 2.
    - Interval [2,3]: No overlap, set lastEnd = 3.
    - Interval [1,3]: Overlap detected, increment removals = 1.
    - Interval [3,4]: No overlap, set lastEnd = 4.

Output:
1

```

---

# 🔍 Complexity Analysis

### Time Complexity :

- Sorting: O(nlogn), where n is the number of intervals.
- Iteration: O(n).
- **Total: O(nlogn).**

### Space Complexity

**Space: O(1)**, as we sort the intervals in-place (or use constant extra space).

---

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me

# Happy Coding! 🚀
