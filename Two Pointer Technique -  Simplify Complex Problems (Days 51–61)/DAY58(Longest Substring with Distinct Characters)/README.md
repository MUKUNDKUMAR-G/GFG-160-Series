# 🌟 Longest Substring with Distinct Characters

---

## 💡 Problem Statement

Given a string `s`, find the length of the **longest substring** that contains all distinct characters.

---

## 🔒 Constraints

- \( 1 $\leq$ $\text{s.size()}$ $\leq$ 3 $\times$ $10^4$ \)
- All characters in `s` are lowercase English letters.

---

## 📝 Function Description

### Method Signature

```java
class Solution {
    public int longestUniqueSubstr(String s);
}
```

### Parameters

- **`s`**: A string of lowercase English letters.

### Returns

- An integer representing the length of the longest substring with all distinct characters.

---

## 📥 Input Format

1. A single string \( s \), which contains only lowercase English letters.

---

## 📤 Output Format

- An integer representing the length of the longest substring with all distinct characters.

---

## 🎯 Examples

### Example 1

**Input**:

```plaintext
s = "geeksforgeeks"
```

**Output**:

```plaintext
7
```

**Explanation**:  
The longest substring with all distinct characters is `"eksforg"`.

---

### Example 2

**Input**:

```plaintext
s = "aaa"
```

**Output**:

```plaintext
1
```

**Explanation**:  
The longest substring with all distinct characters is `"a"`.

---

### Example 3

**Input**:

```plaintext
s = "abcdefabcbb"
```

**Output**:

```plaintext
6
```

**Explanation**:  
The longest substring with all distinct characters is `"abcdef"`.

---

## 💡 Approach

### Sliding Window with HashMap

1. **Use Two Pointers**:

   - Use `start` to mark the beginning of the current substring.
   - Use `end` to iterate through the string.

2. **Track Characters**:

   - Use a `HashMap` to store the last index of each character in the current substring.

3. **Adjust the Window**:

   - If a character at `end` is already in the current substring, move the `start` pointer to exclude the repeated character.

4. **Update the Result**:

   - At each step, calculate the length of the current substring and update the maximum length.

5. **Edge Cases**:
   - An empty string or string of length 1.

---

## ⏱️ Time & Space Complexity

### Time Complexity

- \( O(n) \): Each character is processed at most twice (once by `end` and once by `start`).

### Space Complexity

- \( O(1) \): The `HashMap` stores at most 26 entries (one for each lowercase English letter).

---

## 🖥️ Solution

### Java Implementation

```java
import java.util.*;

class Solution {
    public int longestUniqueSubstr(String s) {
        int n = s.length();
        if (n == 0) return 0;

        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            if (charIndexMap.containsKey(currentChar)) {
                start = Math.max(start, charIndexMap.get(currentChar) + 1);
            }
            charIndexMap.put(currentChar, end);

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
```

---

## 🔍 Example Walkthrough

### Input:

```plaintext
Enter the string: geeksforgeeks
```

### Execution Steps:

1. **Initial Variables**:

   ```plaintext
   maxLength = 0, start = 0, charIndexMap = {}
   ```

2. **Processing Each Character**:

   - `end = 0`, `s[end] = g`:
     - Add `g` to `charIndexMap`.
     - Update `maxLength = 1`.
   - `end = 1`, `s[end] = e`:
     - Add `e` to `charIndexMap`.
     - Update `maxLength = 2`.
   - `end = 2`, `s[end] = e`:
     - Move `start` to `2`.
     - Add `e` to `charIndexMap`.
   - Continue for all characters...

3. **Final Output**:
   ```plaintext
   Length of the longest substring with all distinct characters: 7
   ```

---

## ✨ Key Takeaways

- The **sliding window** approach ensures \( O(n) \) time complexity, making it efficient for large strings.
- **HashMap** enables fast lookups for character indices, ensuring optimal performance.

**Happy Coding!** 🚀
