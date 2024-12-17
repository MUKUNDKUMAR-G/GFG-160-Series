# Anagram

## 📜Problem Statement

Given two strings s1 and s2 consisting of lowercase characters. The task is to check whether two given strings are an anagram of each other or not. An anagram of a string is another string that contains the same characters, only the order of characters can be different. For example, act and tac are an anagram of each other. Strings s1 and s2 can only contain lowercase alphabets.

**Note:** You can assume both the strings s1 & s2 are **non-empty**.

---

## Function Description

**Function**:

```java
public static boolean areAnagrams(String s1, String s2)

Input: Two strings s1 and s2.
Output: Returns true if the strings are anagrams, otherwise false.
```

---

### **Input Format**

s1: A non-empty string of lowercase alphabets.
s2: A non-empty string of lowercase alphabets.

---

### **Output Format**

- true if the strings are anagrams, otherwise false.

---

## 📊 Examples

### Example 1

#### Input:

```
s1 = "geeks", s2 = "kseeg"
```

**Output:**

```java
true
```

### Explanation:

Both the string have same characters with same frequency. So, they are anagrams.

---

### Example 2

#### Input:

```
s1 = "allergy", s2 = "allergic"

```

**Output:**

```java
false
```

### Explanation:

Characters in both the strings are not same, so they are not anagrams.

---

## 🧠 Approach and Solution

1. Check Length: If the lengths of s1 and s2 are different, return false.
2. Frequency Map: Use a hashmap to count character frequencies in s1.
3. Validation: Traverse s2 and decrease the frequency count. If a mismatch occurs, return false.
4. Final Check: Ensure all counts are zero.

---

### Constraints:

```
1 ≤ ∣s1∣, ∣s2∣ ≤ 10^6.
```

# Time Complexity

- Time complexity: O(n), where n is the length of the strings. Each string is traversed once.
- Space complexity: O(1) if we consider the hashmap size constant (only lowercase alphabets).

# Contributions

Feel free to contribute by sharing your insights, optimizations, or any alternative approaches you have for solving this problem. Pull requests are welcome!

# Contact

For any questions or suggestions, please contact me
