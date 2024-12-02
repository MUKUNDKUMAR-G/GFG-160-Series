# Search Pattern (KMP-Algorithm) 🔍

## 📜Problem Statement

Given two strings, one is a text string txt and the other is a pattern string pat. The task is to print the indexes of all the occurrences of the pattern string in the text string. Use 0-based indexing while returning the indices.
Note: Return an empty list in case of no occurrences of pattern.

---

## Function Description

**Function**:

```java
Function Name: searchPattern(String txt, String pat)
Input: Two strings, txt and pat.
Output: A list of integers representing the starting indices where pat occurs in txt.
```

---

### **Input Format**

txt: The main text string.
pat: The pattern string to search for.

---

### **Output Format**

- A list of indices where the pattern starts in the text.

---

## 📊 Examples

### Example 1

#### Input:

```
txt = "abcab", pat = "ab"
```

**Output:**

```java
[0, 3]
```

### Explanation:

The string "ab" occurs twice in txt, one starts at index 0 and the other at index 3.

---

### Example 2

#### Input:

```
txt = "abesdu", pat = "edu"

```

**Output:**

```java
[]
```

### Explanation:

There's no substring "edu" present in txt.

---

## 🧠 Approach and Solution

1. **Preprocess Pattern (LPS Array):** Compute the longest prefix suffix (LPS) array to determine shifts efficiently.
2. **Search:** Use the LPS array to skip unnecessary comparisons and find all occurrences

---

### Constraints:

```
1 ≤ txt.size() ≤ 10^6
1 ≤ pat.size() < txt.size()
Both the strings consist of lowercase English alphabets.
```

# Time Complexity

- Time complexity: O(n+m), where n is the length of txt and m is the length of pat..
- Space complexity: O(m) for the LPS array.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
