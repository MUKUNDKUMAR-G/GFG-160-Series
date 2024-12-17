# Strings Rotations of Each Other 🌀

## 📜Problem Statement

You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated version of the string s1.

**Note:** The characters in the strings are in lowercase.

---

## Function Description

**Function**:

```java
Function Name: areRotations(String s1, String s2)
Input: Two strings s1 and s2.
Output: A boolean value (true or false) indicating whether s2 is a rotated version of s1.
```

---

### **Input Format**

- Two strings of equal lengths, s1 and s2.

### **Output Format**

- Return true if s2 is a rotation of s1; otherwise, return false.

---

## 📊 Examples

### Example 1

#### Input:

```
s1 = "abcd", s2 = "cdab"
```

**Output:**

```java
true
```

### Explanation:

- After 2 right rotations, s1 will become equal to s2.

### Example 2

#### Input:

```
s1 = "abcd", s2 = "acbd"
```

**Output:**

```java
false
```

### Explanation:

Strings are not rotations of each other.

---

## 🧠 Approach(KMP Algorithm for LPS)

- Concatenate s1 with itself.
- Use the KMP algorithm to check if s2 exists in the concatenated string.

---

### Constraints:

```
1 <= s1.size(), s2.size() <= 10^5
```

# Time Complexity

Building LPS: O(n)
KMP Search: O(n)
Overall: O(n) where n is the length of s1.

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
