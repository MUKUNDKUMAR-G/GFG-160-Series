# 🌟 Longest Consecutive Subsequence

---

## 💡 Problem Statement

You are given an array `arr[]` of non-negative integers. The task is to find the **length of the longest subsequence** such that the elements in the subsequence are consecutive integers.

- The elements can appear in **any order** in the array.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{arr.size()}$ $\leq$ $10^5$ \)
- \( 0 $\leq$ $\text{arr[i]}$ $\leq$ $10^5$ \)

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int longestConsecutive(int[] arr);
}
```

### Parameters

- **`arr[]`**: An array of non-negative integers.

### Returns

- An integer representing the length of the longest consecutive subsequence.

---

## 📥 Input Format

1. An integer \( n \), the size of the array.
2. An array \( arr[] \) of \( n \) non-negative integers.

---

## 📤 Output Format

- An integer representing the length of the longest consecutive subsequence.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
arr = [2, 6, 1, 9, 4, 5, 3]
```

**Output**:

```plaintext
6
```

**Explanation**:

- The longest consecutive subsequence is \( 1, 2, 3, 4, 5, 6 \).

---

### Example 2

**Input**:

```plaintext
arr = [1, 9, 3, 10, 4, 20, 2]
```

**Output**:

```plaintext
4
```

**Explanation**:

- The longest consecutive subsequence is \( 1, 2, 3, 4 \).

---

### Example 3

**Input**:

```plaintext
arr = [15, 13, 12, 14, 11, 10, 9]
```

**Output**:

```plaintext
7
```

**Explanation**:

- The longest consecutive subsequence is \( 9, 10, 11, 12, 13, 14, 15 \).

---

## 💡 Approach

### Optimized HashSet-Based Approach

1. **Use a HashSet**:

   - Store all the elements of the array in a HashSet.
   - This allows \( O(1) \) lookup to determine if an element exists.

2. **Find the Start of a Sequence**:

   - An element \( x \) is the start of a sequence if \( x - 1 \) is not in the HashSet.
   - This ensures that we only begin counting for a sequence at its starting point.

3. **Count the Sequence**:

   - For each sequence starting at \( x \), count how many consecutive numbers \( x, x+1, x+2, \ldots \) exist in the HashSet.

4. **Track the Longest Sequence**:
   - Maintain a variable to store the maximum length encountered during the iterations.

---

### Algorithm

1. Create a HashSet from the elements of the array.
2. For each element in the array:
   - Check if it is the start of a sequence (\( x-1 \) is not in the HashSet).
   - If yes, count the length of the sequence starting from this element.
   - Update the maximum length if the current sequence is longer.
3. Return the maximum length.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- **Inserting into HashSet**: \( O(n) \).
- **Processing Each Element**: \( O(n) \).
- Total: \( O(n) \).

### Space Complexity

- \( O(n) \): For storing elements in the HashSet.

---

## 🖥️ Solution

### Java Implementation

```java
class Solution {
    public int longestConsecutive(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int longestStreak = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
2 6 1 9 4 5 3
```

### Execution Steps:

1. **Store Elements in HashSet**:

   ```plaintext
   set = {1, 2, 3, 4, 5, 6, 9}
   ```

2. **Process Each Element**:

   - \( num = 1 \): Start of sequence \( 1, 2, 3, 4, 5, 6 \) (length = 6).
   - \( num = 6 \): Not the start (since \( 5 \) exists).
   - \( num = 9 \): Start of sequence \( 9 \) (length = 1).

3. **Longest Streak**:
   ```plaintext
   longestStreak = 6
   ```

### Output:

```plaintext
Length of the longest consecutive subsequence: 6
```

---

## ✨ Key Takeaways

- **HashSet Optimization**: Efficient lookup and storage of elements for \( O(n) \) complexity.
- **Scalable Solution**: Handles arrays with up to \( $10^5$ \) elements seamlessly.

**Happy Coding!** 🚀
